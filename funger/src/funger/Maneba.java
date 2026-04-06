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
public class Maneba extends Nemico{

    public Maneba(String nome, String path, int vita, int danno, GestoreGioco gestoreGioco) {
        super(nome, path, vita, danno, gestoreGioco);
    }
    
    
    @Override
    public void attacca(){
        Random rnd = new Random();
        for(int i = 0; i < 3; i++){
            if(rnd.nextInt(2) == 1){
                super.getGestoreGioco().attacca(super.getDanno(), getObbiettivo());
            }
        }
    }


    
    
}
