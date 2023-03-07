/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asdm.saul_rodriguez_naranjo.practica3_patronprototype.models;

/**
 *
 * @author SaulRC1
 */
public class Familiar extends Persona {

    public Familiar(String nombre, String apellidos, int telefono, String direccion, int codigoPostal, String ciudad, String nivelEconomico, String correoElectronico, String nivelDeEstudios) {
        super(nombre, apellidos, telefono, direccion, codigoPostal, ciudad, nivelEconomico, correoElectronico, nivelDeEstudios);
    }
    
    public Familiar() {
        super();
    }
    /**
     *
     * @return
     */
    @Override
    public Persona clonar() {
        Familiar nuevoFamiliar = new Familiar();
        
        nuevoFamiliar.setTelefono(this.getTelefono());
        nuevoFamiliar.setDireccion(this.getDireccion());
        nuevoFamiliar.setCodigoPostal(this.getCodigoPostal());
        nuevoFamiliar.setCiudad(this.getCiudad());
        nuevoFamiliar.setNivelEconomico(this.getNivelEconomico());
        
        return (Persona)nuevoFamiliar; 
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj); 
    } 
}
