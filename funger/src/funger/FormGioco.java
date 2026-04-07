/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package funger;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
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
        PanelSfondo sfondo = new PanelSfondo("img/background.png");       
        this.setContentPane(sfondo);
        
        this.gestoreGioco = gestoreGioco;
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setLayout(new BorderLayout());
        
        creaPanelGioco();
        creaPanelLaterale();
        
        panelGioco.setFocusable(true);
        this.getContentPane().setBackground(Color.red);
        this.setVisible(true);
        panelGioco.requestFocusInWindow();
    }
    
    /**
     * crea e aggiunge al frame il panel che mostra cosa sta accandendo nella stanza
     */
    public void creaPanelGioco(){
        panelGioco = new JPanel();
        panelGioco.setLayout(new GridLayout(1, 2));
        
        aggiornaPanelGioco();
        aggiungiListener();
        
        panelGioco.setOpaque(false);
        this.add(panelGioco, BorderLayout.CENTER);
    }
    
    public void aggiungiListener() {
        InputMap im = this.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap am = this.getRootPane().getActionMap();

        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "confermaAzione");
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_BACK_SPACE, 0), "abilita");

        am.put("confermaAzione", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gestoreGioco.interagisci();
            }
        });
        
        am.put("abilita", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DialogAbilita(gestoreGioco);
            }
        });
    }
    
    /**
     * aggiorna le immagini nel panel del gioco
     */
    public void aggiornaPanelGioco(){
        panelGioco.removeAll();
        creaPanelParty();
        creaPanelCreabile();
        
        panelGioco.revalidate();
        panelGioco.repaint();
    }
    
    /**
     * aggiorna le immagini nel panel del party
     */
    public void creaPanelParty(){
        JPanel panelParty = new JPanel();
        panelParty.setOpaque(false);
        panelParty.setLayout(new GridLayout(1, gestoreGioco.getGrandezzaParty()));
        
        for(Giocabile giocatore : gestoreGioco.getParty()){
            JLabelPersonalizzato immagine = new JLabelPersonalizzato(giocatore.getSprite());
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
        
        if(gestoreGioco.getCreabileStanza() != null && gestoreGioco.getStatoCella() != Cella.COMPLETATA){
            JLabelPersonalizzato immagine = new JLabelPersonalizzato(gestoreGioco.getCreabileStanza().getSprite());
            immagine.setHorizontalAlignment(JLabel.CENTER);
            panelCreabile.add(immagine);
        }
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
        JScrollPane sp = new JScrollPane(Logger.getTextArea());
        panelLaterale.add(sp);
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
        bottoneInventario.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    GestoreForm.apriInventario();
                }
            });
        panelBottoni.add(bottoneInventario);
        
        panelBottoni.add(Box.createRigidArea(new Dimension(0, 20)));
        
        JButton bottoneInfo = new JButton("?");
        bottoneInfo.setFont(font);
        bottoneInfo.setAlignmentX(CENTER_ALIGNMENT);
        bottoneInfo.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    JOptionPane.showMessageDialog(null, """
                                                        PER MUOVERTI SULLA MAPPA DEVI APRIRLA E UTILIZZARE LE FRECCE DIREZIONALI.
                                                        PER INTERAGIRE CON UN OGGETTO O PERSONAGGIO NELLA STANZA DEVI PREMERE INVIO.
                                                        PER UTILIZZARE UN'ABILITA FUORI DAL COMBATTIMENTO DEVI PREMERE BACKSPACE.
                                                        DEVI RAGGIUNGERE LA FINE DEL LABIRINTO, BUONA FORTUNA.
                                                        RICORDA DI CONTROLLARE LA FAME E LA MENTE, NON SOLO LA SALUTE.
                                                        """);
                }
            });
        panelBottoni.add(bottoneInfo);
        
        panelBottoni.add(Box.createVerticalGlue());
        
        panelLaterale.add(panelBottoni, BorderLayout.SOUTH);
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
