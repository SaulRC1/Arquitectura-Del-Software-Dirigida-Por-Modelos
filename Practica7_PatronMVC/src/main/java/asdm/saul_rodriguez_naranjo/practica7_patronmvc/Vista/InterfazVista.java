/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package asdm.saul_rodriguez_naranjo.practica7_patronmvc.Vista;

import asdm.saul_rodriguez_naranjo.practica7_patronmvc.Controlador.ControladorFactory;
import javax.swing.JButton;

/**
 *
 * @author SaulRC1
 */
public interface InterfazVista {

    public void setControlador(ControladorFactory controlador);

    public void arranca();

    public int getCantidad();

    public void escribeCambio(String salida);
    
    public JButton getBtnConvertirAHexadecimal();
    
    public JButton getBtnConvertirABinario();
    
    public JButton getBtnConvertirAOctal();
    
    public JButton getBtnAbrirFichero();
    
    public JButton getBtnConvertirFicheroABinario();
    
    public JButton getBtnConvertirFicheroAHexadecimal();
    
    public JButton getBtnConvertirFicheroAOctal();
}
