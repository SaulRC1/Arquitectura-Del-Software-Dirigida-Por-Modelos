/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package asdm.examen_saul_rodriguez_naranjo.Modelos.observable;

import asdm.examen_saul_rodriguez_naranjo.Modelos.observer.Observer;

/**
 *
 * @author SaulRC1
 */
public interface Observable {
    public void addObserver(Observer observer);
    public void notifyObservers();
}
