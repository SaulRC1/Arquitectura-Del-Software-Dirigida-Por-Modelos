/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asdm.saul_rodriguez_naranjo.practica6_patronobserver.models.observables;

import asdm.saul_rodriguez_naranjo.practica6_patronobserver.models.observers.Observer;

/**
 *
 * @author SaulRC1
 */
public class Estacion implements Observer{

    private String nombre;
    private int distanciaHastaSiguienteEstacion; //Distancia en Kms hasta la
                                                 //siguiente estación dirección
                                                 //Huelva-Sevilla

    private int distanciaHastaAnteriorEstacion; //Distancia en Kms hasta la
                                                //estacion anterior direccion
                                                //Sevilla-Huelva

    private int numeroDeEstacion; //A que estacion corresponde 0 - Huelva, 4 - Sevilla
    
    private Tren tren;
    
    //Declaramos las diferentes estaciones
    public static int HUELVA = 0;
    public static int GIBRALEON = 1;
    public static int LA_PALMA = 2;
    public static int BOLLULLOS = 3;
    public static int SEVILLA = 4;

    public Estacion(String nombre, int distanciaHastaSiguienteEstacion, int distanciaHastaAnteriorEstacion, int numeroDeEstacion, Tren tren) {
        this.nombre = nombre;
        this.distanciaHastaSiguienteEstacion = distanciaHastaSiguienteEstacion;
        this.distanciaHastaAnteriorEstacion = distanciaHastaAnteriorEstacion;
        this.numeroDeEstacion = numeroDeEstacion;
        
        this.tren = tren;
    }

    public void actualizar(int plazasDisponibles, boolean direccion,
            boolean estado) {
        
    }
    
    public int getDistanciaSiguiente() {
        return this.distanciaHastaSiguienteEstacion;
    }
    
    public String getNombre() {
        return this.nombre;
    }
    
    public int getDistanciaAnterior() {
        return this.distanciaHastaAnteriorEstacion;
    }
    
    public int getNumeroDeEstacion() {
        return this.numeroDeEstacion;
    }

    @Override
    public void update() {
        if(tren.getNumeroDeEstacion() == this.numeroDeEstacion) {
            System.out.println("ESTACION ACTUAL " + this.nombre);
        }
        
    }
}
