/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asdm.examen_saul_rodriguez_naranjo.Controlador;

import asdm.examen_saul_rodriguez_naranjo.Controlador.factory.Controlador;
import asdm.examen_saul_rodriguez_naranjo.Modelos.Cocina;
import asdm.examen_saul_rodriguez_naranjo.Modelos.Pedido;
import asdm.examen_saul_rodriguez_naranjo.Modelos.observable.Observable;
import asdm.examen_saul_rodriguez_naranjo.Modelos.observer.Observer;
import asdm.examen_saul_rodriguez_naranjo.Vista.VistaCocinero;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author SaulRC1
 */
public class ControladorCocinero implements Controlador, Observable {

    public ArrayList<Observer> listaObservers;
    private VistaCocinero vistaCocinero;
    private Cocina cocina = Cocina.getCocinaInstance();
    
    public ControladorCocinero() {
        this.listaObservers = new ArrayList<>();
        this.vistaCocinero = new VistaCocinero();
        this.addObserver(cocina);
        
        this.setListenersToButtons();
        
    }
    
    @Override
    public void setListenersToButtons() {
        
        //Boton consultar pedidos
        this.vistaCocinero.btnConsultarPedidos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                consultarPedidos();
            }
        });
        
        //Boton preparar pedido
        this.vistaCocinero.btnPrepararPedido.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                prepararPedido();
            }
        });
    }

    @Override
    public void initView() {
        this.vistaCocinero.setTitle("Vista del Cocinero");
        
        this.vistaCocinero.setVisible(true);
        this.vistaCocinero.setLocationRelativeTo(null);
        this.vistaCocinero.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    @Override
    public void addObserver(Observer observer) {
        this.listaObservers.add(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer obs: this.listaObservers) {
            obs.update();
        }
    }
    
    private void consultarPedidos() {
        Pedido pedido = this.cocina.getPedidos().get(this.cocina.getPosicionActual());
        
        String textoActual = "\nNumero de Pedido: " + pedido.getNumeroDePedido() 
                + "\n----------------------------" + "\nTipo de Pizza: " 
                + pedido.getTipoDePizza() + "\nIngredientes Extra:";
        
        for (String ingrediente: pedido.getIngredientesExtra()) {
            textoActual += " " + ingrediente;
        }
        
        if (pedido.getEstado() == Pedido.EN_ESPERA) {
            textoActual += "\nEstado: EN ESPERA";
        } else if (pedido.getEstado() == Pedido.EN_PREPARACION) {
            textoActual += "\nEstado: EN PREPARACION";
        } else if (pedido.getEstado() == Pedido.TERMINADO) {
            textoActual += "\nEstado: TERMINADO";
        } else if (pedido.getEstado() == Pedido.RETIRADO) {
            textoActual += "\nEstado: RETIRADO";
        }
        
        this.notifyObservers();
        this.vistaCocinero.txtConsultarPedido.setText(textoActual);
        
        
    }
    
    private void prepararPedido() {
        this.cocina.prepararPedido();
        this.vistaCocinero.dispose();
    }
    
}
