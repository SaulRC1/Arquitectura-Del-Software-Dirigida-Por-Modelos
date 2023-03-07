/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asdm.examen_saul_rodriguez_naranjo.Modelos;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author SaulRC1
 */
public class Pedido {
    private static int pedidosTotales = 0;
    
    //Estados del pedido
    public static int EN_ESPERA = 0;
    public static int EN_PREPARACION = 1;
    public static int TERMINADO = 2;
    public static int RETIRADO = 3;
    
    private String numeroDePedido;
    private String tipoDePizza;
    private ArrayList<String> ingredientesExtra;
    private int estado;
    private Usuario usuario;
    
    public Pedido(String tipoDePizza, ArrayList<String> ingredientesExtra, Usuario usuario) {
        this.numeroDePedido = Pedido.pedidosTotales + "";
        Pedido.pedidosTotales++;
        this.tipoDePizza = tipoDePizza;
        this.ingredientesExtra = ingredientesExtra;
        this.usuario = usuario;
    }
    
    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    public int getEstado() {
        return this.estado;
    }

    public String getNumeroDePedido() {
        return numeroDePedido;
    }

    public void setNumeroDePedido(String numeroDePedido) {
        this.numeroDePedido = numeroDePedido;
    }

    public String getTipoDePizza() {
        return tipoDePizza;
    }

    public void setTipoDePizza(String tipoDePizza) {
        this.tipoDePizza = tipoDePizza;
    }

    public ArrayList<String> getIngredientesExtra() {
        return ingredientesExtra;
    }

    public void setIngredientesExtra(ArrayList<String> ingredientesExtra) {
        this.ingredientesExtra = ingredientesExtra;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.numeroDePedido);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        return (this.numeroDePedido == ((Pedido)obj).numeroDePedido);
    }
    
    public Usuario getUsuario() {
        return this.usuario;
    }
    
}
