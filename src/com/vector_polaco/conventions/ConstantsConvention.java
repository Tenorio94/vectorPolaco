package com.vector_polaco.conventions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Tenorio94 on 10/26/2016.
 */
public class ConstantsConvention {

    public void readFile(String sFilePath) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(sFilePath));
        ArrayList<String> list = new ArrayList<String>();

        while (scanner.hasNext()){
            list.add(scanner.next());
        }

        scanner.close();
    }

}
