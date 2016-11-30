package com.vector_polaco.conventions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Adriana Valenzuela on 29/10/2016.
 */
public class InstructionPerLineConvention {

    private int iIndentationLevel = 0;
    private int iAuxIndentLevel = 0;
    public int iContadordeErrores = 0;
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

    public void oneInstructionPerLine(String s) {
    if (s.trim().equals("") == false) {

        String sLast;
        int tam = (s.length());
        if (tam > 1) {
            sLast = s.substring(tam - 1, tam);
        } else {
            sLast = s;
        }
            if ((sLast.startsWith(";") == false) && (sLast.startsWith(")") == false)
                    && (sLast.startsWith("{") == false) && (sLast.startsWith("}") == false)
                    && (sLast.startsWith(">") == false)
                && (sLast.trim().equals("") == false) && (s.trim().equals("else") == false)) {
                iContadordeErrores++;
            }
        }
    }

    public void checkWhiteSpaces(ArrayList<String> listFileRead) {
        for (String s : listFileRead) {
            if (s.contains("/*")) {
                bFlagCommentML = true;
            }
            if ((s.contains("//"))) {
                bFlagComment = true;
            }
            if ((bFlagCommentML == false) && (bFlagComment == false) && (!s.contains("*/"))) {
                oneInstructionPerLine(s);

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
