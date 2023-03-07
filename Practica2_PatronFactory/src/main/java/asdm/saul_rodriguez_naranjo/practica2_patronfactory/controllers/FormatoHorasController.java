/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asdm.saul_rodriguez_naranjo.practica2_patronfactory.controllers;

import asdm.saul_rodriguez_naranjo.practica2_patronfactory.controllers.factory.FactoriaHoras;
import asdm.saul_rodriguez_naranjo.practica2_patronfactory.models.concretemodels.RelojThread;
import asdm.saul_rodriguez_naranjo.practica2_patronfactory.models.factorymodels.Hora;
import asdm.saul_rodriguez_naranjo.practica2_patronfactory.views.FormatoHorasVista;
import asdm.saul_rodriguez_naranjo.practica2_patronfactory.views.PanelHoraDigital;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;
import java.util.TimeZone;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author SaulRC1
 */
public class FormatoHorasController {

    private FormatoHorasVista formatoHorasVista;
    private PanelHoraDigital panelHoraDigital;
    //private Hora horaEnFormato24Horas;
    private Calendar calendar;
    private int tipo; // 1 - Formato 12 horas 2 - Formato 24 horas

    private RelojThread relojThread;
    private Thread relojThreadAllocated;

    public FormatoHorasController(int tipo) {
        this.tipo = tipo;
        this.formatoHorasVista = new FormatoHorasVista();
        this.panelHoraDigital = new PanelHoraDigital();
        this.calendar = Calendar.getInstance(TimeZone.getDefault());

        

        this.relojThread = new RelojThread(calendar, panelHoraDigital, tipo);

        this.relojThreadAllocated = new Thread(this.relojThread);

        this.relojThreadAllocated.start();

        this.poblarComboBoxZonaHoraria();
        this.setListenersToButtons();

        this.formatoHorasVista.txtZonaHorariaActual.setText(TimeZone.getDefault().toZoneId().toString());

        this.panelHoraDigital.setBounds(0, 0, 400, 200);
        this.panelHoraDigital.setVisible(true);
        this.formatoHorasVista.add(panelHoraDigital);
        this.formatoHorasVista.setVisible(true);
        
        if(tipo == 1) {
            this.formatoHorasVista.setTitle("Formato 12 Horas");
        } else if(tipo == 2) {
            this.formatoHorasVista.setTitle("Formato 24 Horas");
        }
        
        this.formatoHorasVista.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        //Paramos el hilo cuando la ventana se cierre
        formatoHorasVista.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                System.out.println("Parado");
                relojThreadAllocated.interrupt();
            }
        });
    }

    private void poblarComboBoxZonaHoraria() {
        String[] availId = TimeZone.getAvailableIDs();

        for (String availId1 : availId) {

            System.out.println(availId1);

        }
        this.formatoHorasVista.cbZonaHoraria.setModel(new DefaultComboBoxModel<>(availId));
    }
    
    private void setListenersToButtons() {
        
        //Boton cambiar zona horaria
        this.formatoHorasVista.btnCambiar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                btnCambiarAction();
            }
        });
    }
    
    private void btnCambiarAction() {
        String nuevaZonaHorariaID = (String) this.formatoHorasVista.cbZonaHoraria.getSelectedItem();
        
        TimeZone nuevaZonaHoraria = TimeZone.getTimeZone(nuevaZonaHorariaID);
        
        this.formatoHorasVista.txtZonaHorariaActual.setText(nuevaZonaHorariaID);
        
        this.calendar.setTimeZone(nuevaZonaHoraria);
        
        relojThreadAllocated.interrupt();
        
        this.relojThread = new RelojThread(calendar, panelHoraDigital, this.tipo);
        
        relojThreadAllocated = new Thread(this.relojThread);
        
        relojThreadAllocated.start();
    }

}
