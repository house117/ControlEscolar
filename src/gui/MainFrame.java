/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import controller.ControlEscolar;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

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
    
}
