/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package funger;

/**
 *
 * @author cucchiarini.cesare
 */
public class Demonchild extends Giocatore{

    public Demonchild(String nome, String path, int vita, int danno, GestoreGioco gestoreGioco) {
        super(nome, path, vita, danno, gestoreGioco);
    }

    @Override
    public void utilizzaAbilita() {
        this.guadagnaFame(10);
        this.guadagnaMente(10);
        this.guadagnaVita(10);
    }
    
    @Override public void togliAbilita(){
        
    }
    
}
