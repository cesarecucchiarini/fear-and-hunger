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
    
    /**
     * crea il GestoreForm e mostra subito il form della scelta del personaggio
     */
    public static void sceltaPersonaggio(){
        form = new FormScelta(gestoreGioco);
    }
    
    /**
     * cambia form dalla scelta del personaggio al gioco
     */
    public static void iniziaGioco(){
        form.dispose();
        form = new FormGioco(gestoreGioco);
    }
}
