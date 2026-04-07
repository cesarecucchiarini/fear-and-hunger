/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package funger;

/**
 *
 * @author cucchiarini.cesare
 */
public class Trotur extends Nemico{

    public Trotur(String nome, String path, int vita, int danno, GestoreGioco gestoreGioco) {
        super(nome, path, vita, danno, gestoreGioco);
    }
      
    
    @Override
    public void attacca(){
        Giocabile obbiettivo = super.getObbiettivo();
        Logger.scriviLog(this.getNome() + " ha attaccato " + obbiettivo.getNome());
        super.getGestoreGioco().attacca(super.getDanno(), obbiettivo);       
    }



    
}
