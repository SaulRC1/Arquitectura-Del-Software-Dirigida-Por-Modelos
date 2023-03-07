/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asdm.saul_rodriguez_naranjo.practica7_patronmvc.Vista;

import asdm.saul_rodriguez_naranjo.practica7_patronmvc.Controlador.ControladorFactory;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author SaulRC1
 */
public class VentanaCambio extends JFrame implements InterfazVista {

    public JButton btnConvertirAHexadecimal;
    public JButton btnConvertirABinario;
    public JButton btnConvertirAOctal;
    public JTextField txtCantidad;
    public JLabel lblResultado;
    public JButton btnAbrirFichero;
    public JButton btnConvertirFicheroABinario;
    public JButton btnConvertirFicheroAHexadecimal;
    public JButton btnConvertirFicheroAOctal;
    
    private ControladorFactory controlador;

    public VentanaCambio() {
        super();
    }
    
    @Override
    public void setControlador(ControladorFactory controlador) {
        this.controlador = controlador;
    }

    @Override
    public void arranca() {
        //Arrancamos ventana principal
        this.setSize(600, 400);
        
        //Boton convertir a binario
        this.btnConvertirABinario = new JButton("Convertir A Binario");
        this.btnConvertirABinario.setBounds(300,20, 200, 50);
        this.add(this.btnConvertirABinario);
        
        //Boton convertir a Hexadecimal
        this.btnConvertirAHexadecimal = new JButton("Convertir A Hexadecimal");
        this.btnConvertirAHexadecimal.setBounds(300, 80, 200, 50);
        this.add(this.btnConvertirAHexadecimal);
        
        //Boton convertir a Octal
        this.btnConvertirAOctal = new JButton("Convertir A Octal");
        this.btnConvertirAOctal.setBounds(300, 140, 200, 50);
        this.add(this.btnConvertirAOctal);
        
        //Texto cantidad a convertir
        this.txtCantidad = new JTextField();
        this.txtCantidad.setBounds(10, 90, 250, 40);
        this.add(this.txtCantidad);
        
        //Etiqueta Resultado
        this.lblResultado = new JLabel("Resultado: ");
        this.lblResultado.setBounds(10, 140, 200, 40);
        this.add(this.lblResultado);
        
        //Boton Abrir Fichero
        this.btnAbrirFichero = new JButton("Abrir Fichero");
        this.btnAbrirFichero.setBounds(10, 200, 200, 50);
        this.add(this.btnAbrirFichero);
        
        //Boton Convertir Fichero A Binario
        this.btnConvertirFicheroABinario = new JButton("Convertir Fichero a Binario");
        this.btnConvertirFicheroABinario.setBounds(300, 200, 200, 50);
        this.add(this.btnConvertirFicheroABinario);
        
        //Boton Convertir Fichero A Hexadecimal
        this.btnConvertirFicheroAHexadecimal = new JButton("Convertir Fichero a Hexadecimal");
        this.btnConvertirFicheroAHexadecimal.setBounds(300, 260, 250, 30);
        this.add(this.btnConvertirFicheroAHexadecimal);
        
        //Boton Convertir Fichero A Octal
        this.btnConvertirFicheroAOctal = new JButton("Convertir Fichero a Octal");
        this.btnConvertirFicheroAOctal.setBounds(300, 300, 250, 50);
        this.add(this.btnConvertirFicheroAOctal);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Practica 7 Patron MVC | Saúl Rodríguez Naranjo");
        this.setLayout(new BorderLayout());
        this.setVisible(true);
    }

    @Override
    public int getCantidad() {
        return Integer.parseInt(this.txtCantidad.getText());
    }

    @Override
    public void escribeCambio(String salida) {
        this.lblResultado.setText("Resultado: " + salida);
    }

    @Override
    public JButton getBtnConvertirAHexadecimal() {
        return this.btnConvertirAHexadecimal;
    }

    @Override
    public JButton getBtnConvertirABinario() {
        return this.btnConvertirABinario;
    }

    @Override
    public JButton getBtnConvertirAOctal() {
        return this.btnConvertirAOctal;
    }

    @Override
    public JButton getBtnAbrirFichero() {
        return this.btnAbrirFichero;
    }

    @Override
    public JButton getBtnConvertirFicheroABinario() {
        return this.btnConvertirFicheroABinario;
    }

    @Override
    public JButton getBtnConvertirFicheroAHexadecimal() {
        return this.btnConvertirFicheroAHexadecimal;
    }

    @Override
    public JButton getBtnConvertirFicheroAOctal() {
        return this.btnConvertirFicheroAOctal;
    }
    
}
