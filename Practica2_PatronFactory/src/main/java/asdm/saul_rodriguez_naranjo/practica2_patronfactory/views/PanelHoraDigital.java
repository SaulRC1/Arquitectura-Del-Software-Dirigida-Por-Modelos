/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asdm.saul_rodriguez_naranjo.practica2_patronfactory.views;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author SaulRC1
 */
public class PanelHoraDigital extends JPanel {

    private String hora = "00:00";
    
    public PanelHoraDigital() {
        
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.black);
        InputStream stream = getClass().getResourceAsStream("/fonts/DS-DIGII.TTF");
        Font font = null;
        try {
            font = Font.createFont(Font.TRUETYPE_FONT, stream).deriveFont(72f);
        } catch (FontFormatException ex) {
            Logger.getLogger(PanelHoraDigital.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PanelHoraDigital.class.getName()).log(Level.SEVERE, null, ex);
        }
        g.setFont(font);
        
        g.drawString(hora, this.getWidth()/2 - 150, this.getHeight()/2);
        //g.drawRect(0, 0, this.getWidth() - 20, this.getHeight() - 20);
    }
    
    public void setHora(String hora) {
        this.hora = hora;
        repaint();
    }
    
    
    
}
