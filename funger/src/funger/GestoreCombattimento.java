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

    public GestoreCombattimento(GestoreGioco gestoreGioco) {
        this.gestoreGioco = gestoreGioco;
    }
    
    public void iniziaCombattimento(ArrayList<Giocabile> party, Nemico nemico){
        this.party = party;
        this.nemico = nemico;
        this.giocabileCorrente = party.get(0);
        
        GestoreForm.apriCombattimento();   
    }
    
    public boolean controllaFineCombattimento(){
        if(nemico.controllaMorte() || party.get(0).controllaMorte()){
            GestoreForm.chiudiCombattimento();
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
            if(!controllaFineCombattimento())
                cambiaTurno();
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
}
