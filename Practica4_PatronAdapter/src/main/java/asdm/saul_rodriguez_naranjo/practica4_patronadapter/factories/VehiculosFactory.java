/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asdm.saul_rodriguez_naranjo.practica4_patronadapter.factories;

import asdm.saul_rodriguez_naranjo.practica4_patronadapter.interfaces.IVehiculo;
import asdm.saul_rodriguez_naranjo.practica4_patronadapter.models.Barco;
import asdm.saul_rodriguez_naranjo.practica4_patronadapter.models.CocheAutomatico;
import asdm.saul_rodriguez_naranjo.practica4_patronadapter.models.CocheManual;

/**
 *
 * @author SaulRC1
 */
public class VehiculosFactory {

    public static int COCHE_MANUAL = 0;
    public static int COCHE_AUTOMATICO = 1;
    public static int BARCO = 2;

    public static IVehiculo getVehiculo(int tipo) {
        
        if (tipo == VehiculosFactory.COCHE_MANUAL) {
            
            return VehiculosFactory.getCocheManualInstance();
            
        } else if (tipo == VehiculosFactory.COCHE_AUTOMATICO) {
            
            return VehiculosFactory.getCocheAutomaticoInstance();
            
        } else if (tipo == VehiculosFactory.BARCO) {
            
            return VehiculosFactory.getBarcoInstance();
            
        }
        
        return null;
    }

    public static CocheManual getCocheManualInstance() {
        return new CocheManual();
    }

    public static CocheAutomatico getCocheAutomaticoInstance() {
        return new CocheAutomatico();
    }

    public static Barco getBarcoInstance() {
        return new Barco();
    }
}
