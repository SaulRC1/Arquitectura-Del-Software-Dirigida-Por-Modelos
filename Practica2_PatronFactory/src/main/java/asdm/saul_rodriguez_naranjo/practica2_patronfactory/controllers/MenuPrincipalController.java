/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asdm.saul_rodriguez_naranjo.practica2_patronfactory.controllers;

import asdm.saul_rodriguez_naranjo.practica2_patronfactory.views.MenuPrincipalVista;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author SaulRC1
 */
public class MenuPrincipalController {
    private MenuPrincipalVista menuPrincipalVista;
    
    public MenuPrincipalController() {
        this.menuPrincipalVista = new MenuPrincipalVista();
        
        this.setListenersToButtons();
        
        this.menuPrincipalVista.setVisible(true);
        this.menuPrincipalVista.setTitle("Practica 2 - Patron Factory");
    }

    private void setListenersToButtons() {
        
        //Boton Formato 24 Horas
        this.menuPrincipalVista.btnFormato24Horas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                botonFormato24HorasAction();
            }
        });
        
        //Boton Formato 24 Horas
        this.menuPrincipalVista.btnFormato12Horas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                botonFormato12HorasAction();
            }
        });
    }
    
    private void botonFormato24HorasAction() {
        FormatoHorasController formato24HorasController = new FormatoHorasController(2);
    }
    
    private void botonFormato12HorasAction() {
        FormatoHorasController formato24HorasController = new FormatoHorasController(1);
    }
}
