/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asdm.examen_saul_rodriguez_naranjo.Controlador;

import asdm.examen_saul_rodriguez_naranjo.Modelos.Cocina;
import asdm.examen_saul_rodriguez_naranjo.Modelos.Pedido;
import asdm.examen_saul_rodriguez_naranjo.Modelos.observable.Observable;
import asdm.examen_saul_rodriguez_naranjo.Modelos.observer.Observer;
import asdm.examen_saul_rodriguez_naranjo.Vista.RetirarPedido;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author SaulRC1
 */
public class ControladorRetirarPedido implements Observer {
    private RetirarPedido retirarPedido;
    private Cocina cocina = Cocina.getCocinaInstance();

    
    public ControladorRetirarPedido() {
        this.retirarPedido = new RetirarPedido();
        this.cocina.addObserver(this);
        
        this.setListenersToButtons();
        this.poblarPedidosTerminados();
        
        this.retirarPedido.setTitle("Retirar Pedido");
        this.retirarPedido.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.retirarPedido.setVisible(true);
    }
    
    private void setListenersToButtons() {
        
        //Boton retirar
        this.retirarPedido.btnRetirar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                retirar();
            }
        });
    }
    
    private void poblarPedidosTerminados() {
        this.retirarPedido.txtPedidosTerminados.setText("");
        
        
        for (Pedido ped: this.cocina.getPedidos()) {
            if(ped.getEstado() == Pedido.TERMINADO) {
                String textoActual = this.retirarPedido.txtPedidosTerminados.getText();

                textoActual += "\nNumero de Pedido: " + ped.getNumeroDePedido()
                        + "\n----------------------------" + "\nNombre de Usuario: "
                        + ped.getUsuario().getNombre();
                this.retirarPedido.txtPedidosTerminados.setText(textoActual);
            } 
        }
    }
    
    private void retirar() {
        int numeroDePedido = (int) this.retirarPedido.spnNumeroDePedido.getValue();
        this.cocina.cambiarARetirado(numeroDePedido);
        
    }

    @Override
    public void update() {
        this.poblarPedidosTerminados();
    }
    
}
