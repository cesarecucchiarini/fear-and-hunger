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
public abstract class Nemico extends Giocabile implements Creabile{

    public Nemico(String nome, String path, int vita, int danno, GestoreGioco gestoreGioco) {
        super(nome, path, vita, danno, gestoreGioco);
    }
    
    public Giocabile getObbiettivo(){
        if(super.getGestoreGioco().getNemico() == this)
            return super.getGestoreGioco().getParty().get(new Random().nextInt(super.getGestoreGioco().getGrandezzaParty()));
        else
            return super.getGestoreGioco().getNemico();
    }
}
