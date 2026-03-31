/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package funger;

import javax.swing.JFrame;

/**
 *
 * @author cucchiarini.cesare
 */
public class GestoreForm {
    private static JFrame form;
    private static GestoreGioco gestoreGioco = new GestoreGioco();
    
    public static void sceltaPersonaggio(){
        form = new FormScelta(gestoreGioco);
    }
    
    public static void iniziaGioco(){
        form.dispose();
        form = new FormGioco(gestoreGioco);
    }
}
