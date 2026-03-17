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
public abstract class OggettoEquipaggiabile implements Creabile{
    private String nome;
    private ImageIcon sprite;
    private int statPrincipale;
    private int agilita;
    private TipoOggettoEquipaggiabile tipo;

    public OggettoEquipaggiabile(String nome, int statPrincipale, int agilita, TipoOggettoEquipaggiabile tipo, String path) {
        this.nome = nome;
        this.statPrincipale = statPrincipale;
        this.agilita = agilita;
        this.tipo = tipo;
        sprite = new ImageIcon(path);
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

    public int getAgilita() {
        return agilita;
    }

    public TipoOggettoEquipaggiabile getTipo() {
        return tipo;
    }
    
    
}
