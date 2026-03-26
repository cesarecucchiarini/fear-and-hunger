/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package funger;

import java.io.*;
import java.util.Map;

/**
 *
 * @author cucchiarini.cesare
 */
public class GestoreFile {
    
    private static Map<String, CharacterFactory> CHARACTER_FACTORIES = Map.of(
                "cavaliere", Cavaliere::new,
                "mercenario", Mercenario::new,
                "vichingo", Vichingo::new,
                "necromante", Necromante::new,
                "ragazza", Ragazza::new,
                "moonless", Moonless::new,
                "demonchild", Demonchild::new,
                "maneba", Maneba::new,
                "trotur", Trotur::new,
                "guardia", Guardia::new
            );
    private static GestoreGioco gestoreGioco;
    
    /**
     * legge i file degli oggetti creabili e li aggiunge al gestore dei creabili
     */
    public static void leggiCreabili(GestoreGioco g){
        gestoreGioco = g;
        leggiGiocatori();
        leggiOggetti();
        leggiNemici();
    }
    
    /**
     * legge il file dei giocatori e aggiunge i giocatori al gestore dei creabili
     */
    public static void leggiGiocatori(){  
        try(BufferedReader r = new BufferedReader(new FileReader("creabili/giocatori.txt"))){
            String line;
            String[] split;
            GestoreCreabili.aggiungiProbabilita(Integer.valueOf(r.readLine()));
            
            while((line = r.readLine()) != null){
                split = line.split(",");
                String type = split[0];

                CharacterFactory factory = CHARACTER_FACTORIES.get(type);
                if (factory != null) {
                    Creabile c = factory.createGiocatore(split[1], type + ".png", Integer.parseInt(split[2]), Integer.parseInt(split[3]), gestoreGioco);
                    GestoreCreabili.aggiungiCreabile(c);
                }
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
                if(split[0].equals("oggettoConsumabile")){
                    tipoConsumabile = TipoOggettoConsumabile.valueOf(split[4].toUpperCase());
                    c = (Creabile)new OggettoConsumabile(split[2], split[1]+".png", Integer.parseInt(split[3]), tipoConsumabile);
                }
                else{
                    tipoEquipaggiabile = TipoOggettoEquipaggiabile.valueOf(split[5].toUpperCase());
                    c = (Creabile)new OggettoEquipaggiabile(split[2], Integer.parseInt(split[3]), Integer.parseInt(split[4]), tipoEquipaggiabile, split[1]+".png");
                }
                GestoreCreabili.aggiungiCreabile(c);
            }
        }
        catch(IOException e){}
    }
    
    /**
     * legge il file dei giocatori e aggiunge i giocatori al gestore dei creabili
     */
    public static void leggiNemici(){  
        try(BufferedReader r = new BufferedReader(new FileReader("creabili/nemici.txt"))){
            String line;
            String[] split;
            GestoreCreabili.aggiungiProbabilita(Integer.valueOf(r.readLine()));
            
            while((line = r.readLine()) != null){
                split = line.split(",");
                String type = split[0];

                CharacterFactory factory = CHARACTER_FACTORIES.get(type);
                if (factory != null) {
                    Creabile c = factory.createGiocatore(split[1], type + ".png", Integer.parseInt(split[2]), Integer.parseInt(split[3]), gestoreGioco);
                    GestoreCreabili.aggiungiCreabile(c);
                }
            }
        }
        catch(IOException e){}
    }
    
    @FunctionalInterface
    interface CharacterFactory {
        Creabile createGiocatore(String name, String path, int vita, int danno, GestoreGioco gestoreGioco);
    }
}
