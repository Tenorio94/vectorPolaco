package com.company.conventions;

import java.io.File;
import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by meyru on 12/11/2016.
 */
public class headerConvention {

    public ArrayList<String> readFile(String sFilePath, File fin) throws IOException {
        FileInputStream fis = new FileInputStream(fin);
        // Construct BufferedReader from InputStreamReader
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));
        ArrayList<String> listFileRead = new ArrayList<String>();
        String line;

        while ((line = br.readLine()) != null) {
            System.out.println(line);
            listFileRead.add(line);
        }
        br.close();

        return listFileRead;
    }

    public void evaluateHeader(ArrayList<String> listCurrentFileRead) {
        boolean bFileName = false;
        System.out.println("+" + listCurrentFileRead);

        // Si la primera linea empieza con el bloque de comentarios
        if (listCurrentFileRead.get(0).trim().startsWith("/*")) {
            /*while(!(listCurrentFileRead.contains("*///"))){
                //listCurrentFileRead.
            //} */
            for (int i = 0; listCurrentFileRead.get(i).contains("*/"); i++) {
                // Checar si incluye nombre de file
                if (!bFileName) {
                    bFileName = checkFileName(listCurrentFileRead.get(i));
                }

            }

        }

        // else: calificar 0
    }

    public boolean checkFileName(String line) {
        if (line.contains("cpp")) {
            return true;
        }
        return false;
    }

    public boolean checkDescription(String line) {

        return false;
    }

    public boolean checkName(String line) {

        return false;
    }

    public boolean checkDate(String line) {

        if (line.matches([abc]) {

        }
        return false;
    }

}
