/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asdm.examen_saul_rodriguez_naranjo.Controlador;

import asdm.examen_saul_rodriguez_naranjo.Controlador.factory.Controlador;
import asdm.examen_saul_rodriguez_naranjo.Modelos.Cocina;
import asdm.examen_saul_rodriguez_naranjo.Modelos.ListaDePizzas;
import asdm.examen_saul_rodriguez_naranjo.Modelos.Pedido;
import asdm.examen_saul_rodriguez_naranjo.Modelos.Pizza;
import asdm.examen_saul_rodriguez_naranjo.Modelos.Usuario;
import asdm.examen_saul_rodriguez_naranjo.Modelos.iterator.IListaPizzas;
import asdm.examen_saul_rodriguez_naranjo.Modelos.iterator.Iterador;
import asdm.examen_saul_rodriguez_naranjo.Vista.PantallaTipo1;
import asdm.examen_saul_rodriguez_naranjo.Vista.VistaUsuario;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author SaulRC1
 */
public class ControladorUsuario implements Controlador {

    private VistaUsuario vistaUsuario;
    private PantallaTipo1 pantallaTipo1;

    private IListaPizzas listaDePizzas;
    private Iterador iteradorListaDePizzas;
    private Cocina cocina = Cocina.getCocinaInstance();

    public ControladorUsuario() {
        vistaUsuario = new VistaUsuario();
        pantallaTipo1 = PantallaTipo1.getPantallaTipo1Instance();

        listaDePizzas = new ListaDePizzas();

        listaDePizzas.add(new Pizza("Personalizada"));
        listaDePizzas.add(new Pizza("Barbacoa"));
        listaDePizzas.add(new Pizza("Marinera"));
        listaDePizzas.add(new Pizza("Hawaiana"));

        Iterador iterador = listaDePizzas.crearIterador();

        this.loadPizzaComboBox(iterador);

        this.setListenersToButtons();
    }

    @Override
    public void setListenersToButtons() {

        //Boton Realizar Pedido
        this.vistaUsuario.btnRealizarPedido.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                realizarPedido();
            }
        });

        //Boton Retirar Pedido
        this.vistaUsuario.btnRetirarPedido.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                retirarPedido();
            }
        });
    }

    @Override
    public void initView() {
        vistaUsuario.setTitle("Hacer pedido");

        vistaUsuario.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        vistaUsuario.setVisible(true);
    }

    private boolean checkNoExtraIngredientsSelected() {

        if (!this.vistaUsuario.cbAnchoas.isSelected() && !this.vistaUsuario.cbExtraDeQueso.isSelected()
                && !this.vistaUsuario.cbGambas.isSelected() && !this.vistaUsuario.cbYork.isSelected()) {
            return true;
        } else {
            return false;
        }

    }

    private void loadPizzaComboBox(Iterador iterador) {
        while (iterador.tieneSiguiente()) {
            this.vistaUsuario.comboPizzas.addItem(((Pizza) iterador.siguiente()).getNombre());
        }

    }

    private ArrayList<String> getIngredientesExtra() {
        ArrayList<String> ingredientesExtra = new ArrayList<>();

        if (this.vistaUsuario.cbAnchoas.isSelected()) {
            ingredientesExtra.add("Anchoas");
        }

        if (this.vistaUsuario.cbExtraDeQueso.isSelected()) {
            ingredientesExtra.add("Extra de Queso");
        }

        if (this.vistaUsuario.cbGambas.isSelected()) {
            ingredientesExtra.add("Gambas");
        }

        if (this.vistaUsuario.cbYork.isSelected()) {
            ingredientesExtra.add("York");
        }

        if (ingredientesExtra.isEmpty()) {
            return null;
        }

        return ingredientesExtra;
    }

    private void realizarPedido() {
        if (((String) this.vistaUsuario.comboPizzas.getSelectedItem()).equals("Personalizada")
                && this.checkNoExtraIngredientsSelected()) {

            JOptionPane.showMessageDialog(this.vistaUsuario, "ES OBLIGATORIO COGER INGREDIENTES "
                    + "EXTRA EN LA PERSONALIZADA", "ERROR", JOptionPane.ERROR_MESSAGE);

        } else {
            if (this.vistaUsuario.txtNombre.getText().isEmpty() || this.vistaUsuario.txtTelefono.getText().isEmpty()
                    || this.vistaUsuario.txtDireccion.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this.vistaUsuario, "INTRODUZCA SUS DATOS POR FAVOR",
                         "ERROR", JOptionPane.ERROR_MESSAGE);
            } else {
                Usuario usuario = new Usuario(this.vistaUsuario.txtNombre.getText(),
                        this.vistaUsuario.txtTelefono.getText(), this.vistaUsuario.txtDireccion.getText());
                Pedido pedido = new Pedido((String) this.vistaUsuario.comboPizzas.getSelectedItem(),
                        this.getIngredientesExtra(), usuario);
                pedido.setEstado(Pedido.EN_ESPERA);
                this.cocina.addPedido(pedido);
                this.vistaUsuario.dispose();
            }

        }
    }

    private void retirarPedido() {
        ControladorRetirarPedido controladorRetirarPedido = new ControladorRetirarPedido();
    }

}
