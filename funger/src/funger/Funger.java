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
        Mappa m = new Mappa(3);
        for(Cella[] riga : m.getGriglia(true)){
            for(Cella c : riga){
                System.out.print(c != null ? "*" : "o");
            }
            System.out.print("\n");
        }
    }
    
}
