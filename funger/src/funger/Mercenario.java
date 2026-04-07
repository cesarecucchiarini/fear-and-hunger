/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package funger;

import java.util.Random;

/**
 *
 * @author cucchiarini.cesare
 */
public class Mercenario extends Giocatore{

    public Mercenario(String nome, String path, int vita, int danno, GestoreGioco gestoreGioco) {
        super(nome, path, vita, danno, gestoreGioco);
    }

    @Override
    public void utilizzaAbilita() {
        if(super.getGestoreGioco().inBattaglia()){
            if(new Random().nextInt(2) == 1){
                Logger.scriviLog("il party riesce a scappare");
                super.getGestoreGioco().finisciCombattimento();
            }
        }
        else
            Logger.scriviLog("non succede niente");
    }
    
    @Override
    public void togliAbilita(){
        
    }
    
}
