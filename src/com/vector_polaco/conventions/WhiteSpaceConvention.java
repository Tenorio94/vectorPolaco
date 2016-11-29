package com.vector_polaco.conventions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Adriana Valenzuela on 29/10/2016.
 */
public class WhiteSpaceConvention {

    private int iIndentationLevel = 0;
    private int iAuxIndentLevel = 0;
    private int iContadordeErrores = 0;
    private boolean bFlagCommentML = false;
    private boolean bFlagComment = false;

    public ArrayList<String> readFile(String sFilePath) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(sFilePath));
        ArrayList<String> listFileRead = new ArrayList<String>();
        while (scanner.hasNext()) {
            listFileRead.add(scanner.nextLine());
        }
        scanner.close();
        return listFileRead;
    }

    public void checkIndentationLevel(String s) {
        if ((bFlagCommentML == false) && (bFlagComment == false)) {
            if (s.contains("{")) {
                iIndentationLevel++;
            }
            s.replace("    ", "\t");
            int count = s.length() - s.replace("\t", ".").length();
            if (count != iAuxIndentLevel) {
                iContadordeErrores++;
            }
            iAuxIndentLevel = iIndentationLevel;
            if (s.contains("}")) {
                iIndentationLevel--;
            }
        }
    }

    public void checkSpaces(String s) {
        if (s.contains("+") || s.contains("-") || s.contains("*") || s.contains("/")
                || s.contains("^") || s.contains("=") || s.contains("==")
                || s.contains("!=") || s.contains("<") || s.contains(">")
                || s.contains("<=") || s.contains(">=") || s.contains("&&")
                || s.contains("||") || s.contains(">>") || s.contains("<<")) {
            s = checaSigno(s,"+");
            s = checaSigno(s,"-");
            s = checaSigno(s,"*");
            s = checaSigno(s,"/");
            s = checaSigno(s,"^");
            s = checaSigno(s,"=");
            s = checaSigno(s,"==");
            s = checaSigno(s,"!=");
            s = checaSigno(s,"<");
            s = checaSigno(s,">");
            s = checaSigno(s,"<=");
            s = checaSigno(s,">=");
            s = checaSigno(s,"&&");
            s = checaSigno(s,"||");
            s = checaSigno(s,">>");
            s = checaSigno(s,"<<");
        }
    }

    public String checaSigno(String s, String c) {
        while (s.contains(c)) {
            int iN = s.indexOf(c);
            char cPosA = s.charAt(iN - 1);
            char cPosD = s.charAt(iN + 1);
            if ((cPosA != ' ') && (cPosD != ' ')) {
                iContadordeErrores++;
            }
            s = s.replaceFirst(c, ".");

        }
        return s;
    }

    public void checkWhiteSpaces(ArrayList<String> listFileRead) {
        for (String s : listFileRead) {
            if (s.contains("/*")) {
                bFlagCommentML = true;
            }
            if ((s.contains("//"))) {
                bFlagComment = true;
            }
            if ((bFlagCommentML == false) && (bFlagComment == false) && (!s.contains("*/")) && (!s.contains("#"))) {
                checkIndentationLevel(s);
                checkSpaces(s);

            }
            if (s.contains("*/")) {
                bFlagCommentML = false;
            }
            if (bFlagComment) {
                bFlagComment = false;
            }
        }
        System.out.println(iContadordeErrores);
    }

}
