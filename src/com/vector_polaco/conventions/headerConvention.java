package com.vector_polaco.conventions;

import java.io.File;
import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by meyru on 12/11/2016.
 */
public class headerConvention {

    private int iContadordeErrores = 0;
    boolean bFileName = false;
    boolean bDate = false;
    boolean bVersion = false;

    public ArrayList<String> readFile(String sFilePath) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(sFilePath));
        ArrayList<String> listFileRead = new ArrayList<String>();
        while (scanner.hasNext()) {
            listFileRead.add(scanner.nextLine());
        }
        scanner.close();
        return listFileRead;
    }

    public void evaluateHeader(ArrayList<String> listCurrentFileRead) {
        int i = 0;
        // Si la primera linea empieza con el bloque de comentarios
        if (listCurrentFileRead.get(0).contains("/*")) {
            /*while(!(listCurrentFileRead.contains("*///"))){
            //listCurrentFileRead.
            //} */
            i++;
            while (!listCurrentFileRead.get(i).contains("*/")) {
                // Checar si incluye nombre de file
                if (!listCurrentFileRead.get(i).equals("")) {
                    if (!bFileName) {
                        checkFileName(listCurrentFileRead.get(i));
                    }
                    if (!bDate) {
                        checkDate(listCurrentFileRead.get(i));
                    }
                    if (!bVersion) {
                        checkVersion(listCurrentFileRead.get(i));
                    }
                }
                i++;
            }
            if (bFileName == false || bDate == false || bVersion == false) {
                iContadordeErrores++;
                System.out.println("Error en los comentarios del header");
            }
        }

    }

    public void checkFileName(String s) {
        if (s.contains(".cpp")) {
            bFileName = true;
        }
    }

    public void checkDate(String s) {
        s = s.trim();
        if (s.charAt(2) == '/') {
            if (s.charAt(5) == '/') {
                bDate = true;
            }

        }

    }

    public void checkVersion(String s) {
        if (s.contains("version")) {
            bVersion = true;
        }

    }

    public void evaluateIncludes(ArrayList<String> listCurrentFileRead) {
        boolean bInclude = false;
        for (String s : listCurrentFileRead) {
            if (s.contains("# <include")) {
                bInclude = true;
            }
        }
        if (!bInclude) {
            iContadordeErrores++;
        }
    }

    public boolean isFunction(String s) {
        s = s.trim();
        /*ArrayList<String> lista = new ArrayList<String>();
        for (String string : s.split(",")) {
            lista.add(string);
        }    */
        boolean bTypeReturn = false;
        boolean bFuncion = true;
        //String sf = lista.get(0);
        if (s.startsWith("int") || s.startsWith("float") || s.startsWith("bool")
                || s.startsWith("long") || s.startsWith("string")
                || s.startsWith("char") || s.startsWith("void")) {
            bTypeReturn = true;
        }
        /* String ss = lista.get(1);
        if(String.valueOf(ss.charAt(0)).equals(String.valueOf(ss.charAt(0)).toLowerCase()))
        {

        }*/
        if (s.contains("(")) {
            bFuncion = true;
        }
        if (s.contains("main")) {
            bFuncion = false;
        }
        if (bTypeReturn && bFuncion) {
            return true;
        } else {
            return false;
        }
    }

    public void checkFunction(String s) {
        boolean bParam = false;
        boolean bComa = false;
        boolean bComaAux = false;
        String sub;
        s = s.trim();
        ArrayList<String> listaParamType = new ArrayList<String>();
        ArrayList<String> listaParam = new ArrayList<String>();
        ArrayList<String> lista = new ArrayList<String>();
        for(String string : s.split(" ")){
            lista.add(string);
        }
        for (String string : lista) {
            if (string.contains(",")) {
                bComa = true;
            }
            if (bParam) {
                listaParam.add(string);
                bParam = false;
            }
            if (string.contains("(") || bComa == true) {
                if (string.contains("(")) {
                    int iP = string.indexOf("(");
                    int iL = string.length();
                    sub = string.substring(iP + 1, iL);
                    listaParamType.add(sub);
                    bParam = true;
                }
                else if (bComa) {
                    if(bComaAux == true){
                        sub = string;
                        listaParamType.add(sub);
                        bComa = false;
                        bComaAux = false;
                        bParam = true;
                    }
                    else if (string.contains(",")) {
                        int iC = string.indexOf(",");
                        int iL = string.length();
                        String subAux = string.substring(iC+1,iL);
                        if(subAux == "double" || subAux == "int" || subAux == "float"
                                || subAux == "long" || subAux == "string" ||
                                subAux == "char" || subAux == "bool"){
                            sub = subAux;
                            listaParamType.add(sub);
                            bComa = false;
                            bParam = true;
                        }
                        else{
                            bComaAux = true;
                        }
                    }
                }
            }
        }
        String ss = lista.get(1);
        if (!String.valueOf(ss.charAt(0)).equals(String.valueOf(ss.charAt(0)).toLowerCase())) {
            iContadordeErrores++;
            System.out.println("Función no debe comenzar con mayúscula: " + ss);
        }
        for (int i = 0; i < listaParam.size(); i++) {
            String sp = listaParam.get(i);
            String sss = listaParamType.get(i);
            if (sp.charAt(0) != sss.charAt(0)) {
                iContadordeErrores++;
                System.out.println("Parametro no cumple con estandar de variable: " + sp);
            }
        }
    }


    public void evaluateFunctionsYComentarios(ArrayList<String> listCurrentFileRead) {
        boolean bComentarios = false;
        boolean bParam = false;
        boolean bReturn = false;
        boolean bFuncion = false;
        boolean bFinDeComentario = false;
        for (String s : listCurrentFileRead) {
            if (s.contains("/*")) {
                bComentarios = true;
            }
            if (s.contains("*/")) {
                bComentarios = false;
                bFinDeComentario = true;
            }
            if (bComentarios) {
                if (s.contains("Parameters:")) {
                    bParam = true;
                } else if (s.contains("Returns:")) {
                    bReturn = true;
                }
            }
            if (!s.equals("\n")) {
                if (bFinDeComentario = true) {
                    bFuncion = isFunction(s);
                    if (bFuncion) {
                        if (bParam == false || bReturn == false) {
                            iContadordeErrores++;
                            System.out.println("Se encontró una funcion y el comentario no tiene los requerimientos de valores return y o parametros");
                        }
                        checkFunction(s);
                        bFinDeComentario = false;
                    }
                }
            }

        }
    }

    public void evaluateComments(ArrayList<String> listCurrentFileRead) {
        boolean bGrupodeFuncion = false;
        for (String s : listCurrentFileRead) {
            if (bGrupodeFuncion) {
                if (!(s.contains("//")) || (s.contains("/*"))) {
                    iContadordeErrores++;
                    System.out.println("No hay comentario para grupo de funcion");
                }
                bGrupodeFuncion = false;
            }
            if (s.equals("\n")) {
                bGrupodeFuncion = true;
            }
        }
    }

    public void checkContent(ArrayList<String> listCurreintFileRead) {
        evaluateHeader(listCurreintFileRead);
        evaluateIncludes(listCurreintFileRead);
        evaluateFunctionsYComentarios(listCurreintFileRead);
        evaluateComments(listCurreintFileRead);

    }
}