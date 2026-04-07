/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package funger;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author sergi
 */
public class PanelSfondo extends JPanel{
    private Image backgroundImage;

    public PanelSfondo(String filePath) {
        backgroundImage = new ImageIcon(filePath).getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draws the image to fill the entire panel
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }
}
