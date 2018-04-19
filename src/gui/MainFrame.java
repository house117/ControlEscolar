/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import controlescolar.objects.Alumno;
import controlescolar.objects.Fecha;
import controller.ControlEscolar;
import controller.GestionadorArchivo;
import exceptions.CalificacionInvalidaException;
import exceptions.FechaInvalidaException;
import exceptions.NumeroControlRepetidoException;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

/**
 *
 * @author House
 */
public class MainFrame extends JFrame{
    private ControlPanel pnlControl;
    private TablePanel pnlTabla;
    private ControlEscolar control;
    public MainFrame(String title){
        super(title);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.setSize(800, 600);
        super.setLayout(new BorderLayout());
        super.setJMenuBar(createMenu());
        //super.setJMenuBar(createMenu());
        super.setLocationRelativeTo(null);
        control = new ControlEscolar();
        
        
        ControlEscolar control = new ControlEscolar();
        pnlControl = new ControlPanel();
        pnlTabla = new TablePanel();
        pnlTabla.drawTabla(control.getListaAlumnos());
        
        
        
        super.add(pnlControl, BorderLayout.NORTH);
        super.add(pnlTabla, BorderLayout.CENTER);
        super.setVisible(true);
    }
    private JMenuBar createMenu(){
        JMenuBar menu = new JMenuBar();
        
        //MENU ARCHIVO
        JMenu mmArchivo = new JMenu("Archivo");
        
        //SUBMENUS DE ARCHIVO
        JMenuItem nnAbrir = new JMenuItem("Abrir...");
        nnAbrir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
            JFileChooser fc = new JFileChooser();
                if (fc.showOpenDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION){
                    //cargar el archivo 
                    try {
                        control = GestionadorArchivo.abrirArchivo(fc.getSelectedFile());
                        //pnlTabla.removeAll();
                        pnlTabla.drawTabla(control.getListaAlumnos());
                        
                        MainFrame.this.repaint();
                    } catch (FileNotFoundException e) {
                        JOptionPane.showMessageDialog(MainFrame.this, "Archivo no encontrado", 
                                "Alerta", JOptionPane.ERROR_MESSAGE);
                    } catch (IOException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }  
                }
            }
        });
        JMenuItem nnGuardar = new JMenuItem("Guardar...");
        nnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
               JFileChooser fc = new JFileChooser();
               if(fc.showSaveDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION){

                   System.out.println(fc.getSelectedFile());
                   File f = new File(fc.getSelectedFile().toString());
                   if(f.exists()){
                       JOptionPane.showMessageDialog(MainFrame.this, "Ese archivo ya existe",
                               "Cuidado...",
                               JOptionPane.WARNING_MESSAGE);
                   }else{
                      try {
                          GestionadorArchivo.guardarArchivito(control, fc.getSelectedFile().toString());
                      } catch (IOException ex) {
                          Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                      }
                       
                   }
               }
            }
        });
        JMenuItem nnSalir = new JMenuItem("Salir");
        nnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });
        
        mmArchivo.add(nnAbrir);
        mmArchivo.add(nnGuardar);
        mmArchivo.addSeparator();
        mmArchivo.add(nnSalir);
        
        //MENU ALUMNOS
        JMenu mmAlumnos = new JMenu("Alumnos");
        JMenuItem nnAgregarAlumno = new JMenuItem("Agregar Alumno...");
        nnAgregarAlumno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                /*
                    private String noControl; 
    private String nombre;
    private String aPaterno;
    private String aMaterno;
    private Fecha fechaNac;
    private String Carrera;
    private Double promedio;
    private ArrayList<Materia> materiasDelAlumno;
                */
                String nombre;
                String aPaterno;
                String aMaterno;
                Fecha fechaNac;
                String carrera;
                Double promedio;
                String noControl = JOptionPane.showInputDialog("Ingresa el numero de control");
                
                if(!control.existeNoControl(noControl)){
                    nombre = JOptionPane.showInputDialog("Ingresa el nombre del alumno");
                    aPaterno = JOptionPane.showInputDialog("Ingresa el apellido paterno del alumno");
                    aMaterno = JOptionPane.showInputDialog("Ingresa el apellido materno del alumno");
                    //Para introducir fecha más comodamente
                    
                    JTextField diaField = new JTextField(5);
                    JTextField mesField = new JTextField(5);
                    JTextField anioField = new JTextField(5);

                        
                    
                    JPanel myPanel = new JPanel();
                    myPanel.add(new JLabel("Dia:"));
                    myPanel.add(diaField);
                    myPanel.add(Box.createHorizontalStrut(15)); // a spacer
                    myPanel.add(new JLabel("Mes:"));
                    myPanel.add(mesField);
                    myPanel.add(Box.createHorizontalStrut(15)); // a spacer
                    myPanel.add(new JLabel("Año:"));
                    myPanel.add(anioField);
                    int result = JOptionPane.showConfirmDialog(null, myPanel, "Ingresa la fecha de nacimiento",
                            JOptionPane.OK_CANCEL_OPTION);
                    if(result == JOptionPane.OK_OPTION){
                        try {
                            fechaNac = new Fecha(Integer.parseInt(diaField.getText()),
                                    Integer.parseInt(mesField.getText()),
                                    Integer.parseInt(anioField.getText()));
                            carrera = JOptionPane.showInputDialog("Ingresa la carrera del alumno");
                            promedio = Double.parseDouble(JOptionPane.showInputDialog("Ingresa el promedio del alumno"));
                            try {
                                Alumno aIngresar = new Alumno(noControl, nombre, aPaterno,
                                        aMaterno, fechaNac, carrera, promedio);
                                control.addAlumno(aIngresar);
                                pnlTabla.removeAll();
                                pnlTabla.drawTabla(control.getListaAlumnos());
                                MainFrame.this.repaint();
                            } catch (CalificacionInvalidaException ex) {
                                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (NumeroControlRepetidoException ex) {
                                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        } catch (FechaInvalidaException ex) {
                            ex.printStackTrace();
                            
                        }
                    }
                     
                    
                }else{
                    JOptionPane.showMessageDialog(MainFrame.this, "Ya existe ese numero de control");
                }
            }
        });
        mmAlumnos.add(nnAgregarAlumno);
        
        
        menu.add(mmArchivo);
        menu.add(mmAlumnos);
        return menu;
    }
    
}
