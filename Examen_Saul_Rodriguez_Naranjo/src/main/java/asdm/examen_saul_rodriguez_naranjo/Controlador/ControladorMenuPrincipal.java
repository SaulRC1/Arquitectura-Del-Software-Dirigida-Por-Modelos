/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asdm.examen_saul_rodriguez_naranjo.Controlador;

import asdm.examen_saul_rodriguez_naranjo.Controlador.factory.Controlador;
import asdm.examen_saul_rodriguez_naranjo.Modelos.Cocinero;
import asdm.examen_saul_rodriguez_naranjo.Modelos.Usuario;
import asdm.examen_saul_rodriguez_naranjo.Modelos.factory.Persona;
import asdm.examen_saul_rodriguez_naranjo.Vista.MenuPrincipal;
import asdm.examen_saul_rodriguez_naranjo.Vista.PantallaTipo1;
import asdm.examen_saul_rodriguez_naranjo.Vista.PantallaTipo2;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author SaulRC1
 */
public class ControladorMenuPrincipal {
    private MenuPrincipal menuPrincipal;
    private PantallaTipo1 pantallaTipo1;
    private PantallaTipo2 pantallaTipo2;
    
    public ControladorMenuPrincipal() {
        menuPrincipal = new MenuPrincipal();
        pantallaTipo1 = PantallaTipo1.getPantallaTipo1Instance();
        pantallaTipo2 = PantallaTipo2.getPantallaTipo2Instance();
        pantallaTipo1.setVisible(true);
        pantallaTipo1.setTitle("Pantalla Tipo 1");
        pantallaTipo2.setVisible(true);
        pantallaTipo2.setTitle("Pantalla Tipo 2");
        pantallaTipo2.setLocation(200, 0);
        
        this.setListenersToButtons();
        
        menuPrincipal.setTitle("¿Quién eres?");
        this.menuPrincipal.setLocationRelativeTo(null);
        menuPrincipal.setVisible(true);
    }

    private void setListenersToButtons() {
        
        //Boton Usuario
        this.menuPrincipal.btnUsuario.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent evt) {
                Persona usuario = new Usuario();
                Controlador controladorUsuario = usuario.crearControlador();
                
                controladorUsuario.initView();
            }
        });
        
        //Boton Cocinero
        this.menuPrincipal.btnCocinero.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent evt) {
                Persona cocinero = new Cocinero();
                Controlador controladorCocinero = cocinero.crearControlador();
                
                controladorCocinero.initView();
            }
        });
    }
}
