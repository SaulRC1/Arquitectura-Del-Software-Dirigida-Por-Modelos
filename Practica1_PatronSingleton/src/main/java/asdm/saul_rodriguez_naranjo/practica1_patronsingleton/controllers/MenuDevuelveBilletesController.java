/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asdm.saul_rodriguez_naranjo.practica1_patronsingleton.controllers;

import asdm.saul_rodriguez_naranjo.practica1_patronsingleton.models.Agencia;
import asdm.saul_rodriguez_naranjo.practica1_patronsingleton.models.observables.Avion;
import asdm.saul_rodriguez_naranjo.practica1_patronsingleton.views.MenuDevuelveBilletes;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

/**
 *
 * @author SaulRC1
 */
class MenuDevuelveBilletesController {
    
    private MenuDevuelveBilletes menuDevuelveBilletes;
    private Avion avion;
    private Agencia agencia;

    public MenuDevuelveBilletesController() {
        this.menuDevuelveBilletes = new MenuDevuelveBilletes();
        this.avion = Avion.getAvion();
        this.agencia = new Agencia();
        
        
        this.menuDevuelveBilletes.txtDisponiblesADevolver.setText("" + avion.asientosComprados());
        
        //spnDevolverBilletes.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        //spnDevolverBilletes.setModel(new javax.swing.SpinnerNumberModel(0, 0, 5, 1));
        
        //Settear el maximo valor de devolver billetes como el nº maximo de billetes que se han comprado
        SpinnerModel spnDevolverBilletes = new SpinnerNumberModel(0, 0, avion.asientosComprados(), 1);
        this.menuDevuelveBilletes.spnDevolverBilletes.setModel(spnDevolverBilletes);
        
        this.setListenersToButtons();
        
        menuDevuelveBilletes.setTitle("Devuelve Billetes");
        menuDevuelveBilletes.setVisible(true);
        menuDevuelveBilletes.setLocationRelativeTo(null);
        menuDevuelveBilletes.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
    private void setListenersToButtons() {
        
        //Boton "Devolver Billetes"
        this.menuDevuelveBilletes.btnDevolverBilletes.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                btnDevolverBilletesAction(evt);
            }
        });
    }
    
    private void btnDevolverBilletesAction(MouseEvent evt) {
        //Recogemos valor de la SpinBox
        int billetesADevolver = (Integer) this.menuDevuelveBilletes.spnDevolverBilletes.getValue();
        
        //Devolvemos los billetes
        this.avion.DevuelveBilletes(billetesADevolver);
        
        //Actualizamos cuantos billetes se pueden devolver
        this.menuDevuelveBilletes.txtDisponiblesADevolver.setText("" + avion.asientosComprados());
        
        //Actualizamos valor maximo de la SpinBox
        SpinnerModel spnDevolverBilletes = new SpinnerNumberModel(0, 0, avion.asientosComprados(), 1);
        this.menuDevuelveBilletes.spnDevolverBilletes.setModel(spnDevolverBilletes);
        
        //System.out.println("" + avion.asientosComprados());
    }
    
    
}
