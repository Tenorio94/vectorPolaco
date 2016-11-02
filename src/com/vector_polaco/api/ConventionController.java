package com.vector_polaco.api;

import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;
import com.vector_polaco.conventions.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Created by Tenorio94 on 10/26/2016.
 */
public class ConventionController {

    public ArrayList<String> sArrFileNames = new ArrayList<String>();
    public ArrayList<String> sArrFilePath = new ArrayList<>();
    public ArrayList<ArrayList<String>> sArrFileNamingEvaluation = new ArrayList<>();

    fileNameConvention NamingConvention = new fileNameConvention();

    public void getFilesController(String sPath){
        Boolean bDebugging = true;
        NamingConvention.retrieveFiles(sPath, sArrFileNames, sArrFilePath);

        for(String sFileName : sArrFileNames){
            NamingConvention.evaluateFileName(sFileName, sArrFileNamingEvaluation);
        }

        if(bDebugging){
            NamingConvention.printArray("Naming", sArrFileNamingEvaluation, sArrFileNames);
            NamingConvention.printArray("Evaluation", sArrFileNamingEvaluation, sArrFileNames);
        }
    }

    public void nameConstantConvention() throws FileNotFoundException {
        ConstantsConvention Constants = new ConstantsConvention();

        /*for (String sFilePath : sArrFilePath){
            Constants.readFile(sFilePath);
        }*/

        ArrayList<String> listCurrentFile = Constants.readFile(sArrFilePath.get(0));
        ArrayList<ConstantsConvention> arrListVariables = Constants.evaluateConstants(listCurrentFile);

    }
}
