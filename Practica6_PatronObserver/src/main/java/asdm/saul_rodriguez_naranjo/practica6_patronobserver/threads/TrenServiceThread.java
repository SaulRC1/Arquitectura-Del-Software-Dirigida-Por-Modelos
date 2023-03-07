/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asdm.saul_rodriguez_naranjo.practica6_patronobserver.threads;

import asdm.saul_rodriguez_naranjo.practica6_patronobserver.models.observables.Estacion;
import asdm.saul_rodriguez_naranjo.practica6_patronobserver.models.observables.Tren;
import asdm.saul_rodriguez_naranjo.practica6_patronobserver.views.PanelMovilidadTren;
import asdm.saul_rodriguez_naranjo.practica6_patronobserver.views.PanelesInformacionVista;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;

/**
 *
 * @author SaulRC1
 */
public class TrenServiceThread implements Runnable {

    private Tren tren = Tren.getTrenInstance();
    private ArrayList<Estacion> estaciones = new ArrayList<>();
    private PanelMovilidadTren panelMovilidadTren;
    private PanelesInformacionVista panelesInformacionVista;
    private int trainPosition = 10;

    public void addEstacion(Estacion estacion) {
        this.estaciones.add(estacion);
    }

    public void setPanelMovilidadTren(PanelMovilidadTren panel) {
        this.panelMovilidadTren = panel;
    }

    public void setPanelesInformacionVista(PanelesInformacionVista paneles) {
        this.panelesInformacionVista = paneles;
    }

    private Estacion buscaEstacionPorNumero(int numeroDeEstacion) {
        for (Estacion estacion : this.estaciones) {
            if (estacion.getNumeroDeEstacion() == numeroDeEstacion) {
                return estacion;
            }
        }

        return null;
    }

    private int calcularTiempoHastaSiguienteEstacion(int velocidad, int distanciaHastaSiguienteEstacion) {
        return (int) (((float) distanciaHastaSiguienteEstacion / (float) velocidad) * 60);
    }

