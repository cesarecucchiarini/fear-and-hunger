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
public class InventarioEquipaggiabili {
    /**
     * oggetti contenuti nell'inventario
     */
    private ArrayList<OggettoEquipaggiabile> oggetti = new ArrayList<>();
    
    /**
     * 
     * @param oggetto oggetto da aggiungere
     */
    public void aggiungiOggetto(OggettoEquipaggiabile oggetto){
        if(oggetto != null)oggetti.add(oggetto);
    }
    
    /**
     * 
     * @param oggetto oggetto da rimuovere
     */
    public void rimuoviOggetto(OggettoEquipaggiabile oggetto){
        oggetti.remove(oggetto);     
    }
    
    /**
     * 
     * @return oggetti contenuti nell'inventario
     */
    public ArrayList<OggettoEquipaggiabile> getOggetti(){
        return oggetti;
    }
}
