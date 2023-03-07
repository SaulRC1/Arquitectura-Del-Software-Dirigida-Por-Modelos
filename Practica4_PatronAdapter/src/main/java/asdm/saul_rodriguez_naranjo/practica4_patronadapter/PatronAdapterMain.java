/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package asdm.saul_rodriguez_naranjo.practica4_patronadapter;

import asdm.saul_rodriguez_naranjo.practica4_patronadapter.controllers.MenuPrincipalController;

/**
 *
 * @author SaulRC1
 */
public class PatronAdapterMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        /*Barco barco = new Barco();
        ICoche interfazCoche = new CocheToBarcoAdapter(barco);
        interfazCoche.Encender();
        interfazCoche.Acelerar();
        interfazCoche.Apagar();
        
        interfazCoche = new Coche();
        interfazCoche.Encender();
        interfazCoche.Acelerar();
        interfazCoche.Apagar();
        
        CocheManual cocheManual = new CocheManual(); 
        IMandos interfazMandos = new IMandosToCocheManualAdapter(cocheManual);
        
        interfazMandos.Acelera();
        interfazMandos.Acelera();
        interfazMandos.Acelera();
        interfazMandos.Acelera();
        
        interfazMandos.Frena();
        interfazMandos.Frena();
        interfazMandos.Frena();
        interfazMandos.Frena();
        interfazMandos.Frena();
        interfazMandos.Frena();*/
        
        MenuPrincipalController menuPrincipalController = new MenuPrincipalController();
        
        
    }
    
}
