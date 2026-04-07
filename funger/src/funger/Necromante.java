/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package funger;

/**
 *
 * @author cucchiarini.cesare
 */
public class Necromante extends Giocatore{

    public Necromante(String nome, String path, int vita, int danno, GestoreGioco gestoreGioco) {
        super(nome, path, vita, danno, gestoreGioco);
    }
    
    @Override
    public void utilizzaAbilita(){
        if(super.getGestoreGioco().inBattaglia())
            Logger.scriviLog("non succede niente");
            
        if(super.getGestoreGioco().getCreabileStanza() != null){
            if(super.getGestoreGioco().getCreabileStanza() instanceof Nemico nemico)
                super.getGestoreGioco().aggiungiMembro(nemico);
            else
                Logger.scriviLog("non succede niente");
        }
        else
            Logger.scriviLog("non succede niente");
    }
    
    @Override
    public void togliAbilita(){
        
    }
}
