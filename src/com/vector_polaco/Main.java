package com.vector_polaco;

import com.vector_polaco.interfaces.InterfazPrincipal;
import com.vector_polaco.conventions.fileNameConvention;

public class Main {

    public static void main(String[] args) {
        InterfazPrincipal ipVentanaUno = new InterfazPrincipal();
        ipVentanaUno.createGUI();
        ipVentanaUno.setVisible(true);

        /*fileNameConvention checkFile = new fileNameConvention();
        checkFile.retrieveFiles("C:\\Users\\Teorio94\\IdeaProjects\\vectorPolaco\\src\\com\\vector_polaco\\tests");*/
    }
}
