/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vector_polaco.interfaces;

import com.vector_polaco.api.ConventionController;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.*;

import java.lang.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.*;

public class InterfazCriterios extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;

    private final int CELL_WIDTH = 35, CELL_HEIGHT = 25;

    private JButton jbuAceptar, jbuLimpiar, jbuSalir;
    private JFormattedTextField[] arrJteCriterios;
    private JFormattedTextField[] arrJteDeductedPoints;
    private JCheckBox[] arrJcbCriterios;
    private JLabel[] arrTitulos;
    private JLabel jlbNombreLista;
    private JTextField jteNombreLista;
    private ArrayList<Integer> liGrading = new ArrayList<>();
    private int id_lista_criterio = 0;
    private ConventionController controller;

    private static final String[] letrerosLabels = {
            "Nombre de criterio",
            "<html><div style='text-align:center'>Valor<br>porcentual</div></html>",
            "<html><div style='text-align:center'>Porcentaje<br>deducido<br>por error</div></html>"
    };
    private static final String[] letrerosCheckboxes = {"Nombre de archivo", "Nombres de variables", "Comentarios", "Indentacion", "Instrucciones por linea"};

    public InterfazCriterios(ConventionController c) {
        this.controller = c;
    }

    public InterfazCriterios(ConventionController c, int id_lista_criterio){
        this.controller = c;
        this.id_lista_criterio = id_lista_criterio;
    }

    public void createGUI() {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        Container conVentana = this.getContentPane();
        this.setSize((int) (CELL_WIDTH * 13), (int) (CELL_HEIGHT * 19.5));
        this.setResizable(false);

        NumberFormat longFormat = NumberFormat.getIntegerInstance();
        NumberFormatter numberFormatter = new NumberFormatter(longFormat);
        numberFormatter.setValueClass(Integer.class); //optional, ensures you will always get a long value
        numberFormatter.setAllowsInvalid(false); //this is the key!!
        numberFormatter.setMinimum(0); //Optional
        numberFormatter.setMaximum(100);

        arrJteCriterios = new JFormattedTextField[5];
        arrJteDeductedPoints = new JFormattedTextField[5];
        arrJcbCriterios = new JCheckBox[5];
        arrTitulos = new JLabel[3];


        jlbNombreLista = new JLabel("Nombre de lista");
        jlbNombreLista.setBounds(CELL_WIDTH * 1, CELL_HEIGHT * 1, CELL_WIDTH * 3, CELL_HEIGHT);
        conVentana.add(jlbNombreLista);

        jteNombreLista = new JTextField();
        jteNombreLista.setBounds(CELL_WIDTH * 4, CELL_HEIGHT * 1, CELL_WIDTH * 8, CELL_HEIGHT);
        conVentana.add(jteNombreLista);

        for (int i = 0; i < 3; i++) {
            arrTitulos[i] = new JLabel(letrerosLabels[i]);
            arrTitulos[i].setVerticalAlignment(JLabel.CENTER);
            arrTitulos[i].setHorizontalAlignment(JLabel.CENTER);
            if (i == 0) {
                arrTitulos[i].setBounds(CELL_WIDTH, CELL_HEIGHT * 3, CELL_WIDTH * 5, CELL_HEIGHT * 2);
            } else {
                arrTitulos[i].setBounds(CELL_WIDTH * ((i - 1) * 3 + 7), CELL_HEIGHT * 3, CELL_WIDTH * 2, CELL_HEIGHT * 2);
            }
            conVentana.add(arrTitulos[i]);
        }

        conVentana.setLayout(null);

        for (int i = 0; i < 5; i++) {
            liGrading.add(0);
        }

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        for (int i = 0; i < 5; i++) {
            final int x = i;
            arrJcbCriterios[i] = new JCheckBox(letrerosCheckboxes[i]);
            arrJteCriterios[i] = new JFormattedTextField(numberFormatter);
            arrJteDeductedPoints[i] = new JFormattedTextField(numberFormatter);

            arrJcbCriterios[i].setBounds(CELL_WIDTH, CELL_HEIGHT * (5 + 2 * i), CELL_WIDTH * 6, CELL_HEIGHT);
            arrJteDeductedPoints[i].addKeyListener(new KeyListener() {
                @Override
                public void keyTyped(KeyEvent event) {
                    if(event.getKeyChar() == ('\b') && arrJteDeductedPoints[x].getText().length() == 1) {
                        arrJteDeductedPoints[x].setValue(null);
                    }
                }

                @Override
                public void keyPressed(KeyEvent e) {}

                @Override
                public void keyReleased(KeyEvent e) {}
            });
            conVentana.add(arrJcbCriterios[i]);
            arrJteCriterios[i].addKeyListener(new KeyListener() {
                @Override
                public void keyTyped(KeyEvent event) {
                    if(event.getKeyChar() == ('\b') && arrJteCriterios[x].getText().length() == 1) {
                        arrJteCriterios[x].setValue(null);
                    }
                }

                @Override
                public void keyPressed(KeyEvent e) {}

                @Override
                public void keyReleased(KeyEvent e) {}
            });

            arrJteCriterios[i].setBounds(CELL_WIDTH * 7, CELL_HEIGHT * (5 + 2 * i), CELL_WIDTH * 2, CELL_HEIGHT);
            conVentana.add(arrJteCriterios[i]);

            arrJteDeductedPoints[i].setBounds(CELL_WIDTH * 10, CELL_HEIGHT * (5 + 2 * i), CELL_WIDTH * 2, CELL_HEIGHT);


            conVentana.add(arrJteDeductedPoints[i]);
        }

        // Botones
        jbuSalir = new JButton("Salir");
        jbuSalir.setBounds(CELL_WIDTH, CELL_HEIGHT * 16, CELL_WIDTH * 3, CELL_HEIGHT);
        conVentana.add(jbuSalir);
        jbuSalir.addActionListener(e -> InterfazCriterios.this.dispose());

        jbuLimpiar = new JButton("Limpiar");
        jbuLimpiar.setBounds(CELL_WIDTH * 5, CELL_HEIGHT * 16, CELL_WIDTH * 3, CELL_HEIGHT);
        conVentana.add(jbuLimpiar);
        jbuLimpiar.addActionListener(this);

        jbuAceptar = new JButton("Continuar");
        jbuAceptar.setBounds(CELL_WIDTH * 9, CELL_HEIGHT * 16, CELL_WIDTH * 3, CELL_HEIGHT);
        conVentana.add(jbuAceptar);
        jbuAceptar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int iTotal = 0;
                for (int i : liGrading) {
                    iTotal += i;
                }
                if (iTotal != 100) {
                    JOptionPane.showMessageDialog(null,
                            "El total de la suma debe ser 100.",
                            "error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    private void checaContenidoDeTextField(JTextField jteAChecar) {
        if (jteAChecar.getText().equals("")) {
            jteAChecar.setText("0");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}
