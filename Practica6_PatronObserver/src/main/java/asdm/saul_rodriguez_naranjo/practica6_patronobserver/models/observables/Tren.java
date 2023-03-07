/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asdm.saul_rodriguez_naranjo.practica6_patronobserver.models.observables;

import asdm.saul_rodriguez_naranjo.practica6_patronobserver.models.observers.Observer;
import java.util.ArrayList;

/**
 *
 * @author SaulRC1
 */
public class Tren implements Observable {
    private int capacidad;
    private int plazasDisponibles;
    private boolean direccion; //true: Huelva-Sevilla, false: Sevilla-Huelva
    private boolean estado; //false: parado, true: en marcha
    private int numeroDeEstacion; //0 - Huelva, 4 - Sevilla
    private int velocidad_km_h;
    private ArrayList<Observer> observadores;
    
    //Variables por Defecto
    private static int DEFAULT_CAPACITY = 400;
    private static boolean DEFAULT_DIRECTION = true;
    private static boolean DEFAULT_STATE = false;
    private static int DEFAULT_STATION = Estacion.HUELVA;
    private static int DEFAULT_SPEED_KM_H = 53;
    
    private static Tren tren = new Tren(); //Patron Singleton
    
    /**
     * Constructor privado para seguir patron singleton
     */
    private Tren() {
        this.capacidad = Tren.DEFAULT_CAPACITY;
        this.plazasDisponibles = Tren.DEFAULT_CAPACITY;
        this.direccion = Tren.DEFAULT_DIRECTION;
        this.estado = Tren.DEFAULT_STATE;
        this.numeroDeEstacion = Tren.DEFAULT_STATION;
        this.velocidad_km_h = Tren.DEFAULT_SPEED_KM_H;
        
        this.observadores = new ArrayList<>();
    }
    
    /**
     * Devuelve la instancia del tren
     * @return la unica instancia existente del tren
     */
    public static Tren getTrenInstance() {
        return Tren.tren;
    }
    
    /**
     * Mueve el tren a la siguiente estacion
     */
    public void moverse() {
        this.estado = true;
    }
    
    /**
     * Obtiene el numero de plazas disponibles del tren
     * @return plazasDisponibles
     */
    public int getPlazasDisponibles() {
        return this.plazasDisponibles;
    }
    
    /**
     * Establece las plazas disponibles del tren cuando suben y bajan personas
     * @param suben cuantas personas suben
     * @param bajan cuantas personas bajan
     */
    public void setPlazasDisponibles(int suben, int bajan) {
        int plazasDisponibles = this.plazasDisponibles;
        if(plazasDisponibles + bajan <= 400) {
            plazasDisponibles = plazasDisponibles + bajan;
        }
        
        plazasDisponibles = plazasDisponibles - suben;
        
        if(plazasDisponibles >= 0) {
            this.plazasDisponibles = plazasDisponibles;
        }
    }
    
    /**
     * Cambia la direccion del rumbo del tren
     * @param direccion true -> Huelva - Sevilla | false -> Sevilla - Huelva
     */
    public void establecerDireccion(boolean direccion) {
        this.direccion = direccion;
    }
    
    /**
     * Obtiene la direccion actual del tren
     * @return true -> Huelva - Sevilla | false -> Sevilla - Huelva
     */
    public boolean getDireccion() {
        return this.direccion;
    }
    
    /**
     * Devuelve la estacion actual en la que se encuentra el tren
     * @return 0 - Huelva | 1 - Gibraleon | 2 - La Palma | 3 - Bollullos | 4 - Sevilla
     */
    public int getNumeroDeEstacion() {
        return this.numeroDeEstacion;
    }
    
    public boolean getEstado() {
        return this.estado;
    }
    
    /**
     * Inserta la estacion actual en la que se encuentra el tren
     * @param numeroDeEstacion 0 - Huelva | 1 - Gibraleon | 2 - La Palma | 3 - Bollullos | 4 - Sevilla
     */
    public void setNumeroDeEstacion(int numeroDeEstacion) {
        this.numeroDeEstacion = numeroDeEstacion;
    }
    
    public int getVelocidad() {
        return this.velocidad_km_h;
    }

    @Override
    public void addObserver(Observer observer) {
        this.observadores.add(observer);
    }

    @Override
    public void deleteObserver(Observer observer) {
        this.observadores.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer: this.observadores) {
            observer.update();
        }
    }
    
    
}
