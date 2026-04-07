/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package funger;

import java.awt.BorderLayout;
import java.awt.Dimension;
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
        
        if(oggetto instanceof OggettoConsumabile && ((OggettoConsumabile) oggetto).getTipo().equals(TipoOggettoConsumabile.CURATIVO)){
            for(Giocabile g : gestoreGioco.getParty()){
                JPanel panelPersonaggio = new JPanel();
                panelPersonaggio.setLayout(new BoxLayout(panelPersonaggio, BoxLayout.Y_AXIS));

                panelPersonaggio.add(new JLabel(g.getSprite()));

                JButton bottoneScelta = new JButton("scegli");
                bottoneScelta.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e){
                        gestoreGioco.consumaOggetto((OggettoConsumabile) oggetto, g);
                        dialog.dispose();
                    }
                });

                panelPersonaggio.add(bottoneScelta);
                panelGiocabili.add(panelPersonaggio);
            }
        }
        else{
            for(Giocatore g : gestoreGioco.getGiocatori()){
                JPanel panelPersonaggio = new JPanel();
                panelPersonaggio.setLayout(new BoxLayout(panelPersonaggio, BoxLayout.Y_AXIS));

                panelPersonaggio.add(new JLabel(g.getSprite()));

                JButton bottoneScelta = new JButton("scegli");
                if(oggetto instanceof OggettoConsumabile){
                    bottoneScelta.addActionListener(new ActionListener(){
                        @Override
                        public void actionPerformed(ActionEvent e){
                            gestoreGioco.consumaOggetto((OggettoConsumabile) oggetto, (Giocatore) g);
                            dialog.dispose();
                        }
                    });
                }
                else{
                    bottoneScelta.addActionListener(new ActionListener(){
                        @Override
                        public void actionPerformed(ActionEvent e){
                            gestoreGioco.equipaggiaOggetto((OggettoEquipaggiabile) oggetto, (Giocatore)g);
                            dialog.dispose();
                        }
                    });
                }
                panelPersonaggio.add(bottoneScelta);
                panelGiocabili.add(panelPersonaggio);
            }
        }
        
        this.setLayout(new BorderLayout());
        this.add(panelGiocabili);
            
        this.setSize(new Dimension(300, 300));
        this.setVisible(true);
    }
}
