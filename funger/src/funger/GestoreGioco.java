/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package funger;

import java.util.HashMap;

/**
 *
 * @author cucchiarini.cesare
 */
public class GestoreGioco {
    private Party party;
    private Mappa mappa;
    
    public GestoreGioco(){
    }
    
    /**
     * genera mappa e party
     * @param leader leader del party
     */
    public void inizializza(Giocatore leader){
        party = new Party(leader, this);
        mappa = GestoreMappa.generaMappa(this);
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
        }        
    }
}
