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

    public int iContadordeErrores = 0;
    private boolean bFileName = false;
    private boolean bDate = false;
    private boolean bVersion = false;
    private String sNomFuncion = "";
    private ArrayList<String> arrHeader = new ArrayList();

    public ArrayList<String> readFile(String sFilePath) throws FileNotFoundException {
        iContadordeErrores = 0;
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
        if (listCurrentFileRead.size() > 0) {
            if (listCurrentFileRead.get(0).contains("/*")) {
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
                    this.iContadordeErrores++;
                    String aux = "";
                    if(bFileName == false){
                        aux = aux.concat(", nombre del archivo, ");
                    }
                    if(bDate == false){
                        aux = aux.concat(", fecha ,");
                    }
                    if(bVersion == false){
                        aux = aux.concat(", version de c++ ,");
                    }
                    arrHeader.add("Error en los comentarios del header, no contiene " + aux);
                    System.out.println("Error en los comentarios del header no contiene " + aux);
                }
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
        if (s.length() > 4 && s.charAt(2) == '/' && s.charAt(5) == '/') {
            bDate = true;
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
            arrHeader.add("No contiene #<include>");
        }
    }

    public boolean isFunction(String s) {
        s = s.trim();
        /*ArrayList<String> lista = new ArrayList<String>();
        for (String string : s.split(",")) {
            lista.add(string);
        }    */
        boolean bTypeReturn = false;
        boolean bFuncion = false;
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
            int iBegin = s.indexOf(" ");
            int iEnd = s.indexOf("(");
            sNomFuncion = s.substring(iBegin + 1, iEnd);
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
        for (String string : s.split(" ")) {
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
                } else if (bComa) {
                    if (bComaAux == true) {
                        sub = string;
                        listaParamType.add(sub);
                        bComa = false;
                        bComaAux = false;
                        bParam = true;
                    } else if (string.contains(",")) {
                        int iC = string.indexOf(",");
                        int iL = string.length();
                        String subAux = string.substring(iC + 1, iL);
                        if (subAux == "double" || subAux == "int" || subAux == "float"
                                || subAux == "long" || subAux == "string" ||
                                subAux == "char" || subAux == "bool") {
                            sub = subAux;
                            listaParamType.add(sub);
                            bComa = false;
                            bParam = true;
                        } else {
                            bComaAux = true;
                        }
                    }
                }
            }
        }
        String ss = lista.get(1);
        if (!String.valueOf(ss.charAt(0)).equals(String.valueOf(ss.charAt(0)).toLowerCase())) {
            iContadordeErrores++;
            int iAux = ss.indexOf("(");
            String sAux = ss.substring(0,iAux);
            arrHeader.add("Función no debe comenzar con mayúscula: " + sAux);
            System.out.println("Función no debe comenzar con mayúscula: " + sAux);
        }
        for (int i = 0; i < listaParam.size(); i++) {
            String sp = listaParam.get(i);
            String sss = listaParamType.get(i);
            if (sp.charAt(0) != sss.charAt(0)) {
                iContadordeErrores++;
                arrHeader.add("Parametro no cumple con estandar de variable: " + sp);
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
                            String sAux = "";
                            if(bParam == false){
                                sAux.concat(" parametros ");
                            }
                            if(bReturn == false){
                                sAux.concat(" return ");
                            }
                            arrHeader.add("Se encontró la funcion"
                                    + sNomFuncion + "y el comentario no "
                                    + "tiene los requerimientos de " + sAux);
                            System.out.println("Se encontró la funcion"
                                    + sNomFuncion + "y el comentario no "
                                    + "tiene los requerimientos de " + sAux);
                        }
                        sNomFuncion = "";
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
                    arrHeader.add("No hay comentarios para grupo de funciones");
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

    private int getiContadordeErrores(){
        return iContadordeErrores;
    }

    public ArrayList<String> getArrHeader(){
        return arrHeader;
    }
}