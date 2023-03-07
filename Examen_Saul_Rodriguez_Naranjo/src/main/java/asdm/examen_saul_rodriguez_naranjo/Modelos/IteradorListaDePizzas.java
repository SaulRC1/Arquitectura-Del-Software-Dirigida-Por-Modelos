/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asdm.examen_saul_rodriguez_naranjo.Modelos;

import asdm.examen_saul_rodriguez_naranjo.Modelos.iterator.Iterador;

/**
 *
 * @author SaulRC1
 */
public class IteradorListaDePizzas implements Iterador {

    private Pizza[] lista;
    private int pos = 0;
    
    public IteradorListaDePizzas(Pizza[] lista) {
        this.lista = lista;
    }
    
    @Override
    public Object siguiente() {
        if(pos < this.lista.length) {
            return (Object) this.lista[pos++];
        }
        
        return null;
    }

    @Override
    public boolean tieneSiguiente() {
        if(pos < 4) {
            return true;
        }
        
        return false;
    }
    
}
