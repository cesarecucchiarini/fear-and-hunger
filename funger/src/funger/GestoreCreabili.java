/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package funger;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author cucchiarini.cesare
 */
public class GestoreCreabili {
    private static HashMap<String, ArrayList<Creabile>> mappaCreabili = new HashMap<>();
    
    public static void aggiungiCreabile(Creabile creabile){
        String nome = creabile.getClass().getSimpleName();
        
        if(mappaCreabili.containsKey(nome)){
            mappaCreabili.get(nome).add(creabile);
        }
        else{
            mappaCreabili.put(nome, new ArrayList<>());
            mappaCreabili.get(nome).add(creabile);
        }
    }
    
    public static Creabile getCreabile(String id){
        
    }
}
