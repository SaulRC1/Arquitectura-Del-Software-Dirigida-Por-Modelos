/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asdm.saul_rodriguez_naranjo.practica1_patronsingleton;

import asdm.saul_rodriguez_naranjo.practica1_patronsingleton.controllers.MenuPrincipalController;
import asdm.saul_rodriguez_naranjo.practica1_patronsingleton.controllers.PanelAsientosController;

/**
 *
 * @author Saúl Rodríguez Naranjo
 */
public class PatronSingletonMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        /*Avion avion = Avion.getAvion();
        Agencia agencia = new Agencia();
        Usuario usuario = new Usuario();
        
        usuario.QuieroComprarBilletes(180);
        usuario.QuieroComprarBilletes(1);*/
        
        MenuPrincipalController menuPrincipalController = new MenuPrincipalController();
        PanelAsientosController panelAsientosController = new PanelAsientosController();
    }
    
}
