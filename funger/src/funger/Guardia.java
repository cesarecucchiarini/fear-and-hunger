/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package funger;

/**
 *
 * @author cucchiarini.cesare
 */
public class Guardia extends Nemico{

    public Guardia(String nome, String path, int vita, int danno, GestoreGioco gestoreGioco) {
        super(nome, path, vita, danno, gestoreGioco);
    }
        
    
    @Override
    public void attacca(){
        Giocabile obbiettivo = super.getObbiettivo();
        super.getGestoreGioco().attacca(super.getDanno(), obbiettivo);
        
        if(!super.getGestoreGioco().getGestoreCombattimento().controllaFineCombattimento()){
            if(!obbiettivo.controllaMorte())
                super.getGestoreGioco().attacca(super.getDanno() / 2, obbiettivo);
            else
                super.getGestoreGioco().attacca(super.getDanno() / 2, super.getObbiettivo());
        }
    }    
}
