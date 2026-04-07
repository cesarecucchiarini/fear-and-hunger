/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package funger;

/**
 *
 * @author cucchiarini.cesare
 */
public class Vichingo extends Giocatore{

    private int counter = 0;
    
    public Vichingo(String nome, String path, int vita, int danno, GestoreGioco gestoreGioco) {
        super(nome, path, vita, danno, gestoreGioco);
    }

    @Override
    public void utilizzaAbilita() {
        if(super.getGestoreGioco().inBattaglia()){
            Logger.scriviLog(this.getNome() +" va in furia barbarica");
            counter = 3;
        }
        else
            Logger.scriviLog("non succede niente");
    }
    
    public void attaccoSpeciale(){
        Logger.scriviLog(this.getNome() + " fa un attacco potente da infuriato");
        int dannoInput = super.getDanno() + (super.getOggettoOffensivo() != null ? super.getOggettoOffensivo().getStatPrincipale() : 0);
        dannoInput *= 2;
        super.getGestoreGioco().attacca(dannoInput, super.getGestoreGioco().getNemico());
        counter--;
    }
    
    public boolean furia(){
        return counter > 0;
    }
    
    @Override
    public void togliAbilita(){
        counter = 0;
    }
}
