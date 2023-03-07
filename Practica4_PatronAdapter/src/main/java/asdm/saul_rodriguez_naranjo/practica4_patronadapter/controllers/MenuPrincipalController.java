/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asdm.saul_rodriguez_naranjo.practica4_patronadapter.controllers;

import asdm.saul_rodriguez_naranjo.practica4_patronadapter.factories.VehiculosFactory;
import asdm.saul_rodriguez_naranjo.practica4_patronadapter.interfaces.IVehiculo;
import asdm.saul_rodriguez_naranjo.practica4_patronadapter.models.CocheAutomatico;
import asdm.saul_rodriguez_naranjo.practica4_patronadapter.views.MenuPrincipalVista;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;

/**
 *
 * @author SaulRC1
 */
public class MenuPrincipalController {
    private MenuPrincipalVista menuPrincipalVista = new MenuPrincipalVista();
    
    public MenuPrincipalController() {
        this.menuPrincipalVista = new MenuPrincipalVista();
        
        this.setListenersToButtons();
        
        this.menuPrincipalVista.setVisible(true);
        //this.menuPrincipalVista.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.menuPrincipalVista.setTitle("Menu Principal - Seleccionar Vehiculo");
        this.menuPrincipalVista.setLocationRelativeTo(null);
    }
    
    public void setListenersToButtons() {
        
        //boton Coche Automatico
        this.menuPrincipalVista.btnCocheAutomatico.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                btnCocheAutomaticoAction();
            }
        });
        
        //boton Coche Manual
        this.menuPrincipalVista.btnCocheManual.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                btnCocheManualAction();
            }
        });
        
        //boton Barco
        this.menuPrincipalVista.btnBarco.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                btnBarcoAction();
            }
        });
    }
    
    public void btnCocheAutomaticoAction() {
        
        IVehiculo cocheAutomatico = VehiculosFactory.getVehiculo(VehiculosFactory.COCHE_AUTOMATICO);
        ControlarVehiculoController controlarCocheAutomaticoController = new ControlarVehiculoController(cocheAutomatico);
        
    }
    
    public void btnCocheManualAction() {
        IVehiculo cocheManual = VehiculosFactory.getVehiculo(VehiculosFactory.COCHE_MANUAL);
        ControlarVehiculoController controlarCocheManualController = new ControlarVehiculoController(cocheManual);
    }
    
    public void btnBarcoAction() {
        IVehiculo barco = VehiculosFactory.getVehiculo(VehiculosFactory.BARCO);
        ControlarVehiculoController controlarBarcoController = new ControlarVehiculoController(barco);
    }
}
