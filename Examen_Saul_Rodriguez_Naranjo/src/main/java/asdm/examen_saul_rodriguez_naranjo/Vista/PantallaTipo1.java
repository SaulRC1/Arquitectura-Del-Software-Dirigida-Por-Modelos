/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package asdm.examen_saul_rodriguez_naranjo.Vista;

import asdm.examen_saul_rodriguez_naranjo.Modelos.Cocina;
import asdm.examen_saul_rodriguez_naranjo.Modelos.Pedido;
import asdm.examen_saul_rodriguez_naranjo.Modelos.observer.Observer;

/**
 *
 * @author SaulRC1
 */
public class PantallaTipo1 extends javax.swing.JFrame implements Observer {

    private static PantallaTipo1 pantallaTipo1 = new PantallaTipo1();
    private Cocina cocina = Cocina.getCocinaInstance();
    /**
     * Creates new form PantallaTipo1
     * Sigue el patron Singleton
     */
    private PantallaTipo1() {
        cocina.addObserver(this);
        initComponents();
    }
    
    public static PantallaTipo1 getPantallaTipo1Instance() {
        return PantallaTipo1.pantallaTipo1;
    }
    
    public void addPedido(Pedido pedido) {
        String textoActual = this.txtPedidosRealizadosPorLosUsuarios.getText();
        
        textoActual += "\nNumero de Pedido: " + pedido.getNumeroDePedido() 
                + "\n----------------------------" + "\nTipo de Pizza: " 
                + pedido.getTipoDePizza() + "\nIngredientes Extra:";
        
        for (String ingrediente: pedido.getIngredientesExtra()) {
            textoActual += " " + ingrediente;
        }
        
        if (pedido.getEstado() == Pedido.EN_ESPERA) {
            textoActual += "\nEstado: EN ESPERA";
        } else if (pedido.getEstado() == Pedido.EN_PREPARACION) {
            textoActual += "\nEstado: EN PREPARACION";
        } else if (pedido.getEstado() == Pedido.TERMINADO) {
            textoActual += "\nEstado: TERMINADO";
        } else if (pedido.getEstado() == Pedido.RETIRADO) {
            textoActual += "\nEstado: RETIRADO";
        }
        
        
        this.txtPedidosRealizadosPorLosUsuarios.setText(textoActual);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtPedidosRealizadosPorLosUsuarios = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtPedidosRealizadosPorLosUsuarios.setColumns(20);
        txtPedidosRealizadosPorLosUsuarios.setRows(5);
        jScrollPane1.setViewportView(txtPedidosRealizadosPorLosUsuarios);

        jLabel1.setText("Pedidos Realizados Por Los Usuarios");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(jLabel1)))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTextArea txtPedidosRealizadosPorLosUsuarios;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update() {
        this.txtPedidosRealizadosPorLosUsuarios.setText("");
        
        for (Pedido ped: this.cocina.getPedidos()) {
            this.addPedido(ped);
        }
    }
}
