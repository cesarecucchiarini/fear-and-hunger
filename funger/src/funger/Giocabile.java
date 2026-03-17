/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package funger;

import javax.swing.ImageIcon;

/**
 *
 * @author cucchiarini.cesare
 */
public abstract class Giocabile {
    private int vita;
    private int danno;
    private ImageIcon sprite;
    
    public Giocabile(int vita, int danno, String path){
        this.vita = vita;
        this.danno = danno;
        this.sprite = new ImageIcon(path);
    }
    
    public abstract int attacca();

    public int getVita() {
        return vita;
    }

    public int getDanno() {
        return danno;
    }

    public ImageIcon getSprite() {
        return sprite;
    }
    
    public void guadagnaVita(int guadagno){
        vita = Math.min(100, guadagno+vita);
    }
    
    public void perdiVita(int perdita){
        vita = Math.max(0, vita-perdita);
    }
    
    /**
     * 
     * @return ritorna true se il Giocabile è morto
     */
    public boolean controllaMorte(){
        return vita == 0;
    }
}
