/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package funger;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Random;

/**
 *
 * @author cucchiarini.cesare
 */
public class GestoreCreabili {
    /**
     * mappa dei creabili, contiene il tipo di creabile e i creabili a esso associati
     */
    private static LinkedHashMap<String, ArrayList<Creabile>> mappaCreabili = new LinkedHashMap<>();
    
    /**
     * lista delle probabilita di apparizione di ogni tipo di creabile
     */
    private static ArrayList<Integer> listaProbabilita = new ArrayList<>();
    private static int totaleProbabilita = 0;
    
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
     * @param probabilita probabilita da aggiungere alla lista
     */
    public static void aggiungiProbabilita(Integer probabilita){
        listaProbabilita.add(probabilita);
        totaleProbabilita += probabilita;
    }
    
    /**
     * 
     * @param id id del creabile in forma "Tipo" +"_"+ "Numero"
     * @return creabile correlato all'id
     */
    public static Creabile getCreabile(String id){
        String[] split = id.split("_");
        Creabile c = (Creabile)mappaCreabili.get(split[0]).get(Integer.parseInt(split[1]));
        return (Creabile) c.clone();
    }
    
    /**
     * ritorna l'id di un creabile scelto casualmente o scelto in base alla probabilita di apparizione
     * @param probabilita true - creabile scelto casualmene in base a una probabilita, false - creabile scelto a caso
     * @return id di un creabile a caso
     */
    public static String getRandomIdCreabile(boolean probabilita){
        return probabilita ? getIdCreabileProbabile() : getIdCreabileRandom();
    }
    
    /**
     * 
     * @return id casuale di un creabile
     */
    public static String getIdCreabileRandom(){
        Random rnd = new Random();
        String id;
        int len = mappaCreabili.size();
        
        id = mappaCreabili.keySet().toArray(new String[len])[rnd.nextInt(len)];
        len = mappaCreabili.get(id).size();
        id += "_" + rnd.nextInt(len);
        
        return id;
    }
    
    /**
     * 
     * @return id casuale di un creabile, tenendo conto della probabilita
     */
    public static String getIdCreabileProbabile(){
        String id = "";
        Random rnd = new Random();
        int perc = rnd.nextInt(1, totaleProbabilita+1);
        
        for(int i = 0; i < listaProbabilita.size(); i++){
            if(perc <= listaProbabilita.get(i)){
                id = (String) mappaCreabili.keySet().toArray()[i];
                id += "_" + rnd.nextInt(mappaCreabili.get(id).size());
                return id;
            }
            else{
                perc -= listaProbabilita.get(i);
            }
        }
        
        return id;
    }    

    static void cambiaGestoreGioco(GestoreGioco gestoreGioco) {
        for(Giocabile g : mappaCreabili.get("Giocatore").toArray(Giocabile[]::new)){
            g.setGestoreGioco(gestoreGioco);
        }
        for(Giocabile g : mappaCreabili.get("Nemico").toArray(Giocabile[]::new)){
            g.setGestoreGioco(gestoreGioco);
        }
    }
}