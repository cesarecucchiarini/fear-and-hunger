/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package funger;

/**
 *
 * @author cucchiarini.cesare
 */
public class GestoreGioco {
    Party party;
    
    /**
     * 
     * @param leader leader del party
     */
    public GestoreGioco(Giocatore leader){
        party = new Party(leader, this);
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
