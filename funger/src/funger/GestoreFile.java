/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package funger;

import java.io.*;

/**
 *
 * @author cucchiarini.cesare
 */
public class GestoreFile {
    /**
     * legge i file degli oggetti creabili e li aggiunge al gestore dei creabili
     */
    public static void leggiCreabili(){
        leggiGiocatori();
        leggiOggetti();
    }
    
    /**
     * legge il file dei giocatori e aggiunge i giocatori al gestore dei creabili
     */
    public static void leggiGiocatori(){
        try(BufferedReader r = new BufferedReader(new FileReader("creabili/giocatori.txt"))){
            Creabile c = null;
            String line;
            String[] split;
            GestoreCreabili.aggiungiProbabilita(Integer.valueOf(r.readLine()));
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
                    GestoreCreabili.aggiungiCreabile(c);
            }
        }
        catch(IOException e){}
    }
    
    /**
     * legge il file degli oggetti e li agiunge al gestore dei creabili
     */
    public static void leggiOggetti(){
        try(BufferedReader r = new BufferedReader(new FileReader("creabili/oggetti.txt"))){
            Creabile c;
            String line;
            String[] split;
            TipoOggettoConsumabile tipoConsumabile = null;
            TipoOggettoEquipaggiabile tipoEquipaggiabile = null;
            GestoreCreabili.aggiungiProbabilita(Integer.valueOf(r.readLine()));
            
            while((line = r.readLine()) != null){
                split = line.split(",");
                if(split.length == 4){
                    switch(split[3]){
                        case "curativo" -> {tipoConsumabile = TipoOggettoConsumabile.CURATIVO;}
                        case "mentale" -> {tipoConsumabile = TipoOggettoConsumabile.MENTALE;}
                        case "commestibile" -> {tipoConsumabile = TipoOggettoConsumabile.COMMESTIBILE;}
                    }
                    c = (Creabile)new OggettoConsumabile(split[1], split[0]+".png", Integer.parseInt(split[2]), tipoConsumabile);
                }
                else{
                    switch(split[4]){
                    case "offensivo" -> {tipoEquipaggiabile = TipoOggettoEquipaggiabile.OFFENSIVO;}
                    case "difensivo" -> {tipoEquipaggiabile = TipoOggettoEquipaggiabile.DIFENSIVO;}                
                    }
                    c = (Creabile)new OggettoEquipaggiabile(split[1], Integer.parseInt(split[2]), Integer.parseInt(split[3]), tipoEquipaggiabile, split[0]+".png");
                }
                GestoreCreabili.aggiungiCreabile(c);
            }
        }
        catch(IOException e){}
    }
}
