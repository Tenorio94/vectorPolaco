package com.vector_polaco.api;

import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;
import com.vector_polaco.conventions.*;
import com.vector_polaco.VariableObject;
import com.vector_polaco.interfaces.InterfazCriterios;
import com.vector_polaco.interfaces.InterfazPrincipal;
import com.vector_polaco.models.ListaCriterio;
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
    private InterfazPrincipal ip;
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

        ArrayList<String> listCurrentFile = Constants.readFile(sArrFilePath.get(0));
        Constants.evaluateConstants(listCurrentFile);

        Constants.fillVariables(listCurrentFile, "int");
        Constants.fillVariables(listCurrentFile, "bool");
        Constants.fillVariables(listCurrentFile, "double");
        Constants.fillVariables(listCurrentFile, "char");
        Constants.fillVariables(listCurrentFile, "float");
        Constants.fillVariables(listCurrentFile, "String");
        Constants.fillVariables(listCurrentFile, "iArr");
        ArrayList<VariableObject> arrListRealVariables = Constants.fillVariables(listCurrentFile, "dMat");
        Constants.evaluateVariables(arrListRealVariables);

        ArrayList<String> lista = wsc.readFile(sArrFilePath.get(0));
        wsc.checkWhiteSpaces(lista);
        ArrayList<String> list = wsc.readFile(sArrFilePath.get(0));
        iplc.checkWhiteSpaces(list);
        ArrayList<String> listFiles = hc.readFile(sArrFilePath.get(0));
        hc.checkContent(listFiles);

        System.out.println("Finished...");
    }

    public void launchMainInterface(){
        ArrayList<ListaCriterio> l = ListaCriterio.getAll();
        if(l.size() > 0){
            ip = new InterfazPrincipal(this);
            ip.setListaCriterio(l);
            ip.createGUI();
            ip.setVisible(true);
        } else {
            InterfazCriterios ic = new InterfazCriterios(this);
            ic.createGUI();
            ic.setVisible(true);
            ic.launchFirstTime();
        }
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

    public void updateList() {
        ArrayList<ListaCriterio> l = ListaCriterio.getAll();
        if(ip == null){
            ip = new InterfazPrincipal(this);
            ip.createGUI();
            ip.setVisible(true);
        }
        ip.setListaCriterio(l);
    }
}

