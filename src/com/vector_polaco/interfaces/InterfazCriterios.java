/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vector_polaco.interfaces;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import static java.lang.System.in;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.LinkedList;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.lang.*;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class InterfazCriterios extends JFrame implements ActionListener, KeyListener {

    private static final long serialVersionUID = 1L;

    private final int CELL_WIDTH = 30, CELL_HEIGHT = 25;

    private JButton jbuAceptar, jbuLimpiar, jbuSalir;
    private JTextField jteCriterio1, jteCriterio2, jteCriterio3, jteCriterio4, jteCriterio5;
    private JCheckBox jcbCriterio1, jcbCriterio2, jcbCriterio3, jcbCriterio4, jcbCriterio5;
    private ArrayList<String> liCriterios = new ArrayList<>();
    private ArrayList<Integer> liGrading = new ArrayList<>();

    public void createGui() {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        Container conVentana = this.getContentPane();
        this.setSize((int) (CELL_WIDTH * 13), (int) (CELL_HEIGHT * 19.5));
        this.setResizable(false);

        conVentana.setLayout(null);

        jcbCriterio1 = new JCheckBox("Nombre de archivo");
        jcbCriterio1.setBounds(CELL_WIDTH, CELL_HEIGHT, CELL_WIDTH * 6, CELL_HEIGHT);
        conVentana.add(jcbCriterio1);
        jcbCriterio1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                liCriterios.add("1");
            }

        });

        //jcbCriterio1.addActionListener(e -> validateCriteria(0, jcbCriterio1, jteCriterio1));
        jcbCriterio2 = new JCheckBox("Nombres de variables");
        jcbCriterio2.setBounds(CELL_WIDTH, CELL_HEIGHT * 3, CELL_WIDTH * 6, CELL_HEIGHT);
        conVentana.add(jcbCriterio2);
        jcbCriterio2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                liCriterios.add("2");
            }

        });

        //jcbCriterio2.addActionListener(e -> validateCriteria(1, jcbCriterio2, jteCriterio2));
        jcbCriterio3 = new JCheckBox("Comentarios");
        jcbCriterio3.setBounds(CELL_WIDTH, CELL_HEIGHT * 5, CELL_WIDTH * 6, CELL_HEIGHT);
        conVentana.add(jcbCriterio3);
        jcbCriterio3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                liCriterios.add("3");
            }

        });

        //jcbCriterio3.addActionListener(e -> validateCriteria(2, jcbCriterio3, jteCriterio3));
        jcbCriterio4 = new JCheckBox("Indentacion");
        jcbCriterio4.setBounds(CELL_WIDTH, CELL_HEIGHT * 7, CELL_WIDTH * 6, CELL_HEIGHT);
        conVentana.add(jcbCriterio4);
        jcbCriterio4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                liCriterios.add("4");
            }

        });

        //jcbCriterio4.addActionListener(e -> validateCriteria(2, jcbCriterio4, jteCriterio4));;
        jcbCriterio5 = new JCheckBox("Instrucciones por linea");
        jcbCriterio5.setBounds(CELL_WIDTH, CELL_HEIGHT * 9, CELL_WIDTH * 6, CELL_HEIGHT);
        conVentana.add(jcbCriterio5);
        jcbCriterio5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                liCriterios.add("5");
            }

        });

        //jcbCriterio5.addActionListener(e -> validateCriteria(1, jcbCriterio5, jteCriterio5));
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        jteCriterio1 = new JTextField("0") {
            public void processKeyEvent(KeyEvent ev) {
                char c = ev.getKeyChar();
                if (c >= 48 && c <= 57 || c == '\b') { // c = '0' ... c = '9'
                    super.processKeyEvent(ev);
                }
            }
        };
        jteCriterio1.setBounds(CELL_WIDTH * 7, CELL_HEIGHT, CELL_WIDTH * 5, CELL_HEIGHT);
        /* jteCriterio1.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                checaContenidoDeTextField(jteCriterio1);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                checaContenidoDeTextField(jteCriterio1);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                checaContenidoDeTextField(jteCriterio1);
            }
        });*/
        conVentana.add(jteCriterio1);

        jteCriterio2 = new JTextField("0") {
            public void processKeyEvent(KeyEvent ev) {
                char c = ev.getKeyChar();
                if (c >= 48 && c <= 57 || c == '\b') { // c = '0' ... c = '9'
                    super.processKeyEvent(ev);
                }
            }
        };
        jteCriterio2.setBounds(CELL_WIDTH * 7, CELL_HEIGHT * 3, CELL_WIDTH * 5, CELL_HEIGHT);
        /* jteCriterio2.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                checaContenidoDeTextField(jteCriterio2);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                checaContenidoDeTextField(jteCriterio2);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                checaContenidoDeTextField(jteCriterio2);
            }
        });*/
        conVentana.add(jteCriterio2);

        jteCriterio3 = new JTextField("0") {
            public void processKeyEvent(KeyEvent ev) {
                char c = ev.getKeyChar();
                if (c >= 48 && c <= 57 || c == '\b') { // c = '0' ... c = '9'
                    super.processKeyEvent(ev);
                }
            }
        };
        jteCriterio3.setBounds(CELL_WIDTH * 7, CELL_HEIGHT * 5, CELL_WIDTH * 5, CELL_HEIGHT);
        /*jteCriterio3.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                checaContenidoDeTextField(jteCriterio3);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                checaContenidoDeTextField(jteCriterio3);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                checaContenidoDeTextField(jteCriterio3);
            }
        });*/
        conVentana.add(jteCriterio3);

        jteCriterio4 = new JTextField("0") {
            public void processKeyEvent(KeyEvent ev) {
                char c = ev.getKeyChar();
                if (c >= 48 && c <= 57 || c == '\b') { // c = '0' ... c = '9'
                    super.processKeyEvent(ev);
                }
            }
        };
        jteCriterio4.setBounds(CELL_WIDTH * 7, CELL_HEIGHT * 7, CELL_WIDTH * 5, CELL_HEIGHT);
        /*jteCriterio4.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                checaContenidoDeTextField(jteCriterio4);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                checaContenidoDeTextField(jteCriterio4);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                checaContenidoDeTextField(jteCriterio4);
            }
        });*/
        conVentana.add(jteCriterio4);

        jteCriterio5 = new JTextField("0") {
            public void processKeyEvent(KeyEvent ev) {
                char c = ev.getKeyChar();
                if (c >= 48 && c <= 57 || c == '\b') { // c = '0' ... c = '9'
                    super.processKeyEvent(ev);
                }
            }
        };
        jteCriterio5.setBounds(CELL_WIDTH * 7, CELL_HEIGHT * 9, CELL_WIDTH * 5, CELL_HEIGHT);
        /*jteCriterio5.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                checaContenidoDeTextField(jteCriterio5);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                checaContenidoDeTextField(jteCriterio5);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                checaContenidoDeTextField(jteCriterio5);
            }
        });*/
        conVentana.add(jteCriterio5);

        // Botones
        jbuSalir = new JButton("Salir");
        jbuSalir.setBounds(CELL_WIDTH, CELL_HEIGHT * 16, CELL_WIDTH * 3, CELL_HEIGHT);
        conVentana.add(jbuSalir);
        jbuSalir.addActionListener(this);

        jbuLimpiar = new JButton("Limpiar");
        jbuLimpiar.setBounds(CELL_WIDTH * 5, CELL_HEIGHT * 16, CELL_WIDTH * 3, CELL_HEIGHT);
        conVentana.add(jbuLimpiar);
        jbuLimpiar.addActionListener(this);

        jbuAceptar = new JButton("Continuar");
        jbuAceptar.setBounds(CELL_WIDTH * 9, CELL_HEIGHT * 16, CELL_WIDTH * 3, CELL_HEIGHT);
        conVentana.add(jbuAceptar);
        jbuAceptar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (liCriterios.size() > 0) {
                    if (liCriterios.contains("1")) {
                        if ((jteCriterio1.getText().equals("0")) || (jteCriterio1.getText().equals(""))) {
                            JOptionPane.showMessageDialog(null,
                                    "El texto 1 debe tener valor",
                                    "error",
                                    JOptionPane.ERROR_MESSAGE);
                        } else {
                            int grad = Integer.parseInt(jteCriterio1.getText());
                            liGrading.add(grad);
                        }
                    }
                    if (liCriterios.contains("2")) {
                        if ((jteCriterio2.getText().equals("0")) || (jteCriterio2.getText().equals(""))) {
                            JOptionPane.showMessageDialog(null,
                                    "El texto 2 debe tener valor",
                                    "error",
                                    JOptionPane.ERROR_MESSAGE);
                        } else {
                            int grad = Integer.parseInt(jteCriterio2.getText());
                            liGrading.add(grad);
                        }
                    }
                    if (liCriterios.contains("3")) {
                        if ((jteCriterio3.getText().equals("0")) || (jteCriterio3.getText().equals(""))) {
                            JOptionPane.showMessageDialog(null,
                                    "El texto 3 debe tener valor",
                                    "error",
                                    JOptionPane.ERROR_MESSAGE);
                        } else {
                            int grad = Integer.parseInt(jteCriterio3.getText());
                            liGrading.add(grad);
                        }
                    }
                    if (liCriterios.contains("4")) {
                        if ((jteCriterio4.getText().equals("0")) || (jteCriterio4.getText().equals(""))) {
                            JOptionPane.showMessageDialog(null,
                                    "El texto 4 debe tener valor",
                                    "error",
                                    JOptionPane.ERROR_MESSAGE);
                        } else {
                            int grad = Integer.parseInt(jteCriterio4.getText());
                            liGrading.add(grad);
                        }
                    }
                    if (liCriterios.contains("5")) {
                        if ((jteCriterio5.getText().equals("0")) || (jteCriterio5.getText().equals(""))) {
                            JOptionPane.showMessageDialog(null,
                                    "El texto 5 debe tener valor",
                                    "error",
                                    JOptionPane.ERROR_MESSAGE);
                        } else {
                            int grad = Integer.parseInt(jteCriterio5.getText());
                            liGrading.add(grad);
                        }
                    }
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
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Debe Seleccionar por lo menos un criterio",
                            "error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    /*  private void validateCriteria(int index, JCheckBox jcbCriterio, JTextField jteCriterio){
        if(!jcbCriterio.isSelected()){
            jteCriterio.setText("0");
        }
    }

    private void checaContenidoDeTextField(JTextField jteAChecar){
        if(jteAChecar.getText().equals("")){
            jteAChecar.setText("0");
        }
        else{
            int grad = Integer.parseInt(jteAChecar.getText());
            liGrading.add(grad);
        }
    }
     */
    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}
