/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package funger;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author sergi
 */
public class DialogSceltaPersonaggio extends JDialog{
    private Oggetto oggetto;
    private GestoreGioco gestoreGioco;

    public DialogSceltaPersonaggio(Oggetto oggetto, GestoreGioco gestoreGioco) {
        super((JFrame)null, true);
        this.oggetto = oggetto;
        this.gestoreGioco = gestoreGioco;
        JDialog dialog = this;
        
        JPanel panelGiocabili = new JPanel();
        panelGiocabili.setLayout(new GridLayout(1, gestoreGioco.getGrandezzaParty()));
        
        
        
        for(Giocabile g : gestoreGioco.getParty()){
            JPanel panelPersonaggio = new JPanel();
            panelPersonaggio.setLayout(new BorderLayout());

            panelPersonaggio.add(new JLabelPersonalizzato(g.getSprite()), BorderLayout.CENTER);

            JButton bottoneScelta = new JButton("scegli");
            bottoneScelta.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    if(oggetto instanceof OggettoConsumabile)
                        gestoreGioco.consumaOggetto((OggettoConsumabile) oggetto, g);
                    else
                        gestoreGioco.equipaggiaOggetto((OggettoEquipaggiabile) oggetto, (Giocatore)g);
                    dialog.dispose();
                }
            });

            panelPersonaggio.add(bottoneScelta, BorderLayout.SOUTH);
            
            if((oggetto instanceof OggettoConsumabile && ((OggettoConsumabile) oggetto).getTipo().equals(TipoOggettoConsumabile.CURATIVO)))
                panelGiocabili.add(panelPersonaggio);
            else if(g instanceof Giocatore)
                panelGiocabili.add(panelPersonaggio);
        }
        
        this.setLayout(new BorderLayout());
        this.add(panelGiocabili);

        this.setSize(new Dimension(400*gestoreGioco.getGrandezzaParty(), 400));
        this.setVisible(true);
    }
}
