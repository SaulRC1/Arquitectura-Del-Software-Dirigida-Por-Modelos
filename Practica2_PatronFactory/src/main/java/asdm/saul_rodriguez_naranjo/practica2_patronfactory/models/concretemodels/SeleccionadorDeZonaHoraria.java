/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asdm.saul_rodriguez_naranjo.practica2_patronfactory.models.concretemodels;

import asdm.saul_rodriguez_naranjo.practica2_patronfactory.models.factorymodels.Hora;
import java.util.TimeZone;

/**
 * Utilizará patron Singleton
 * @author SaulRC1
 */
public class SeleccionadorDeZonaHoraria {
    
    //Variable que alojara nuestro patron singleton
    private static SeleccionadorDeZonaHoraria seleccionadorDeZonaHoraria = new SeleccionadorDeZonaHoraria();
    
    
    /**
     * Constructor privado para seguir el patron Singleton
     */
    private SeleccionadorDeZonaHoraria() {
        
    }
    
    public static SeleccionadorDeZonaHoraria getSeleccionadorDeZonaHorariaInstance() {
        return SeleccionadorDeZonaHoraria.seleccionadorDeZonaHoraria;
    }
    
    public Hora cambiarZonaHoraria(TimeZone zona1, TimeZone zona2, int formato)
    {
        return null;
    }
    
}
