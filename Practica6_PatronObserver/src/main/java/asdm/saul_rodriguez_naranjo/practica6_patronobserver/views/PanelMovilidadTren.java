/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asdm.saul_rodriguez_naranjo.practica6_patronobserver.views;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author SaulRC1
 */
public class PanelMovilidadTren extends JPanel {
    private int posicionTren_X = 0;
    private int posicionTren_y = 250;
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); 
        g.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
        g.drawString("HUELVA", 10, 200);
        g.drawString("GIBRALEON", 210, 200);
        g.drawString("LA PALMA", 410, 200);
        g.drawString("BOLLULLOS", 610, 200);
        g.drawString("SEVILLA", 810, 200);
        
        g.setColor(Color.BLUE);
        
        g.fillOval(20, 250, 30, 30);
        g.fillOval(220, 250, 30, 30);
        g.fillOval(420, 250, 30, 30);
        g.fillOval(620, 250, 30, 30);
        g.fillOval(820, 250, 30, 30);
        
        g.setColor(Color.black);
        
        g.drawRect(0, 0, 950, 400);
        
        g.fillRect(this.posicionTren_X, this.posicionTren_y, 100, 50);
        
    }
    
    public void moveTrain(int x, int y) {
        this.posicionTren_X = x;
        this.posicionTren_y = y;
        repaint();
    }

    public int getPosicionTren_X() {
        return posicionTren_X;
    }

    public int getPosicionTren_y() {
        return posicionTren_y;
    }
    
    
    
    
    
}
