/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package funger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 *
 * @author cucchiarini.cesare
 */
public class GestoreCreabili {
    private static HashMap<String, ArrayList<Creabile>> mappaCreabili = new HashMap<>();
    
    /**
     * 
     * @param creabile creabile da aggiungere alla mappa 
     */
    public static void aggiungiCreabile(Creabile creabile){
        String nome;
        
        if(creabile instanceof Oggetto)
            nome = "Oggetto";
        else if(creabile instanceof Giocatore)
            nome = "Giocatore";
        else
            nome = "Nemico";
        
        if(mappaCreabili.containsKey(nome)){
            mappaCreabili.get(nome).add(creabile);
        }
        else{
            mappaCreabili.put(nome, new ArrayList<>());
            mappaCreabili.get(nome).add(creabile);
        }
    }
    
    /**
     * 
     * @param id id del creabile in forma "Tipo" +"_"+ "Numero"
     * @return creabile correlato all'id
     */
    public static Creabile getCreabile(String id){
        String[] split = id.split("_");
        return mappaCreabili.get(split[0]).get(Integer.parseInt(split[1]));
    }
    
    /**
     * ritorna l'id di un creabile scelto casualmente
     * @return id di un creabile a caso
     */
    public static String getRandomIdCreabile(){
        Random rnd = new Random();
        String id;
        int len = mappaCreabili.size();
        
        id = mappaCreabili.keySet().toArray(new String[len])[rnd.nextInt(len)];
        len = mappaCreabili.get(id).size();
        id += "_" + rnd.nextInt(len);
        
        return id;
    }
    
    /**
     * ritorna un creabile casuale scelto in base al tipo specificato, oppure un id casuale in caso il tipo specificato non esista
     * @param tipo tipo scelto
     * @return id scelto casualmente
     */
    public static String getRandomIdCreabile(String tipo){
        Random rnd = new Random();
        String id = tipo;
        int len;
        try{
            len = mappaCreabili.get(id).size();
        }
        catch(Exception e){
            return getRandomIdCreabile();
        }
        
        id += "_" + rnd.nextInt(len);
        
        return id;
    }
}