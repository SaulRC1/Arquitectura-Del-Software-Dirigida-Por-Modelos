/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package asdm.saul_rodriguez_naranjo.practica3_patronprototype.views;

/**
 *
 * @author SaulRC1
 */
public class MenuPrincipalVista extends javax.swing.JFrame {

    /**
     * Creates new form MenuPrincipalVista
     */
    public MenuPrincipalVista() {
        initComponents();
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
        tblPersonas = new javax.swing.JTable();
        btnAnadirFamiliar = new javax.swing.JButton();
        btnAnadirNuevaPersona = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblPersonas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblPersonas);

        btnAnadirFamiliar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnAnadirFamiliar.setText("Añadir Familiar");

        btnAnadirNuevaPersona.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnAnadirNuevaPersona.setText("Añadir Nueva Persona");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAnadirFamiliar)
                .addGap(79, 79, 79)
                .addComponent(btnAnadirNuevaPersona)
                .addGap(244, 244, 244))
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 958, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAnadirFamiliar)
                    .addComponent(btnAnadirNuevaPersona))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAnadirFamiliar;
    public javax.swing.JButton btnAnadirNuevaPersona;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable tblPersonas;
    // End of variables declaration//GEN-END:variables
}
