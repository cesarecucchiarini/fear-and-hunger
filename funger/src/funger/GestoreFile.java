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
        mappaCreabili.put(0, null);
        
        leggiGiocatori(mappaCreabili);
        leggiOggettiConsumabili(mappaCreabili);
        leggiOggettiEquipaggiabili(mappaCreabili);
        
        return mappaCreabili;
    }
    
    public static void leggiGiocatori(HashMap mappaCreabili){
        try(BufferedReader r = new BufferedReader(new FileReader("creabili/giocatori.txt"))){
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
    }
    
    public static void leggiOggettiConsumabili(HashMap mappaCreabili){
        try(BufferedReader r = new BufferedReader(new FileReader("creabili/oggettiConsumabili.txt"))){
            Creabile c;
            String line;
            String[] split;
            TipoOggettoConsumabile tipo = null;
            while((line = r.readLine()) != null){
                split = line.split(",");
                
                switch(split[3]){
                    case "curativo" -> {tipo = TipoOggettoConsumabile.CURATIVO;}
                    case "mentale" -> {tipo = TipoOggettoConsumabile.MENTALE;}
                    case "commestibile" -> {tipo = TipoOggettoConsumabile.COMMESTIBILE;}
                }
                c = (Creabile)new OggettoConsumabile(split[1], split[0]+".png", Integer.parseInt(split[2]), tipo);
                
                mappaCreabili.put(c.hashCode(), c);
            }
        }
        catch(IOException e){}
    }
    
    public static void leggiOggettiEquipaggiabili(HashMap mappaCreabili){
        try(BufferedReader r = new BufferedReader(new FileReader("creabili/oggettiEquipaggiabili.txt"))){
            Creabile c;
            String line;
            String[] split;
            TipoOggettoEquipaggiabile tipo = null;
            while((line = r.readLine()) != null){
                split = line.split(",");
                
                switch(split[4]){
                    case "offensivo" -> {tipo = TipoOggettoEquipaggiabile.OFFENSIVO;}
                    case "difensivo" -> {tipo = TipoOggettoEquipaggiabile.DIFENSIVO;}                
                }
                c = (Creabile)new OggettoEquipaggiabile(split[1], Integer.parseInt(split[2]), Integer.parseInt(split[3]), tipo, split[0]+".png");
                
                mappaCreabili.put(c.hashCode(), c);
            }
        }
        catch(IOException e){}
    }
}
