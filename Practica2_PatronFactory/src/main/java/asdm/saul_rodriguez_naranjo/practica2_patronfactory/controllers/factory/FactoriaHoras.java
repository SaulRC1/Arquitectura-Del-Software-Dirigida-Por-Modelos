/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asdm.saul_rodriguez_naranjo.practica2_patronfactory.controllers.factory;

import asdm.saul_rodriguez_naranjo.practica2_patronfactory.models.concretemodels.HoraFormato24Horas;
import asdm.saul_rodriguez_naranjo.practica2_patronfactory.models.concretemodels.HoraFormatoAM_PM;
import asdm.saul_rodriguez_naranjo.practica2_patronfactory.models.factorymodels.Hora;

/**
 *
 * @author SaulRC1
 */
public class FactoriaHoras {
    
    public static Hora formatoHorasSeleccionado(String formato, int segundos) {
        if(formato.equals("24H")) {
            return new HoraFormato24Horas(segundos);
        } else {
            return new HoraFormatoAM_PM(segundos);
        }
    }
    
    public static Hora formatoHorasSeleccionado(String formato, int horas,
            int minutos, int segundos) {
        if(formato.equals("24H")) {
            return new HoraFormato24Horas(horas, minutos, segundos);
        } else {
            return new HoraFormatoAM_PM(horas, minutos, segundos);
        }
    }
}
