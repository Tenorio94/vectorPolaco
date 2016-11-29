package com.vector_polaco.conventions;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
import  com.vector_polaco.VariableObject;

/**
 * Created by Tenorio94 on 10/26/2016.
 */
public class ConstantsConvention {

    ArrayList<VariableObject> arrListVariables = new ArrayList<>();
    ArrayList<VariableObject> arrListRealVariables = new ArrayList<>();

    public ArrayList<String> readFile(String sFilePath) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(sFilePath));
        ArrayList<String> listFileRead = new ArrayList<String>();

        while (scanner.hasNext()){
            listFileRead.add(scanner.next());
        }
        scanner.close();

        return listFileRead;
    }

    public ArrayList<VariableObject>  fillVariables(ArrayList<String> listCurrentFileRead, String type){

        int iNumber = 1;
        int iIntegerIndex = 0;
        String sCurrentWord = "";

        if(type == "int"){
            while(listCurrentFileRead.contains("int")) {
                iIntegerIndex = listCurrentFileRead.indexOf("int");
                listCurrentFileRead.remove(iIntegerIndex);

                do {
                    sCurrentWord = listCurrentFileRead.get(iIntegerIndex);
                    //System.out.println("Integer: " + sCurrentWord);
                    fillVariableInteger(sCurrentWord);
                    listCurrentFileRead.remove(iIntegerIndex);
                }while(sCurrentWord.charAt(sCurrentWord.length() - 1) != ';' && sCurrentWord.charAt(sCurrentWord.length() - 1) != '(' && sCurrentWord.charAt(sCurrentWord.length() - 1) != ')');
            }
        }

        if(type == "bool"){
            while(listCurrentFileRead.contains("bool")) {
                iIntegerIndex = listCurrentFileRead.indexOf("bool");
                listCurrentFileRead.remove(iIntegerIndex);

                do {
                    sCurrentWord = listCurrentFileRead.get(iIntegerIndex);
                    //System.out.println("Boolean: " + sCurrentWord);
                    fillVariableBoolean(sCurrentWord);
                    listCurrentFileRead.remove(iIntegerIndex);
                }while(sCurrentWord.charAt(sCurrentWord.length() - 1) != ';' && sCurrentWord.charAt(sCurrentWord.length() - 1) != '(' && sCurrentWord.charAt(sCurrentWord.length() - 1) != ')');
            }
        }

        if (type == "double"){
            while(listCurrentFileRead.contains("double")) {
                iIntegerIndex = listCurrentFileRead.indexOf("double");
                listCurrentFileRead.remove(iIntegerIndex);

                do {
                    sCurrentWord = listCurrentFileRead.get(iIntegerIndex);
                    //System.out.println("Double: " + sCurrentWord);
                    fillVariableDouble(sCurrentWord);
                    listCurrentFileRead.remove(iIntegerIndex);
                }while(sCurrentWord.charAt(sCurrentWord.length() - 1) != ';' && sCurrentWord.charAt(sCurrentWord.length() - 1) != '(' && sCurrentWord.charAt(sCurrentWord.length() - 1) != ')');
            }
        }

        if(type == "float"){
            while(listCurrentFileRead.contains("float")) {
                iIntegerIndex = listCurrentFileRead.indexOf("float");
                listCurrentFileRead.remove(iIntegerIndex);

                do {
                    sCurrentWord = listCurrentFileRead.get(iIntegerIndex);
                    //System.out.println("Float: " + sCurrentWord);
                    fillVariableFloat(sCurrentWord);
                    listCurrentFileRead.remove(iIntegerIndex);
                }while(sCurrentWord.charAt(sCurrentWord.length() - 1) != ';' && sCurrentWord.charAt(sCurrentWord.length() - 1) != '(' && sCurrentWord.charAt(sCurrentWord.length() - 1) != ')');
            }
        }

        if (type == "char") {
            while(listCurrentFileRead.contains("char")) {
                iIntegerIndex = listCurrentFileRead.indexOf("char");
                listCurrentFileRead.remove(iIntegerIndex);

                do {
                    sCurrentWord = listCurrentFileRead.get(iIntegerIndex);
                    //System.out.println("Char: " + sCurrentWord);
                    fillVariableChar(sCurrentWord);
                    listCurrentFileRead.remove(iIntegerIndex);
                }while(sCurrentWord.charAt(sCurrentWord.length() - 1) != ';' && sCurrentWord.charAt(sCurrentWord.length() - 1) != '(' && sCurrentWord.charAt(sCurrentWord.length() - 1) != ')');
            }
        }

        if(type == "String"){
            while(listCurrentFileRead.contains("String")) {
                iIntegerIndex = listCurrentFileRead.indexOf("String");
                listCurrentFileRead.remove(iIntegerIndex);

                do {
                    sCurrentWord = listCurrentFileRead.get(iIntegerIndex);
                    //System.out.println("String: " + sCurrentWord);
                    fillVariableString(sCurrentWord);
                    listCurrentFileRead.remove(iIntegerIndex);
                }while(sCurrentWord.charAt(sCurrentWord.length() - 1) != ';' && sCurrentWord.charAt(sCurrentWord.length() - 1) != '(' && sCurrentWord.charAt(sCurrentWord.length() - 1) != ')');
            }
        }

        if(type == "iArr"){
            while(listCurrentFileRead.contains("iArr")) {
                iIntegerIndex = listCurrentFileRead.indexOf("iArr");
                listCurrentFileRead.remove(iIntegerIndex);

                do {
                    sCurrentWord = listCurrentFileRead.get(iIntegerIndex);
                    //System.out.println("iArr: " + sCurrentWord);
                    fillVariableIntArr(sCurrentWord);
                    listCurrentFileRead.remove(iIntegerIndex);
                }while(sCurrentWord.charAt(sCurrentWord.length() - 1) != ';' && sCurrentWord.charAt(sCurrentWord.length() - 1) != '(' && sCurrentWord.charAt(sCurrentWord.length() - 1) != ')');
            }
        }

        if(type == "dMat"){
            while(listCurrentFileRead.contains("dMat")) {
                iIntegerIndex = listCurrentFileRead.indexOf("dMat");
                listCurrentFileRead.remove(iIntegerIndex);

                do {
                    sCurrentWord = listCurrentFileRead.get(iIntegerIndex);
                    System.out.println("dMat: " + sCurrentWord);
                    fillVariableDoubleMatrix(sCurrentWord);
                    listCurrentFileRead.remove(iIntegerIndex);
                }while(sCurrentWord.charAt(sCurrentWord.length() - 1) != ';' && sCurrentWord.charAt(sCurrentWord.length() - 1) != '(' && sCurrentWord.charAt(sCurrentWord.length() - 1) != ')');
            }
        }

        return arrListRealVariables;
    }

    public void fillVariableInteger(String sVariableName){
        VariableObject newInteger = new VariableObject(sVariableName, "Integer", false);
        arrListRealVariables.add(newInteger);

        newInteger = null;
    }

    public void fillVariableBoolean(String sVariableName){
        VariableObject newBoolean = new VariableObject(sVariableName, "Boolean", false);
        arrListRealVariables.add(newBoolean);

        newBoolean = null;
    }

    public void fillVariableDouble(String sVariableName){
        VariableObject newDouble = new VariableObject(sVariableName, "Double", false);
        arrListRealVariables.add(newDouble);

        newDouble = null;
    }

    public void fillVariableFloat(String sVariableName){
        VariableObject newFloat = new VariableObject(sVariableName, "Float", false);
        arrListRealVariables.add(newFloat);

        newFloat = null;
    }

    public void fillVariableChar(String sVariableName){
        VariableObject newChar = new VariableObject(sVariableName, "Character", false);
        arrListRealVariables.add(newChar);

        newChar = null;
    }

    public void fillVariableString(String sVariableName){
        VariableObject newString = new VariableObject(sVariableName, "String", false);
        arrListRealVariables.add(newString);

        newString = null;
    }

    public void fillVariableIntArr(String sVariableName){
        VariableObject newIntArr = new VariableObject(sVariableName, "Integer Array", false);
        arrListRealVariables.add(newIntArr);

        newIntArr = null;
    }

    public void fillVariableDoubleMatrix(String sVariableName){
        VariableObject newDMat = new VariableObject(sVariableName, "Double Matrix", false);
        arrListRealVariables.add(newDMat);

        newDMat = null;
    }

    public void evaluateVariables(ArrayList<VariableObject> arrListRealVariables){
        for(VariableObject variable : arrListRealVariables){
            switch (variable.sVariableType) {
                case "Integer" :
                    evaluateVariableInteger(variable);
                    break;
                case "Boolean" :
                    evaluateVariableBoolean(variable);
                    break;
                case "String" :
                    evaluateVariableString(variable);
                    break;
                case "Character" :
                    evaluateVariableCharacter(variable);
                    break;
                case "Double" :
                    evaluateVariableDouble(variable);
                    break;
                case "Float" :
                    evaluateVariableFloat(variable);
                    break;
                case "Integer Array" :
                    evaluateVariableIntArray(variable);
                    break;
                case "Double Matrix" :
                    evaluateVariableDoubleMatrix(variable);
                    break;
            }
        }
    }

    private void evaluateVariableInteger(VariableObject variable){
        String currentvariable = variable.sVariableName;
        boolean bIsPerfect = true;
        currentvariable = currentvariable.replace(",", "");
        currentvariable = currentvariable.replace(";", "");
        currentvariable = currentvariable.replace(")", "");
        currentvariable = currentvariable.replace("(", "");
        currentvariable = currentvariable.trim();
        variable.sVariableName = currentvariable;

        System.out.println(currentvariable.charAt(0));

        if (currentvariable.charAt(0) != 'i'){
            variable.sFeedback += "Variable starts with wrong prefix.\n";
            bIsPerfect = false;
        }

        if (bIsPerfect){
            variable.sFeedback += "Variable is correctly written";
        }
    }

    private void evaluateVariableBoolean(VariableObject variable){
        String currentvariable = variable.sVariableName;
        boolean bIsPerfect = true;
        currentvariable = currentvariable.replace(",", "");
        currentvariable = currentvariable.replace(";", "");
        currentvariable = currentvariable.replace(")", "");
        currentvariable = currentvariable.replace("(", "");
        currentvariable = currentvariable.trim();
        variable.sVariableName = currentvariable;

        if (currentvariable.charAt(0) != 'b'){
            variable.sFeedback += "Variable starts with wrong prefix.\n";
            bIsPerfect = false;
        }

        if (bIsPerfect){
            variable.sFeedback += "Variable is correctly written";
        }
    }

    private void evaluateVariableString(VariableObject variable){
        String currentvariable = variable.sVariableName;
        boolean bIsPerfect = true;
        currentvariable = currentvariable.replace(",", "");
        currentvariable = currentvariable.replace(";", "");
        currentvariable = currentvariable.replace(")", "");
        currentvariable = currentvariable.replace("(", "");
        currentvariable = currentvariable.trim();
        variable.sVariableName = currentvariable;

        if (currentvariable.charAt(0) != 's'){
            variable.sFeedback += "Variable starts with wrong prefix.\n";
            bIsPerfect = false;
        }

        if (bIsPerfect){
            variable.sFeedback += "Variable is correctly written";
        }
    }

    private void evaluateVariableCharacter(VariableObject variable){
        String currentvariable = variable.sVariableName;
        boolean bIsPerfect = true;
        currentvariable = currentvariable.replace(",", "");
        currentvariable = currentvariable.replace(";", "");
        currentvariable = currentvariable.replace(")", "");
        currentvariable = currentvariable.replace("(", "");
        currentvariable = currentvariable.trim();
        variable.sVariableName = currentvariable;

        if (currentvariable.charAt(0) != 'c'){
            variable.sFeedback += "Variable starts with wrong prefix.\n";
            bIsPerfect = false;
        }

        if (bIsPerfect){
            variable.sFeedback += "Variable is correctly written";
        }
    }

    private void evaluateVariableDouble(VariableObject variable){
        String currentvariable = variable.sVariableName;
        boolean bIsPerfect = true;
        currentvariable = currentvariable.replace(",", "");
        currentvariable = currentvariable.replace(";", "");
        currentvariable = currentvariable.replace(")", "");
        currentvariable = currentvariable.replace("(", "");
        currentvariable = currentvariable.trim();
        variable.sVariableName = currentvariable;

        if (currentvariable.charAt(0) != 'd'){
            variable.sFeedback += "Variable starts with wrong prefix.\n";
            bIsPerfect = false;
        }

        if (bIsPerfect){
            variable.sFeedback += "Variable is correctly written";
        }
    }

    private void evaluateVariableFloat(VariableObject variable){
        String currentvariable = variable.sVariableName;
        boolean bIsPerfect = true;
        currentvariable = currentvariable.replace(",", "");
        currentvariable = currentvariable.replace(";", "");
        currentvariable = currentvariable.replace(")", "");
        currentvariable = currentvariable.replace("(", "");
        currentvariable = currentvariable.trim();
        variable.sVariableName = currentvariable;

        if (currentvariable.charAt(0) != 'f'){
            variable.sFeedback += "Variable starts with wrong prefix.\n";
            bIsPerfect = false;
        }

        if (bIsPerfect){
            variable.sFeedback += "Variable is correctly written";
        }
    }

    private void evaluateVariableIntArray(VariableObject variable){
        String currentvariable = variable.sVariableName;
        boolean bIsPerfect = true;
        currentvariable = currentvariable.replace(",", "");
        currentvariable = currentvariable.replace(";", "");
        currentvariable = currentvariable.replace(")", "");
        currentvariable = currentvariable.replace("(", "");
        currentvariable = currentvariable.trim();
        variable.sVariableName = currentvariable;

        if (currentvariable.substring(0, 3) != "iArr"){
            variable.sFeedback += "Variable starts with wrong prefix.\n";
            bIsPerfect = false;
        }

        if (bIsPerfect){
            variable.sFeedback += "Variable is correctly written";
        }
    }

    private void evaluateVariableDoubleMatrix(VariableObject variable){
        String currentvariable = variable.sVariableName;
        boolean bIsPerfect = true;
        currentvariable = currentvariable.replace(",", "");
        currentvariable = currentvariable.replace(";", "");
        currentvariable = currentvariable.replace(")", "");
        currentvariable = currentvariable.replace("(", "");
        currentvariable = currentvariable.trim();
        variable.sVariableName = currentvariable;

        if (currentvariable.substring(0, 3) != "dMat"){
            variable.sFeedback += "Variable starts with wrong prefix.\n";
            bIsPerfect = false;
        }

        if (bIsPerfect){
            variable.sFeedback += "Variable is correctly written";
        }
    }




    public ArrayList<VariableObject> fillConstants(ArrayList<String> listCurrentFileRead) {
        int iNumber = 1;
        int iIntegerIndex = 0;
        String sCurrentWord = "";

        System.out.println(listCurrentFileRead);

        while(listCurrentFileRead.contains("const")){
            iIntegerIndex = listCurrentFileRead.indexOf("const");
            listCurrentFileRead.remove(iIntegerIndex);
            sCurrentWord = listCurrentFileRead.get(iIntegerIndex);

            switch(sCurrentWord) {
                case "int" :
                    do {
                        listCurrentFileRead.remove(iIntegerIndex);
                        sCurrentWord = listCurrentFileRead.get(iIntegerIndex);
                        fillConstantIntegers(sCurrentWord);
                    }while(sCurrentWord.charAt(sCurrentWord.length() - 1) != ';');
                    break;

                case "double" :
                    do {
                        listCurrentFileRead.remove(iIntegerIndex);
                        sCurrentWord = listCurrentFileRead.get(iIntegerIndex);
                        fillConstantDouble(sCurrentWord);
                    }while(sCurrentWord.charAt(sCurrentWord.length() - 1) != ';');
                    break;

                case "char" :
                    do {
                        listCurrentFileRead.remove(iIntegerIndex);
                        sCurrentWord = listCurrentFileRead.get(iIntegerIndex);

                        fillConstantChars(sCurrentWord);
                    }while(sCurrentWord.charAt(sCurrentWord.length() - 1) != ';');
                    break;

                case "String" :
                    do {
                        listCurrentFileRead.remove(iIntegerIndex);
                        sCurrentWord = listCurrentFileRead.get(iIntegerIndex);
                        fillConstantStrings(sCurrentWord);
                    }while(sCurrentWord.charAt(sCurrentWord.length() - 1) != ';');
                    break;

                case "float" :
                    do {
                        listCurrentFileRead.remove(iIntegerIndex);
                        sCurrentWord = listCurrentFileRead.get(iIntegerIndex);
                        fillConstantFloat(sCurrentWord);
                    }while(sCurrentWord.charAt(sCurrentWord.length() - 1) != ';');
                    break;

                case "bool" :
                    do {
                        listCurrentFileRead.remove(iIntegerIndex);
                        sCurrentWord = listCurrentFileRead.get(iIntegerIndex);
                        fillConstantBooleans(sCurrentWord);
                    }while(sCurrentWord.charAt(sCurrentWord.length() - 1) != ';');
                    break;

                case "int[]" :
                    do {
                        listCurrentFileRead.remove(iIntegerIndex);
                        sCurrentWord = listCurrentFileRead.get(iIntegerIndex);
                        fillConstantIntArray(sCurrentWord);
                    }while(sCurrentWord.charAt(sCurrentWord.length() - 1) != ';');
                    break;

                case "double[]" :
                    do {
                        listCurrentFileRead.remove(iIntegerIndex);
                        sCurrentWord = listCurrentFileRead.get(iIntegerIndex);
                        fillConstantDoubleMatrix(sCurrentWord);
                    }while(sCurrentWord.charAt(sCurrentWord.length() - 1) != ';');
                    break;
            }

            iNumber++;
            listCurrentFileRead.remove(iIntegerIndex);
        }
        System.out.println(listCurrentFileRead);
        return arrListVariables;
    }

    public void evaluateConstants(ArrayList<VariableObject> arrListVariables){
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
        boolean bUpperCase = false;
        currentConstant = currentConstant.replace(",", "");
        currentConstant = currentConstant.replace(";", "");
        currentConstant = currentConstant.trim();

        if (currentConstant.charAt(0) != 'i'){
            constant.sFeedback += "Variable starts with wrong prefix.\n";
            bIsPerfect = false;
        }

        for (int i=1; i<currentConstant.length(); i++){
            if (Character.isLowerCase(currentConstant.charAt(i))){
                if (!bUpperCase)
                    constant.sFeedback += "Variable should be written in uppercase. \n";
                bIsPerfect = false;
                bUpperCase = true;
            }
        }

        if (bIsPerfect){
            constant.sFeedback += "Variable is correctly written";
        }
    }

    private void evaluateBoolean(VariableObject constant){
        String currentConstant = constant.sVariableName;
        boolean bIsPerfect = true;
        boolean bUpperCase = false;
        currentConstant = currentConstant.replace(",", "");
        currentConstant = currentConstant.replace(";", "");
        currentConstant = currentConstant.trim();

        if (currentConstant.charAt(0) != 'b'){
            constant.sFeedback += "Variable starts with wrong prefix.\n";
            bIsPerfect = false;
        }

        for (int i=1; i<currentConstant.length(); i++){
            if (Character.isLowerCase(currentConstant.charAt(i))){
                if (!bUpperCase)
                    constant.sFeedback += "Variable should be written in uppercase. \n";
                bIsPerfect = false;
                bUpperCase = true;
            }
        }

        if (bIsPerfect){
            constant.sFeedback += "Variable is correctly written";
        }
    }

    private void evaluateString(VariableObject constant){
        String currentConstant = constant.sVariableName;
        boolean bIsPerfect = true;
        boolean bUpperCase = false;
        currentConstant = currentConstant.replace(",", "");
        currentConstant = currentConstant.replace(";", "");
        currentConstant = currentConstant.trim();

        if (currentConstant.charAt(0) != 's'){
            constant.sFeedback += "Variable starts with wrong prefix.\n";
            bIsPerfect = false;
        }

        for (int i=1; i<currentConstant.length(); i++){
            if (Character.isLowerCase(currentConstant.charAt(i))){
                if (!bUpperCase)
                    constant.sFeedback += "Variable should be written in uppercase. \n";
                bIsPerfect = false;
                bUpperCase = true;
            }
        }

        if (bIsPerfect){
            constant.sFeedback += "Variable is correctly written";
        }
    }

    private void evaluateCharacter(VariableObject constant){
        String currentConstant = constant.sVariableName;
        boolean bIsPerfect = true;
        boolean bUpperCase = false;
        currentConstant = currentConstant.replace(",", "");
        currentConstant = currentConstant.replace(";", "");
        currentConstant = currentConstant.trim();

        if (currentConstant.charAt(0) != 'c'){
            constant.sFeedback += "Variable starts with wrong prefix.\n";
            bIsPerfect = false;
        }

        for (int i=1; i<currentConstant.length(); i++){
            if (Character.isLowerCase(currentConstant.charAt(i))){
                if (!bUpperCase)
                    constant.sFeedback += "Variable should be written in uppercase. \n";
                bIsPerfect = false;
                bUpperCase = true;
            }
        }

        if (bIsPerfect){
            constant.sFeedback += "Variable is correctly written";
        }
    }

    private void evaluateDouble(VariableObject constant){
        String currentConstant = constant.sVariableName;
        boolean bIsPerfect = true;
        boolean bUpperCase = false;
        currentConstant = currentConstant.replace(",", "");
        currentConstant = currentConstant.replace(";", "");
        currentConstant = currentConstant.trim();

        if (currentConstant.charAt(0) != 'd'){
            constant.sFeedback += "Variable starts with wrong prefix.\n";
            bIsPerfect = false;
        }

        for (int i=1; i<currentConstant.length(); i++){
            if (Character.isLowerCase(currentConstant.charAt(i))){
                if (!bUpperCase)
                    constant.sFeedback += "Variable should be written in uppercase. \n";
                bIsPerfect = false;
                bUpperCase = true;
            }
        }

        if (bIsPerfect){
            constant.sFeedback += "Variable is correctly written";
        }
    }

    private void evaluateFloat(VariableObject constant){
        String currentConstant = constant.sVariableName;
        boolean bIsPerfect = true;
        boolean bUpperCase = false;
        currentConstant = currentConstant.replace(",", "");
        currentConstant = currentConstant.replace(";", "");
        currentConstant = currentConstant.trim();

        if (currentConstant.charAt(0) != 'f'){
            constant.sFeedback += "Variable starts with wrong prefix.\n";
            bIsPerfect = false;
        }

        for (int i=1; i<currentConstant.length(); i++){
            if (Character.isLowerCase(currentConstant.charAt(i))){
                if (!bUpperCase)
                    constant.sFeedback += "Variable should be written in uppercase. \n";
                bIsPerfect = false;
                bUpperCase = true;
            }
        }

        if (bIsPerfect){
            constant.sFeedback += "Variable is correctly written";
        }
    }

    private void evaluateIntArray(VariableObject constant){
        String currentConstant = constant.sVariableName;
        boolean bIsPerfect = true;
        boolean bUpperCase = false;
        currentConstant = currentConstant.replace(",", "");
        currentConstant = currentConstant.replace(";", "");
        currentConstant = currentConstant.trim();

        if (currentConstant.substring(0, 3) != "iArr"){
            constant.sFeedback += "Variable starts with wrong prefix.\n";
            bIsPerfect = false;
        }

        for (int i=1; i<currentConstant.length(); i++){
            if (Character.isLowerCase(currentConstant.charAt(i))){
                if (!bUpperCase)
                    constant.sFeedback += "Variable should be written in uppercase. \n";
                bIsPerfect = false;
                bUpperCase = true;
            }
        }

        if (bIsPerfect){
            constant.sFeedback += "Variable is correctly written";
        }
    }

    private void evaluateDoubleMatrix(VariableObject constant){
        String currentConstant = constant.sVariableName;
        boolean bIsPerfect = true;
        boolean bUpperCase = false;
        currentConstant = currentConstant.replace(",", "");
        currentConstant = currentConstant.replace(";", "");
        currentConstant = currentConstant.trim();

        if (currentConstant.substring(0, 3) != "dMat"){
            constant.sFeedback += "Variable starts with wrong prefix.\n";
            bIsPerfect = false;
        }

        for (int i=1; i<currentConstant.length(); i++){
            if (Character.isLowerCase(currentConstant.charAt(i))){
                if (!bUpperCase)
                    constant.sFeedback += "Variable should be written in uppercase. \n";
                bIsPerfect = false;
                bUpperCase = true;
            }
        }

        if (bIsPerfect){
            constant.sFeedback += "Variable is correctly written";
        }
    }


}
