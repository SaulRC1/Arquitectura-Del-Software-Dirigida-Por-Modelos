/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asdm.saul_rodriguez_naranjo.practica5_patroniterator.controllers;

import asdm.saul_rodriguez_naranjo.practica5_patroniterator.factories.ListaFactory;
import asdm.saul_rodriguez_naranjo.practica5_patroniterator.iteradores.Iterador;
import asdm.saul_rodriguez_naranjo.practica5_patroniterator.views.MenuListaVista;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author SaulRC1
 */
public class MenuListaController {

    private MenuListaVista menuListaVista;
    private ListaFactory lista;
    private Iterador listaIterador;

    public MenuListaController(ListaFactory lista) {
        menuListaVista = new MenuListaVista();
        this.lista = lista;

        this.listaIterador = lista.createIterator();
        this.setListenersToButtons();

        menuListaVista.setVisible(true);
        menuListaVista.setTitle(lista.getTipoDeLista());
        menuListaVista.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void setListenersToButtons() {

        //Boton Añadir Elemento
        this.menuListaVista.btnAnadirElemento.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                anadirElementoAction();
            }
        });

        //Boton comprobar si tiene elemento siguiente
        this.menuListaVista.btnComprobarSiTieneElementoSiguiente.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {

                if (listaIterador.tieneSiguiente()) {
                    JOptionPane.showMessageDialog(menuListaVista, "EXISTE ELEMENTO SIGUIENTE", "EXISTE SIGUIENTE", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(menuListaVista, "LA LISTA NO CONTIENE MAS ELEMENTOS", "NO HAY MAS ELEMENTOS", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        //Boton obtener elemento siguiente
        this.menuListaVista.btnObtenerElementoSiguiente.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                obtenerElementoSiguienteAction();
            }
        });

        //Boton obtener Elemento Anterior
        this.menuListaVista.btnObtenerElementoAnterior.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                obtenerElementoAnteriorAction();
            }
        });
    }

    private void anadirElementoAction() {
        String elementoAnadir = this.menuListaVista.txtAnadirElemento.getText();

        try {
            Integer elementoAnadirInt = Integer.parseInt(elementoAnadir);

            if (elementoAnadirInt.getClass().getName().equals(this.lista.acceptedType())) {
                this.lista.add(elementoAnadirInt);
            } else {
                JOptionPane.showMessageDialog(this.menuListaVista, "EL ELEMENTO AÑADIDO NO ES VALIDO", "ERROR", JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception e) {
            if (elementoAnadir.getClass().getName().equals(this.lista.acceptedType())) {
                this.lista.add(elementoAnadir);
            } else {
                JOptionPane.showMessageDialog(this.menuListaVista, "EL ELEMENTO AÑADIDO NO ES VALIDO", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }

        this.listaIterador = this.lista.createIterator();

        this.menuListaVista.txtElementosDeLaLista.setText(this.listaIterador.convertListToString());
    }

    private void obtenerElementoSiguienteAction() {

        if (this.listaIterador.tieneSiguiente()) {
            this.menuListaVista.txtElementoSiguiente.setText(this.listaIterador.siguiente().toString());
            this.menuListaVista.txtElementosDeLaLista.setText(this.listaIterador.convertListToString());
        } else {
            JOptionPane.showMessageDialog(menuListaVista, "LA LISTA NO CONTIENE MAS ELEMENTOS", "NO HAY MAS ELEMENTOS", JOptionPane.ERROR_MESSAGE);
        }

    }

    private void obtenerElementoAnteriorAction() {
        this.menuListaVista.txtElementoAnterior.setText(this.listaIterador.anterior().toString());
        this.menuListaVista.txtElementosDeLaLista.setText(this.listaIterador.convertListToString());
    }
}
