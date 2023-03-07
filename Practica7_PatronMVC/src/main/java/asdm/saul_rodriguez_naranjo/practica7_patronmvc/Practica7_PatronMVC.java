/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package asdm.saul_rodriguez_naranjo.practica7_patronmvc;

import asdm.saul_rodriguez_naranjo.practica7_patronmvc.Controlador.ControlCambio;
import asdm.saul_rodriguez_naranjo.practica7_patronmvc.Controlador.ControladorFactory;
import asdm.saul_rodriguez_naranjo.practica7_patronmvc.Vista.InterfazVista;
import asdm.saul_rodriguez_naranjo.practica7_patronmvc.Vista.VentanaCambio;
import javax.swing.SwingUtilities;

/**
 *
 * @author SaulRC1
 */
public class Practica7_PatronMVC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ControladorFactory controlador = new ControlCambio();
        InterfazVista vista = new VentanaCambio();
        
        controlador.setInterfazGrafica(vista);
        controlador.arrancaInterfaz();
        
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                controlador.actionPerformed();
            }
        });
        
    }
    
}
