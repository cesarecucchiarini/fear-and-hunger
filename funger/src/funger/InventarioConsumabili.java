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
    private ArrayList<OggettoConsumabile> oggetti = new ArrayList<>();
    
    public void aggiungiOggetto(OggettoConsumabile oggetto){
        oggetti.add(oggetto);
    }
    
    public void rimuoviOggetto(OggettoConsumabile oggetto){
        oggetti.remove(oggetto);     
    }
    
    public ArrayList<OggettoConsumabile> getOggetti(){
        return oggetti;
    }
}
