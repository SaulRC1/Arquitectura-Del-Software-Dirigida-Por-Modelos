/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asdm.saul_rodriguez_naranjo.practica5_patroniterator.iteradores;

import asdm.saul_rodriguez_naranjo.practica5_patroniterator.agregados.ListaNumero;

/**
 *
 * @author SaulRC1
 */
public class ListaNumerosIterador implements Iterador {

    private int numeros[];
    private int posicion;
    private int actual;
    private ListaNumero listaNumeros;

    public ListaNumerosIterador(int[] numeros, int posicion, ListaNumero listaNumeros) {
        this.numeros = numeros;
        this.posicion = posicion;
        this.listaNumeros = listaNumeros;
        this.actual = posicion;
    }

    @Override
    public Object siguiente() {
        if (this.tieneSiguiente()) {
            Object siguiente = this.numeros[this.posicion + 1];
            this.actual = this.posicion + 1;
            this.posicion++;
            return siguiente;
        } else {
            return null;
        }
    }

    @Override
    public boolean tieneSiguiente() {
        return this.numeros[this.posicion + 1] != -1;
    }

    @Override
    public Object anterior() {
        if (this.posicion - 1 >= 0) {
            Object anterior = this.numeros[this.posicion - 1];
            this.actual = this.posicion - 1;
            this.posicion--;
            return anterior;
        } else {
            this.actual = 0;
            return this.numeros[0];
        }
    }

    @Override
    public String convertListToString() {
        String listaToString = "";

        for (int i = 0; i < numeros.length; i++) {
            if (this.numeros[i] != -1) {
                if (i == this.actual) {
                    listaToString += "\n-->[" + numeros[i] + "]<--";
                } else {
                    listaToString += "\n" + numeros[i];
                }
            }
        }

        return listaToString;
    }

    @Override
    public Object actual() {
        return (Object) this.actual;
    }

}
