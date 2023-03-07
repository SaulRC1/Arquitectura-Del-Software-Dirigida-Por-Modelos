/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package asdm.saul_rodriguez_naranjo.practica5_patroniterator.interfaces;

import asdm.saul_rodriguez_naranjo.practica5_patroniterator.factories.ListaFactory;
import asdm.saul_rodriguez_naranjo.practica5_patroniterator.iteradores.Iterador;
import asdm.saul_rodriguez_naranjo.practica5_patroniterator.iteradores.ListaPalabrasIterador;

/**
 *
 * @author SaulRC1
 */
public interface IListaPalabras extends ListaFactory {
    public void agregar(String p);
    public ListaPalabrasIterador crearIterador();
}
