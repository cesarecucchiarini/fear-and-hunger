/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package funger;

import java.util.HashMap;

/**
 *
 * @author cucchiarini.cesare
 */
public class Funger {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*
        HashMap<Integer, Creabile> mappa = GestoreFile.leggiCreabili();
        Mappa m = GestoreMappa.generaMappa(mappa.keySet().toArray(new Integer[mappa.size()]));
        for(Cella[] riga : m.getGriglia(true)){
            for(Cella c : riga){
                /*
                if(c == null) System.out.print(" ");
                else
                    switch(c.getTipo()){
                        case TipoCella.INIZIO -> {System.out.print("I");}
                        case TipoCella.FINE -> {System.out.print("F");}
                        case TipoCella.MURO -> {System.out.print("#");}
                        case TipoCella.VUOTO -> {System.out.print("V");}
                        case TipoCella.PIENO -> {System.out.print("P");}
                    }
                
                
                if(c != null){
                    if(c.getTipo().equals(TipoCella.PIENO) && c.getIdCreabile() != 0)
                        System.out.println(mappa.get(c.getIdCreabile()).getClass().getCanonicalName());
                }
            }
            System.out.print("\n");
        }
    }
    */
        OggettoConsumabile og = new OggettoConsumabile("a", "a", 0, TipoOggettoConsumabile.COMMESTIBILE);
        System.out.print(og.getClass().getName() + "\n" + og.getClass().getCanonicalName() + "\n" + og.getClass().getSimpleName());
    } 
}
