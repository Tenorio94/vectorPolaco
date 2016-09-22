/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vector_polaco;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author 1046877159
 */
public class InterfazPrincipal extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;

    private final int CELL_WIDTH = 30, CELL_HEIGHT = 25;

    private JButton jbuBorrarListaCriterios, jbuEditarListaCriterios, jbuNuevaListaCriterios;
    private JButton jbuSeleccionarCarpetaContenedora, jbuSeleccionarArchivoOutput;
    private JButton jbuSalir, jbuLimpiarCampos, jbuContinuar;
    private JLabel jlaCarpetaContenedora, jlaArchivoOutput, jlaExtension, jlaNombreArchivoSalida, jlaListaCriterios;
    private JTextField jteCarpetaContenedora, jteLugarArchivoSalida, jteNombreArchivoSalida;
    private JComboBox<String> jcoListaCriterios;

    public void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container conVentana = this.getContentPane();
        this.setSize((int) (CELL_WIDTH * 13), (int) (CELL_HEIGHT * 19.5));
        this.setResizable(false);

        conVentana.setLayout(null);

        String[] sArrListaFormasDeEvaluacion = {"Tarea", "Examen", "Proyecto"};

        // Labels
        jlaListaCriterios = new JLabel("Forma de evaluacion");
        jlaListaCriterios.setBounds(CELL_WIDTH, CELL_HEIGHT, CELL_WIDTH * 10, CELL_HEIGHT);
        conVentana.add(jlaListaCriterios);

        jlaCarpetaContenedora = new JLabel("Carpeta contenedora de archivos");
        jlaCarpetaContenedora.setBounds(CELL_WIDTH, CELL_HEIGHT * 6, CELL_WIDTH * 11, CELL_HEIGHT);
        conVentana.add(jlaCarpetaContenedora);

        jlaArchivoOutput = new JLabel("Carpeta de archivo de salida");
        jlaArchivoOutput.setBounds(CELL_WIDTH, CELL_HEIGHT * 9, CELL_WIDTH * 8, CELL_HEIGHT);
        conVentana.add(jlaArchivoOutput);

        jlaNombreArchivoSalida = new JLabel("Nombre de archivo de salida");
        jlaNombreArchivoSalida.setBounds(CELL_WIDTH, CELL_HEIGHT * 12, CELL_WIDTH * 9, CELL_HEIGHT);
        conVentana.add(jlaNombreArchivoSalida);

        jlaExtension = new JLabel(".csv");
        jlaExtension.setBounds(CELL_WIDTH * 10, CELL_HEIGHT * 13, CELL_WIDTH * 2, CELL_HEIGHT);
        conVentana.add(jlaExtension);

        // Botones
        jbuBorrarListaCriterios = new JButton("Borrar");
        jbuBorrarListaCriterios.setBounds(CELL_WIDTH, CELL_HEIGHT * 4, CELL_WIDTH * 3, CELL_HEIGHT);
        conVentana.add(jbuBorrarListaCriterios);
        jbuBorrarListaCriterios.addActionListener(this);
        //jbuBorrarListaCriterios.

        jbuEditarListaCriterios = new JButton("Editar");
        jbuEditarListaCriterios.setBounds(CELL_WIDTH * 5, CELL_HEIGHT * 4, CELL_WIDTH * 3, CELL_HEIGHT);
        conVentana.add(jbuEditarListaCriterios);
        jbuEditarListaCriterios.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Criterios c = new Criterios();
                c.createGui();
                c.setVisible(true);
            }
        });

        jbuNuevaListaCriterios = new JButton("Nuevo");
        jbuNuevaListaCriterios.setBounds(CELL_WIDTH * 9, CELL_HEIGHT * 4, CELL_WIDTH * 3, CELL_HEIGHT);
        conVentana.add(jbuNuevaListaCriterios);
        jbuNuevaListaCriterios.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Criterios c = new Criterios();
                c.createGui();
                c.setVisible(true);
            }
        });

        jbuSeleccionarCarpetaContenedora = new JButton("Seleccionar");
        jbuSeleccionarCarpetaContenedora.setBounds(CELL_WIDTH * 9, CELL_HEIGHT * 7, CELL_WIDTH * 3, CELL_HEIGHT);
        conVentana.add(jbuSeleccionarCarpetaContenedora);
        jbuSeleccionarCarpetaContenedora.addActionListener(this);

        jbuSeleccionarArchivoOutput = new JButton("Seleccionar");
        jbuSeleccionarArchivoOutput.setBounds(CELL_WIDTH * 9, (int) (CELL_HEIGHT * 10), CELL_WIDTH * 3, CELL_HEIGHT);
        conVentana.add(jbuSeleccionarArchivoOutput);
        jbuSeleccionarArchivoOutput.addActionListener(this);

        jbuSalir = new JButton("Salir");
        jbuSalir.setBounds(CELL_WIDTH, CELL_HEIGHT * 16, CELL_WIDTH * 3, CELL_HEIGHT);
        conVentana.add(jbuSalir);
        jbuSalir.addActionListener(this);

        jbuLimpiarCampos = new JButton("Limpiar");
        jbuLimpiarCampos.setBounds(CELL_WIDTH * 5, CELL_HEIGHT * 16, CELL_WIDTH * 3, CELL_HEIGHT);
        conVentana.add(jbuLimpiarCampos);
        jbuLimpiarCampos.addActionListener(this);

        jbuContinuar = new JButton("Continuar");
        jbuContinuar.setBounds(CELL_WIDTH * 9, CELL_HEIGHT * 16, CELL_WIDTH * 3, CELL_HEIGHT);
        conVentana.add(jbuContinuar);
        jbuContinuar.addActionListener(this);

        // JTextFields
        jteCarpetaContenedora = new JTextField();
        jteCarpetaContenedora.setBounds(CELL_WIDTH, CELL_HEIGHT * 7, CELL_WIDTH * 7, CELL_HEIGHT);
        conVentana.add(jteCarpetaContenedora);

        jteLugarArchivoSalida = new JTextField();
        jteLugarArchivoSalida.setBounds(CELL_WIDTH, CELL_HEIGHT * 10, CELL_WIDTH * 7, CELL_HEIGHT);
        conVentana.add(jteLugarArchivoSalida);

        jteNombreArchivoSalida = new JTextField();
        jteNombreArchivoSalida.setBounds(CELL_WIDTH, CELL_HEIGHT * 13, CELL_WIDTH * 7, CELL_HEIGHT);
        conVentana.add(jteNombreArchivoSalida);

        // Combobox
        jcoListaCriterios = new JComboBox<>(sArrListaFormasDeEvaluacion);
        jcoListaCriterios.setBounds(CELL_WIDTH, CELL_HEIGHT * 2, CELL_WIDTH * 11, CELL_HEIGHT);
        conVentana.add(jcoListaCriterios);
        jcoListaCriterios.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
