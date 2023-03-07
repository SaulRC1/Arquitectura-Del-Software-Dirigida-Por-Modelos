/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asdm.saul_rodriguez_naranjo.practica2_patronfactory.models.concretemodels;

import asdm.saul_rodriguez_naranjo.practica2_patronfactory.models.factorymodels.Hora;

/**
 *
 * @author SaulRC1
 */
public class HoraFormatoAM_PM extends Hora {

    public HoraFormatoAM_PM(int horas, int minutos, int segundos) {
        super(horas, minutos, segundos);
    }

    public HoraFormatoAM_PM(int segundos) {
        super(segundos);
    }

    @Override
    public String establecerFormatoHora() {
        
        String afterOrPostMeridian;
        
        if(this.getHoras() > 12) {
            this.setHoras(this.getHoras() - 12);
            afterOrPostMeridian = " PM";
        } else {
            afterOrPostMeridian = " AM";
        }
        
        String horas = (this.getHoras() < 10) ? ("0" + this.getHoras()) : ("" + this.getHoras());
        String minutos = (this.getMinutos()< 10) ? ("0" + this.getMinutos()) : ("" + this.getMinutos());
        String segundos = (this.getSegundos() < 10) ? ("0" + this.getSegundos()) : ("" + this.getSegundos());
        
        String formatoAM_PM = horas.concat(":").concat(minutos).concat(":").concat(segundos).concat(afterOrPostMeridian);
        
        return formatoAM_PM;
    }
    
}
