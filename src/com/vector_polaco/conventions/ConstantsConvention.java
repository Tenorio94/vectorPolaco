package com.vector_polaco.conventions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Tenorio94 on 10/26/2016.
 */
public class ConstantsConvention {

    ArrayList<ConstantsConvention> arrListVariables = new ArrayList<>();

    public ConstantsConvention () {
        String sVariableName = "";
        Boolean bConstant = true;
        String sVariableType = "";
    }

    public ConstantsConvention (String sName, String sType, Boolean bIsConstant) {
        String sVariableName = sName;
        Boolean bConstant = bIsConstant;
        String sVariableType = sType;
    }

    public ArrayList<String> readFile(String sFilePath) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(sFilePath));
        ArrayList<String> listFileRead = new ArrayList<String>();

        while (scanner.hasNext()){
            listFileRead.add(scanner.next());
        }
        scanner.close();

        return listFileRead;
    }

    public ArrayList<ConstantsConvention> evaluateConstants(ArrayList<String> listCurrentFileRead) {
        int iNumber = 1;
        int iIntegerIndex = 0;
        String sCurrentWord = "";

        System.out.println(listCurrentFileRead);

        while(listCurrentFileRead.contains("const")){
            iIntegerIndex = listCurrentFileRead.indexOf("const");
            sCurrentWord = listCurrentFileRead.get(iIntegerIndex + 1);

            switch(sCurrentWord) {
                case "int" :
                    evaluateConstantIntegers(sCurrentWord);
                    break;

                case "double" :
                    evaluateConstantDouble(sCurrentWord);
                    break;

                case "String" :
                    evaluateConstantStrings(sCurrentWord);
                    break;

                case "float" :
                    evaluateConstantFloat(sCurrentWord);
                    break;

                case "bool" :
                    evaluateConstantBooleans(sCurrentWord);
                    break;

                case "int[]" :
                    evaluateConstantIntArray(sCurrentWord);
                    break;

                case "double[]" :
                    evaluateConstantDoubleMatrix(sCurrentWord);
                    break;

            }

            if(sCurrentWord.charAt(sCurrentWord.length() - 1) == ';') {
                System.out.println(sCurrentWord);
            }

            System.out.println("Integer #" + iNumber + " Found");
            iNumber++;

            listCurrentFileRead.remove(iIntegerIndex);
        }

        return arrListVariables;
    }

    private void evaluateConstantIntegers(String sConstantName){
        System.out.println("Enter integer");

        ConstantsConvention newInteger = new ConstantsConvention(sConstantName, "Integer", true);
        arrListVariables.add(newInteger);

        newInteger = null;
    }

    private void evaluateConstantBooleans(String sConstantName){
        System.out.println("Enter Boolean");

        ConstantsConvention newBoolean = new ConstantsConvention(sConstantName, "Boolean", true);
        arrListVariables.add(newBoolean);

        newBoolean = null; //Garbage collector
    }

    private void evaluateConstantStrings(String sConstantName){
        System.out.println("Enter String");

        ConstantsConvention newString = new ConstantsConvention(sConstantName, "String", true);
        arrListVariables.add(newString);

        newString = null;
    }

    private void evaluateConstantChars(String sConstantName){
        System.out.println("Enter Character");

        ConstantsConvention newCharacter = new ConstantsConvention(sConstantName, "Character", true);
        arrListVariables.add(newCharacter);

        newCharacter = null;
    }

    private void evaluateConstantDouble(String sConstantName){
        System.out.println("Enter Double");

        ConstantsConvention newDouble = new ConstantsConvention(sConstantName, "Double", true);
        arrListVariables.add(newDouble);

        newDouble = null;
    }

    private void evaluateConstantFloat(String sConstantName){
        System.out.println("Enter Float");

        ConstantsConvention newFloat = new ConstantsConvention(sConstantName, "Float", true);
        arrListVariables.add(newFloat);

        newFloat = null;
    }

    private void evaluateConstantIntArray(String sConstantName){
        System.out.println("Enter Integer Array");

        ConstantsConvention newIntegerArray = new ConstantsConvention(sConstantName, "Integer Array", true);
        arrListVariables.add(newIntegerArray);

        newIntegerArray = null;
    }

    private void evaluateConstantDoubleMatrix(String sConstantName){
        System.out.println("Enter Double Matrix");

        ConstantsConvention newDoubleMatrix = new ConstantsConvention(sConstantName, "Double Matrix", true);
        arrListVariables.add(newDoubleMatrix);

        newDoubleMatrix = null;
    }

}
