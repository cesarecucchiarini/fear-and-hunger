/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package funger;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author cucchiarini.cesare
 */
public class Party implements Serializable{
    private static final long serialVersionUID = 1L; 
    private ArrayList<Giocabile> personaggi = new ArrayList<>();
    private GestoreGioco gestoreGioco;
    private Inventario inventario = new Inventario();
    
    /**
     * 
     * @param leader leader del party
     * @param gestoreGioco gestore da utilizzare per scrivere i log
     */
    public Party(Giocatore leader, GestoreGioco gestoreGioco){
        personaggi.add(leader);
        this.gestoreGioco = gestoreGioco;
    }
    
    /**
     * 
     * se il team è troppo grande semplicemente il Giocabile non viene accettato
     * @param giocabile membro da aggiungere
     */
    public void aggiungiMembro(Giocabile giocabile){
        if(personaggi.size() < 4){
            personaggi.add(giocabile);
            Logger.scriviLog(giocabile.getNome() + " si unisce al party");
        }
        else{
            Logger.scriviLog(giocabile.getNome() + " non può unirsi al party");
        }
    }
    
    /**
     * rimuove il membro morto e finisce il gioco in caso il membro morto sia il leader
     * @param giocabile membro morto da rimuovere
     */
    public void rimuoviMembro(Giocabile giocabile){
        Logger.scriviLog(giocabile.getNome() + " è morto");
        if(giocabile.equals(personaggi.get(0))){
            gestoreGioco.fineGioco();
        }
        personaggi.remove(giocabile);
    }

    /**
     * 
     * @return lista dei personaggi del party
     */
    public ArrayList<Giocabile> getPersonaggi(){
        return personaggi;
    }
    
    /**
     * 
     * @return personaggi filtrati per ottenere solo i Giocatore
     */
    public ArrayList<Giocatore> getGiocatori(){
        ArrayList<Giocatore> temp = new ArrayList<>();
        
        for(Giocabile g : personaggi){
            if(g instanceof Giocatore) temp.add((Giocatore) g);
        }
        return temp;
    }
    
    /**
     * 
     * @return lista di OggettoConsumabile nell'inventario
     */
    public ArrayList<OggettoConsumabile> getOggettiConsumabili(){
        return inventario.getOggettiConsumabili();
    }
    
    /**
     * 
     * @return lista di OggettoEquipaggiabile nell'inventario
     */
    public ArrayList<OggettoEquipaggiabile> getOggettiEquipaggiabili(){
        return inventario.getOggettiEquipaggiabili();
    }
    
    /**
     * 
     * @param oggetto oggetto da aggiungere all'inventario
     */
    public void aggiungiOggetto(Oggetto oggetto){
        inventario.aggiungiOggetto(oggetto);
    }
    
    /**
     * scambia un OggettoEquipaggiabile del Giocatore con uno nell'inventario
     * @param giocatore giocatore a cui assegnare l'oggetto
     * @param oggetto oggetto da assegnare
     * 
     */
    public void cambiaOggetto(Giocatore giocatore, OggettoEquipaggiabile oggetto){
        inventario.rimuoviOggetto(oggetto);
        inventario.aggiungiOggetto(giocatore.setOggettoEquipaggiabile(oggetto));
    }
        
    /**
     * 
     * @param giocabile Giocabile su cui utilizzare l'OggettoConsumabile
     * @param oggetto OggettoConsumabile da utilizzare
     */
    public void usaOggetto(Giocabile giocabile, OggettoConsumabile oggetto){
        giocabile.consumaOggetto(oggetto);
    }
    
    public ArrayList<Oggetto> getOggetti(){
        return inventario.getOggetti();
    }

    public void rimuoviOggetto(Oggetto oggetto) {
        inventario.rimuoviOggetto(oggetto);
    }
}
