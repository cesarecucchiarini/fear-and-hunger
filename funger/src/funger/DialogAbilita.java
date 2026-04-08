/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package funger;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author sergi
 */
public class DialogAbilita extends JDialog{
    
    public DialogAbilita(GestoreGioco gestoreGioco){
        super((JFrame)null, true);
        this.setLayout(new GridLayout(1, gestoreGioco.getGrandezzaParty()));
        JDialog dialog = this;
        
        for(Giocatore g : gestoreGioco.getGiocatori()){
            JPanel panelGiocatore = new JPanel();
            panelGiocatore.setLayout(new BorderLayout());
            
            panelGiocatore.add(new JLabelPersonalizzato(g.getSprite()));
            
            JButton bottoneAbilita = new JButton("scegli");
            bottoneAbilita.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    g.utilizzaAbilita();
                    dialog.dispose();
                }
            });
            panelGiocatore.add(bottoneAbilita, BorderLayout.SOUTH);
            this.add(panelGiocatore);
        }
        this.setSize(new Dimension(500*gestoreGioco.getGrandezzaParty(), 500));
        this.setVisible(true);
    }
}
