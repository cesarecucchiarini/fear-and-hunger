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
    private static FormMappa formMappa;
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
        formMappa = new FormMappa(gestoreGioco);
        gestoreGioco.setFormMappa(formMappa);
        form = new FormGioco(gestoreGioco);
        formMappa.aggiornaGrigliaMappa();
    }
    
    public static void apriMappa(){
        formMappa.mostraMappa();
        formMappa.requestFocus();
    }
    
    public static void chiudiMappa(){
        formMappa.dispose();
    }
    
    public static void aggiornaGrigliaMappa(){
        formMappa.aggiornaGrigliaMappa();
    }
    
    public static void aggiornaPanelGioco(){
        ((FormGioco)form).aggiornaPanelGioco();
    }
    
    public static void apriCombattimento(){
        form.dispose();
        formMappa.dispose();
        form = new FormCombattimento(gestoreGioco.getGestoreCombattimento());
    }
    
    public static void chiudiCombattimento(){
        form.dispose();
        form = new FormGioco(gestoreGioco);
    }
    
    public static void chiudiGioco(){
        form.dispose();
    }
    
    /*
    DEVO MODIFICARE PERCHE LA BARRA SCENDE TARDI
    */
    public static void aggiornaProgressBars(){
        FormCombattimento f = (FormCombattimento) form;
        f.disabilitaBottoni();
        f.aggiornaProgressBars();

        javax.swing.Timer timer = new javax.swing.Timer(500, e -> {
            f.abilitaBottoni();
        });

        timer.setRepeats(false);
        timer.start();
    }
}
