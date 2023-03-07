/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asdm.saul_rodriguez_naranjo.practica1_patronsingleton.models;

import asdm.saul_rodriguez_naranjo.practica1_patronsingleton.models.observables.Avion;

/**
 *
 * @author SaulRC1
 */
public class Agencia {
    private Avion avion;
    
    public Agencia() {
        avion = Avion.getAvion();
    }
    
    public void QuieroDevolverBilletes(int billetes) {
        avion.DevuelveBilletes(billetes);
    }
    
}
