/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asdm.examen_saul_rodriguez_naranjo.Modelos;

import asdm.examen_saul_rodriguez_naranjo.Controlador.ControladorCocinero;
import asdm.examen_saul_rodriguez_naranjo.Controlador.factory.Controlador;
import asdm.examen_saul_rodriguez_naranjo.Modelos.factory.Persona;

/**
 *
 * @author SaulRC1
 */
public class Cocinero implements Persona {

    @Override
    public Controlador crearControlador() {
        return new ControladorCocinero();
    }
    
}
