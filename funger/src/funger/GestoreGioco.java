/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package funger;

import java.util.ArrayList;


/**
 *
 * @author cucchiarini.cesare
 */
public class GestoreGioco {
    private Party party;
    private Mappa mappa;
    private int[] posizione = new int[2];
    private FormMappa formMappa;
    
    public GestoreGioco(){
        GestoreFile.leggiCreabili();
    }
    
    /**
     * genera mappa e party
     * @param leader leader del party
     */
    public void inizializza(Giocatore leader){
        party = new Party(leader, this);
        mappa = GestoreMappa.generaMappa();
    }
    
    /**
     * metodo da chiamare in caso di morte del leader
     */
    public void fineGioco(){
        System.out.println("Gioco finito, ma lo devo ancora implementare");
    }
    
    /**
     * sposta il party e controlla che nessuno sia morto nel frattempo
     * @param movX spostamento orizzontale
     * @param movY spostamento verticale
     */
    public void muovi(int movX, int movY){
        for(Giocatore g : party.getGiocatori()){
            g.muovi();
            if(g.controllaMorte()){
                party.rimuoviMembro(g);
            }
            formMappa.aggiornaMappaScoperta();
        }        
    }
    
    /**
     * 
     * @return lista dei giocabili del party
     */
    public ArrayList<Giocabile> getParty(){
        return party.getPersonaggi();
    }
    
    /**
     * 
     * @return numero di membri del party
     */
    public int getGrandezzaParty(){
        return party.getPersonaggi().size();
    }
    
    public void aggiungiMembro(Giocabile membro){
        party.aggiungiMembro(membro);
    }
    
    public int getGrandezzaMappa(){
        return mappa.getRighe();
    }
    
    public TipoCella getCella(){
        return mappa.getTipoCella(posizione[0], posizione[1]);
    }
    
    public TipoCella[] getCelleAdiacenti(){
        TipoCella[] tipi = new TipoCella[5];
        tipi[0] = mappa.getTipoCella(posizione[0]+1, posizione[1]);
        tipi[1] = mappa.getTipoCella(posizione[0], posizione[1]-1);
        tipi[2] = mappa.getTipoCella(posizione[0], posizione[1]);
        tipi[3] = mappa.getTipoCella(posizione[0], posizione[1]+1);
        tipi[4] = mappa.getTipoCella(posizione[0]-1, posizione[1]);
        return tipi;
    }
    
    public int[] getPosizione(){
        return posizione;
    }
    
    public void setFormMappa(FormMappa formMappa){
        this.formMappa = formMappa;
    }
}
