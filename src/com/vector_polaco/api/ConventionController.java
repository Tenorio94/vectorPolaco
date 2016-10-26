package com.vector_polaco.api;

import com.vector_polaco.interfaces.*;
import com.vector_polaco.conventions.*;

import java.util.ArrayList;

/**
 * Created by Tenorio94 on 10/26/2016.
 */
public class ConventionController {

    public ArrayList<String> sArrFileNames = new ArrayList<String>();
    public ArrayList<ArrayList<String>> sArrFileNamingEvaluation = new ArrayList<>();
    fileNameConvention NamingConvention = new fileNameConvention();

    public void getFilesController(String sPath){
        Boolean bDebugging = true;
        NamingConvention.retrieveFiles(sPath, sArrFileNames);

        for(String sFileName : sArrFileNames){
            NamingConvention.evaluateFileName(sFileName, sArrFileNamingEvaluation);
        }

        if(bDebugging){
            NamingConvention.printArray("Naming", sArrFileNamingEvaluation, sArrFileNames);
            NamingConvention.printArray("Evaluation", sArrFileNamingEvaluation, sArrFileNames);
        }
    }

}
