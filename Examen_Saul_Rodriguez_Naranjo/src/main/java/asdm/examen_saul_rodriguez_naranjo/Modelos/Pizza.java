/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asdm.examen_saul_rodriguez_naranjo.Modelos;

import java.util.ArrayList;

/**
 *
 * @author SaulRC1
 */
public class Pizza {
    
    private String nombre;
    private ArrayList<String> ingredientes;
    
    public Pizza(String nombre) {
        this.ingredientes = new ArrayList<>();
        this.nombre = nombre;
    }
    
    public void addIngrediente(String ingrediente) {
        this.ingredientes.add(ingrediente);
    }
    
    public String getNombre() {
        return this.nombre;
    }
    
}
