/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package funger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

/**
 *
 * @author cucchiarini.cesare
 */
public class GestoreMappa {
    private static int grandezzaMappa = 10;
    private static Random rnd  = new Random();
    
    /**
     * 
     * @return mappa generata con inizio, fine, un percorso che porta alla fine, e stanze casuali
     */
    public static Mappa generaMappa(){        
        Mappa mappa = new Mappa(grandezzaMappa);
        
        int[][] posizioni = inizializzaMappa(mappa);
        
        int[] posInizio = posizioni[0];
        int[] posFine = posizioni[1];
        
        generaPercorso(mappa, posInizio, posFine);
        
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
     */
    public static void generaPercorso(Mappa mappa, int[] posInizio, int[] posFine){
        int[] posAttuale = posInizio;
        while((Math.abs(posAttuale[0] - posFine[0]) + Math.abs(posAttuale[1] - posFine[1])) != 1){
            if((posAttuale[0] - posFine[0] != 0)) 
                posAttuale = new int[] {posAttuale[0] + ((posAttuale[0] - posFine[0]) < 0 ? 1 : -1), posAttuale[1]};
            else
                posAttuale = new int[] {posAttuale[0], posAttuale[1] + ((posAttuale[1] - posFine[1]) < 0 ? 1 : -1)};
            
            mappa.aggiungiCella(new Cella(TipoCella.VUOTO), posAttuale[0], posAttuale[1]);
        }
    }
    
    /**
     * 
     * @param mappa mappa a per cui generare le celle
     */
    public static void generaCelleCasuali(Mappa mappa, int[] posInizio, int[] posFine){
        int numCelle = (grandezzaMappa * grandezzaMappa) - (Math.abs(posInizio[0] - posFine[0]) + Math.abs(posInizio[1] - posFine[1])) +1;
        TipoCella tipo;
        int idCreabile;
        for(int i = 0; i < numCelle; i++){
            mappa.aggiungiCella(new Cella());
        }
    }
}
