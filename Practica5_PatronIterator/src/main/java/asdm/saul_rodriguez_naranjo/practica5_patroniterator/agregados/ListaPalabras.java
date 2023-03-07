/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asdm.saul_rodriguez_naranjo.practica5_patroniterator.agregados;

import asdm.saul_rodriguez_naranjo.practica5_patroniterator.interfaces.IListaPalabras;
import asdm.saul_rodriguez_naranjo.practica5_patroniterator.iteradores.Iterador;
import asdm.saul_rodriguez_naranjo.practica5_patroniterator.iteradores.ListaPalabrasIterador;

/**
 *
 * @author SaulRC1
 */
public class ListaPalabras implements IListaPalabras {
    String palabras[];
    int pos;
    
    public ListaPalabras() {
        pos = 0;
        palabras = new String[5];
    }
    
    @Override
    public void agregar(String p) {
        palabras[pos++] = p;
    }

    @Override
    public ListaPalabrasIterador crearIterador() {
        return new ListaPalabrasIterador(palabras, -1);
    }

    @Override
    public Iterador createIterator() {
        return (Iterador) new ListaPalabrasIterador(palabras, -1);
    }

    @Override
    public String getTipoDeLista() {
        return "Lista de Palabras";
    }

    @Override
    public void add(Object obj) {
        if(obj instanceof String) {
            this.agregar((String) obj);
        }
    }

    @Override
    public String acceptedType() {
        return String.class.getName();
    }
    
}
