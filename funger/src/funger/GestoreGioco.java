/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package funger;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;


/**
 *
 * @author cucchiarini.cesare
 */
public class GestoreGioco implements Serializable{
    private static final long serialVersionUID = 1L;
    private Party party;
    private Mappa mappa;
    private int[] posizione = new int[2];
    private boolean movimentoPossibile = true;
    private Creabile creabileStanza;
    private GestoreCombattimento gestoreCombattimento;
    
    public GestoreGioco(){
        GestoreFile.setGestoreGioco(this);
        GestoreFile.leggiCreabili();
        GestoreInput.setGestoreGioco(this);
        gestoreCombattimento = new GestoreCombattimento(this);
        Logger.creaTextArea();
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
        GestoreForm.morte();
    }
    
    /**
     * sposta il party e controlla che nessuno sia morto nel frattempo
     * @param movX spostamento orizzontale
     * @param movY spostamento verticale
     */
    public void muovi(int movX, int movY){
        creabileStanza = null;
        if(!mappa.getTipoCella(posizione[0] + movX, posizione[1] + movY).equals(TipoCella.MURO) && movimentoPossibile){
            for(Giocatore g : party.getGiocatori()){
                g.perdiFame(3);
                g.perdiMente(3);
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
        if(mappa.getTipoCella(posizione[0], posizione[1]).equals(TipoCella.FINE))
            GestoreForm.vittoria();
    }
    
    /**
     * 
     * @return lista dei giocabili del party
     */
    public ArrayList<Giocabile> getParty(){
        return party.getPersonaggi();
    }
    
    public ArrayList<Giocatore> getGiocatori(){
        return party.getGiocatori();
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
            else if(creabileStanza instanceof Oggetto){
                aggiungiOggetto((Oggetto)creabileStanza);
            }
            else if(creabileStanza instanceof Giocabile){
                aggiungiMembro((Giocabile) creabileStanza);
            }
            
            mappa.setStatoCella(posizione[0], posizione[1], Cella.COMPLETATA);
            movimentoPossibile = true;
            creabileStanza = null;
            GestoreForm.aggiornaPanelGioco();
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

    public int getStatoCella() {
        return mappa.getStatoCella(posizione[0], posizione[1]);
    }
    
    public ArrayList<Oggetto> getOggetti(){
        return party.getOggetti();
    }

    public void rimuoviOggetto(Oggetto oggetto) {
        party.rimuoviOggetto(oggetto);
        GestoreForm.aggiornaInventario();
    }
    
    public void aggiungiOggetto(Oggetto oggetto){
        party.aggiungiOggetto(oggetto);
        GestoreForm.aggiornaInventario();
    }

    public void consumaOggetto(OggettoConsumabile oggetto, Giocabile g){
        g.consumaOggetto(oggetto);
        rimuoviOggetto(oggetto);
        GestoreForm.aggiornaInventario();
    }
    
    public void consumaOggetto(OggettoConsumabile oggetto, Giocatore g) {
        g.consumaOggetto(oggetto);
        rimuoviOggetto(oggetto);
        GestoreForm.aggiornaInventario();
    }

    public void equipaggiaOggetto(OggettoEquipaggiabile oggetto, Giocatore g) {
        party.cambiaOggetto(g, oggetto);
        Logger.scriviLog(g.getNome() + " ha equipaggiato " + oggetto.getNome());
        GestoreForm.aggiornaInventario();
    }
    
    public Giocatore getLeader(){
        if(party.getPersonaggi().isEmpty()) 
            return null;
        return (Giocatore) party.getPersonaggi().getFirst();
    }
    
    public Giocabile getNemico(){
        return gestoreCombattimento.getNemico();
    }
    
    public boolean inBattaglia(){
        return gestoreCombattimento.inBattaglia();
    }

    public void finisciCombattimento() {
        gestoreCombattimento.finisciCombattimento();
    }
    
    public void finisciAbilita(){
        for(Giocatore g : party.getGiocatori()){
            g.togliAbilita();
        }
    }
    
    public void finisciGuardia(){
        for(Giocatore g : party.getGiocatori()){
            g.togliGuardia();
        }
    }
    
    public Giocabile getObbiettivoRandom(){
        for(Giocatore g : party.getGiocatori()){
            if(g instanceof Ragazza r){
                if(r.abilitaAttiva())
                    return r;
            }
        }
        
        return party.getPersonaggi().get(new Random().nextInt(getGrandezzaParty()));
    }
}
