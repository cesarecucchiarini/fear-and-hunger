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
public abstract class Oggetto implements Creabile{
    private String nome;
    private ImageIcon sprite;

    public Oggetto(String nome, String path) {
        this.nome = nome;
        this.sprite = new ImageIcon(path);
    }

    public String getNome() {
        return nome;
    }

    public ImageIcon getSprite() {
        return sprite;
    }
    
    
}
