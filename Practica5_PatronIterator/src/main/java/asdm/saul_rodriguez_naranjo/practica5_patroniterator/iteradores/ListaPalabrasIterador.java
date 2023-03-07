/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asdm.saul_rodriguez_naranjo.practica5_patroniterator.iteradores;

import asdm.saul_rodriguez_naranjo.practica5_patroniterator.agregados.ListaPalabras;

/**
 *
 * @author SaulRC1
 */
public class ListaPalabrasIterador implements Iterador {

    private String palabras[];
    private int pos;
    private int actual;
    private ListaPalabras lista;

    public ListaPalabrasIterador(String[] palabras, int pos) {
        this.palabras = palabras;
        this.pos = pos;
        this.actual = pos;
    }

    public ListaPalabrasIterador(String[] palabras, int pos, ListaPalabras lista) {
        this.palabras = palabras;
        this.pos = pos;
        this.lista = lista;
    }

    @Override
    public Object siguiente() {
        if (pos < palabras.length) {
            this.actual = pos + 1;
            this.pos = pos + 1;
            return palabras[pos];
        } else {
            return null;
        }
    }

    @Override
    public boolean tieneSiguiente() {
        return this.palabras[this.pos + 1] != null;
    }

    @Override
    public Object anterior() {
        if (pos > 0) {
            this.actual = pos - 1;
            this.pos = this.pos - 1;
            return palabras[pos];
        }
        this.actual = 0;
        return this.palabras[0];
    }

    @Override
    public String convertListToString() {
        String listaToString = "";

        for (int i = 0; i < this.palabras.length; i++) {
            if (palabras[i] == null) {
                break;
            } else {
                if (i == this.actual) {
                    listaToString += "\n-->[" + palabras[i] + "]<--";
                } else{
                    listaToString += "\n" + palabras[i];
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
