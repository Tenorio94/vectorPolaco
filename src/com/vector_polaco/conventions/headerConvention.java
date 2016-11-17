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
        System.out.println("+" + listCurrentFileRead);
        
        int i = 1;

        // Si la primera linea empieza con el bloque de comentarios
        if (listCurrentFileRead.get(0).contains("/*")) {
            /*while(!(listCurrentFileRead.contains("*///"))){
                //listCurrentFileRead.
            //} */
            while(!listCurrentFileRead.get(i).contains("*/")) {
                // Checar si incluye nombre de file
                if(!bFileName){
                    checkFileName(listCurrentFileRead.get(i));
                }
                if(!bDate){
                    checkDate(listCurrentFileRead.get(i));
                }
                if(!bVersion){
                    checkVersion(listCurrentFileRead.get(i));
                }
                i++;
            }
            if(bFileName == false || bDate == false || bVersion == false){
                iContadordeErrores++;
                System.out.println("Faltan datos en los comentarios de header");
            }
        }
        
        
       
    }

    public void checkFileName(String s){
        if (s.contains(".cpp")) {
            bFileName = true;
        }        
    }
    
    public void checkDate(String s){
        s = s.trim();
        if(s.charAt(2)=='/') {
            if (s.charAt(5) == '/') {
                bDate = true;
            }
        }
    }
    
    public void checkVersion(String s){
        if(s.contains("version")){
            bVersion = true;
        }
    }
    
    public void evaluateIncludes(ArrayList<String> listCurrentFileRead){
        boolean bInclude = false;
        for (String s : listCurrentFileRead)
        {
            if(s.contains("# <include"))
            {
                bInclude = true;
            }
        }
        if(!bInclude){
            iContadordeErrores++;
        }
    }

    public boolean isFunction(String s){
        s = s.trim();
        /*ArrayList<String> lista = new ArrayList<String>();
        for (String string : s.split(",")) {
            lista.add(string);
        }    */    
        boolean bTypeReturn = false;
        boolean bFuncion = true;
        //String sf = lista.get(0);
        if (s.startsWith("int") || s.startsWith("float") || s.startsWith("bool") 
                || s.startsWith("long") || s.startsWith("string") || 
                s.startsWith("char") || s.startsWith("void"))
        {
            bTypeReturn = true;
        }
       /* String ss = lista.get(1);
        if(String.valueOf(ss.charAt(0)).equals(String.valueOf(ss.charAt(0)).toLowerCase()))
        {
            
        }*/
        if(s.contains("(")){
            bFuncion = true;
        }
        if(bTypeReturn && bFuncion){
            return true;
        }
        else{
            return false;
        }
    }
    
    public void checkFunction(String s){
        s = s.trim();
        ArrayList<String> lista = new ArrayList<String>();
        for (String string : s.split(",")) {
            lista.add(string);
        }     
        String ss = lista.get(1);
        if(!String.valueOf(ss.charAt(0)).equals(String.valueOf(ss.charAt(0)).toLowerCase()))
        {
            iContadordeErrores++;
            System.out.println("Función no debe comenzar con mayuscula");
        }
        for(int i = 2; i < lista.size(); i+=2){
            String sp = lista.get(i);
            String sss = lista.get(i+1);
            if(sp.charAt(0) != sss.charAt(0)){
                iContadordeErrores++;
                System.out.println("Parametro no cumple con estandar de variable");
            }
            
        }
    }
    
    public void evaluateFunctionsYComentarios(ArrayList<String> listCurrentFileRead){
        boolean bComentarios = false;
        boolean bParam = false;
        boolean bReturn = false;
        boolean bFuncion = false;
        boolean bFinDeComentario = false;
        for (String s : listCurrentFileRead){
            if(s.contains("/*")){
                bComentarios = true;
            }
            if(s.contains("*/")){
                bComentarios = false;
                bFinDeComentario = true;
            }
            if(bComentarios){
                if(s.contains("Parameters:")){
                    bParam = true;
                }
                else if(s.contains("Returns:")){
                    bReturn = true;
                }
            }
            if(!s.equals("\n")){
                if(bFinDeComentario = true){
                    bFuncion = isFunction(s);
                    if(bFuncion) {
                        if(bParam == false || bReturn == false){
                            iContadordeErrores++;
                            System.out.println("hay una funcion y el comentario no tiene los requerimientos de valores return y o parametros");
                        }
                        checkFunction(s);
                        bFinDeComentario = false;
                    }
                }
            }
            
        }
    }
    
    public void evaluateComments(ArrayList<String> listCurrentFileRead){
        boolean bGrupodeFuncion = false;
        for(String s : listCurrentFileRead){
            if(bGrupodeFuncion){
                if(!(s.contains("//")) || (s.contains("/*"))){
                   iContadordeErrores++;
                   System.out.println("No hay comentario para grupo de funcion");
                }
                bGrupodeFuncion = false;
            }
            if(s.equals("\n")){
                bGrupodeFuncion = true;
            }
        }
    }
    
    public void checkContent(ArrayList<String> listCurreintFileRead){
        evaluateHeader(listCurreintFileRead);
        evaluateIncludes(listCurreintFileRead);
        evaluateFunctionsYComentarios(listCurreintFileRead);
        evaluateComments(listCurreintFileRead);
    }
}

