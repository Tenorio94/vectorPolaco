package com.vector_polaco.conventions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by 1046877159 on 29/10/2016.
 */
public class whiteSpaceConvention {
    private int IndentationLevel;
    public void readFile(String sFilePath) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(sFilePath));
        ArrayList<String> listFileRead = new ArrayList<String>();

        while (scanner.hasNext()){
            listFileRead.add(scanner.nextLine());
        }
        scanner.close();
    }
    public void checkIndentationLevel(){

    }
}

