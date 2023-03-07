/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asdm.examen_saul_rodriguez_naranjo.Modelos;

import asdm.examen_saul_rodriguez_naranjo.Modelos.iterator.IListaPizzas;
import asdm.examen_saul_rodriguez_naranjo.Modelos.iterator.Iterador;

/**
 *
 * @author SaulRC1
 */
public class ListaDePizzas implements IListaPizzas {

    private Pizza[] pizzas = new Pizza[4];
    private int pos = 0;
    
    @Override
    public Iterador crearIterador() {
        return new IteradorListaDePizzas(pizzas);
    }

    @Override
    public void add(Pizza p) {
        if(pos < 4) {
            pizzas[pos] = p;
            pos++;
        }
    }
    
    public Pizza[] getPizzas() {
        return this.pizzas;
    }
    
}
