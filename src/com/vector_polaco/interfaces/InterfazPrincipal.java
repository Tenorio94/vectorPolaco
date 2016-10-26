package com.vector_polaco.interfaces;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.System.exit;
import com.vector_polaco.conventions.fileNameConvention;
import com.vector_polaco.api.*;

public class InterfazPrincipal extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;

    private final int CELL_WIDTH = 30, CELL_HEIGHT = 25;

    private JButton jbuBorrarListaCriterios, jbuEditarListaCriterios, jbuNuevaListaCriterios;
    private JButton jbuSeleccionarCarpetaContenedora, jbuSeleccionarArchivoOutput;
    private JButton jbuSalir, jbuLimpiarCampos, jbuContinuar;
    private JLabel jlaCarpetaContenedora, jlaArchivoOutput, jlaExtension, jlaNombreArchivoSalida, jlaListaCriterios;
    private JTextField jteCarpetaContenedora, jteLugarArchivoSalida, jteNombreArchivoSalida;
    private JComboBox<String> jcoListaCriterios;
    private String sDirectory;

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
                InterfazCriterios c = new InterfazCriterios();
                c.createGui();
                c.setVisible(true);
            }
        });

        jbuNuevaListaCriterios = new JButton("Nuevo");
        jbuNuevaListaCriterios.setBounds(CELL_WIDTH * 9, CELL_HEIGHT * 4, CELL_WIDTH * 3, CELL_HEIGHT);
        conVentana.add(jbuNuevaListaCriterios);
        jbuNuevaListaCriterios.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                InterfazCriterios c = new InterfazCriterios();
                c.createGui();
                c.setVisible(true);
            }
        });

        jbuSeleccionarCarpetaContenedora = new JButton("Seleccionar");
        jbuSeleccionarCarpetaContenedora.setBounds(CELL_WIDTH * 9, CELL_HEIGHT * 7, CELL_WIDTH * 3, CELL_HEIGHT);
        conVentana.add(jbuSeleccionarCarpetaContenedora);
        jbuSeleccionarCarpetaContenedora.addActionListener(e -> clickBotonSeleccionarCarpetaContenedora());

        jbuSeleccionarArchivoOutput = new JButton("Seleccionar");
        jbuSeleccionarArchivoOutput.setBounds(CELL_WIDTH * 9, (int) (CELL_HEIGHT * 10), CELL_WIDTH * 3, CELL_HEIGHT);
        conVentana.add(jbuSeleccionarArchivoOutput);
        jbuSeleccionarArchivoOutput.addActionListener(e -> clickBotonSeleccionarArchivoOutput());

        jbuSalir = new JButton("Salir");
        jbuSalir.setBounds(CELL_WIDTH, CELL_HEIGHT * 16, CELL_WIDTH * 3, CELL_HEIGHT);
        conVentana.add(jbuSalir);
        jbuSalir.addActionListener(e -> exit(0));

        jbuLimpiarCampos = new JButton("Limpiar");
        jbuLimpiarCampos.setBounds(CELL_WIDTH * 5, CELL_HEIGHT * 16, CELL_WIDTH * 3, CELL_HEIGHT);
        conVentana.add(jbuLimpiarCampos);
        jbuLimpiarCampos.addActionListener(e -> clickBotonLimpiar());

        jbuContinuar = new JButton("Continuar");
        jbuContinuar.setBounds(CELL_WIDTH * 9, CELL_HEIGHT * 16, CELL_WIDTH * 3, CELL_HEIGHT);
        conVentana.add(jbuContinuar);
        jbuContinuar.addActionListener(e -> clickBotonContinuar());

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


    private void clickBotonSeleccionarCarpetaContenedora() {
        JFileChooser folderPicker = new JFileChooser();
        String folderPickerTitle = "Select your folder";
        folderPicker.setCurrentDirectory(new java.io.File("."));
        folderPicker.setDialogTitle(folderPickerTitle);
        folderPicker.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);


        folderPicker.setAcceptAllFileFilterUsed(false);

        if (folderPicker.showOpenDialog(InterfazPrincipal.this) == JFileChooser.APPROVE_OPTION) {
            System.out.println("getCurrentDirectory(): "
                    + folderPicker.getCurrentDirectory());
            System.out.println("getSelectedFile() : "
                    + folderPicker.getSelectedFile());
            sDirectory = folderPicker.getSelectedFile().getAbsolutePath();
            jteCarpetaContenedora.setText(sDirectory);
        } else {
            System.out.println("No Folder Selection");
        }
    }

    private void clickBotonContinuar(){
        ConventionController Controller = new ConventionController();
        checkFileNaming(Controller);
    }

    private void checkFileNaming(ConventionController Controller){
        String sPath = "";
        sPath = jteCarpetaContenedora.getText();

        Controller.getFilesController(sPath);
    }

    private void clickBotonLimpiar() {
        jteLugarArchivoSalida.setText("");
        jteCarpetaContenedora.setText("");
        jteNombreArchivoSalida.setText("");
    }

    private void clickBotonSeleccionarArchivoOutput() {
        JFileChooser folderPicker = new JFileChooser();
        String folderPickerTitle = "Select your folder";
        folderPicker.setCurrentDirectory(new java.io.File("."));
        folderPicker.setDialogTitle(folderPickerTitle);
        folderPicker.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);


        folderPicker.setAcceptAllFileFilterUsed(false);

        if (folderPicker.showOpenDialog(InterfazPrincipal.this) == JFileChooser.APPROVE_OPTION) {
            System.out.println("getCurrentDirectory(): "
                    + folderPicker.getCurrentDirectory());
            System.out.println("getSelectedFile() : "
                    + folderPicker.getSelectedFile());
            sDirectory = folderPicker.getCurrentDirectory().getAbsolutePath();
            jteLugarArchivoSalida.setText(sDirectory);
        } else {
            System.out.println("No Folder Selection");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}