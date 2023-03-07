/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asdm.saul_rodriguez_naranjo.practica4_patronadapter.controllers;

import asdm.saul_rodriguez_naranjo.practica4_patronadapter.adapters.IMandosToBarcoAdapter;
import asdm.saul_rodriguez_naranjo.practica4_patronadapter.adapters.IMandosToCocheManualAdapter;
import asdm.saul_rodriguez_naranjo.practica4_patronadapter.interfaces.IMandos;
import asdm.saul_rodriguez_naranjo.practica4_patronadapter.interfaces.IVehiculo;
import asdm.saul_rodriguez_naranjo.practica4_patronadapter.models.Barco;
import asdm.saul_rodriguez_naranjo.practica4_patronadapter.models.CocheAutomatico;
import asdm.saul_rodriguez_naranjo.practica4_patronadapter.models.CocheManual;
import asdm.saul_rodriguez_naranjo.practica4_patronadapter.views.ControlarVehiculoVista;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;

/**
 *
 * @author SaulRC1
 */
public class ControlarVehiculoController {
    
    private ControlarVehiculoVista controlarVehiculoVista;
    private IVehiculo vehiculo;
    private IMandos mandosVehiculoAControlar;
    private String resultadoAcelera;
    private String resultadoFrenar;
    
    public ControlarVehiculoController(IVehiculo vehiculo) {
        controlarVehiculoVista = new ControlarVehiculoVista();
        this.vehiculo = vehiculo;
        this.resultadoAcelera = "";
        this.resultadoFrenar = "";
        
        
        this.setListenersToButtons();
        
        if(this.vehiculo instanceof CocheAutomatico) {
            this.mandosVehiculoAControlar = new CocheAutomatico();
        } else if(this.vehiculo instanceof CocheManual) {
            this.mandosVehiculoAControlar = new IMandosToCocheManualAdapter((CocheManual)vehiculo);
        } else if(this.vehiculo instanceof Barco) {
            this.mandosVehiculoAControlar = new IMandosToBarcoAdapter((Barco)vehiculo);
        }
        
        this.controlarVehiculoVista.setVisible(true);
        this.controlarVehiculoVista.setTitle("Controlando " + vehiculo.getTipo());
        this.controlarVehiculoVista.setLocationRelativeTo(null);
        this.controlarVehiculoVista.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void setListenersToButtons() {
        
        //Boton Acelerar
        this.controlarVehiculoVista.btnAcelerar.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent evt) {
                btnAcelerarAction();
            }
        });
        
        //Boton Frenar
        this.controlarVehiculoVista.btnFrenar.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent evt) {
                btnFrenarAction();
            }
        });
    }
    
    private void btnAcelerarAction() {
        resultadoAcelera += "\n" + this.mandosVehiculoAControlar.Acelera();
        this.controlarVehiculoVista.txtAreaVehiculoLog.setText(resultadoAcelera);
    }
    
    private void btnFrenarAction() {
        this.resultadoFrenar += "\n" + this.mandosVehiculoAControlar.Frena();
        this.controlarVehiculoVista.txtAreaVehiculoLog.setText(this.resultadoFrenar);
        
    }
}
