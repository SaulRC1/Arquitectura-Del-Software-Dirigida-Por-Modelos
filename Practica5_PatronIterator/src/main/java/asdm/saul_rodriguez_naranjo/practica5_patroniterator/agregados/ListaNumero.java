/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asdm.saul_rodriguez_naranjo.practica5_patroniterator.agregados;

import asdm.saul_rodriguez_naranjo.practica5_patroniterator.interfaces.IListaNumero;
import asdm.saul_rodriguez_naranjo.practica5_patroniterator.iteradores.Iterador;
import asdm.saul_rodriguez_naranjo.practica5_patroniterator.iteradores.ListaNumerosIterador;

/**
 *
 * @author SaulRC1
 */
public class ListaNumero implements IListaNumero {

    private int numeros[];
    private int posicion;

    private static int LIST_INCREMENT = 2;
    private static int DEFAULT_STORAGE = 10;

    public ListaNumero() {
        this.posicion = 0;
        this.numeros = new int[ListaNumero.DEFAULT_STORAGE];
        
        for (int i = 0; i < this.numeros.length; i++) {
            this.numeros[i] = -1;
        }
    }

    @Override
    public void agregar(int numero) {
        if (this.posicion < this.numeros.length) {
            this.numeros[this.posicion] = numero;
            this.posicion++;
        } else {
            int[] oldNumeros = this.numeros;
            this.numeros = new int[oldNumeros.length * ListaNumero.LIST_INCREMENT];

            for (int i = 0; i < oldNumeros.length; i++) {
                this.numeros[i] = oldNumeros[i];
            }
            
            for (int i = oldNumeros.length; i < this.numeros.length; i++) {
                this.numeros[i] = -1;
            }

            this.numeros[this.posicion] = numero;
            this.posicion++;
        }
    }

    @Override
    public ListaNumerosIterador crearIterador() {
        return new ListaNumerosIterador(numeros, -1, this);
    }

    @Override
    public Iterador createIterator() {
        return (Iterador) new ListaNumerosIterador(numeros, -1, this);
    }

    @Override
    public String getTipoDeLista() {
        return "Lista de Numeros";
    }

    @Override
    public void add(Object obj) {

        this.agregar((int) obj);

    }

    @Override
    public String acceptedType() {
        return Integer.class.getName();
    }

}
