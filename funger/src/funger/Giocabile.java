/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package funger;

import java.io.Serializable;
import javax.swing.ImageIcon;

/**
 *
 * @author cucchiarini.cesare
 */
public abstract class Giocabile implements Cloneable, Serializable{
    private static final long serialVersionUID = 1L; 
    /**
     * vita del Giocabile
     */
    private int vita;
    private int vitaMax;
    
    /**
     * danno del Giocabile
     */
    private int danno;
    private String nome;
    private ImageIcon sprite;
    private GestoreGioco gestoreGioco;
    /**
     * 
     * @param nome nome del Giocabile
     * @param path percorso dell'immagine
     * @param vita vita massima del Gioacbile
     * @param danno danno dell'attacco del Giocabile
     * @param gestoreGioco gestore del gioco, serve per effettuare gli attacchi
     */
    public Giocabile(String nome, String path, int vita, int danno, GestoreGioco gestoreGioco){
        this.nome = nome;
        this.vita = vita;
        this.vitaMax = vita;
        this.danno = danno;
        this.sprite = new ImageIcon(path);
        this.gestoreGioco = gestoreGioco;
    }
    
    public GestoreGioco getGestoreGioco(){
        return gestoreGioco;
    }
    
    /**
     * 
     * permette al Giocabile di attaccare, tramite il gestore del gioco
     */
    public abstract void attacca();

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
    
    public int getVitaMax(){
        return vitaMax;
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
        vita = Math.min(vitaMax, guadagno+vita);
    }
    
    /**
     * 
     * @param perdita vita persa
     */
    public void perdiVita(int perdita){
        vita -= perdita;
        vita = Math.max(0, vita);
        Logger.scriviLog(this.getNome() + " ha perso " + perdita + " punti vita");
    }
    
    /**
     * 
     * @return true se il Giocabile è morto
     */
    public boolean controllaMorte(){
        if(vita == 0){
            Logger.scriviLog(nome + " è morto");
            return true;
        }
        return false;
    }
    
    /**
     * consuma un OggettoConsumabile e ne controlla gli effetti
     * @param oggetto oggetto da consumare
     */
    public void consumaOggetto(OggettoConsumabile oggetto){
        if(oggetto.getTipo().equals(TipoOggettoConsumabile.CURATIVO)){
            guadagnaVita(oggetto.getStatPrincipale());
            Logger.scriviLog(this.getNome() + " ha consumato " + oggetto.getNome());
        }
    }
    
    @Override
    public Object clone(){
        try{
            return super.clone();
        }
        catch(Exception e){}
        return null;
    }
}
