/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package asdm.saul_rodriguez_naranjo.practica1_patronsingleton.models.observables;

import asdm.saul_rodriguez_naranjo.practica1_patronsingleton.models.observers.Observer;

/**
 *
 * @author SaulRC1
 */
public interface Observable {
    public void addObserver(Observer obs);
    public void deleteObserver(Observer obs);
    public void notifyObservers();
}
