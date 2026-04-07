/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package funger;

/**
 *
 * @author cucchiarini.cesare
 */
public class Ragazza extends Giocatore{

    private boolean abilita = false;
    
    public Ragazza(String nome, String path, int vita, int danno, GestoreGioco gestoreGioco) {
        super(nome, path, vita, danno, gestoreGioco);
    }
    
    @Override
    public void utilizzaAbilita() {
        if(super.getGestoreGioco().inBattaglia()){
            Logger.scriviLog(this.getNome() + " attira i nemici");
            abilita = true;
        }
        else
            Logger.scriviLog("non succede niente");
    }
    
    @Override
    public void togliAbilita(){
        abilita = false;
    }
    
    public boolean abilitaAttiva(){
        return abilita;
    }
    
}
