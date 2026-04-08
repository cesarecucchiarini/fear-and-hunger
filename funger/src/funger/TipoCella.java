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
public enum TipoCella implements Serializable{
    VUOTO,
    MURO,
    PIENO,
    FINE,
    INIZIO;
    
    private static final long serialVersionUID = 1L; 
}
