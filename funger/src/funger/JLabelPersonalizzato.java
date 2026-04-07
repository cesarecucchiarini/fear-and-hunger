/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package funger;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author sergi
 */
public class JLabelPersonalizzato extends JLabel{
    private ImageIcon img;
    
    public JLabelPersonalizzato(ImageIcon img){
        super();
        this.img = img;
    }
    
    public JLabelPersonalizzato(String s){
        super(s);
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        if(img == null) return;
        
        Graphics2D g2d = (Graphics2D) g;

        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.drawImage(img.getImage(), 0, 0, getWidth(), getHeight(), null);
    }
}
