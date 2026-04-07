/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package funger;

import java.util.ArrayList;

/**
 *
 * @author sergi
 */
public class GestoreCombattimento {
    private GestoreGioco gestoreGioco;
    private ArrayList<Giocabile> party;
    private Nemico nemico;
    private Giocabile giocabileCorrente;
    private int indiceCorrente;
    private boolean combattimento;

    public GestoreCombattimento(GestoreGioco gestoreGioco) {
        this.gestoreGioco = gestoreGioco;
    }
    
    public void iniziaCombattimento(ArrayList<Giocabile> party, Nemico nemico){
        this.party = party;
        this.nemico = nemico;
        combattimento = true;
        indiceCorrente = 0;
        this.giocabileCorrente = party.get(indiceCorrente);
        
        
        GestoreForm.apriCombattimento();   
    }
    
    public void finisciCombattimento(){
        combattimento = false;
    }
    
    public boolean controllaFineCombattimento(){
        if(!combattimento){
            nemico = null;
            gestoreGioco.finisciAbilita();
            GestoreForm.chiudiCombattimento();
            return true;
        }
        if(nemico.controllaMorte()){
            nemico = null;
            gestoreGioco.finisciAbilita();
            GestoreForm.chiudiCombattimento();
            return true;
        }
        
        if(party.get(0).controllaMorte()){
            nemico = null;
            gestoreGioco.finisciAbilita();
            GestoreForm.chiudiGioco();
            return true;
        }
        
        return false;
    }
    
    public void cambiaTurno(){
        indiceCorrente++;
        if(indiceCorrente % (party.size()+1) == party.size()){
            giocabileCorrente = nemico;
            indiceCorrente = -1;
        }
        else{
            giocabileCorrente = party.get(indiceCorrente);
        }
        controllaAttacco();
    }

    public void controllaAttacco(){
        if(!(giocabileCorrente instanceof Giocatore)){
            giocabileCorrente.attacca();
            GestoreForm.aggiornaProgressBars();
            if(!controllaFineCombattimento())
                cambiaTurno();
        }
        else{
            if(giocabileCorrente instanceof Vichingo vichingo){
                if(vichingo.furia()){
                    vichingo.attaccoSpeciale();
                    cambiaTurno();
                }
                else
                    vichingo.togliGuardia();
            }
            else
                ((Giocatore)giocabileCorrente).togliGuardia();
        }
    }
    
    public ArrayList<Giocabile> getParty() {
        return party;
    }

    public Nemico getNemico() {
        return nemico;
    }
    
    public Giocabile getGiocabileCorrente(){
        return giocabileCorrente;
    }

    public boolean inBattaglia() {
        return nemico != null;
    }
}
