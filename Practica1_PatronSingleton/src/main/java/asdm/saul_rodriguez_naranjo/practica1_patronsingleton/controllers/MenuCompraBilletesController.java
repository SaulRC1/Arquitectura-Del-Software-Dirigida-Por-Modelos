/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asdm.saul_rodriguez_naranjo.practica1_patronsingleton.controllers;

import asdm.saul_rodriguez_naranjo.practica1_patronsingleton.models.observables.Avion;
import asdm.saul_rodriguez_naranjo.practica1_patronsingleton.models.Usuario;
import asdm.saul_rodriguez_naranjo.practica1_patronsingleton.views.MenuCompraBilletes;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author SaulRC1
 */
public class MenuCompraBilletesController {
    
    private MenuCompraBilletes menuCompraBilletes;
    private Avion avion = Avion.getAvion();
    private Usuario usuario;
    
    public MenuCompraBilletesController () {
        menuCompraBilletes = new MenuCompraBilletes();
        usuario = new Usuario();
        
        this.setListenersToButtons();
        /*ImageIcon imagenAvion = new ImageIcon("/asdm/saul_rodriguez_naranjo/practica1_patronsingleton/images/imagenAvion.png");
        Image imagenAvionImage = imagenAvion.getImage();
        imagenAvionImage = imagenAvionImage.getScaledInstance(281, 150, java.awt.Image.SCALE_SMOOTH);
        imagenAvion = createImageIcon(imagenAvionImage);
        menuCompraBilletes.lblImagenAvion.setIcon(imagenAvion);*/
        //menuCompraBilletes.lblImagenAvion.setIcon(new ImageIcon(getClass().getResource("/asdm/saul_rodriguez_naranjo/practica1_patronsingleton/images/imagenAvion.png")));
        

        //lblImagenAvion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asdm/saul_rodriguez_naranjo/practica1_patronsingleton/images/imagenAvion.png"))); // NOI18N
        
        
        menuCompraBilletes.txtPlazasRestantes.setText("" + avion.CuantosAsientosQuedan());
        menuCompraBilletes.setTitle("Comprar Billetes");
        menuCompraBilletes.setVisible(true);
        menuCompraBilletes.setLocationRelativeTo(null);
        menuCompraBilletes.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
    private void setListenersToButtons() {
        this.menuCompraBilletes.btnComprarBilletes.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                comprarBilletes(evt);
            }
        });
    }
    
    private void comprarBilletes(MouseEvent evt) {
        int billetesAComprar = (Integer) this.menuCompraBilletes.spinnerComprarBilletes.getValue();
        
        //System.out.println("Billetes A Comprar: " + billetesAComprar);
        usuario.QuieroComprarBilletes(billetesAComprar);
        this.menuCompraBilletes.txtPlazasRestantes.setText("" + avion.CuantosAsientosQuedan());
        
    }
}
