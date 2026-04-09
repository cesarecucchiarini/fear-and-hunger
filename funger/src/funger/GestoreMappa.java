/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package funger;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author cucchiarini.cesare
 */
public class GestoreMappa {
    private static int grandezzaMappa = 10;
    private static Random rnd  = new Random();
    private static int[] posizioneInizio = new int[2];
    
    /**
     * 
     * @return mappa generata con inizio, fine, un percorso che porta alla fine, e stanze casuali
     */
    public static Mappa generaMappa(){
        Mappa mappa = new Mappa(grandezzaMappa);
        
        int[][] posizioni = inizializzaMappa(mappa);
        
        posizioneInizio = posizioni[0];
        int[] posInizio = posizioni[0];
        int[] posFine = posizioni[1];
        
        ArrayList<int[]> celle = generaPercorso(mappa, posInizio, posFine);
        
        generaCelleCasuali(mappa, celle);
        
        return mappa;
    }
    
    /**
     * 
     * @param mappa mappa da inizializzare
     * @return posizioni di inizio e fine
     */
    public static int[][] inizializzaMappa(Mappa mappa){
        int[] posInizio = {rnd.nextInt(grandezzaMappa), rnd.nextInt(grandezzaMappa)};
        mappa.aggiungiCella(new Cella(TipoCella.INIZIO), posInizio[0], posInizio[1]);
        
        int[] posFine = {rnd.nextInt(grandezzaMappa), rnd.nextInt(grandezzaMappa)};
        while((Math.abs(posInizio[0] - posFine[0]) + Math.abs(posInizio[1] - posFine[1])) < 6){
            posFine = new int[] {rnd.nextInt(grandezzaMappa), rnd.nextInt(grandezzaMappa)};
        }
        mappa.aggiungiCella(new Cella(TipoCella.FINE), posFine[0], posFine[1]);
        
        return new int[][] {posInizio, posFine};
    }
    
    /**
     * 
     * @param mappa mappa da modificare
     * @param posInizio posizione dell'inizio
     * @param posFine posizione della fine
     * @return celle aggiunte
     */
    public static ArrayList<int[]> generaPercorso(Mappa mappa, int[] posInizio, int[] posFine){
        ArrayList<int[]> celle = new ArrayList<>();
        celle.add(posInizio);
        celle.add(posFine);
        int[] posAttuale = posInizio;
        
        while((Math.abs(posAttuale[0] - posFine[0]) + Math.abs(posAttuale[1] - posFine[1])) != 1){
            if((posAttuale[0] - posFine[0] != 0)) 
                posAttuale = new int[] {posAttuale[0] + ((posAttuale[0] - posFine[0]) < 0 ? 1 : -1), posAttuale[1]};
            else
                posAttuale = new int[] {posAttuale[0], posAttuale[1] + ((posAttuale[1] - posFine[1]) < 0 ? 1 : -1)};
            
            mappa.aggiungiCella(generaCellaCasuale(false), posAttuale[0], posAttuale[1]);
            celle.add(posAttuale);
        }
        
        return celle;
    }
    
    /**
     * 
     * @param mappa mappa a per cui generare le celle
     * @param celle celle mappate
     */
    public static void generaCelleCasuali(Mappa mappa, ArrayList<int[]> celle){
        ArrayList<int[]> celleNuove = new ArrayList<>();
        
        for(int[] pos : celle){
            celleNuove.addAll(generaCelleAdiacenti(mappa, pos[0], pos[1]));
        }
        
        if(!celleNuove.isEmpty())
            generaCelleCasuali(mappa, celleNuove);
    }
    
    /**
     * genera 4 celle adiacenti alla cella passata
     * @param mappa mappa da modificare
     * @param x ascissa della cella
     * @param y ordinata della cella
     * @return posizioni delle celle create
     */
    public static ArrayList<int[]> generaCelleAdiacenti(Mappa mappa, int x, int y){
        ArrayList<int[]> celleCreate = new ArrayList<>();
        Cella c;
        
        if(!mappa.cellaInizializzata(x+1, y)){
            c = generaCellaCasuale(true);
            mappa.aggiungiCella(c, x+1, y);
            if(!c.getTipo().equals(TipoCella.MURO))
                celleCreate.add(new int[]{x+1, y});
        }
        if(!mappa.cellaInizializzata(x-1, y)){
            c = generaCellaCasuale(true);
            mappa.aggiungiCella(c, x-1, y);
            if(!c.getTipo().equals(TipoCella.MURO))
                celleCreate.add(new int[]{x-1, y});
        }
        if(!mappa.cellaInizializzata(x, y+1)){
            c = generaCellaCasuale(true);
            mappa.aggiungiCella(c, x, y+1);
            if(!c.getTipo().equals(TipoCella.MURO))
                celleCreate.add(new int[]{x, y+1});
        }
        if(!mappa.cellaInizializzata(x, y-1)){
            c = generaCellaCasuale(true);
            mappa.aggiungiCella(c, x, y-1);
            if(!c.getTipo().equals(TipoCella.MURO))
                celleCreate.add(new int[]{x, y-1});
        }
        
        return celleCreate;
    }
    
    /**
     *  
     * @return cella creata casualmente
     */
    public static Cella generaCellaCasuale(boolean muro){
        Cella c;
        int tipoCella = rnd.nextInt(muro ? 0 : 1, 3);
        switch(tipoCella){
            default -> {c = new Cella();}
            case 1 -> {c = new Cella(TipoCella.VUOTO);}
            case 2 -> {c = new Cella(TipoCella.PIENO, GestoreCreabili.getRandomIdCreabile(true));}
        }
        
        return c;
    }
    
    public static int[] getPosizioneInizio(){
        return posizioneInizio;
    }
}
