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
    private ArrayList<OggettoEquipaggiabile> oggetti = new ArrayList<>();
    
    public void aggiungiOggetto(OggettoEquipaggiabile oggetto){
        oggetti.add(oggetto);
    }
    
    public void rimuoviOggetto(OggettoEquipaggiabile oggetto){
        oggetti.remove(oggetto);     
    }
    
    public ArrayList<OggettoEquipaggiabile> getOggetti(){
        return oggetti;
    }
}
