/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import controlescolar.objects.Alumno;
import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author House
 */
public class TablePanel extends JPanel{
    /*
        Esta clase es de lo más importante pues aquí se muestran los alumnos
        Recibe un arrayList de alumnos y lo despliega con su constructor
    */
    private JScrollPane scrollPane;
    private JTable studentsTable;
    DefaultTableModel tblmEstudiante;
    //Despliega la lista completa que recibe
    public TablePanel(ArrayList<Alumno> listaAlumnos){
        super();
        super.setLayout(null);
        String col[] = {"No.Control","Nombre","Ap.Paterno", "Ap.Materno", "Fecha Nac.", 
                            "Carrera", "Promedio"};
        tblmEstudiante = new DefaultTableModel(col, 0){
            @Override
            public boolean isCellEditable(int i, int i1){
                return false;
            }
            /*
                Esta parte es muy importante pues sobrescribimos
                el metodo isCellEditable de DefaultTableModel
                para así evitar que las celdas de la tabla
                sean editables.
            */
        };
        drawTabla(listaAlumnos);
    }
    //Método para agregar un alumno más a la lista.
    public void addAlumno(Alumno alumno){
        //cadenas innecesarias, solo de apoyo
        String noControl;
        String nombre;
        String aPaterno;
        String aMaterno;
        String fecha;
        String carrera;
        String promedio;
       //Prints en consola de apoyo
            System.out.println("Control = "+alumno.getNoControl());
            System.out.println("Nombre = "+alumno.getNombre());
            System.out.println("Apellido pat= "+ alumno.getaPaterno());
            System.out.println("Apellido mat= "+alumno.getaMaterno());
            System.out.println("fecha nac= "+alumno.getFechaNac().toString());
            System.out.println("carrera= "+alumno.getCarrera());
            System.out.println("promedio= "+alumno.getPromedio().toString());
                noControl = alumno.getNoControl();
                nombre = alumno.getNombre();
                aPaterno = alumno.getaPaterno();
                aMaterno = alumno.getaMaterno();
                fecha = alumno.getFechaNac().toString();
                carrera = alumno.getCarrera();
                promedio = alumno.getPromedio().toString();
                Object[] data = {noControl, nombre, aPaterno,
                    aMaterno, fecha, carrera, promedio};
                tblmEstudiante.addRow(data);
    }
    public void drawTabla(ArrayList<Alumno> aMostrar){
        //Método de dibujar la tabla, es llamado por el constructor para desplejar
        //la tabla completa
        super.setLayout(new BorderLayout());
        //Hace que el Layout sea Border para
        System.out.println("ME EJECUTE");
        //metodo que obtiene un arrayList de alumnos y lo agrega a una tabla y
        //agrega esta al JPanel
        
        String noControl;
        String nombre;
        String aPaterno;
        String aMaterno;
        String fecha;
        String carrera;
        String promedio;
        for(int i=0; i<aMostrar.size(); i++){    
            System.out.println("ENTRE AL FOR veces: "+i);
            System.out.println("Control = "+aMostrar.get(i).getNoControl());
            System.out.println("Nombre = "+aMostrar.get(i).getNombre());
            System.out.println("Apellido pat= "+ aMostrar.get(i).getaPaterno());
            System.out.println("Apellido mat= "+aMostrar.get(i).getaMaterno());
            System.out.println("fecha nac= "+aMostrar.get(i).getFechaNac().toString());
            System.out.println("carrera= "+aMostrar.get(i).getCarrera());
            System.out.println("promedio= "+aMostrar.get(i).getPromedio().toString());
                noControl = aMostrar.get(i).getNoControl();
                nombre = aMostrar.get(i).getNombre();
                aPaterno = aMostrar.get(i).getaPaterno();
                aMaterno = aMostrar.get(i).getaMaterno();
                fecha = aMostrar.get(i).getFechaNac().toString();
                carrera = aMostrar.get(i).getCarrera();
                promedio = aMostrar.get(i).getPromedio().toString();
                Object[] data = {noControl, nombre, aPaterno,
                    aMaterno, fecha, carrera, promedio};
                tblmEstudiante.addRow(data);
                //Agrega la fila a table Model estudiante
                
        }
        
        //creamos la tabla y le agregamos el modelo
        studentsTable = new JTable(tblmEstudiante);
        studentsTable.setRowSelectionAllowed(true);
        //el setRow no es necesario pero meh
       
        scrollPane = new JScrollPane(studentsTable);
        //scrollPane.setPreferredSize(new Dimension(200, 400));
        studentsTable.setFillsViewportHeight(true);
        
        super.add(scrollPane, BorderLayout.CENTER);
    }
    //Hacer el drawTabla para cuando busque un alumno
    /*
    A ese le agregaremos 2 tablas, una con los datos del alumno
    y una con los datos de sus respectivas materias
    */
}
