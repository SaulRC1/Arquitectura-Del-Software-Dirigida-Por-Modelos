/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asdm.saul_rodriguez_naranjo.practica3_patronprototype.models.iterators;

import asdm.saul_rodriguez_naranjo.practica3_patronprototype.models.Familiar;
import asdm.saul_rodriguez_naranjo.practica3_patronprototype.models.Persona;

/**
 *
 * @author SaulRC1
 */
public class IteradorListaPersonas implements IteradorPersonas {

    private Persona[] personas;
    private int posicionActual;
    
    public IteradorListaPersonas(Persona[] personas) {
        this.personas = personas;
        this.posicionActual = -1;
        
    }
    
    @Override
    public Persona siguiente() {
        if(this.tieneSiguiente()) {
            this.posicionActual++;
            return this.personas[this.posicionActual];
        }
        
        return null;
    }

    @Override
    public boolean tieneSiguiente() {
        if(this.personas[posicionActual + 1] == null) {
            return false;
        }
        
        return true;
    }
    
}
