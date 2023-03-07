/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asdm.saul_rodriguez_naranjo.practica4_patronadapter.adapters;

import asdm.saul_rodriguez_naranjo.practica4_patronadapter.interfaces.IMandos;
import asdm.saul_rodriguez_naranjo.practica4_patronadapter.models.Barco;

/**
 *
 * @author SaulRC1
 */
public class IMandosToBarcoAdapter implements IMandos {
    private Barco barco;

    public IMandosToBarcoAdapter(Barco barco) {
        this.barco = barco;
        this.barco.Conectar();
        this.barco.Activar();
    }
    
    
    
    @Override
    public String Acelera() {
        String resultadoAcelera = "";
        if(!barco.getGrifo()) {
            this.barco.Conectar();
            this.barco.Activar();
            resultadoAcelera += "BARCO ACTIVADO";
        }
        resultadoAcelera += this.barco.moverMasRapido();
        return resultadoAcelera;
    }

    @Override
    public String Frena() {
        String resultadoFrenar = "";
        
        if(barco.getGrifo()) {
            return this.barco.Detener() + "\n" + this.barco.Desconectar();
        }
        
        return this.barco.Detener();
        
    }
    
}
