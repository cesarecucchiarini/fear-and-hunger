/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package funger;

/**
 *
 * @author cucchiarini.cesare
 */
public class Cavaliere extends Giocatore{

    private boolean superGuardia = false;
    
    public Cavaliere(String nome, String path, int vita, int danno, GestoreGioco gestoreGioco) {
        super(nome, path, vita, danno, gestoreGioco);
    }
    
    @Override
    public void utilizzaAbilita() {
        if(super.getGestoreGioco().inBattaglia()){
            Logger.scriviLog(this.getNome() + " si difende");
            superGuardia = true;
        }
        else
            Logger.scriviLog("non succede niente");
    }
    
    @Override
    public void togliAbilita(){
    }
    
    @Override
    public void togliGuardia(){
        superGuardia = false;
        togliGuardia();
    }
    
    @Override
    public void perdiVita(int perdita){
        if(superGuardia){
            superGuardia = false;
            Logger.scriviLog(this.getNome() + " non subisce danni");
        }
        else{
            super.perdiVita(perdita);
        }
    }
}
