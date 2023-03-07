/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asdm.saul_rodriguez_naranjo.practica2_patronfactory.models.concretemodels;

import asdm.saul_rodriguez_naranjo.practica2_patronfactory.controllers.factory.FactoriaHoras;
import asdm.saul_rodriguez_naranjo.practica2_patronfactory.models.factorymodels.Hora;
import asdm.saul_rodriguez_naranjo.practica2_patronfactory.views.PanelHoraDigital;
import java.util.Calendar;
import javax.swing.SwingUtilities;

/**
 *
 * @author SaulRC1
 */
public class RelojThread implements Runnable {
    private PanelHoraDigital panelHoraDigital;
    private Calendar calendar;
    private Hora formatoHora;
    private int tipo; // 1 - Formato 12 Horas 2 - Formato 24 horas
    
    public RelojThread(Calendar calendar, PanelHoraDigital panelHoraDigital, int tipo) {
        this.calendar = calendar;
        this.panelHoraDigital = panelHoraDigital;
        this.tipo = tipo;
    }

    @Override
    public void run() {
        while(!Thread.currentThread().isInterrupted()) {
            
            //System.out.println("holaaa");
            
            calendar = Calendar.getInstance(this.calendar.getTimeZone());
            
            if(tipo == 1) {
                this.formatoHora = FactoriaHoras.formatoHorasSeleccionado("12H", calendar.get(Calendar.HOUR_OF_DAY),
                        calendar.get(Calendar.MINUTE), calendar.get(Calendar.SECOND));
            } else {
                this.formatoHora = FactoriaHoras.formatoHorasSeleccionado("24H", calendar.get(Calendar.HOUR_OF_DAY),
                        calendar.get(Calendar.MINUTE), calendar.get(Calendar.SECOND));
            }
            
            
            String hora = formatoHora.establecerFormatoHora();
            System.out.println(hora);
            
            SwingUtilities.invokeLater(new Runnable(){
                @Override
                public void run() {
                    panelHoraDigital.setHora(hora); 
                }      
            });
            
        }
    }
    
}
