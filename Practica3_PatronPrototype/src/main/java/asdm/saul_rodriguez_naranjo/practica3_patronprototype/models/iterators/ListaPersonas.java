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
public class ListaPersonas implements IListaPersonas {
    private Persona[] personas;
    private int posicionActual;
    
    private static int DEFAULT_STORAGE = 10;
    private static int DEFAULT_INCREMENT = 10;
    
    public ListaPersonas() {
        personas = new Persona[ListaPersonas.DEFAULT_STORAGE];
        this.posicionActual = 0;
    }
    
    @Override
    public IteradorPersonas crearIterador() {
        return new IteradorListaPersonas(this.personas);
    }

    @Override
    public void addElement(Persona persona) {
        
        if(this.posicionActual < this.personas.length) {
            
            this.personas[this.posicionActual] = persona;
            this.posicionActual++;
            
        } else {
            this.incrementStorage();
            this.personas[this.posicionActual] = persona;
            this.posicionActual++;
        }
    }
    
    private void incrementStorage() {
        
        Persona[] oldStorage = this.personas;
        
        this.personas = new Persona[this.personas.length + ListaPersonas.DEFAULT_INCREMENT];
        
        for (int i = 0; i < oldStorage.length; i++) {
            this.personas[i] = oldStorage[i];
        }
    }

    @Override
    public Persona getElementByNumber(int position) {
        return this.personas[position];
    }
}
