/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asdm.saul_rodriguez_naranjo.practica1_patronsingleton.controllers;

import asdm.saul_rodriguez_naranjo.practica1_patronsingleton.models.observables.Avion;
import asdm.saul_rodriguez_naranjo.practica1_patronsingleton.models.observers.Observer;
import asdm.saul_rodriguez_naranjo.practica1_patronsingleton.views.PanelAsientosVista;
import javax.swing.ImageIcon;

/**
 *
 * @author SaulRC1
 */
public class PanelAsientosController implements Observer {

    private Avion avion;
    private PanelAsientosVista panelAsientosVista = new PanelAsientosVista();

    public PanelAsientosController() {
        this.avion = Avion.getAvion();
        this.avion.addObserver(this);
        
        panelAsientosVista = new PanelAsientosVista();
        
        this.panelAsientosVista.lblAsientosLibres.setIcon(new ImageIcon(getClass().
                getResource("/asientosLibres.png")));
        this.panelAsientosVista.lblAsientosOcupados.setIcon(new ImageIcon(getClass().
                getResource("/asientosOcupados.png")));
        
        this.panelAsientosVista.txtAsientosDisponibles.setText("" + avion.CuantosAsientosQuedan());
        this.panelAsientosVista.txtAsientosOcupados.setText("" + avion.asientosComprados());
        
        this.panelAsientosVista.setTitle("Panel de Asientos");
        this.panelAsientosVista.setVisible(true);
    }

    @Override
    public void update() {
        this.panelAsientosVista.txtAsientosDisponibles.setText("" + avion.CuantosAsientosQuedan());
        this.panelAsientosVista.txtAsientosOcupados.setText("" + avion.asientosComprados());
    }

}
