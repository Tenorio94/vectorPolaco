package com.vector_polaco.utilities;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ashraf
 */
public class CsvFileWriter {

    //Delimiter used in CSV file
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";
    private FileWriter fileWriter;
    //CSV file header
    private static final String FILE_HEADER = "nombre,criterio1,criterio2,criterio3,criterio4";

    public CsvFileWriter(String fileName) {
        try {
            fileWriter = new FileWriter(fileName);
            fileWriter.append(FILE_HEADER);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeCsvFile(String s) {

        try {
            fileWriter.append(s);
        } catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Error while flushing/closing fileWriter !!!");
            e.printStackTrace();
        }


    }
}