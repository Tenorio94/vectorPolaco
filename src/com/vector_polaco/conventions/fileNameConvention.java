package com.vector_polaco.conventions;

/**
 * Created by Tenorio94 on 10/26/2016.
 */

import java.io.File;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class fileNameConvention {
    public ArrayList<String> sArrFileNames = new ArrayList<String>();
    public ArrayList<ArrayList<String>> sArrFileNamingEvaluation = new ArrayList<>();

    public void retrieveFiles(String sPathName){
        File folder = new File(sPathName);
        File [] fileInDirectoryCollection = folder.listFiles();
        System.out.println(sPathName);
        String sExtension = "";
        int iExtensionIndex = 0;

        for(File fileIndividual: fileInDirectoryCollection){
            if (fileIndividual.isFile()){
                iExtensionIndex = fileIndividual.getName().lastIndexOf('.');
                sExtension = fileIndividual.getName();
                sExtension = sExtension.substring(iExtensionIndex + 1);

                if(sExtension.equals("cpp")) {
                    sArrFileNames.add(fileIndividual.getName());
                }
            }
        }
        System.out.println(sArrFileNames);
    }

    public void checkFileName(String sFileName){
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
        if (Pattern.matches(".*[áéíóúýñÑ].*", sFileName)){
            sArrNameReview.add("Filename should not contain accents or ñ/Ñ");
            bPerfectFileName = false;
        }

        if(bPerfectFileName){
            sArrNameReview.add("Filename - OK");
        }
        sArrFileNamingEvaluation.add(sArrNameReview);
    }

    public void printArray(String sTypeArray){
        if (sTypeArray == "Naming"){
            for(int iterator = 0; iterator < sArrFileNames.size(); iterator++){
                System.out.println("Filename " + sArrFileNames.get(iterator));
            }
        }
        else if (sTypeArray == "Evaluation"){
            for(int iterator = 0; iterator < sArrFileNamingEvaluation.size(); iterator++){
                System.out.println(sArrFileNamingEvaluation.get(iterator));
            }
        }
    }

}
