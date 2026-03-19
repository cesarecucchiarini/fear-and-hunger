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
        
        try(BufferedReader r = new BufferedReader(new FileReader("Creabili.txt"))){
            Creabile c;
            String line;
            String[] split;
            while((line = r.readLine()) != null){
                split = line.split(",");
                
                switch(split[0]){
                    case "" -> {}
                }
            }
        }
        catch(IOException e){}
        
        return mappaCreabili;
    }
}
