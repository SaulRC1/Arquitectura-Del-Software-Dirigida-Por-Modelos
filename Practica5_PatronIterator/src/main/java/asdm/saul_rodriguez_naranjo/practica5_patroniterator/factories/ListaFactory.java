/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package asdm.saul_rodriguez_naranjo.practica5_patroniterator.factories;

import asdm.saul_rodriguez_naranjo.practica5_patroniterator.iteradores.Iterador;

/**
 *
 * @author SaulRC1
 */
public interface ListaFactory {
    public Iterador createIterator();
    public String getTipoDeLista();
    public void add(Object obj);
    public String acceptedType();
}
