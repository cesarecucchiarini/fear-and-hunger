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
public class DialogUtilizzoOggetto extends JDialog{
    private Oggetto oggetto;
    private GestoreGioco gestoreGioco;
    
    public DialogUtilizzoOggetto(Oggetto oggetto, GestoreGioco gestoreGioco){
        super((JFrame)null, true);
        this.oggetto = oggetto;
        this.gestoreGioco = gestoreGioco;
        JDialog dialog = this;
        
        this.setSize(new Dimension(400, 400));
        this.setLayout(new BorderLayout());
        
        JPanel panelOggetto = new JPanel();
        panelOggetto.setLayout(new GridLayout(1, 2));
        
        panelOggetto.add(new JLabelPersonalizzato(oggetto.getSprite()));
        
        JPanel panelDescrizione = new JPanel();
        panelDescrizione.setLayout(new BoxLayout(panelDescrizione, BoxLayout.Y_AXIS));
        
        if(oggetto instanceof OggettoEquipaggiabile){
            panelDescrizione.add(new JLabel(oggetto.getNome()));
            panelDescrizione.add(new JLabel(((OggettoEquipaggiabile) oggetto).getTipo().name()));
            panelDescrizione.add(new JLabel(((OggettoEquipaggiabile) oggetto).getStatPrincipale()+""));
            panelDescrizione.add(new JLabel(((OggettoEquipaggiabile) oggetto).getAgilita()+""));
        }
        else{
            panelDescrizione.add(new JLabel(oggetto.getNome()));
            panelDescrizione.add(new JLabel(((OggettoConsumabile) oggetto).getTipo().name()));
            panelDescrizione.add(new JLabel(((OggettoConsumabile) oggetto).getStatPrincipale()+""));
        }
        
        panelOggetto.add(panelDescrizione);
        this.add(panelOggetto, BorderLayout.CENTER);
        
        JPanel panelBottoni = new JPanel();
        
        JButton bottoneUtilizzo = new JButton("usa oggetto");
        bottoneUtilizzo.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                new DialogSceltaPersonaggio(oggetto, gestoreGioco);
                dialog.dispose();
            }
        });
        panelBottoni.add(bottoneUtilizzo);

        JButton bottoneLascio = new JButton("butta oggetto");
        bottoneLascio.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                gestoreGioco.rimuoviOggetto(oggetto);
                dialog.dispose();
            }
        });
        panelBottoni.add(bottoneLascio);
        
        this.add(panelBottoni, BorderLayout.SOUTH);
        this.setVisible(true);
    }
}
