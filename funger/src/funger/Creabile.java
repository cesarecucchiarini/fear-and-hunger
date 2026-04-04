/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package funger;

import javax.swing.ImageIcon;

/**
 *
 * @author sergi
 */
public interface Creabile{
    public Object clone();
    
    public String getNome();
    
    public ImageIcon getSprite();
}
