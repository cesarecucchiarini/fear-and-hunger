/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package funger;

import java.io.Serializable;

/**
 *
 * @author cucchiarini.cesare
 */
public class Mappa implements Serializable{
    private static final long serialVersionUID = 1L; 
    private Cella[][] griglia;
    private int righe;
    private int numCella;
    
    /**
     * crea la mappa e la inizializza con i bordi sotto forma di muro
     * @param righe larghezza e lunghezza della mappa 
     */
    public Mappa(int righe){
        this.righe = righe;
        numCella = 0;
        griglia = new Cella[righe+2][righe+2];
        
        Cella muro = new Cella();
        for(int i = 0; i < righe+2; i++){
            griglia[0][i] = muro;
            griglia[righe+1][i] = muro;
            griglia[i][0] = muro;
            griglia[i][righe+1] = muro;
        }
    }
    
    /**
     * aggiunge una cella in uno spazio vuoto senza overridare alcuna cella
     * @param cella cella da aggiungere
     */
    public void aggiungiCella(Cella cella){
        if(numCella > righe*righe) return;
        
        int x = (int) (numCella / righe) + 1;
        int y = (numCella % righe) + 1;
        if(griglia[x][y] == null) griglia[x][y] = cella;
        else{
            numCella++;
            aggiungiCella(cella);
        }
        numCella++;
    }
    
    /**
     * 
     * @param cella cella da aggiungere
     * @param x riga in cui aggiungerla
     * @param y colonna in cui aggiungerla
     */
    public void aggiungiCella(Cella cella, int x, int y){
        griglia[x+1][y+1] = cella;
    }
    
    /**
     * 
     * @param x posizione della cella
     * @param y posizione della cella
     * @return creabile nella cella
     */
    public String getIdCreabileCella(int x, int y){
        return griglia[x+1][y+1].getIdCreabile();
    }
    
    /**
     * 
     * @param x posizione della cella
     * @param y posizione della cella
     * @return stato della cella
     */
    public int getStatoCella(int x, int y){
        return griglia[x+1][y+1].getStato();
    }
    
    /**
     * 
     * @param x posizione della cella
     * @param y posizione della cella
     * @return tipo della cella
     */
    public TipoCella getTipoCella(int x, int y){
        return griglia[x+1][y+1].getTipo();
    }
    
    /**
     * 
     * @param stato nuovo stato della cella
     * @param x posizione della cella
     * @param y posizione della cella
     */
    public void setStatoCella(int x, int y, int stato){
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
    
    /**
     * 
     * @param x ascisa della cella
     * @param y ordinata della cella
     * @return true se la cella è gia stata creata
     */
    public boolean cellaInizializzata(int x, int y){
        return griglia[x+1][y+1] != null;
    }
    
    public int getRighe(){
        return righe;
    }
}
