/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asdm.saul_rodriguez_naranjo.practica4_patronadapter.adapters;

import asdm.saul_rodriguez_naranjo.practica4_patronadapter.interfaces.IMandos;
import asdm.saul_rodriguez_naranjo.practica4_patronadapter.models.CocheManual;

/**
 *
 * @author SaulRC1
 */
public class IMandosToCocheManualAdapter implements IMandos {

    private CocheManual cocheManual;

    public IMandosToCocheManualAdapter(CocheManual cocheManual) {
        this.cocheManual = cocheManual;
        this.cocheManual.Encender();
        
    }

    @Override
    public String Acelera() {
        String acelera = null;
        
        acelera = this.cocheManual.Acelerar();
        
        if(!cocheManual.getAveriado()) {
            acelera += this.cocheManual.SubeMarcha();
        }
        
        
        return acelera;
    }

    @Override
    public String Frena() {
        
        String frena = null;
        
        frena = this.cocheManual.Frenar();
        
        if(!cocheManual.getAveriado()) {
            frena += this.cocheManual.BajaMarcha();
        }
        
        
        return frena;
    }

}
