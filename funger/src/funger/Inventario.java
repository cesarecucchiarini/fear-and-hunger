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
public class Inventario {
    private ArrayList<Oggetto> oggetti = new ArrayList<>();
    
    /**
     * 
     * @param oggetto oggetto da aggiungere
     */
    public void aggiungiOggetto(Oggetto oggetto){
        if(oggetto != null){
            oggetti.add(oggetto);
            Logger.scriviLog("hai raccolto " + oggetto.getNome());
        }
    }
    
    /**
     * 
     * @param oggetto oggetto da rimuovere
     */
    public void rimuoviOggetto(Oggetto oggetto){
        oggetti.remove(oggetto);
        Logger.scriviLog("hai rimosso " + oggetto.getNome());
    }
    
    /**
     * 
     * @return oggetti contenuti nell'inventario
     */
    public ArrayList<Oggetto> getOggetti(){
        return oggetti;
    }
    
    /**
     * 
     * @return oggetti equipaggiabili contenuti nell'inventario
     */
    public ArrayList<OggettoEquipaggiabile> getOggettiEquipaggiabili(){
        ArrayList<OggettoEquipaggiabile> temp = new ArrayList<>();
        
        for(Oggetto o : oggetti){
            if(o instanceof OggettoEquipaggiabile)
                temp.add((OggettoEquipaggiabile) o);
        }
        
        return temp;
    }
    
    /**
     * 
     * @return oggetti consumabili contenuti nell'inventario
     */
    public ArrayList<OggettoConsumabile> getOggettiConsumabili(){
        ArrayList<OggettoConsumabile> temp = new ArrayList<>();
        
        for(Oggetto o : oggetti){
            if(o instanceof OggettoConsumabile)
                temp.add((OggettoConsumabile) o);
        }
        
        return temp;
    }
}
