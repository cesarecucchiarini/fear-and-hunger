/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package funger;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author cucchiarini.cesare
 */
public class FormGioco extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FormGioco.class.getName());
    
    private GestoreGioco gestoreGioco;
    private JPanel panelGioco;
    private JPanel panelLaterale;
    /**
     * Creates new form FormGioco
     * @param gestoreGioco gestore da passare agli oggetti
     */
    public FormGioco(GestoreGioco gestoreGioco) {
        initComponents();
        this.gestoreGioco = gestoreGioco;
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setLayout(new BorderLayout());
        
        creaPanelGioco();
        creaPanelLaterale();
        
        this.getContentPane().setBackground(Color.red);
        this.setVisible(true);
    }
    
    /**
     * crea e aggiunge al frame il panel che mostra cosa sta accandendo nella stanza
     */
    public void creaPanelGioco(){
        panelGioco = new JPanel();
        panelGioco.setLayout(new GridLayout(1, 2));
        
        aggiornaPanelGioco();
        
        panelGioco.setOpaque(false);
        this.add(panelGioco, BorderLayout.CENTER);
    }
    
    /**
     * aggiorna le immagini nel panel del gioco
     */
    public void aggiornaPanelGioco(){
        panelGioco.removeAll();
        creaPanelParty();
        creaPanelCreabile();
    }
    
    /**
     * aggiorna le immagini nel panel del party
     */
    public void creaPanelParty(){
        JPanel panelParty = new JPanel();
        panelParty.setOpaque(false);
        panelParty.setLayout(new GridLayout(1, gestoreGioco.getGrandezzaParty()));
        
        for(Giocabile g : gestoreGioco.getParty()){
            JLabel immagine = new JLabel(g.getNome());
            immagine.setHorizontalAlignment(JLabel.CENTER);
            panelParty.add(immagine);
        }
        
        panelGioco.add(panelParty);
    }
    
    /**
     * aggiorna le pagine nel panel del creabile
     */
    public void creaPanelCreabile(){
        JPanel panelCreabile = new JPanel();
        panelCreabile.setOpaque(false);
        panelCreabile.setLayout(new BorderLayout());       
        
        JLabel immagine = new JLabel("creabile");
        immagine.setHorizontalAlignment(JLabel.CENTER);
        panelCreabile.add(immagine);
        
        panelGioco.add(panelCreabile);
    }
    
    /**
     * crea il panel laterale che mostra vari bottoni e log
     */
    public void creaPanelLaterale(){
        panelLaterale = new JPanel();
        panelLaterale.setOpaque(false);
        panelLaterale.setLayout(new GridLayout(2, 1));
        
        panelLaterale.removeAll();
        creaTextArea();
        creaPanelBottoni();
        
        panelLaterale.setPreferredSize(new Dimension(300, 0));
        this.add(panelLaterale, BorderLayout.EAST);
    }
    
    /**
     * crea la textArea che funziona da logger e la passa alla classe Logger
     */
    public void creaTextArea(){
        JTextArea textArea = new JTextArea();
        textArea.append("Log");
        panelLaterale.add(textArea);
        Logger.assegnaTextArea(textArea);
    }
    
    /**
     * crea il panel contenente i bottoni di inventario, mappa e informazioni
     */
    public void creaPanelBottoni(){
        Font font = new Font("Dialog", 1, 20);
        JPanel panelBottoni = new JPanel();
        panelBottoni.setOpaque(false);
        panelBottoni.setLayout(new BoxLayout(panelBottoni, BoxLayout.Y_AXIS));
        
        panelBottoni.add(Box.createVerticalGlue());
        
        JButton bottoneMappa = new JButton("Mappa");
        bottoneMappa.setFont(font);
        bottoneMappa.setAlignmentX(CENTER_ALIGNMENT);
        bottoneMappa.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    GestoreForm.apriMappa();
                }
            });
        panelBottoni.add(bottoneMappa);
        
        panelBottoni.add(Box.createRigidArea(new Dimension(0, 20)));
        
        JButton bottoneInventario = new JButton("Inventario");
        bottoneInventario.setFont(font);
        bottoneInventario.setAlignmentX(CENTER_ALIGNMENT);
        panelBottoni.add(bottoneInventario);
        
        panelBottoni.add(Box.createRigidArea(new Dimension(0, 20)));
        
        JButton bottoneInfo = new JButton("?");
        bottoneInfo.setFont(font);
        bottoneInfo.setAlignmentX(CENTER_ALIGNMENT);
        panelBottoni.add(bottoneInfo);
        
        panelBottoni.add(Box.createVerticalGlue());
        
        panelLaterale.add(panelBottoni, BorderLayout.EAST);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
