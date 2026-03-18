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
public abstract class OggettoConsumabile implements Creabile{
    private String nome;
    private ImageIcon sprite;
    private int statPrincipale;
    private TipoOggettoConsumabile tipo;

    /**
     * 
     * @param nome nome dell'oggetto
     * @param path percorso dell'immagine
     * @param statPrincipale statistica da controllare in caso di consumo
     * @param tipo tipo di oggetto, indica la statistica interessata
     */
    public OggettoConsumabile(String nome, String path, int statPrincipale, TipoOggettoConsumabile tipo) {
        this.nome = nome;
        this.sprite = new ImageIcon(path);
        this.statPrincipale = statPrincipale;
        this.tipo = tipo;
    }

    /**
     * 
     * @return nome dell'oggetto
     */
    public String getNome() {
        return nome;
    }

    /**
     * 
     * @return immagine dell'oggetto
     */
    public ImageIcon getSprite() {
        return sprite;
    }

    /**
     * 
     * @return statistica dell'oggetto
     */
    public int getStatPrincipale() {
        return statPrincipale;
    }

    /**
     * 
     * @return tipo dell'oggetto
     */
    public TipoOggettoConsumabile getTipo() {
        return tipo;
    }
    
}
