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
public class Party {
    ArrayList<Giocabile> personaggi = new ArrayList<>();
    GestoreGioco gestoreGioco;
    
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
        if(personaggi.size() < 4) personaggi.add(giocabile);
    }
    
    /**
     * 
     * @param giocabile membro morto da rimuovere
     */
    public void rimuoviMembro(Giocabile giocabile){
        //logica in caso di morte del leader
        if(giocabile.equals(personaggi.get(0))){
            gestoreGioco.fineGioco();
        }
        personaggi.remove(giocabile);
    }

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
    
}
