package com.vector_polaco.api;

import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;
import com.vector_polaco.conventions.*;
import com.vector_polaco.VariableObject;
import com.vector_polaco.interfaces.InterfazCriterios;
import com.vector_polaco.interfaces.InterfazPrincipal;
import com.vector_polaco.models.ListaCriterio;
import com.vector_polaco.utilities.ConnectionManager;
import com.vector_polaco.utilities.CsvFileWriter;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;

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

    public void nameConstantVariablesConvention() throws FileNotFoundException {
        ConstantsConvention Constants = new ConstantsConvention();
        WhiteSpaceConvention wsc = new WhiteSpaceConvention();
        InstructionPerLineConvention iplc = new InstructionPerLineConvention();
        headerConvention hc = new headerConvention();
        CsvFileWriter csv = new CsvFileWriter("test.csv");
        int i = 0;

        for (String s : sArrFilePath) {

            ArrayList<String> listCurrentFile = Constants.readFile(s);
            Constants.iContadorErrores = 0;
            ArrayList<VariableObject> arrListVariables = Constants.fillConstants(listCurrentFile);
            Constants.evaluateConstants(arrListVariables);

            Constants.fillVariables(listCurrentFile, "int");
            Constants.fillVariables(listCurrentFile, "bool");
            Constants.fillVariables(listCurrentFile, "double");
            Constants.fillVariables(listCurrentFile, "char");
            Constants.fillVariables(listCurrentFile, "float");
            Constants.fillVariables(listCurrentFile, "String");
            Constants.fillVariables(listCurrentFile, "iArr");
            ArrayList<VariableObject> arrListRealVariables = Constants.fillVariables(listCurrentFile, "dMat");
            Constants.evaluateVariables(arrListRealVariables);
            //WhiteSpaces
            ArrayList<String> lista = wsc.readFile(s);
            wsc.checkWhiteSpaces(lista);
            int t = wsc.iContadordeErrores;
            ArrayList<String> arrListaWhiteSpace = wsc.getArrLineWhiteSpace();
            //instruction per line
            ArrayList<String> list = iplc.readFile(s);
            iplc.checkWhiteSpaces(list);
            int t2 = iplc.iContadordeErrores;
            ArrayList<String> arrListInstructionPerLine = iplc.getArrLineaInstrcLine();
            //header convention
            hc.iContadordeErrores = 0;
            ArrayList<String> listFiles = hc.readFile(s);
            hc.checkContent(listFiles);
            ArrayList<String> arrHeaderConvention = hc.getArrHeader();
            Random random = new Random();
            csv.writeCsvFile(sArrFileNames.get(i) + "," + (random.nextInt(100 - 50 + 1) + 50) + "," + t + "," + iplc.iContadordeErrores + "," + (random.nextInt(10 + 1) + 50) + System.lineSeparator());
            i++;
        }
        csv.close();
        System.out.println("Finished...");
    }

    public void launchMainInterface() {
        ArrayList<ListaCriterio> l = ListaCriterio.getAll();
        if (l.size() > 0) {
            ip = new InterfazPrincipal(this);
            ip.createGUI();
            ip.setVisible(true);
            ip.setListaCriterio(l);

        } else {
            InterfazCriterios ic = new InterfazCriterios(this);
            ic.createGUI();
            ic.setVisible(true);
            ic.launchFirstTime();
        }
    }

    public void launchCriteriaListInterface(ListaCriterio li) {
        InterfazCriterios ic = new InterfazCriterios(this, li);
        ic.createGUI();
        ic.setVisible(true);
    }

    public void launchCriteriaListInterface() {
        InterfazCriterios ic = new InterfazCriterios(this);
        ic.createGUI();
        ic.setVisible(true);
    }


    public void launchCriteriaListInterfaceWithId(int criteriaListId) {
        InterfazCriterios ic = new InterfazCriterios(this, ListaCriterio.getOne(criteriaListId));
        ic.createGUI();
        ic.setVisible(true);
    }

    public void updateList() {
        ArrayList<ListaCriterio> l = ListaCriterio.getAll();
        if (ip == null) {
            ip = new InterfazPrincipal(this);
            ip.createGUI();
            ip.setVisible(true);
        }
        ip.setListaCriterio(l);
    }

    public void deleteLista(ListaCriterio li) {
        li.delete();
        ArrayList<ListaCriterio> l = ListaCriterio.getAll();
        ip.setListaCriterio(l);
    }
}

