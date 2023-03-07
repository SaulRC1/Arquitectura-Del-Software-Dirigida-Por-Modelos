/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package asdm.saul_rodriguez_naranjo.practica2_patronfactory;

import asdm.saul_rodriguez_naranjo.practica2_patronfactory.controllers.MenuPrincipalController;
import asdm.saul_rodriguez_naranjo.practica2_patronfactory.controllers.factory.FactoriaHoras;
import asdm.saul_rodriguez_naranjo.practica2_patronfactory.models.factorymodels.Hora;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 *
 * @author SaulRC1
 */
public class PatronFactoryApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        /*int hora = LocalDateTime.now().getHour();
        int minutos = LocalDateTime.now().getMinute();
        int segundos = LocalDateTime.now().getSecond();
        Hora h = FactoriaHoras.formatoHorasSeleccionado("24H", hora, minutos, segundos);
        System.out.println("Formato 24 Horas");
        System.out.println("----------------");
        System.out.println(h.establecerFormatoHora());
        Hora h2 = FactoriaHoras.formatoHorasSeleccionado("AM_PM", hora, minutos, segundos);
        System.out.println("Formato AM PM");
        System.out.println("-------------");
        System.out.println(h2.establecerFormatoHora());
        System.out.println(LocalDateTime.now().getHour() + ":" + LocalDateTime.now().getMinute() + ":" 
                + LocalDateTime.now().getSecond());
        
        String[] availId = TimeZone.getAvailableIDs();   

        for (String availId1 : availId) {

            System.out.println(availId1);

        }*/
        /*Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        while(true) {
            calendar = Calendar.getInstance(TimeZone.getDefault());
            System.out.println("Segundos: " + calendar.get(Calendar.SECOND));
        }*/
        MenuPrincipalController menuPrincipalController = new MenuPrincipalController();
        
    }
    
}
