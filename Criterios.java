/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vector_polaco;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

/**
 *
 * @author 1046877159
 */
public class Criterios extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;

    private final int CELL_WIDTH = 30, CELL_HEIGHT = 25;

    private JButton jbuAceptar, jbuLimpiar, jbuSalir;
    private JTextField jteCriterio1, jteCriterio2, jteCriterio3, jteCriterio4, jteCriterio5;
    private JCheckBox jcbCriterio1, jcbCriterio2, jcbCriterio3, jcbCriterio4, jcbCriterio5;
    private LinkedList<String> liCriterios = new LinkedList<String>();
    private LinkedList<Integer> liGrading = new LinkedList<Integer>();

    public void createGui() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container conVentana = this.getContentPane();
        this.setSize((int) (CELL_WIDTH * 13), (int) (CELL_HEIGHT * 19.5));
        this.setResizable(false);

        conVentana.setLayout(null);

        jcbCriterio1 = new JCheckBox("Filename");
        jcbCriterio1.setBounds(CELL_WIDTH, CELL_HEIGHT, CELL_WIDTH * 6, CELL_HEIGHT);
        conVentana.add(jcbCriterio1);
        jcbCriterio1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                liCriterios.add("Filename");
                liGrading.add(Integer.parseInt(jteCriterio1.getText()));
            }
        });

        jcbCriterio2 = new JCheckBox("Identifier naming");
        jcbCriterio2.setBounds(CELL_WIDTH, CELL_HEIGHT * 3, CELL_WIDTH * 6, CELL_HEIGHT);
        conVentana.add(jcbCriterio2);
        jcbCriterio2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                liCriterios.add("Identifier naming");
                liGrading.add(Integer.parseInt(jteCriterio2.getText()));
            }
        });

        jcbCriterio3 = new JCheckBox("Comments");
        jcbCriterio3.setBounds(CELL_WIDTH, CELL_HEIGHT * 5, CELL_WIDTH * 6, CELL_HEIGHT);
        conVentana.add(jcbCriterio3);
        jcbCriterio3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                liCriterios.add("Comments");
                liGrading.add(Integer.parseInt(jteCriterio3.getText()));
            }
        });

        jcbCriterio4 = new JCheckBox("Indentation");
        jcbCriterio4.setBounds(CELL_WIDTH, CELL_HEIGHT * 7, CELL_WIDTH * 6, CELL_HEIGHT);
        conVentana.add(jcbCriterio4);
        jcbCriterio4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                liCriterios.add("Indentation");
                liGrading.add(Integer.parseInt(jteCriterio4.getText()));
            }
        });;

        jcbCriterio5 = new JCheckBox("Instructions per line");
        jcbCriterio5.setBounds(CELL_WIDTH, CELL_HEIGHT * 9, CELL_WIDTH * 6, CELL_HEIGHT);
        conVentana.add(jcbCriterio5);
        jcbCriterio5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                liCriterios.add("Instructions per line");
                liGrading.add(Integer.parseInt(jteCriterio1.getText()));
            }
        });

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////        
        jteCriterio1 = new JTextField("");
        jteCriterio1.setBounds(CELL_WIDTH * 7, CELL_HEIGHT, CELL_WIDTH * 5, CELL_HEIGHT);
        conVentana.add(jteCriterio1);

        jteCriterio2 = new JTextField("");
        jteCriterio2.setBounds(CELL_WIDTH * 7, CELL_HEIGHT * 3, CELL_WIDTH * 5, CELL_HEIGHT);
        conVentana.add(jteCriterio2);

        jteCriterio3 = new JTextField("");
        jteCriterio3.setBounds(CELL_WIDTH * 7, CELL_HEIGHT * 5, CELL_WIDTH * 5, CELL_HEIGHT);
        conVentana.add(jteCriterio3);

        jteCriterio4 = new JTextField("");
        jteCriterio4.setBounds(CELL_WIDTH * 7, CELL_HEIGHT * 7, CELL_WIDTH * 5, CELL_HEIGHT);
        conVentana.add(jteCriterio4);

        jteCriterio5 = new JTextField("");
        jteCriterio5.setBounds(CELL_WIDTH * 7, CELL_HEIGHT * 9, CELL_WIDTH * 5, CELL_HEIGHT);
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
                int iTotal = 0;
                for (int i : liGrading) {
                    iTotal += i;
                }
                if (iTotal != 100) {
                    JOptionPane.showMessageDialog(null,
                            "Grading criteria should sum 100.",
                            "error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // JTextFields
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}
