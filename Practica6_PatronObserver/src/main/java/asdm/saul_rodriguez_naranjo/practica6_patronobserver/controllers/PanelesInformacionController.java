/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asdm.saul_rodriguez_naranjo.practica6_patronobserver.controllers;

import asdm.saul_rodriguez_naranjo.practica6_patronobserver.models.observables.Estacion;
import asdm.saul_rodriguez_naranjo.practica6_patronobserver.models.observables.Tren;
import asdm.saul_rodriguez_naranjo.practica6_patronobserver.threads.TrenServiceThread;
import asdm.saul_rodriguez_naranjo.practica6_patronobserver.views.PanelMovilidadTren;
import asdm.saul_rodriguez_naranjo.practica6_patronobserver.views.PanelesInformacionVista;
import java.lang.reflect.InvocationTargetException;
import javax.swing.SwingUtilities;

/**
 *
 * @author SaulRC1
 */
public class PanelesInformacionController {
    private PanelesInformacionVista panelesInformacionVista;
    private PanelMovilidadTren panelMovilidadTren;
    private TrenServiceThread trenServiceThread;
    
    public PanelesInformacionController() {
        panelesInformacionVista = new PanelesInformacionVista();
        panelMovilidadTren = new PanelMovilidadTren();
        
        //initTrain();
        
        panelesInformacionVista.add(panelMovilidadTren);
        panelesInformacionVista.setTitle("Practica 6 - Patron Observer | Saúl Rodríguez Naranjo");
        panelMovilidadTren.setBounds(20, 300, 1000, 500);
        panelesInformacionVista.setVisible(true);
        
    }
    
    public PanelMovilidadTren getPanelMovilidadTren() {
        return this.panelMovilidadTren;
    }
    
    public PanelesInformacionVista getPanelInformacionVista() {
        return this.panelesInformacionVista;
    }
    
    /*private void initTrain() throws InterruptedException, InvocationTargetException {
        Tren tren = Tren.getTrenInstance();
        TrenServiceThread trenServiceThread = new TrenServiceThread();
        
        Estacion estacionHuelva = new Estacion("HUELVA", 17, 0, 0, tren);
        Estacion estacionGibraleon = new Estacion("GIBRALEON", 23, 17, 1, tren);
        Estacion estacionLaPalma = new Estacion("LA PALMA", 12, 23, 2, tren);
        Estacion estacionBollullos = new Estacion("BOLLULLOS", 30, 12, 3, tren);
        Estacion estacionSevilla = new Estacion("SEVILLA", 0, 30, 4, tren);
        
        tren.addObserver(estacionHuelva);
        tren.addObserver(estacionSevilla);
        tren.addObserver(estacionBollullos);
        tren.addObserver(estacionGibraleon);
        tren.addObserver(estacionLaPalma);
        
        trenServiceThread.addEstacion(estacionHuelva);
        trenServiceThread.addEstacion(estacionGibraleon);
        trenServiceThread.addEstacion(estacionLaPalma);
        trenServiceThread.addEstacion(estacionBollullos);
        trenServiceThread.addEstacion(estacionSevilla);
        
        Thread trenService = new Thread(trenServiceThread);
        
        trenServiceThread.setPanelMovilidadTren(panelMovilidadTren);
        
        SwingUtilities.invokeAndWait(trenService);
        /*int posx = 10;
        int posy = 250;
        
        for (int i = 0; i < 5; i++) {
            Thread.sleep(1000);
            panelMovilidadTren.moveTrain(posx, posy);
            posx += 200;
        }

    }*/
}
