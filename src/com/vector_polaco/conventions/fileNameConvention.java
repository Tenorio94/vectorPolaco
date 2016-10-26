package com.vector_polaco.conventions;

/**
 * Created by Tenorio94 on 10/26/2016.
 */

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class fileNameConvention {

    public void retrieveFiles(String sPathName, ArrayList<String> sArrFileNames){
        File folder = new File(sPathName);
        File [] fileInDirectoryCollection = folder.listFiles();
        System.out.println(sPathName);
        String sExtension = "";
        String sOriginalName = "";
        int iExtensionIndex = 0;

        for(File fileIndividual: fileInDirectoryCollection){
            if (fileIndividual.isFile()){
                iExtensionIndex = fileIndividual.getName().lastIndexOf('.');
                sExtension = fileIndividual.getName();
                sExtension = sExtension.substring(iExtensionIndex + 1);

                if(sExtension.equals("cpp")) {
                    sOriginalName = removeNamePrefix(fileIndividual.getName());
                    sArrFileNames.add(sOriginalName);
                }
            }
        }
        System.out.println(sArrFileNames);
    }

    //Remove Blackboard default formatting
    private String removeNamePrefix(String sFileName){
        int iDateScoreIndex = 0;
        String sOriginalFileName = "";

        iDateScoreIndex = sFileName.indexOf("_attempt_");
        sOriginalFileName = sFileName.substring(iDateScoreIndex + 29);

        return sOriginalFileName;
    }

    public void evaluateFileName(String sFileName, ArrayList<ArrayList<String>> sArrFileNamingEvaluation){
        ArrayList<String> sArrNameReview = new ArrayList<String>();
        Boolean bPerfectFileName = true;

        if (sFileName.contains("_")) {
            sArrNameReview.add("Filename cannot contain underscore.");
            bPerfectFileName = false;
        }
        if (sFileName.contains(" ")){
            sArrNameReview.add("Filename cannot contain spaces.");
            bPerfectFileName = false;
        }
        if (Character.isLowerCase(sFileName.charAt(0))){
            sArrNameReview.add("Filename should start with uppercase");
            bPerfectFileName = false;
        }
        if (Pattern.matches(".*[áéíóúýñÑ%].*", sFileName)){
            sArrNameReview.add("Filename should not contain accents, '%', or ñ/Ñ");
            bPerfectFileName = false;
        }

        if(bPerfectFileName){
            sArrNameReview.add("Filename - OK");
        }
        sArrFileNamingEvaluation.add(sArrNameReview);
    }

    //Debugging
    public void printArray(String sTypeArray, ArrayList<ArrayList<String>> sArrFileNamingEvaluation, ArrayList<String> sArrFileNames){
        if (sTypeArray == "Naming"){
            for(int iterator = 0; iterator < sArrFileNames.size(); iterator++){
                System.out.println("Filename " + sArrFileNames.get(iterator));
            }
        }
        else if (sTypeArray == "Evaluation"){
            System.out.println("-----------------------------------------------------");
            for(int iterator = 0; iterator < sArrFileNamingEvaluation.size(); iterator++){
                System.out.println("Naming review for file " + sArrFileNames.get(iterator));
                for(String sNameFeedback : sArrFileNamingEvaluation.get(iterator)) {
                    System.out.println(sNameFeedback);
                }
                System.out.println("-----------------------------------------------------");
            }
        }
    }

}
