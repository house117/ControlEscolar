/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author House
 */
public class ControlPanel extends JPanel{
    private JButton btnBusquedaPorNombre;
    private JButton btnBusquedaPorControl;
    private JTextField txtBusquedaNombre;
    private JTextField txtBusquedaControl;
    
    public ControlPanel(){
        super();
        super.setBackground(Color.RED);
        super.setLayout(new BorderLayout());
        
        /*PANELES DENTRO DE CONTROL PANEL*/
        JPanel pnlBotonControl = new JPanel();
        pnlBotonControl.setLayout(new BorderLayout());
        
        JPanel pnlBotonNombre = new JPanel();
        pnlBotonNombre.setLayout(new BorderLayout());
        
        /*BOTONES*/
        btnBusquedaPorNombre = new JButton();
        btnBusquedaPorNombre.setText("Buscar por nombre");
        btnBusquedaPorNombre.setPreferredSize(new Dimension(170, 30));
        
        
        btnBusquedaPorControl = new JButton();
        btnBusquedaPorControl.setText("Buscar por no. control");
        btnBusquedaPorControl.setPreferredSize(new Dimension(170, 30));
        
        /*TEXT FIELDS*/
        txtBusquedaControl = new JTextField("No. control");
        txtBusquedaControl.setPreferredSize(new Dimension(600, 10));
        
        txtBusquedaNombre = new JTextField("Nombre...");
        txtBusquedaNombre.setPreferredSize(new Dimension(600,10));
        /*
        txtMinas = new JTextField("10");
        txtMinas.setPreferredSize(new Dimension(60, 30));
        txtMinas.setFont(new Font("Courier New", Font.BOLD, 24));
        txtMinas.setForeground(Color.RED);
        txtMinas.setBackground(Color.BLACK);
        */
        
        
        
        pnlBotonControl.add(btnBusquedaPorControl,BorderLayout.EAST);
        pnlBotonControl.add(txtBusquedaControl,BorderLayout.WEST);
        
        
        
        pnlBotonNombre.add(btnBusquedaPorNombre, BorderLayout.EAST);
        pnlBotonNombre.add(txtBusquedaNombre, BorderLayout.WEST);
        
        JPanel pnlDivisor = new JPanel();
        pnlDivisor.setPreferredSize(new Dimension(0, 4));
        
        super.add(pnlBotonNombre, BorderLayout.NORTH);
        super.add(pnlBotonControl, BorderLayout.SOUTH);
        super.add(pnlDivisor, BorderLayout.CENTER);
        
        
        
    }
}
