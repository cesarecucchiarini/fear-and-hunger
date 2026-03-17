/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package funger;

/**
 *
 * @author cucchiarini.cesare
 */
public abstract class Giocatore extends Giocabile{
    private int fame;
    private int mente;

    public Giocatore(int fame, int mente, int vita, int danno, String path) {
        super(vita, danno, path);
        this.fame = fame;
        this.mente = mente;
    }
    
    //da modificare con l'aggiunta di oggetti
    @Override
    public int attacca(){
        return getDanno();
    }
    
    public abstract void utilizzaAbilita();
    
    /**
     * perdita di fame e mente durante lo spostamento
     */
    public void muovi(){
        perdiFame(10);
        perdiMente(10);
    }
    
    /**
     * 
     * @return ritorna true se il Giocatore è morto
     */
    @Override
    public boolean controllaMorte(){
        return super.controllaMorte() || fame == 0 || mente == 0;
    }
    
    public void perdiMente(int perdita){
        mente = Math.max(0, mente - perdita);
    }
    
    public void guadagnaMente(int guadagno){
        mente = Math.min(100, mente+guadagno);
    }
    
    public void perdiFame(int perdita){
        fame = Math.max(0, fame - perdita);
    }
    
    public void guadagnaFame(int guadagno){
        fame = Math.min(100, fame+guadagno);
    }
}
