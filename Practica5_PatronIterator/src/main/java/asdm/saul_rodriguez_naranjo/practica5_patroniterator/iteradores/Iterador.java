/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package asdm.saul_rodriguez_naranjo.practica5_patroniterator.iteradores;

/**
 *
 * @author SaulRC1
 */
public interface Iterador {

    public Object siguiente();

    public boolean tieneSiguiente();

    public Object anterior();

    public String convertListToString();

    public Object actual();
}
