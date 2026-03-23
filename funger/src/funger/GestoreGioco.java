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
    private HashMap<Integer, Creabile> mappaCreabili;
    private Party party;
    private Mappa mappa;
    
    /**
     * 
     * @param leader leader del party
     */
    public GestoreGioco(Giocatore leader){
        party = new Party(leader, this);
        mappaCreabili = GestoreFile.leggiCreabili();
        mappa = GestoreMappa.generaMappa(mappaCreabili.keySet().toArray(new Integer[mappaCreabili.size()]));
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
