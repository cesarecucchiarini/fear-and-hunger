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

    public OggettoConsumabile(String nome, String path, int statPrincipale, TipoOggettoConsumabile tipo) {
        this.nome = nome;
        this.sprite = new ImageIcon(path);
        this.statPrincipale = statPrincipale;
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public ImageIcon getSprite() {
        return sprite;
    }

    public int getStatPrincipale() {
        return statPrincipale;
    }

    public TipoOggettoConsumabile getTipo() {
        return tipo;
    }
    
}
