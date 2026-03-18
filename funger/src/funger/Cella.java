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

    public Cella(TipoCella tipo, int idCreabile) {
        this.tipo = tipo;
        this.idCreabile = idCreabile;
        stato = NON_VISITATA;
    }
    
    /**
     * 
     * @return tipo della cella, id dell'oggetto nella cella, stato della cella
     */
    public int[] getInfos(){
        return new int[]{tipo.ordinal(), idCreabile, stato};
    }
    
    public void setStato(int stato){
        this.stato = stato;
        if(stato == COMPLETATA) idCreabile = 0;
    }
}
