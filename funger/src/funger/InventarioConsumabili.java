/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package funger;

import java.util.ArrayList;

/**
 *
 * @author sergi
 */
public class InventarioConsumabili {
    /**
     * oggetti contenuti nell'inventario
     */
    private ArrayList<OggettoConsumabile> oggetti = new ArrayList<>();
    
    /**
     * 
     * @param oggetto oggetto da aggiungere
     */
    public void aggiungiOggetto(OggettoConsumabile oggetto){
        oggetti.add(oggetto);
    }
    
    /**
     * 
     * @param oggetto oggetto da rimuovere 
     */
    public void rimuoviOggetto(OggettoConsumabile oggetto){
        oggetti.remove(oggetto);     
    }
    
    /**
     * 
     * @return oggetti contenuti nell'inventario
     */
    public ArrayList<OggettoConsumabile> getOggetti(){
        return oggetti;
    }
}
