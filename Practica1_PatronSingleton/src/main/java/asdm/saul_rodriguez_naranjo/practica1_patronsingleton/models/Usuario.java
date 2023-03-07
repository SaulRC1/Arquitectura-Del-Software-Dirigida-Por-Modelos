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
public class Usuario {
    private Avion avion;
    
    public Usuario() {
        avion = Avion.getAvion();
    }
    
    public void QuieroComprarBilletes(int billetes) {
        avion.VendeBillete(billetes);
    }
}