    @Override
    public void run() {
        System.out.println("Tren moviendose...");
        tren.moverse();

        while (true) {
            try {
                if (tren.getDireccion() == true) {
                    Estacion estacionActual = this.buscaEstacionPorNumero(tren.getNumeroDeEstacion());
                    Estacion estacionSiguiente;
                    String panelDeInformacion2;
                    if (tren.getNumeroDeEstacion() < this.estaciones.size() - 1) {
                        estacionSiguiente = this.buscaEstacionPorNumero(tren.getNumeroDeEstacion() + 1);
                        panelDeInformacion2 = "ESTACION SIGUIENTE: " + estacionSiguiente.getNombre()
                                + "\nDistancia llegada: " + estacionActual.getDistanciaSiguiente()
                                + "\nTiempo Estimado de llegada: " + this.calcularTiempoHastaSiguienteEstacion(tren.getVelocidad(),
                                        estacionActual.getDistanciaSiguiente()) + " mins";
                        SwingUtilities.invokeLater(new Runnable() {
                            @Override
                            public void run() {
                                panelesInformacionVista.txtPanelDeInformacion2.setText(panelDeInformacion2);
                            }
                        });
                    }

                    tren.notifyObservers();
                    int tiempoHastaSiguienteEstacion = this.calcularTiempoHastaSiguienteEstacion(tren.getVelocidad(),
                            estacionActual.getDistanciaSiguiente());
                    System.out.println("Distancia Siguiente: " + estacionActual.getDistanciaSiguiente());
                    System.out.println("Duermo...");
                    System.out.println("Tiempo: " + tiempoHastaSiguienteEstacion * 100);
                    
                    Random rand = new Random(System.currentTimeMillis());
                    
                    int suben = rand.nextInt((10 - 1) + 1) + 1;
                    int bajan = rand.nextInt((10 - 1) + 1) + 1;
                    
                    System.out.println("suben: " + suben);
                    System.out.println("bajan: " + bajan);
                    
                    tren.setPlazasDisponibles(suben, bajan);
                    
                    String panelDeInformacion1 = "ESTACION ACTUAL\n----------------------" + "\nPlazas Disponibles: "
                            + estacionActual.getNombre() + "\nPlazas Disponibles: " + tren.getPlazasDisponibles() + "\nEstado: "
                            + (tren.getEstado() ? "Moviendose" : "Parado") + "\nDireccion: " + (tren.getDireccion() ? "Huelva-Sevilla" : "Sevilla-Huelva");
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            panelesInformacionVista.txtPanelDeInformacion1.setText(panelDeInformacion1);
                            //panelesInformacionVista.txtPanelDeInformacion2.setText();
                        }
                    });
                    Thread.sleep(tiempoHastaSiguienteEstacion * 100);

                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {

                            //if (tren.getNumeroDeEstacion()  < estaciones.size() - 1) {
                            panelMovilidadTren.moveTrain(trainPosition,
                                    panelMovilidadTren.getPosicionTren_y());
                            //}
                        }
                    });
                    
                    if (tren.getNumeroDeEstacion()  < estaciones.size() - 1) {
                        trainPosition += 200;
                        System.out.println("posicion: " + trainPosition);
                    }
                    

                    System.out.println("Pongo la siguiente");
                    System.out.println("Siguiente Estacion: " + tren.getNumeroDeEstacion() + 1);
                    if (tren.getNumeroDeEstacion() + 1 >= this.estaciones.size()) {
                        tren.establecerDireccion(!tren.getDireccion());
                    } else {
                        tren.setNumeroDeEstacion(tren.getNumeroDeEstacion() + 1);
                    }
                } else {
                    Estacion estacionActual = this.buscaEstacionPorNumero(tren.getNumeroDeEstacion());
                    Estacion estacionSiguiente;
                    String panelDeInformacion2;
                    tren.notifyObservers();
                    if (tren.getNumeroDeEstacion() > 0) {
                        estacionSiguiente = this.buscaEstacionPorNumero(tren.getNumeroDeEstacion() - 1);
                        panelDeInformacion2 = "ESTACION SIGUIENTE: " + estacionSiguiente.getNombre()
                                + "\nDistancia llegada: " + estacionActual.getDistanciaAnterior()
                                + "\nTiempo Estimado de llegada: " + this.calcularTiempoHastaSiguienteEstacion(tren.getVelocidad(),
                                        estacionActual.getDistanciaAnterior()) + " mins";
                        SwingUtilities.invokeLater(new Runnable() {
                            @Override
                            public void run() {
                                panelesInformacionVista.txtPanelDeInformacion2.setText(panelDeInformacion2);
                            }
                        });
                    }
                    
                    Random rand = new Random(System.currentTimeMillis());
                    
                    int suben = rand.nextInt((10 - 1) + 1) + 1;
                    int bajan = rand.nextInt((10 - 1) + 1) + 1;
                    
                    System.out.println("suben: " + suben);
                    System.out.println("bajan: " + bajan);
                    
                    tren.setPlazasDisponibles(suben, bajan);

                    int tiempoHastaSiguienteEstacion = this.calcularTiempoHastaSiguienteEstacion(tren.getVelocidad(),
                            estacionActual.getDistanciaAnterior());
                    String panelDeInformacion1 = "ESTACION ACTUAL\n----------------------" + "\nPlazas Disponibles: "
                            + estacionActual.getNombre() + "\nPlazas Disponibles: " + tren.getPlazasDisponibles() + "\nEstado: "
                            + (tren.getEstado() ? "Moviendose" : "Parado") + "\nDireccion: " + (tren.getDireccion() ? "Huelva-Sevilla" : "Sevilla-Huelva");
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            panelesInformacionVista.txtPanelDeInformacion1.setText(panelDeInformacion1);
                        }
                    });
                    Thread.sleep(tiempoHastaSiguienteEstacion * 100);
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            //if (tren.getNumeroDeEstacion() > 0) {
                                panelMovilidadTren.moveTrain(trainPosition,
                                        panelMovilidadTren.getPosicionTren_y());
                            //}
                        }
                    });
                    
                    if (tren.getNumeroDeEstacion() > 0) {
                        trainPosition -= 200;
                        System.out.println("posicion: " + trainPosition);
                    }
                    

                    if (tren.getNumeroDeEstacion() - 1 < 0) {
                        tren.establecerDireccion(!tren.getDireccion());
                    } else {
                        tren.setNumeroDeEstacion(tren.getNumeroDeEstacion() - 1);
                    }
                }

            } catch (InterruptedException ex) {
                Logger.getLogger(TrenServiceThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
