/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asdm.saul_rodriguez_naranjo.practica1_patronsingleton.controllers;

import asdm.saul_rodriguez_naranjo.practica1_patronsingleton.views.MenuCompraBilletes;
import asdm.saul_rodriguez_naranjo.practica1_patronsingleton.views.MenuPrincipal;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author SaulRC1
 */
public class MenuPrincipalController {
    private MenuPrincipal menuPrincipal;
    private MenuCompraBilletesController menuCompraBilletesController;
    private MenuDevuelveBilletesController menuDevuelveBilletesController;
    
    public MenuPrincipalController(){
        this.menuPrincipal = new MenuPrincipal();
        this.setListenersToButtons();
        
        menuPrincipal.setTitle("Practica 1 - Patrón Singleton | Saúl");
        menuPrincipal.setVisible(true);
        menuPrincipal.setLocationRelativeTo(null);
    }
    
    private void setListenersToButtons(){
        //Boton Comprar Billetes
        this.menuPrincipal.btnComprarBilletes.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                menuCompraBilletesController = new MenuCompraBilletesController();
            }
        });
        
        this.menuPrincipal.btnDevolverBilletes.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                menuDevuelveBilletesController = new MenuDevuelveBilletesController();
            }
        });
    }
}
