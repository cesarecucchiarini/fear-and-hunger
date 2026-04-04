/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package funger;
import java.util.Map;

/**
 *
 * @author sergi
 */
public class GestoreInput {
    private static GestoreGioco gestoreGioco;
    private static Map<Integer, int[]>  mappaMovimenti = Map.of(
            38, new int[]{-1, 0},
            40, new int[]{1, 0},
            37, new int[]{0, -1},
            39, new int[]{0, 1}
    );
    
    public static void setGestoreGioco(GestoreGioco gestoreGioco){
        GestoreInput.gestoreGioco = gestoreGioco;
    }
    
    public static Map<Integer, int[]> getMappaMovimenti(){
        return mappaMovimenti;
    }
}
