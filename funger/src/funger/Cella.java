/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package funger;

/**
 *
 * @author cucchiarini.cesare
 */
public class Cella {
    public final int VISITATA = 1;
    public final int NON_VISITATA = 0;
    public final int COMPLETATA = 2;
    
    private TipoCella tipo;
    private int stato;
    private int idCreabile;
    
    /**
     * 
     * @param tipo tipo di cella
     * @param idCreabile oggetto creabile della cella, 0 se non c'è un oggetto creabile
     */
    public Cella(TipoCella tipo, int idCreabile) {
        this.tipo = tipo;
        this.idCreabile = idCreabile;
        stato = NON_VISITATA;
    }
    
    /**
     * inizializza la cella senza creabile
     * @param tipo 
     */
    public Cella(TipoCella tipo){
        this.tipo = tipo;
        this.idCreabile = 0;
        stato = NON_VISITATA;
    }
    
    /**
     * inizializza la cella come muro
     */
    public Cella(){
        this.tipo = TipoCella.MURO;
        this.idCreabile = 0;
        stato = NON_VISITATA;
    }
    
    /**
     * 
     * @return stato della cella
     */
    public int getStato(){
        return stato;
    }

    /**
     * 
     * @return id dell'oggetto nella cella
     */
    public int getIdCreabile() {
        return idCreabile;
    }

    /**
     * 
     * @return tipo della cella
     */
    public TipoCella getTipo() {
        return tipo;
    }
    
    /**
     * 
     * @param stato nuovo stato da assegnare alla cella
     */
    public void setStato(int stato){
        this.stato = stato;
        if(stato == COMPLETATA) idCreabile = 0;
    }
}
