/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import controlescolar.objects.Alumno;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.LayoutManager;
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
    private JScrollPane scrollPane;
    private JTable studentsTable;
    public TablePanel(){
        super();
        super.setLayout(new BorderLayout());
    }
    
    public void drawTabla(ArrayList<Alumno> aMostrar){
        //metodo que obtiene un arrayList de alumnos y lo agrega a una tabla y
        //agrega esta al JPanel
        String col[] = {"No.Control","Nombre","Ap.Paterno", "Ap.Materno", "Fecha Nac.", 
                            "Carrera", "Promedio"};
        DefaultTableModel tableModel = new DefaultTableModel(col, 0);
        String noControl;
        String nombre;
        String aPaterno;
        String aMaterno;
        String fecha;
        String carrera;
        String promedio;
        for(int i=0; i<aMostrar.size(); i++){    
                noControl = aMostrar.get(i).getNoControl();
                nombre = aMostrar.get(i).getNombre();
                aPaterno = aMostrar.get(i).getaPaterno();
                aMaterno = aMostrar.get(i).getaMaterno();
                fecha = aMostrar.get(i).getFechaNac().toString();
                carrera = aMostrar.get(i).getCarrera();
                promedio = aMostrar.get(i).getPromedio().toString();
                Object[] data = {noControl, nombre, aPaterno,
                    aMaterno, fecha, carrera, promedio};
                tableModel.addRow(data);
        }
        
        
        studentsTable = new JTable(tableModel);
       
        scrollPane = new JScrollPane(studentsTable);
        //scrollPane.setPreferredSize(new Dimension(200, 400));
        studentsTable.setFillsViewportHeight(true);
        
        super.add(scrollPane, BorderLayout.CENTER);
    }
}
