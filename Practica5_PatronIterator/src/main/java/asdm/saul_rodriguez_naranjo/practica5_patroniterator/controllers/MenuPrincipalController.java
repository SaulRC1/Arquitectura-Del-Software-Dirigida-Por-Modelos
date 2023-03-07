/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asdm.saul_rodriguez_naranjo.practica5_patroniterator.controllers;

import asdm.saul_rodriguez_naranjo.practica5_patroniterator.agregados.ListaNumero;
import asdm.saul_rodriguez_naranjo.practica5_patroniterator.agregados.ListaPalabras;
import asdm.saul_rodriguez_naranjo.practica5_patroniterator.interfaces.IListaNumero;
import asdm.saul_rodriguez_naranjo.practica5_patroniterator.interfaces.IListaPalabras;
import asdm.saul_rodriguez_naranjo.practica5_patroniterator.views.MenuPrincipalVista;
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
        this.menuPrincipalVista.setTitle("Patron Iterator - Saúl Rodríguez Naranjo");
        this.menuPrincipalVista.setLocationRelativeTo(null);
    }
    
    private void setListenersToButtons() {
        
        //Boton Lista de Numeros
        this.menuPrincipalVista.btnCrearListaDeNumeros.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                IListaNumero iListaNumero = new ListaNumero();
                MenuListaController menuListaController = new MenuListaController(iListaNumero);
            }
        });
        
        //Boton Lista de Palabras
        this.menuPrincipalVista.btnCrearListaDePalabras.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                IListaPalabras iListaPalabras = new ListaPalabras();
                MenuListaController menuListaController = new MenuListaController(iListaPalabras);
            }
        });
    }
}
