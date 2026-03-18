/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package funger;

/**
 *
 * @author cucchiarini.cesare
 */
public class Mappa {
    private Cella[][] griglia;
    private int numCella;
    private int righe;
    
    /**
     * crea la mappa e la inizializza con i bordi sotto forma di muro
     * @param righe larghezza e lunghezza della mappa 
     */
    public Mappa(int righe){
        numCella = 0;
        this.righe = righe;
        griglia = new Cella[righe+2][righe+2];
        
        Cella muro = new Cella();
        for(int i = 0; i < righe+2; i++){
            griglia[0][i] = muro;
            griglia[righe+1][i] = muro;
            griglia[i][0] = muro;
            griglia[i][righe+1] = muro;
        }
    }
    
    public void aggiungiCella(Cella cella){
        griglia[(int) (numCella / righe) + 1][(numCella % righe) + 1] = cella;
        numCella++;
    }
    
    public int[] getInfosCella(int x, int y){
        return griglia[x+1][y+1].getInfos();
    }
    
    public void setStatoCella(int stato, int x, int y){
        griglia[x+1][y+1].setStato(stato);
    }
    
    /**
     * 
     * @param bordo serve a decidere se contare o no il bordo per il ritorno
     * @return ritorna la griglia con o senza bordo
     */
    public Cella[][] getGriglia(boolean bordo){
        if(bordo)
            return griglia;
        
        Cella[][] g = new Cella[righe][righe];
        for(int i = 1; i < righe+1; i++){
            for(int j = 1; j < righe+1; j++){
                g[i-1][j-1] = griglia[i][j];
            }
        }
        return g;
    }
}
