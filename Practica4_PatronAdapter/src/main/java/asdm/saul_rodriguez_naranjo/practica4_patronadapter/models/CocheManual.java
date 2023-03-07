/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asdm.saul_rodriguez_naranjo.practica4_patronadapter.models;

import asdm.saul_rodriguez_naranjo.practica4_patronadapter.interfaces.IVehiculo;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SaulRC1
 */
public class CocheManual implements IVehiculo {

    private int Revoluciones;
    private int Velocidad;
    private int marcha;
    private boolean averiado;

    public static int MAX_REVOLUCIONES = 5000;
    public static int MAX_MARCHA = 5;
    public static int MIN_REVOLUCIONES = 1000;
    public static int MIN_MARCHA = 1;

    public CocheManual(int Revoluciones, int Velocidad, int marcha) {
        this.Revoluciones = Revoluciones;
        this.Velocidad = Velocidad;
        this.marcha = marcha;
        this.averiado = false;
    }

    public CocheManual() {
        this.Revoluciones = 0;
        this.marcha = 0;
        this.Velocidad = 0;
        this.averiado = false;
    }

    public void Encender() {
        if (!averiado) {
            this.Revoluciones = 1000;
            this.marcha = 1;
            this.Velocidad = 20;

            System.out.println("El coche manual se ha encendido");
            System.out.println("Velocidad actual al: " + this.Velocidad + "");
            System.out.println("Marcha actual: " + this.marcha);
            System.out.println("Revoluciones actuales: " + this.Revoluciones);
        } else {
            System.out.println("Motor averiado, no se puede realizar la accion");
        }

    }

    public String Acelerar() {
        String resultadoAcelerar = null;
        
        if (!averiado) {
            resultadoAcelerar = "Coche manual acelera, se pasa de " + this.Revoluciones 
                    + " revoluciones a ";
            this.Revoluciones += 1000;
            resultadoAcelerar += this.Revoluciones + "";
            
            //System.out.println(resultadoAcelerar);
            this.Velocidad += 20;
            //System.out.println("Velocidad actual al: " + this.Velocidad + "%");
            resultadoAcelerar += "\nVelocidad actual al: " + this.Velocidad + "%";

            if (this.marcha > CocheManual.MAX_MARCHA || this.Revoluciones > CocheManual.MAX_REVOLUCIONES) {
                //System.out.println("Se ha sobrepasado el limite de marchas/revoluciones");
                //System.out.println("Apagando motor por averia...");
                resultadoAcelerar += "\nSe ha sobrepasado el limite de marchas/revoluciones";
                resultadoAcelerar += "\nApagando motor por averia...";
                
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(CocheManual.class.getName()).log(Level.SEVERE, null, ex);
                }

                resultadoAcelerar += "\n" + this.Apagar();

                this.averiado = true;

            }
        } else {
            //System.out.println("Motor averiado, no se puede realizar la accion");
            resultadoAcelerar = "Motor averiado, no se puede realizar la accion";
        }
        
        return resultadoAcelerar;
    }

    public String Apagar() {
        String resultadoApagar = "";
        if (!averiado) {
            System.out.println("Apagando el motor...");
            resultadoApagar = "Apagando el motor...";
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(CocheManual.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Apagado");
        } else {
            System.out.println("Motor averiado, no se puede realizar la accion");
        }
        
        return resultadoApagar;
    }

    public String Frenar() {
        String resultadoFrenar = null;
        if (!averiado) {
            resultadoFrenar = "Coche manual frena, se pasa de " + this.Revoluciones + " revoluciones a ";
            this.Revoluciones -= 1000;
            resultadoFrenar += this.Revoluciones + "";
            //System.out.println(resultadoFrenar);
            this.Velocidad -= 20;
            //System.out.println("Velocidad actual al: " + this.Velocidad + "%");
            resultadoFrenar += "\nVelocidad actual al: " + this.Velocidad + "%";

            if (this.marcha < CocheManual.MIN_MARCHA || this.Revoluciones < CocheManual.MIN_REVOLUCIONES) {
                //System.out.println("El coche esta por debajo de los valores minimos de marcha/revoluciones, se procede al apagado del motor");
                resultadoFrenar += "\nEl coche esta por debajo de los valores minimos de marcha/revoluciones, se procede al apagado del motor";
                resultadoFrenar += "\n" + this.Apagar();
            }
        } else {
            //System.out.println("Motor averiado, no se puede realizar la accion");
            resultadoFrenar = "Motor averiado, no se puede realizar la accion";
        }
        
        return resultadoFrenar;
    }
    
    public String SubeMarcha() {
        System.out.println("Se sube de marcha, de " + this.marcha + "ª a " + (this.marcha + 1) + "ª");
        this.marcha++;
        
        return "Se sube de marcha, de " + this.marcha + "ª a " + (this.marcha + 1) + "ª";
    }
    
    public String BajaMarcha() {
        System.out.println("Se sube de marcha, de " + this.marcha + "ª a " + (this.marcha - 1) + "ª");
        this.marcha--;
        
        return "Se sube de marcha, de " + this.marcha + "ª a " + (this.marcha - 1) + "ª";
    }

    @Override
    public String getCaracteristicas() {
        String caracteristicas = "Tipo de Vehiculo: Coche Manual\n" +
                                 "Sistema motor: Revoluciones y Marchas";
        
        return caracteristicas;
    }
    
    @Override
    public String getTipo() {
        return "Coche Manual";
    }
    
    public boolean getAveriado() {
        return this.averiado;
    }

}
