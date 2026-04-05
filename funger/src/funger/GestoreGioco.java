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
    private boolean movimentoPossibile = true;
    private Creabile creabileStanza;
    private GestoreCombattimento gestoreCombattimento;
    
    public GestoreGioco(){
        GestoreFile.leggiCreabili();
        GestoreInput.setGestoreGioco(this);
        gestoreCombattimento = new GestoreCombattimento(this);
    }
    
    /**
     * genera mappa e party
     * @param leader leader del party
     */
    public void inizializza(Giocatore leader){
        party = new Party(leader, this);
        mappa = GestoreMappa.generaMappa();
        posizione = GestoreMappa.getPosizioneInizio();
        mappa.setStatoCella(posizione[0], posizione[1], Cella.COMPLETATA);
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
        if(!mappa.getTipoCella(posizione[0] + movX, posizione[1] + movY).equals(TipoCella.MURO) && movimentoPossibile){
            for(Giocatore g : party.getGiocatori()){
                g.muovi();
                if(g.controllaMorte()){
                    party.rimuoviMembro(g);
                }
            }
            posizione[0] += movX;
            posizione[1] += movY;
            if(mappa.getStatoCella(posizione[0], posizione[1]) == Cella.NON_VISITATA)
                mappa.setStatoCella(posizione[0], posizione[1], Cella.VISITATA);
            GestoreForm.aggiornaGrigliaMappa();
            controllaStanza();
        }
    }
    
    public void controllaStanza(){
        if(mappa.getTipoCella(posizione[0], posizione[1]).equals(TipoCella.PIENO) 
                && mappa.getStatoCella(posizione[0], posizione[1]) != Cella.COMPLETATA){
            
            creabileStanza = GestoreCreabili.getCreabile(mappa.getIdCreabileCella(posizione[0], posizione[1]));
            GestoreForm.chiudiMappa();
            if(creabileStanza instanceof Nemico)
                movimentoPossibile = false;
        }
        GestoreForm.aggiornaPanelGioco();
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
    
    public int[] getPosizione(){
        return posizione;
    }
    
    public void setFormMappa(FormMappa formMappa){
        this.formMappa = formMappa;
    }
    
    public int getX(){
        return posizione[0];
    }
    
    public int getY(){
        return posizione[1];
    }
    
    public Mappa getMappa(){
        return mappa;
    }

    public void interagisci() {
        if(mappa.getStatoCella(posizione[0], posizione[1]) != Cella.COMPLETATA){
            if(creabileStanza instanceof Nemico)
                gestoreCombattimento.iniziaCombattimento(party.getPersonaggi(), (Nemico) creabileStanza);
            mappa.setStatoCella(posizione[0], posizione[1], Cella.COMPLETATA);
            movimentoPossibile = true;
        }
    }

    public GestoreCombattimento getGestoreCombattimento() {
        return gestoreCombattimento;
    }

    public Creabile getCreabileStanza() {
        return creabileStanza;
    }
    
    public void attacca(int dannoInput, Giocabile obbiettivo){
        obbiettivo.perdiVita(dannoInput);
    }
}
