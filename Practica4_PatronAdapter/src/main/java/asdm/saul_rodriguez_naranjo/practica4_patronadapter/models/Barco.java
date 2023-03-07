/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asdm.saul_rodriguez_naranjo.practica4_patronadapter.models;

import asdm.saul_rodriguez_naranjo.practica4_patronadapter.interfaces.IVehiculo;

/**
 *
 * @author SaulRC1
 */
public class Barco implements IVehiculo {
    private boolean grifo;
    
    public Barco() {
        System.out.println("El grifo esta desconectado");
        this.grifo = false;
    }
    
    /**
     * Conecta el grifo
     */
    public void Conectar() {
        System.out.println("El grifo esta conectado");
        this.grifo = true;
    }
    
    /**
     * Activa el barco, en caso de que el grifo este conectado. En caso contrario
     * nos devuelve un mensaje de error.
     */
    public void Activar() {
        if (this.grifo == true) {
            System.out.println("El grifo esta conectado, se ha activado");
        } else {
            System.out.println("El grifo no esta conectado, imposible de activar");
        }
    }
    
    /**
     * Aumenta la velocidad del barco
     */
    public String moverMasRapido() {
        if(this.grifo == true) {
            //System.out.println("Velocidad Aumentada");
            return "\nVelocidad Aumentada";
        } else {
            return "\nERROR, EL GRIFO NO ESTA CONECTADO";
            //System.out.println("ERROR, EL GRIFO NO ESTA CONECTADO");
        }
    }
    
    /**
     * Detiene del barco
     */
    public String Detener() {
        if(this.grifo == true) {
            return "\nDeteniendo el barco...";
            //System.out.println("Deteniendo el barco...");
        } else {
            //System.out.println("ERROR, EL GRIFO NO ESTA CONECTADO");
            return "\nERROR, EL GRIFO NO ESTA CONECTADO";
        }
    }
    
    /**
     * Desconecta el grifo
     */
    public String Desconectar() {
        this.grifo = false;
        System.out.println("BARCO DESCONECTADO");
        return "BARCO DESCONECTADO";
    }

    @Override
    public String getCaracteristicas() {
        String caracteristicas = "Tipo de Vehiculo: Barco\n"
                               + "Sistema motor: Grifo";
        
        return caracteristicas;
    }
    
    @Override
    public String getTipo() {
        return "Barco";
    }
    
    public boolean getGrifo() {
        return this.grifo;
    }
}
