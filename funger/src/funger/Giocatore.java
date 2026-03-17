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
    private OggettoEquipaggiabile oggettoOffensivo = null;
    private OggettoEquipaggiabile oggettoDifensivo = null;

    public Giocatore(String nome, String path) {
        super(nome, path);
        this.fame = 100;
        this.mente = 100;
    }
    
    /**
     * 
     * il danno viene aumentato dalla stat dell'oggetto offensivo
     */
    @Override
    public int attacca(){
        return getDanno() + (oggettoOffensivo != null ? oggettoOffensivo.getStatPrincipale() : 0);
    }
    
    /**
     * 
     * il danno viene diminuito dalla stat dell'oggetto difensivo
     */
    @Override
    public void perdiVita(int perdita){
        super.perdiVita(Math.max(0, perdita - (oggettoDifensivo != null ? oggettoDifensivo.getStatPrincipale() : 0)));
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
