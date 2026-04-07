/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package funger;

/**
 *
 * @author cucchiarini.cesare
 */
public class Moonless extends Giocatore{

    public Moonless(String nome, String path, int vita, int danno, GestoreGioco gestoreGioco) {
        super(nome, path, vita, danno, gestoreGioco);
    }
    
    @Override
    public void utilizzaAbilita() {
        if(super.getGestoreGioco().inBattaglia()){
            Logger.scriviLog(this.getNome() + " fa un attacco potente");
            attaccoPotente();
        }
        else{
            Logger.scriviLog("non succede niente");
        }
    }
    
    public void attaccoPotente(){
        int dannoInput = super.getDanno() + (super.getOggettoOffensivo() != null ? super.getOggettoOffensivo().getStatPrincipale() : 0);
        dannoInput *= 1.5;
        super.getGestoreGioco().attacca(dannoInput, super.getGestoreGioco().getNemico());
    }
    
    @Override
    public void togliAbilita(){
        
    }
    
}
