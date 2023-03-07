/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asdm.saul_rodriguez_naranjo.practica3_patronprototype.models;

import java.util.Objects;

/**
 *
 * @author SaulRC1
 */
public abstract class Persona {
    public static final String NIVEL_ECONOMICO_BAJO = "BAJO";
    public static final String NIVEL_ECONOMICO_MEDIO = "MEDIO";
    public static final String NIVEL_ECONOMICO_ALTO = "ALTO";
    
    public static final String NIVEL_DE_ESTUDIOS_BAJO = "BAJO";
    public static final String NIVEL_DE_ESTUDIOS_MEDIO = "MEDIO";
    public static final String NIVEL_DE_ESTUDIOS_ALTO = "ALTO";
    
    private String nombre;
    private String apellidos;
    private int telefono;
    private String direccion;
    private int codigoPostal;
    private String ciudad;
    private String nivelEconomico;
    private String correoElectronico;
    private String nivelDeEstudios;

    public Persona(String nombre, String apellidos, int telefono, String direccion, int codigoPostal, String ciudad, String nivelEconomico, String correoElectronico, String nivelDeEstudios) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.direccion = direccion;
        this.codigoPostal = codigoPostal;
        this.ciudad = ciudad;
        this.nivelEconomico = nivelEconomico;
        this.correoElectronico = correoElectronico;
        this.nivelDeEstudios = nivelDeEstudios;
    }

    public Persona() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getNivelEconomico() {
        return nivelEconomico;
    }

    public void setNivelEconomico(String nivelEconomico) {
        this.nivelEconomico = nivelEconomico;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getNivelDeEstudios() {
        return nivelDeEstudios;
    }

    public void setNivelDeEstudios(String nivelDeEstudios) {
        this.nivelDeEstudios = nivelDeEstudios;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.nombre);
        hash = 11 * hash + Objects.hashCode(this.apellidos);
        hash = 11 * hash + this.telefono;
        hash = 11 * hash + Objects.hashCode(this.direccion);
        hash = 11 * hash + this.codigoPostal;
        hash = 11 * hash + Objects.hashCode(this.ciudad);
        hash = 11 * hash + Objects.hashCode(this.nivelEconomico);
        hash = 11 * hash + Objects.hashCode(this.correoElectronico);
        hash = 11 * hash + Objects.hashCode(this.nivelDeEstudios);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Persona other = (Persona) obj;
        if (this.telefono != other.telefono) {
            return false;
        }
        if (this.codigoPostal != other.codigoPostal) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.apellidos, other.apellidos)) {
            return false;
        }
        if (!Objects.equals(this.direccion, other.direccion)) {
            return false;
        }
        if (!Objects.equals(this.ciudad, other.ciudad)) {
            return false;
        }
        if (!Objects.equals(this.nivelEconomico, other.nivelEconomico)) {
            return false;
        }
        if (!Objects.equals(this.correoElectronico, other.correoElectronico)) {
            return false;
        }
        return Objects.equals(this.nivelDeEstudios, other.nivelDeEstudios);
    }
    
    
    
    public abstract Persona clonar();
}
