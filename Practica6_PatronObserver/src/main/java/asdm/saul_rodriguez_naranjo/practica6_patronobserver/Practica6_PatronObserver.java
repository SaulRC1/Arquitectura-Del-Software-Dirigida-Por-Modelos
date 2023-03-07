/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package asdm.saul_rodriguez_naranjo.practica6_patronobserver;

import asdm.saul_rodriguez_naranjo.practica6_patronobserver.controllers.PanelesInformacionController;
import asdm.saul_rodriguez_naranjo.practica6_patronobserver.models.observables.Estacion;
import asdm.saul_rodriguez_naranjo.practica6_patronobserver.models.observables.Tren;
import asdm.saul_rodriguez_naranjo.practica6_patronobserver.threads.TrenServiceThread;
import asdm.saul_rodriguez_naranjo.practica6_patronobserver.views.PanelMovilidadTren;
import javax.swing.SwingUtilities;

/**
 *
 * @author SaulRC1
 */
public class Practica6_PatronObserver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here
        /*Tren tren = Tren.getTrenInstance();
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
        
        trenService.start();
        
        PanelesInformacionController panelesInformacionController = new PanelesInformacionController();
        PanelMovilidadTren panelMovilidadTren = panelesInformacionController.getPanelMovilidadTren();
        
        int posx = 10;
        int posy = 250;
        
        for (int i = 0; i < 5; i++) {
            Thread.sleep(1000);
            panelMovilidadTren.moveTrain(posx, posy);
            posx += 200;
        }*/
        
        PanelesInformacionController panelesInformacionController = new PanelesInformacionController();
        
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
        
        trenServiceThread.setPanelMovilidadTren(panelesInformacionController.getPanelMovilidadTren());
        trenServiceThread.setPanelesInformacionVista(panelesInformacionController.getPanelInformacionVista());
        
        trenService.start();
        
    }
    
}
