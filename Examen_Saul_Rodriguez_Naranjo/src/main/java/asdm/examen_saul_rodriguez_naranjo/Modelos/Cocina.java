/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asdm.examen_saul_rodriguez_naranjo.Modelos;

import asdm.examen_saul_rodriguez_naranjo.Modelos.observable.Observable;
import asdm.examen_saul_rodriguez_naranjo.Modelos.observer.Observer;
import java.util.ArrayList;

/**
 *
 * @author SaulRC1
 */
public class Cocina implements Observable, Observer { 
    private ArrayList<Pedido> pedidos;
    private ArrayList<Observer> observers;
    private int posicionActual = 0;
    
    private static Cocina cocina = new Cocina();
    

    private Cocina() {
        pedidos = new ArrayList<>();
        observers = new ArrayList<>();
    }
    
    @Override
    public void addObserver(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        for(Observer obs: this.observers) {
            obs.update();
        }
    }
    
    public void addPedido(Pedido pedido) {
        this.pedidos.add(pedido);
        this.notifyObservers();
    }
    
    public void removePedido(Pedido pedido) {
        this.pedidos.remove(pedido);
    }
    
    public static Cocina getCocinaInstance() {
        return Cocina.cocina;
    }
    
    public ArrayList<Pedido> getPedidos() {
        return this.pedidos;
    }

    @Override
    public void update() {
        this.pedidos.get(posicionActual).setEstado(Pedido.EN_PREPARACION);
        this.notifyObservers();
    }
    
    public void prepararPedido() {
        this.pedidos.get(posicionActual).setEstado(Pedido.TERMINADO);
        this.notifyObservers();
        this.posicionActual++;
    }
    
    public int getPosicionActual() {
        return this.posicionActual;
    }
    
    public void cambiarARetirado(int pos) {
        this.pedidos.get(pos).setEstado(Pedido.RETIRADO);
        this.notifyObservers();
    }
}
