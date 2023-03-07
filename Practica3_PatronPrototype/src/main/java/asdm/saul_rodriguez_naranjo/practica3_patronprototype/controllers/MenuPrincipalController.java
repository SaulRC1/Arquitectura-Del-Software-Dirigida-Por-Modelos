/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asdm.saul_rodriguez_naranjo.practica3_patronprototype.controllers;

import asdm.saul_rodriguez_naranjo.practica3_patronprototype.models.Persona;
import asdm.saul_rodriguez_naranjo.practica3_patronprototype.models.iterators.IListaPersonas;
import asdm.saul_rodriguez_naranjo.practica3_patronprototype.models.iterators.IteradorPersonas;
import asdm.saul_rodriguez_naranjo.practica3_patronprototype.models.iterators.ListaPersonas;
import asdm.saul_rodriguez_naranjo.practica3_patronprototype.views.MenuPrincipalVista;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author SaulRC1
 */
public class MenuPrincipalController {
    private MenuPrincipalVista menuPrincipalVista;
    //private ArrayList<Persona> listaDePersonas;
    private IListaPersonas listaDePersonas;
    private DefaultTableModel tblPersonasModel;
    
    public MenuPrincipalController() {
        this.menuPrincipalVista = new MenuPrincipalVista();
        this.listaDePersonas = new ListaPersonas();
        
        this.setListenersToButtons();
        this.setTabletblPersonas();
        
        this.menuPrincipalVista.setVisible(true);
        this.menuPrincipalVista.setTitle("Menu Principal - Mostrando Todas las Personas");
        this.menuPrincipalVista.setLocationRelativeTo(null);
    }
    
    /**
     * Recibe una persona y es añadida al conjunto
     * @param persona Persona que se quiere enviar al menu principal
     */
    public void recibirPersona(Persona persona) {
        this.listaDePersonas.addElement(persona);
        this.setTabletblPersonas();
    }
    
    public void setListenersToButtons() {
        
        //Boton Añadir Nueva Persona
        this.menuPrincipalVista.btnAnadirNuevaPersona.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                btnAnadirNuevaPersonaAction(evt);
            }
        });
        
        //Boton Añadir Familiar
        this.menuPrincipalVista.btnAnadirFamiliar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                btnAnadirFamiliarAction(evt);
            }
        });
    }
    
    private void btnAnadirNuevaPersonaAction(MouseEvent evt) {
        AnadirNuevaPersonaController anadirNuevaPersonaController = new AnadirNuevaPersonaController(this);
    }
    
    private void btnAnadirFamiliarAction(MouseEvent evt) {
        
        if(this.menuPrincipalVista.tblPersonas.getSelectedRow() != -1) {
            Persona personaSeleccionada = this.listaDePersonas.getElementByNumber(this.menuPrincipalVista.tblPersonas.getSelectedRow());
            AnadirFamiliarController anadirFamiliarController = new AnadirFamiliarController(this, personaSeleccionada);
        } else {
            JOptionPane.showMessageDialog(menuPrincipalVista, "Debe seleccionar una persona", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        /*if(this.listaDePersonas != null && !this.listaDePersonas.isEmpty()) {
            AnadirFamiliarController anadirFamiliarController = new AnadirFamiliarController(this, this.listaDePersonas.get(0));
        } else {
            JOptionPane.showMessageDialog(menuPrincipalVista, "No hay ningun familiar añadido", "ERROR", JOptionPane.ERROR_MESSAGE);
        }*/
        
    }

    private void setTabletblPersonas() {
        DefaultTableModel tblPersonasModel = new DefaultTableModel();
        String[] tblPersonasIdentifiers = {"Nombre", "Apellidos", "Teléfono",
                                           "Dirección", "Cod.Postal", "Ciudad",
                                           "Nivel Económico", "Correo Electrónico",
                                           "Nivel de Estudios"};
        tblPersonasModel.setColumnIdentifiers(tblPersonasIdentifiers);
        
        IteradorPersonas iterador = this.listaDePersonas.crearIterador();
        
        while(iterador.tieneSiguiente()) {
            Persona persona = iterador.siguiente();
            
            Object[] datoDeFila = new Object[9];
                
                datoDeFila[0] = persona.getNombre();
                datoDeFila[1] = persona.getApellidos();
                datoDeFila[2] = persona.getTelefono();
                datoDeFila[3] = persona.getDireccion();
                datoDeFila[4] = persona.getCodigoPostal();
                datoDeFila[5] = persona.getCiudad();
                datoDeFila[6] = persona.getNivelEconomico();
                datoDeFila[7] = persona.getCorreoElectronico();
                datoDeFila[8] = persona.getNivelDeEstudios();
                
                tblPersonasModel.addRow(datoDeFila);
            
        }
        
        /*if(!this.listaDePersonas.isEmpty() && this.listaDePersonas != null) {
            Object[] datoDeFila = new Object[9];
            
            for (int i = 0; i < this.listaDePersonas.size(); i++) {
                
                datoDeFila[0] = this.listaDePersonas.get(i).getNombre();
                datoDeFila[1] = this.listaDePersonas.get(i).getApellidos();
                datoDeFila[2] = this.listaDePersonas.get(i).getTelefono();
                datoDeFila[3] = this.listaDePersonas.get(i).getDireccion();
                datoDeFila[4] = this.listaDePersonas.get(i).getCodigoPostal();
                datoDeFila[5] = this.listaDePersonas.get(i).getCiudad();
                datoDeFila[6] = this.listaDePersonas.get(i).getNivelEconomico();
                datoDeFila[7] = this.listaDePersonas.get(i).getCorreoElectronico();
                datoDeFila[8] = this.listaDePersonas.get(i).getNivelDeEstudios();
                
                tblPersonasModel.addRow(datoDeFila);
            }
        }*/

        this.menuPrincipalVista.tblPersonas.setModel(tblPersonasModel);
    }
}
