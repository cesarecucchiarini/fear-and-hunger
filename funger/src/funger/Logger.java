/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package funger;

import javax.swing.JTextArea;

/**
 *
 * @author cucchiarini.cesare
 */
public class Logger {
    private static JTextArea textArea;

    /**
     * 
     * @param textArea textArea da assegnare al logger per scrivere le informazioni
     */
    public static void creaTextArea() {
        Logger.textArea = new JTextArea("Log\n");
        textArea.setEditable(false);
    }
    
    /**
     * 
     * @param msg messaggio da scrivere sul log
     */
    public static void scriviLog(String msg){
        textArea.append(msg+"\n");
    }

    public static JTextArea getTextArea() {
        return textArea;
    }
    
    
}
