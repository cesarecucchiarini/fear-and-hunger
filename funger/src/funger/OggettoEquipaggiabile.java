/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package funger;

import javax.swing.ImageIcon;

/**
 *
 * @author sergi
 */
public class OggettoEquipaggiabile extends Oggetto{
    private int statPrincipale;
    private TipoOggettoEquipaggiabile tipo;

    /**
     * 
     * @param nome nome dell'oggetto
     * @param statPrincipale aumento della statistica dato dall'oggetto
     * @param tipo tipo dell'oggetto
     * @param path percorso dell'immagine
     */
    public OggettoEquipaggiabile(String nome, String path, int statPrincipale, TipoOggettoEquipaggiabile tipo) {
        super(nome, path);
        this.statPrincipale = statPrincipale;
        this.tipo = tipo;
    }

    /**
     * 
     * @return statistica principale dell'oggetto
     */
    public int getStatPrincipale() {
        return statPrincipale;
    }

    /**
     * 
     * @return tipo dell'oggetto
     */
    public TipoOggettoEquipaggiabile getTipo() {
        return tipo;
    }
    
    
}
