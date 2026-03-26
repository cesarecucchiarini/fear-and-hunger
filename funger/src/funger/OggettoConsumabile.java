/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package funger;

/**
 *
 * @author sergi
 */
public class OggettoConsumabile extends Oggetto{
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
        super(nome, path);
        this.statPrincipale = statPrincipale;
        this.tipo = tipo;
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
