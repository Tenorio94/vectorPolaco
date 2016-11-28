package com.vector_polaco.api;

import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;
import com.vector_polaco.conventions.*;
import com.vector_polaco.interfaces.InterfazCriterios;
import com.vector_polaco.interfaces.InterfazPrincipal;
import com.vector_polaco.utilities.ConnectionManager;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Created by Tenorio94 on 10/26/2016.
 */
public class ConventionController {

    public ArrayList<String> sArrFileNames = new ArrayList<String>();
    public ArrayList<String> sArrFilePath = new ArrayList<>();
    public ArrayList<ArrayList<String>> sArrFileNamingEvaluation = new ArrayList<>();
    ConnectionManager conmManager;
    fileNameConvention NamingConvention = new fileNameConvention();

    public ConventionController() {
        conmManager = ConnectionManager.getInstance();
    }

    public void getFilesController(String sPath) {
        Boolean bDebugging = true;
        NamingConvention.retrieveFiles(sPath, sArrFileNames, sArrFilePath);

        for (String sFileName : sArrFileNames) {
            NamingConvention.evaluateFileName(sFileName, sArrFileNamingEvaluation);
        }

        if (bDebugging) {
            NamingConvention.printArray("Naming", sArrFileNamingEvaluation, sArrFileNames);
            NamingConvention.printArray("Evaluation", sArrFileNamingEvaluation, sArrFileNames);
        }
    }

    public void nameConstantConvention() throws FileNotFoundException {
        ConstantsConvention Constants = new ConstantsConvention();
        WhiteSpaceConvention wsc = new WhiteSpaceConvention();
        InstructionPerLineConvention iplc = new InstructionPerLineConvention();
        headerConvention hc = new headerConvention();

        /*for (String sFilePath : sArrFilePath){
            Constants.readFile(sFilePath);
        }*/

        ArrayList<String> listCurrentFile = Constants.readFile(sArrFilePath.get(0));
        ArrayList<ConstantsConvention> arrListVariables = Constants.evaluateConstants(listCurrentFile);
        Constants.evaluateConstants(listCurrentFile);
        ArrayList<String> lista = wsc.readFile(sArrFilePath.get(0));
        wsc.checkWhiteSpaces(lista);
        ArrayList<String> list = wsc.readFile(sArrFilePath.get(0));
        iplc.checkWhiteSpaces(list);
        ArrayList<String> listFiles = hc.readFile(sArrFilePath.get(0));
        hc.checkContent(listFiles);
    }

    public void launchMainInterface(){
        InterfazPrincipal ipVentanaUno = new InterfazPrincipal(this);
        ipVentanaUno.createGUI();
        ipVentanaUno.setVisible(true);
    }

    public void launchCriteriaListInterface(){
        InterfazCriterios ic = new InterfazCriterios(this);
        ic.createGUI();
        ic.setVisible(true);
    }

    public void launchCriteriaListInterfaceWithId(int criteriaListId){
        InterfazCriterios ic = new InterfazCriterios(this, criteriaListId);
        ic.createGUI();
        ic.setVisible(true);
    }
}

