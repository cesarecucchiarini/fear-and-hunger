/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package funger;

import java.io.*;
import java.util.HashMap;

/**
 *
 * @author cucchiarini.cesare
 */
public class GestoreFile {
    public static HashMap<Integer, Creabile> leggiCreabili(){
        HashMap<Integer, Creabile> mappaCreabili = new HashMap<>();
        
        try(BufferedReader r = new BufferedReader(new FileReader("creabili.txt"))){
            Creabile c = null;
            String line;
            String[] split;
            while((line = r.readLine()) != null){
                split = line.split(",");
                
                switch(split[0]){
                    case "cavaliere" -> {c = (Creabile)new Cavaliere(split[1], split[0]+".png");}
                    case "mercenario"-> {c = (Creabile)new Mercenario(split[1], split[0]+".png");}
                    case "vichingo"-> {c = (Creabile)new Vichingo(split[1], split[0]+".png");}
                    case "necromante" -> {c = (Creabile)new Necromante(split[1], split[0]+".png");}
                    case "ragazza" -> {c = (Creabile)new Ragazza(split[1], split[0]+".png");}
                    case "moonless" -> {c = (Creabile)new Moonless(split[1], split[0]+".png");}
                    case "demonchild" -> {c = (Creabile)new Demonchild(split[1], split[0]+".png");}
                }
                
                if(c != null)
                    mappaCreabili.put(c.hashCode(), c);
            }
        }
        catch(IOException e){}
        
        return mappaCreabili;
    }
}
