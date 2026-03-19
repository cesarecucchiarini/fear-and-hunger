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
    /**
     * vita del Giocabile
     */
    private int vita;
    
    /**
     * danno del Giocabile
     */
    private int danno;
    private String nome;
    private ImageIcon sprite;
    
    /**
     * 
     * @param nome nome del Giocabile
     * @param path percorso dell'immagine
     * @param gestoreGioco gestore da utilizzare per scrivere i log
     */
    public Giocabile(String nome, String path){
        this.nome = nome;
        this.vita = 100;
        this.danno = 100;
        this.sprite = new ImageIcon(path);
    }
    
    /**
     * 
     * @return danno causato
     */
    public abstract int attacca();

    /**
     * 
     * @return ritorna il nome del Giocabile
     */
    public String getNome(){
        return nome;
    }
    
    /**
     * 
     * @return ritorna la vita rimasta del Giocabile
     */
    public int getVita() {
        return vita;
    }

    /**
     * 
     * @return ritorna il danno del Giocabile
     */
    public int getDanno() {
        return danno;
    }

    /**
     * 
     * @return ritorna lo sprite del Giocabile
     */
    public ImageIcon getSprite() {
        return sprite;
    }
    
    /**
     * 
     * @param guadagno vita guadagnata
     */
    public void guadagnaVita(int guadagno){
        vita = Math.min(100, guadagno+vita);
    }
    
    /**
     * 
     * @param perdita vita persa
     */
    public void perdiVita(int perdita){
        vita = Math.max(0, vita-perdita);
    }
    
    /**
     * 
     * @return true se il Giocabile è morto
     */
    public boolean controllaMorte(){
        return vita == 0;
    }
    
    /**
     * consuma un OggettoConsumabile e ne controlla gli effetti
     * @param oggetto oggetto da consumare
     */
    public void consumaOggetto(OggettoConsumabile oggetto){
        if(oggetto.getTipo().equals(TipoOggettoConsumabile.CURATIVO))
            guadagnaVita(oggetto.getStatPrincipale());
    }
}
