/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package funger;

/**
 *
 * @author cucchiarini.cesare
 */
public abstract class Giocatore extends Giocabile implements Creabile{
    private int fame;
    private int mente;
    private OggettoEquipaggiabile oggettoOffensivo = null;
    private OggettoEquipaggiabile oggettoDifensivo = null;

    public Giocatore(String nome, String path, int vita, int danno, GestoreGioco gestoreGioco) {
        super(nome, path, vita, danno, gestoreGioco);
        this.fame = 100;
        this.mente = 100;
    }

    @Override
    public void attacca(){
    }
    
    public void guardia(){
        
    }
    
    /**
     * 
     * il danno viene diminuito dalla stat dell'oggetto difensivo
     */
    @Override
    public void perdiVita(int perdita){
        super.perdiVita(Math.max(0, perdita - (oggettoDifensivo != null ? oggettoDifensivo.getStatPrincipale() : 0)));
    }
    
    /**
     * abilita del Giocatore
     */
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
    
    /**
     * 
     * @param perdita mente persa
     */
    public void perdiMente(int perdita){
        mente = Math.max(0, mente - perdita);
    }
    
    /**
     * 
     * @param guadagno mente guadagnata
     */
    public void guadagnaMente(int guadagno){
        mente = Math.min(100, mente+guadagno);
    }
    
    /**
     * 
     * @param perdita fame persa
     */
    public void perdiFame(int perdita){
        fame = Math.max(0, fame - perdita);
    }
    
    /**
     * 
     * @param guadagno fame guadagnata
     */
    public void guadagnaFame(int guadagno){
        fame = Math.min(100, fame+guadagno);
    }
    
    /**
     * 
     * @param oggetto
     * @return ritorna l'OggettoEquipaggiabile appena tolto
     */
    public OggettoEquipaggiabile setOggettoEquipaggiabile(OggettoEquipaggiabile oggetto){
        OggettoEquipaggiabile t;
        if(oggetto.getTipo().equals(TipoOggettoEquipaggiabile.DIFENSIVO)){
            t = oggettoDifensivo;
            oggettoDifensivo = oggetto;
        }
        else{
            t = oggettoOffensivo;
            oggettoOffensivo = oggetto;
        }
        return t;
    }

    /**
     * 
     * @return oggetto equipaggiabile offensivo
     */
    public OggettoEquipaggiabile getOggettoOffensivo() {
        return oggettoOffensivo;
    }

    /**
     * 
     * @return oggetto equipaggiabile difensivo
     */
    public OggettoEquipaggiabile getOggettoDifensivo() {
        return oggettoDifensivo;
    }
    
    @Override
    public void consumaOggetto(OggettoConsumabile oggetto){
        switch(oggetto.getTipo()){
            case TipoOggettoConsumabile.CURATIVO -> {guadagnaVita(oggetto.getStatPrincipale());}
            case TipoOggettoConsumabile.COMMESTIBILE -> {guadagnaFame(oggetto.getStatPrincipale());}
            case TipoOggettoConsumabile.MENTALE -> {guadagnaMente(oggetto.getStatPrincipale());}
        }
    }
}
