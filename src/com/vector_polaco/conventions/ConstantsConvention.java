package com.vector_polaco.conventions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Created by Tenorio94 on 10/26/2016.
 */
public class ConstantsConvention {

    public ArrayList<String> readFile(String sFilePath) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(sFilePath));
        ArrayList<String> listFileRead = new ArrayList<String>();

        while (scanner.hasNext()){
            listFileRead.add(scanner.next());
        }
        scanner.close();

        return listFileRead;
    }

    public void evaluateConstants(ArrayList<String> listCurrentFileRead) {
        int iNumber = 1;
        int iIntegerIndex = 0;
        String sCurrentWord = "";

        System.out.println(listCurrentFileRead);

        while(listCurrentFileRead.contains("const")){
            iIntegerIndex = listCurrentFileRead.indexOf("const");
            sCurrentWord = listCurrentFileRead.get(iIntegerIndex + 1);

            switch(sCurrentWord) {
                case "int" :
                    evaluateConstantIntegers();
                    break;

                case "double" :
                    evaluateConstantDouble();
                    break;

                case "String" :
                    evaluateConstantStrings();
                    break;

                case "float" :
                    evaluateConstantFloat();
                    break;

                case "boolean" :
                    evaluateConstantBooleans();
                    break;

                case "int[]" :
                    evaluateConstantIntArray();
                    break;

                case "double[]" :
                    evaluateConstantDoubleMatrix();
                    break;

            }

            if(sCurrentWord.charAt(sCurrentWord.length() - 1) == ';') {
                System.out.println(sCurrentWord);
            }

            System.out.println("Integer #" + iNumber + " Found");
            iNumber++;

            listCurrentFileRead.remove(iIntegerIndex);
        }
    }

    private void evaluateConstantIntegers(){

    }

    private void evaluateConstantBooleans(){

    }

    private void evaluateConstantStrings(){

    }

    private void evaluateConstantChars(){

    }

    private void evaluateConstantDouble(){

    }

    private void evaluateConstantFloat(){

    }

    private void evaluateConstantIntArray(){

    }

    private void evaluateConstantDoubleMatrix(){

    }

}
