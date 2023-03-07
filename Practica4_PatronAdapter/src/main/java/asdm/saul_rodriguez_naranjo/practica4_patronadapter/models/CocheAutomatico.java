/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asdm.saul_rodriguez_naranjo.practica4_patronadapter.models;

import asdm.saul_rodriguez_naranjo.practica4_patronadapter.interfaces.IMandos;
import asdm.saul_rodriguez_naranjo.practica4_patronadapter.interfaces.IVehiculo;

/**
 *
 * @author SaulRC1
 */
public class CocheAutomatico implements IMandos, IVehiculo {

    private int Revoluciones;
    private int Velocidad;

    public static int MAX_REVOLUCIONES = 5000;
    public static int MIN_REVOLUCIONES = 0;

    public CocheAutomatico() {
        this.Revoluciones = 0;
        this.Velocidad = 0;
    }

    @Override
    public String Acelera() {
        String resultadoAcelerar = null;
        
        if (this.Revoluciones < CocheAutomatico.MAX_REVOLUCIONES) {
            resultadoAcelerar = "Coche manual acelera, se pasa de " + this.Revoluciones
                    + " revoluciones a ";
            this.Revoluciones += 1000;
            resultadoAcelerar += this.Revoluciones + "";

            //System.out.println(resultadoAcelerar);
            this.Velocidad += 20;
            //System.out.println("Velocidad actual al: " + this.Velocidad + "%");
            resultadoAcelerar += "\nVelocidad actual al: " + this.Velocidad + "%";
        } else {
            resultadoAcelerar = "VELOCIDAD Y REVOLUCIONES MAXIMAS ALCANZADAS";
            //System.out.println("VELOCIDAD Y REVOLUCIONES MAXIMAS ALCANZADAS");
        }
        
        return resultadoAcelerar;
    }

    @Override
    public String Frena() {
        String resultadoFrenar = null;
        
        if (this.Revoluciones > CocheAutomatico.MIN_REVOLUCIONES) {
            
            resultadoFrenar = "Coche manual frena, se pasa de " + this.Revoluciones + " revoluciones a ";
            this.Revoluciones -= 1000;
            resultadoFrenar += this.Revoluciones + "";
            //System.out.println(resultadoFrenar);
            this.Velocidad -= 20;
            resultadoFrenar += "\nVelocidad actual al: " + this.Velocidad + "%";
            //System.out.println("Velocidad actual al: " + this.Velocidad + "%");
            
        } else {
            //System.out.println("VELOCIDAD Y REVOLUCIONES MINIMAS ALCANZADAS");
            resultadoFrenar = "VELOCIDAD Y REVOLUCIONES MINIMAS ALCANZADAS";
        }
        
        return resultadoFrenar;
    }

    @Override
    public String getCaracteristicas() {
        String caracteristicas = "Tipo de Vehiculo: Coche Automático\n" +
                                 "Sistema motor: Revoluciones";
        
        return caracteristicas;
    }
    
    @Override
    public String getTipo() {
        return "Coche Automatico";
    }

}
