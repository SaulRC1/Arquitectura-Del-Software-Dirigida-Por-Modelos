/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package asdm.saul_rodriguez_naranjo.practica7_patronmvc.Controlador;

import asdm.saul_rodriguez_naranjo.practica7_patronmvc.Vista.InterfazVista;

/**
 *
 * @author SaulRC1
 */
public interface ControladorFactory {
    public void arrancaInterfaz();
    public void setInterfazGrafica(InterfazVista vista);
    public void actionPerformed();
}
