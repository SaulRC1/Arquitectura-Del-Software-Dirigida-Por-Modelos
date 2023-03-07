/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asdm.examen_saul_rodriguez_naranjo.Modelos;

import asdm.examen_saul_rodriguez_naranjo.Controlador.ControladorUsuario;
import asdm.examen_saul_rodriguez_naranjo.Controlador.factory.Controlador;
import asdm.examen_saul_rodriguez_naranjo.Modelos.factory.Persona;

/**
 *
 * @author SaulRC1
 */
public class Usuario implements Persona {

    private String nombre;
    private String telefono;
    private String direccion;

    public Usuario() {
        
    }
    
    public Usuario(String nombre, String telefono, String direccion) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
    }
    
    @Override
    public Controlador crearControlador() {
        return new ControladorUsuario();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    
    
}
