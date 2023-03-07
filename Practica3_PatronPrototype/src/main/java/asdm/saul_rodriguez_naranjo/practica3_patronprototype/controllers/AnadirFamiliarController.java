/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asdm.saul_rodriguez_naranjo.practica3_patronprototype.controllers;

import asdm.saul_rodriguez_naranjo.practica3_patronprototype.models.Familiar;
import asdm.saul_rodriguez_naranjo.practica3_patronprototype.models.Persona;
import asdm.saul_rodriguez_naranjo.practica3_patronprototype.views.AnadirFamiliarVista;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;

/**
 *
 * @author SaulRC1
 */
public class AnadirFamiliarController {
    private AnadirFamiliarVista anadirFamiliarVista;
    private MenuPrincipalController menuPrincipalController;
    private Persona personaRecibida;

    public AnadirFamiliarController(MenuPrincipalController menuPrincipalController, Persona personaRecibida) {
        this.menuPrincipalController = menuPrincipalController;
        this.personaRecibida = personaRecibida;
        this.anadirFamiliarVista = new AnadirFamiliarVista();
        
        this.setListenersToButtons();
        this.setValuesToComboBoxes();
        
        this.anadirFamiliarVista.setVisible(true);
        this.anadirFamiliarVista.setTitle("Añadir Familiar");
        this.anadirFamiliarVista.setLocationRelativeTo(null);
        this.anadirFamiliarVista.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void setListenersToButtons() {
        //Boton Enviar
        this.anadirFamiliarVista.btnEnviar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                btnEnviarAction(evt);
            }
        });
        
        //Boton Cancelar
        this.anadirFamiliarVista.btnCancelar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                btnCancelarAction(evt);
            }
        });
    }
    
    private void btnEnviarAction(MouseEvent evt) {
        try {
            
            String nombre = this.anadirFamiliarVista.txtNombre.getText();
            String apellidos = this.anadirFamiliarVista.txtApellidos.getText();
            String correoElectronico = this.anadirFamiliarVista.txtCorreoElectronico.getText();
            String nivelDeEstudios = (String) this.anadirFamiliarVista.cmbNivelDeEstudios.getModel().getSelectedItem();
            
            Persona familiarAEnviar;
            
            Familiar familiar = (Familiar) personaRecibida;
            familiarAEnviar = familiar.clonar();
            
            familiarAEnviar.setNombre(nombre);
            familiarAEnviar.setApellidos(apellidos);
            familiarAEnviar.setCorreoElectronico(correoElectronico);
            familiarAEnviar.setNivelDeEstudios(nivelDeEstudios);
            
            this.enviarFamiliarAMenuPrincipal(familiarAEnviar);
            this.anadirFamiliarVista.dispose();
            
        } catch (Exception e) {
            System.out.println(e.getCause() + " " + e.getMessage());
        }
    }
    
    private void btnCancelarAction(MouseEvent evt) {
        this.anadirFamiliarVista.dispose();
    }
    
    private void setValuesToComboBoxes() {
        //ComboBox Nivel de Estudios
        DefaultComboBoxModel<String> cmbModelNivelDeEstudios = new DefaultComboBoxModel<>();
        cmbModelNivelDeEstudios.addElement(Persona.NIVEL_DE_ESTUDIOS_BAJO);
        cmbModelNivelDeEstudios.addElement(Persona.NIVEL_DE_ESTUDIOS_MEDIO);
        cmbModelNivelDeEstudios.addElement(Persona.NIVEL_DE_ESTUDIOS_ALTO);
        //cmbModelNivelDeEstudios.setSelectedItem();
        this.anadirFamiliarVista.cmbNivelDeEstudios.setModel(cmbModelNivelDeEstudios);
    }

    private void enviarFamiliarAMenuPrincipal(Persona familiarAEnviar) {
        this.menuPrincipalController.recibirPersona(familiarAEnviar);
    }
    
}
