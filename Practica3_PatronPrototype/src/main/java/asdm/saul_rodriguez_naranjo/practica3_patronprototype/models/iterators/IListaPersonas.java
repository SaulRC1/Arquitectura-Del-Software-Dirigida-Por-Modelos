/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package asdm.saul_rodriguez_naranjo.practica3_patronprototype.models.iterators;

import asdm.saul_rodriguez_naranjo.practica3_patronprototype.models.Familiar;
import asdm.saul_rodriguez_naranjo.practica3_patronprototype.models.Persona;

/**
 *
 * @author SaulRC1
 */
public interface IListaPersonas {

    public IteradorPersonas crearIterador();

    public void addElement(Persona persona);
    
    public Persona getElementByNumber(int position);

}
