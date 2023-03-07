/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asdm.saul_rodriguez_naranjo.practica7_patronmvc.Controlador;

import asdm.saul_rodriguez_naranjo.practica7_patronmvc.Modelo.CambioSistemaNumerico;
import asdm.saul_rodriguez_naranjo.practica7_patronmvc.Vista.InterfazVista;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author SaulRC1
 */
public class ControlCambio implements ControladorFactory {

    private InterfazVista vista;
    private CambioSistemaNumerico modeloCambioSistemaNumerico = CambioSistemaNumerico.getCambioSistemaNumericoInstance();

    public ControlCambio() {

    }

    @Override
    public void arrancaInterfaz() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                vista.arranca();
            }
        });
    }

    @Override
    public void setInterfazGrafica(InterfazVista vista) {
        this.vista = vista;
    }

    @Override
    public void actionPerformed() {

        //Boton convertir a hexadecimal
        /*this.vista.getBtnConvertirAHexadecimal().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                
            }
        });
        
        //Boton convertir a Octal
        this.vista.getBtnConvertirAOctal().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                
            }
        });*/
        //Boton convertir a Binario
        this.vista.getBtnConvertirABinario().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                /*SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        vista.escribeCambio(modeloCambioSistemaNumerico
                        .decimalABinario(vista.getCantidad()));
                    }
                });*/

                vista.escribeCambio(modeloCambioSistemaNumerico
                        .decimalABinario(vista.getCantidad()));

            }
        });

        //Boton convertir a Hexadecimal
        this.vista.getBtnConvertirAHexadecimal().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                vista.escribeCambio(modeloCambioSistemaNumerico
                        .decimalAHexadecimal(vista.getCantidad()));
            }
        });

        //Boton convertir a Octal
        this.vista.getBtnConvertirAOctal().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                vista.escribeCambio(modeloCambioSistemaNumerico
                        .decimalAOctal(vista.getCantidad()));
            }
        });

        //Boton abrir fichero
        this.vista.getBtnAbrirFichero().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                btnAbrirFicheroAction();
            }
        });

        //Boton convertir fichero a binario
        this.vista.getBtnConvertirFicheroABinario().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                btnConvertirFicheroABinarioAction();
            }
        });
        
        //Boton convertir fichero a hexadecimal
        this.vista.getBtnConvertirFicheroAHexadecimal().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                btnConvertirFicheroAHexadecimalAction();
            }
        });
        
        //Boton convertir fichero a octal
        this.vista.getBtnConvertirFicheroAOctal().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                btnConvertirFicheroAOctalAction();
            }
        });
    }

    private void btnAbrirFicheroAction() {
        JFileChooser fileChooser = new JFileChooser();

        int seleccion = fileChooser.showOpenDialog(null);

        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File archivoSeleccionado = fileChooser.getSelectedFile();

            try {
                modeloCambioSistemaNumerico.abrirFichero(archivoSeleccionado);
            } catch (IOException ex) {
                Logger.getLogger(ControlCambio.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void btnConvertirFicheroABinarioAction() {
        ArrayList<String> numerosLeidos = modeloCambioSistemaNumerico.getNumerosLeidosDesdeFichero();
        ArrayList<String> numerosEnBinario = new ArrayList<>();

        JFileChooser fileChooser = new JFileChooser();

        int seleccion = fileChooser.showSaveDialog(null);
        String path = "";

        if (seleccion == JFileChooser.APPROVE_OPTION) {
            path = fileChooser.getSelectedFile().getAbsolutePath();
            
            for (String numero : numerosLeidos) {
                numerosEnBinario.add(modeloCambioSistemaNumerico.decimalABinario(Integer.parseInt(numero)));
            }
            
            try {
                modeloCambioSistemaNumerico.escribirFichero(path, numerosEnBinario);
            } catch (IOException ex) {
                Logger.getLogger(ControlCambio.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println(path);
        }
        
        JOptionPane.showMessageDialog(null, ("Fichero Convertido a Binario con exito en\n" + path),
                "Fichero guardado!", JOptionPane.INFORMATION_MESSAGE);

    }
    
    private void btnConvertirFicheroAHexadecimalAction() {
        ArrayList<String> numerosLeidos = modeloCambioSistemaNumerico.getNumerosLeidosDesdeFichero();
        ArrayList<String> numerosEnHexadecimal = new ArrayList<>();

        JFileChooser fileChooser = new JFileChooser();

        int seleccion = fileChooser.showSaveDialog(null);
        
        String path = "";

        if (seleccion == JFileChooser.APPROVE_OPTION) {
            path = fileChooser.getSelectedFile().getAbsolutePath();
            
            for (String numero : numerosLeidos) {
                numerosEnHexadecimal.add(modeloCambioSistemaNumerico.decimalAHexadecimal(Integer.parseInt(numero)));
            }
            
            try {
                modeloCambioSistemaNumerico.escribirFichero(path, numerosEnHexadecimal);
            } catch (IOException ex) {
                Logger.getLogger(ControlCambio.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println(path);
        }
        
        JOptionPane.showMessageDialog(null, ("Fichero Convertido a Hexadecimal con exito en\n" + path),
                "Fichero guardado!", JOptionPane.INFORMATION_MESSAGE);
        
    }
    
    private void btnConvertirFicheroAOctalAction() {
        ArrayList<String> numerosLeidos = modeloCambioSistemaNumerico.getNumerosLeidosDesdeFichero();
        ArrayList<String> numerosEnOctal = new ArrayList<>();

        JFileChooser fileChooser = new JFileChooser();

        int seleccion = fileChooser.showSaveDialog(null);
        String path = "";
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            path = fileChooser.getSelectedFile().getAbsolutePath();
            
            for (String numero : numerosLeidos) {
                numerosEnOctal.add(modeloCambioSistemaNumerico.decimalAOctal(Integer.parseInt(numero)));
            }
            
            try {
                modeloCambioSistemaNumerico.escribirFichero(path, numerosEnOctal);
            } catch (IOException ex) {
                Logger.getLogger(ControlCambio.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println(path);
        }
        
        JOptionPane.showMessageDialog(null, ("Fichero Convertido a Octal con exito en\n" + path),
                "Fichero guardado!", JOptionPane.INFORMATION_MESSAGE);
    }

}
