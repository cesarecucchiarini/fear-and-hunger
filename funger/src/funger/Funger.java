/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package funger;

/**
 *
 * @author cucchiarini.cesare
 */
public class Funger {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Mappa m = GestoreMappa.generaMappa();
        for(Cella[] riga : m.getGriglia(true)){
            for(Cella c : riga){
                if(c == null) System.out.print("O");
                else
                    switch(c.getTipo()){
                        case TipoCella.INIZIO -> {System.out.print("I");}
                        case TipoCella.FINE -> {System.out.print("F");}
                        case TipoCella.MURO -> {System.out.print("#");}
                        case TipoCella.VUOTO -> {System.out.print("V");}
                    }
            }
            System.out.print("\n");
        }
    }
    
}
