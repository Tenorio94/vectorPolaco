package com.vector_polaco;

import com.vector_polaco.interfaces.InterfazPrincipal;

public class Main {

    public static void main(String[] args) {
        InterfazPrincipal ipVentanaUno = new InterfazPrincipal();
        ipVentanaUno.createGUI();
        ipVentanaUno.setVisible(true);
    }
}
