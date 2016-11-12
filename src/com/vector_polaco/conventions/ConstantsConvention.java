package com.vector_polaco.conventions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import com.sun.org.apache.xpath.internal.operations.Bool;
import com.sun.org.apache.xpath.internal.operations.Variable;
import  com.vector_polaco.VariableObject;

/**
 * Created by Tenorio94 on 10/26/2016.
 */
public class ConstantsConvention {

    ArrayList<VariableObject> arrListVariables = new ArrayList<>();

    public ArrayList<String> readFile(String sFilePath) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(sFilePath));
        ArrayList<String> listFileRead = new ArrayList<String>();

        while (scanner.hasNext()){
            listFileRead.add(scanner.next());
        }
        scanner.close();

        return listFileRead;
    }

    public ArrayList<VariableObject> fillConstants(ArrayList<String> listCurrentFileRead) {
        int iNumber = 1;
        int iIntegerIndex = 0;
        String sCurrentWord = "";

        System.out.println(listCurrentFileRead);

        while(listCurrentFileRead.contains("const")){
            iIntegerIndex = listCurrentFileRead.indexOf("const");
            sCurrentWord = listCurrentFileRead.get(iIntegerIndex + 1);

            switch(sCurrentWord) {
                case "int" :
                    fillConstantIntegers(sCurrentWord);
                    break;

                case "double" :
                    fillConstantDouble(sCurrentWord);
                    break;

                case "char" :
                    fillConstantChars(sCurrentWord);
                    break;

                case "String" :
                    fillConstantStrings(sCurrentWord);
                    break;

                case "float" :
                    fillConstantFloat(sCurrentWord);
                    break;

                case "bool" :
                    fillConstantBooleans(sCurrentWord);
                    break;

                case "int[]" :
                    fillConstantIntArray(sCurrentWord);
                    break;

                case "double[]" :
                    fillConstantDoubleMatrix(sCurrentWord);
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

    public void evaluateConstants(){
        for(VariableObject constant : arrListVariables){
            switch (constant.sVariableType) {
                case "Integer" :
                    evaluateInteger(constant);
                    break;
                case "Boolean" :
                    evaluateBoolean(constant);
                    break;
                case "String" :
                    evaluateString(constant);
                    break;
                case "Character" :
                    evaluateCharacter(constant);
                    break;
                case "Double" :
                    evaluateDouble(constant);
                    break;
                case "Float" :
                    evaluateFloat(constant);
                    break;
                case "Integer Array" :
                    evaluateIntArray(constant);
                    break;
                case "Double Matrix" :
                    evaluateDoubleMatrix(constant);
                    break;
            }
        }
    }

    private void fillConstantIntegers(String sConstantName){
        System.out.println("Enter integer");

        VariableObject newInteger = new VariableObject(sConstantName, "Integer", true);
        arrListVariables.add(newInteger);

        newInteger = null;
    }

    private void fillConstantBooleans(String sConstantName){
        System.out.println("Enter Boolean");

        VariableObject newBoolean = new VariableObject(sConstantName, "Boolean", true);
        arrListVariables.add(newBoolean);

        newBoolean = null; //Garbage collector
    }

    private void fillConstantStrings(String sConstantName){
        System.out.println("Enter String");

        VariableObject newString = new VariableObject(sConstantName, "String", true);
        arrListVariables.add(newString);

        newString = null;
    }

    private void fillConstantChars(String sConstantName){
        System.out.println("Enter Character");

        VariableObject newCharacter = new VariableObject(sConstantName, "Character", true);
        arrListVariables.add(newCharacter);

        newCharacter = null;
    }

    private void fillConstantDouble(String sConstantName){
        System.out.println("Enter Double");

        VariableObject newDouble = new VariableObject(sConstantName, "Double", true);
        arrListVariables.add(newDouble);

        newDouble = null;
    }

    private void fillConstantFloat(String sConstantName){
        System.out.println("Enter Float");

        VariableObject newFloat = new VariableObject(sConstantName, "Float", true);
        arrListVariables.add(newFloat);

        newFloat = null;
    }

    private void fillConstantIntArray(String sConstantName){
        System.out.println("Enter Integer Array");

        VariableObject newIntegerArray = new VariableObject(sConstantName, "Integer Array", true);
        arrListVariables.add(newIntegerArray);

        newIntegerArray = null;
    }

    private void fillConstantDoubleMatrix(String sConstantName){
        System.out.println("Enter Double Matrix");

        VariableObject newDoubleMatrix = new VariableObject(sConstantName, "Double Matrix", true);
        arrListVariables.add(newDoubleMatrix);

        newDoubleMatrix = null;
    }

    private void evaluateInteger(VariableObject constant){
        String currentConstant = constant.sVariableName;
        boolean bIsPerfect = true;
        currentConstant = currentConstant.trim();

        if (currentConstant.indexOf(0) != 'i'){
            constant.sFeedback += "Variable starts with wrong prefix.";
            bIsPerfect = false;
        }

        for (int i=1; i<currentConstant.length(); i++){
            if (Character.isLowerCase(currentConstant.charAt(i))){
                constant.sFeedback += "Variable should be written in uppercase.";
                bIsPerfect = false;
            }
        }

        if (!bIsPerfect){
            constant.sFeedback += "Variable is correctly written";
        }
    }

    private void evaluateBoolean(VariableObject constant){
        String currentConstant = constant.sVariableName;
        boolean bIsPerfect = true;
        currentConstant = currentConstant.trim();

        if (currentConstant.indexOf(0) != 'b'){
            constant.sFeedback += "Variable starts with wrong prefix.";
            bIsPerfect = false;
        }

        for (int i=1; i<currentConstant.length(); i++){
            if (Character.isLowerCase(currentConstant.charAt(i))){
                constant.sFeedback += "Variable should be written in uppercase.";
                bIsPerfect = false;
            }
        }

        if (!bIsPerfect){
            constant.sFeedback += "Variable is correctly written";
        }
    }

    private void evaluateString(VariableObject constant){
        String currentConstant = constant.sVariableName;
        boolean bIsPerfect = true;
        currentConstant = currentConstant.trim();

        if (currentConstant.indexOf(0) != 's'){
            constant.sFeedback += "Variable starts with wrong prefix.";
            bIsPerfect = false;
        }

        for (int i=1; i<currentConstant.length(); i++){
            if (Character.isLowerCase(currentConstant.charAt(i))){
                constant.sFeedback += "Variable should be written in uppercase.";
                bIsPerfect = false;
            }
        }

        if (!bIsPerfect){
            constant.sFeedback += "Variable is correctly written";
        }
    }

    private void evaluateCharacter(VariableObject constant){
        String currentConstant = constant.sVariableName;
        boolean bIsPerfect = true;
        currentConstant = currentConstant.trim();

        if (currentConstant.indexOf(0) != 'c'){
            constant.sFeedback += "Variable starts with wrong prefix.";
            bIsPerfect = false;
        }

        for (int i=1; i<currentConstant.length(); i++){
            if (Character.isLowerCase(currentConstant.charAt(i))){
                constant.sFeedback += "Variable should be written in uppercase.";
                bIsPerfect = false;
            }
        }

        if (!bIsPerfect){
            constant.sFeedback += "Variable is correctly written";
        }
    }

    private void evaluateDouble(VariableObject constant){
        String currentConstant = constant.sVariableName;
        boolean bIsPerfect = true;
        currentConstant = currentConstant.trim();

        if (currentConstant.indexOf(0) != 'd'){
            constant.sFeedback += "Variable starts with wrong prefix.";
            bIsPerfect = false;
        }

        for (int i=1; i<currentConstant.length(); i++){
            if (Character.isLowerCase(currentConstant.charAt(i))){
                constant.sFeedback += "Variable should be written in uppercase.";
                bIsPerfect = false;
            }
        }

        if (!bIsPerfect){
            constant.sFeedback += "Variable is correctly written";
        }
    }

    private void evaluateFloat(VariableObject constant){
        String currentConstant = constant.sVariableName;
        boolean bIsPerfect = true;
        currentConstant = currentConstant.trim();

        if (currentConstant.indexOf(0) != 'f'){
            constant.sFeedback += "Variable starts with wrong prefix.";
            bIsPerfect = false;
        }

        for (int i=1; i<currentConstant.length(); i++){
            if (Character.isLowerCase(currentConstant.charAt(i))){
                constant.sFeedback += "Variable should be written in uppercase.";
                bIsPerfect = false;
            }
        }

        if (!bIsPerfect){
            constant.sFeedback += "Variable is correctly written";
        }
    }

    private void evaluateIntArray(VariableObject constant){
        String currentConstant = constant.sVariableName;
        boolean bIsPerfect = true;
        currentConstant = currentConstant.trim();

        if (currentConstant.substring(0,3) != "iArr"){
            constant.sFeedback += "Variable starts with wrong prefix.";
            bIsPerfect = false;
        }

        for (int i=4; i<currentConstant.length(); i++){
            if (Character.isLowerCase(currentConstant.charAt(i))){
                constant.sFeedback += "Variable should be written in uppercase.";
                bIsPerfect = false;
            }
        }

        if (!bIsPerfect){
            constant.sFeedback += "Variable is correctly written";
        }
    }

    private void evaluateDoubleMatrix(VariableObject constant){
        String currentConstant = constant.sVariableName;
        boolean bIsPerfect = true;
        currentConstant = currentConstant.trim();

        if (currentConstant.substring(0,3) != "dMat"){
            constant.sFeedback += "Variable starts with wrong prefix.";
            bIsPerfect = false;
        }

        for (int i=4; i<currentConstant.length(); i++){
            if (Character.isLowerCase(currentConstant.charAt(i))){
                constant.sFeedback += "Variable should be written in uppercase.";
                bIsPerfect = false;
            }
        }

        if (!bIsPerfect){
            constant.sFeedback += "Variable is correctly written";
        }
    }



}
