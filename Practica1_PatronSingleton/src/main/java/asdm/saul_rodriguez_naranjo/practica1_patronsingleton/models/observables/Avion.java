/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asdm.saul_rodriguez_naranjo.practica1_patronsingleton.models.observables;

import asdm.saul_rodriguez_naranjo.practica1_patronsingleton.models.observers.Observer;
import java.util.ArrayList;
import javax.swing.SwingUtilities;

/**
 *
 * @author SaulRC1
 */
public class Avion implements Observable {
    private static Avion avion = new Avion();
    private int asientos;
    private ArrayList<Observer> observers;
    
    public Avion() {
        this.asientos = 180;
        this.observers = new ArrayList<>();
    }
    
    public static Avion getAvion() {
        return avion;
    }
    
    public void VendeBillete(int billetes) {
        if(asientos > 0) {
            asientos -= billetes;
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    notifyObservers();
                }
            });
        } else {
            System.out.println("No quedan mas plazas");
        }
    }
    
    public void DevuelveBilletes(int billetes) {
        if(asientos < 180) {
            asientos += billetes;
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    notifyObservers();
                }
            });
        }
    }
    
    public int CuantosAsientosQuedan() {
        return asientos;
    }
    
    public int asientosComprados() {
        return 180 - asientos;
    }

    @Override
    public void addObserver(Observer obs) {
        this.observers.add(obs);
    }

    @Override
    public void deleteObserver(Observer obs) {
        this.observers.remove(obs);
    }

    @Override
    public void notifyObservers() {
        for(Observer obs: this.observers) {
            obs.update();
        }
    }
}
