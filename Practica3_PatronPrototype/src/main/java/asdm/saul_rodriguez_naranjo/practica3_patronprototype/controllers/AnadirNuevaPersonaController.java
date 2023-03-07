/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asdm.saul_rodriguez_naranjo.practica3_patronprototype.controllers;

import asdm.saul_rodriguez_naranjo.practica3_patronprototype.models.Familiar;
import asdm.saul_rodriguez_naranjo.practica3_patronprototype.models.Persona;
import asdm.saul_rodriguez_naranjo.practica3_patronprototype.views.AnadirNuevaPersonaVista;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author SaulRC1
 */
public class AnadirNuevaPersonaController {

    private AnadirNuevaPersonaVista anadirNuevaPersonaVista;
    private MenuPrincipalController menuPrincipalController;

    public AnadirNuevaPersonaController(MenuPrincipalController menuPrincipalController) {
        this.menuPrincipalController = menuPrincipalController;

        this.anadirNuevaPersonaVista = new AnadirNuevaPersonaVista();
        this.anadirNuevaPersonaVista.setVisible(true);
        this.anadirNuevaPersonaVista.setLocationRelativeTo(null);
        this.anadirNuevaPersonaVista.setTitle("Añadir Nueva Persona");
        this.anadirNuevaPersonaVista.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        this.setListenersToButtons();
        this.setValuesToComboBoxes();

    }

    public void enviarNuevaPersonaAMenuPrincipal(Persona persona) {
        this.menuPrincipalController.recibirPersona(persona);
    }

    private void setListenersToButtons() {

        //Boton Enviar
        this.anadirNuevaPersonaVista.btnEnviar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                btnEnviarAction();
            }
        });

        //Boton Cancelar
        this.anadirNuevaPersonaVista.btnCancelar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                btnCancelarAction();
            }
        });
    }

    private void btnEnviarAction() {
        try {
            String nombre = this.anadirNuevaPersonaVista.txtNombre.getText();
            String apellidos = this.anadirNuevaPersonaVista.txtApellidos.getText();
            int telefono = Integer.parseInt(this.anadirNuevaPersonaVista.txtTelefono.getText());
            String direccion = this.anadirNuevaPersonaVista.txtDireccion.getText();
            int codigoPostal = Integer.parseInt(this.anadirNuevaPersonaVista.txtCodigoPostal.getText());
            String ciudad = this.anadirNuevaPersonaVista.txtCiudad.getText();
            String nivelEconomico = (String) this.anadirNuevaPersonaVista.cmbNivelEconomico.getModel().getSelectedItem();
            String correoElectronico = this.anadirNuevaPersonaVista.txtCorreoElectronico.getText();
            String nivelDeEstudios = (String) this.anadirNuevaPersonaVista.cmbNivelDeEstudios.getModel().getSelectedItem();

            Familiar personaNueva = new Familiar(nombre, apellidos, telefono, direccion, codigoPostal, ciudad,
                    nivelEconomico, correoElectronico, nivelDeEstudios);

            this.enviarNuevaPersonaAMenuPrincipal(personaNueva);

            this.anadirNuevaPersonaVista.dispose();

        } catch (NumberFormatException ex) {
            String codigoPostal = this.anadirNuevaPersonaVista.txtCodigoPostal.getText();
            
            if(!esUnNumero(codigoPostal) || codigoPostal.isBlank() || codigoPostal.isEmpty()) {
                JOptionPane.showMessageDialog(anadirNuevaPersonaVista, "El código postal no tiene un formato válido",
                        "ERROR", JOptionPane.ERROR_MESSAGE);
            }
            
            String telefono = this.anadirNuevaPersonaVista.txtTelefono.getText();
            
            if(!esUnNumero(telefono) || telefono.isBlank() || telefono.isEmpty()) {
                JOptionPane.showMessageDialog(anadirNuevaPersonaVista, "El teléfono no tiene un formato válido",
                        "ERROR", JOptionPane.ERROR_MESSAGE);
            }
            
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(anadirNuevaPersonaVista, "Debe rellenar todos los campos",
                        "ERROR", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            System.out.println(e.getCause() + " " + e.getMessage());
        }

        /*Persona personaEnviar = new Persona(nombre, apellidos, telefono, direccion, codigoPostal, 
                ciudad, nivelEconomico, correoElectronico, nivelDeEstudios);*/
    }

    private void btnCancelarAction() {
        this.anadirNuevaPersonaVista.dispose();
    }

    private void setValuesToComboBoxes() {
        //ComboBox Nivel de Estudios
        DefaultComboBoxModel<String> cmbModelNivelDeEstudios = new DefaultComboBoxModel<>();
        cmbModelNivelDeEstudios.addElement(Persona.NIVEL_DE_ESTUDIOS_BAJO);
        cmbModelNivelDeEstudios.addElement(Persona.NIVEL_DE_ESTUDIOS_MEDIO);
        cmbModelNivelDeEstudios.addElement(Persona.NIVEL_DE_ESTUDIOS_ALTO);
        //cmbModelNivelDeEstudios.setSelectedItem();
        this.anadirNuevaPersonaVista.cmbNivelDeEstudios.setModel(cmbModelNivelDeEstudios);

        //ComboBox Nivel Economico
        DefaultComboBoxModel<String> cmbModelNivelEconomico = new DefaultComboBoxModel<>();
        cmbModelNivelEconomico.addElement(Persona.NIVEL_ECONOMICO_BAJO);
        cmbModelNivelEconomico.addElement(Persona.NIVEL_ECONOMICO_MEDIO);
        cmbModelNivelEconomico.addElement(Persona.NIVEL_ECONOMICO_ALTO);
        this.anadirNuevaPersonaVista.cmbNivelEconomico.setModel(cmbModelNivelEconomico);

    }

    private boolean esUnNumero(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }

}
