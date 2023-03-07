/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asdm.saul_rodriguez_naranjo.practica2_patronfactory.models.factorymodels;

/**
 *
 * @author SaulRC1
 */
public abstract class Hora {
    private int horas;
    private int minutos;
    private int segundos;
    
    public Hora(int horas, int minutos, int segundos) {
        this.horas = horas;
        this.minutos = minutos;
        this.segundos = segundos;
    }

    public Hora(int segundos) {
        this.horas = this.calcularHoras(segundos);
        int segundosSobrantesDeLasHoras = segundos - this.horas * 3600;
        this.minutos = this.calcularMinutos(segundosSobrantesDeLasHoras);
        int segundosSobrantesDeLosMinutos = segundosSobrantesDeLasHoras - this.minutos * 60;
        this.segundos = segundosSobrantesDeLosMinutos;
    }
    
    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    public int getSegundos() {
        return segundos;
    }

    public void setSegundos(int segundos) {
        this.segundos = segundos;
    }
    
    public int calcularHoras(int segundos) {
        return (segundos / 3600);
    }
    
    public int calcularMinutos(int segundos) {
        return (segundos / 60);
    }
    
    public abstract String establecerFormatoHora();
     
}
