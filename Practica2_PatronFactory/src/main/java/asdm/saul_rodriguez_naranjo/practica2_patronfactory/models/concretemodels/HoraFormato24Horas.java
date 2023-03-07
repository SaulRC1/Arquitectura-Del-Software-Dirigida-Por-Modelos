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
public class HoraFormato24Horas extends Hora {

    public HoraFormato24Horas(int horas, int minutos, int segundos) {
        super(horas, minutos, segundos);
    }

    public HoraFormato24Horas(int segundos) {
        super(segundos);
    }

    @Override
    public String establecerFormatoHora() {
        
        //86400 segundos son 24h 0m 0s
        if(this.getHoras() == 24) {
            this.setHoras(0);
        }
        
        String horas = (this.getHoras() < 10) ? ("0" + this.getHoras()) : ("" + this.getHoras());
        String minutos = (this.getMinutos()< 10) ? ("0" + this.getMinutos()) : ("" + this.getMinutos());
        String segundos = (this.getSegundos() < 10) ? ("0" + this.getSegundos()) : ("" + this.getSegundos());
        
        String formato24Horas = horas.concat(":").concat(minutos).concat(":").concat(segundos);
        
        return formato24Horas;
    }
    
}
