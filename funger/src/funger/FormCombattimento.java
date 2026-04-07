/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package funger;

import java.awt.BorderLayout;
import java.awt.Color;
import static java.awt.Component.CENTER_ALIGNMENT;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollBar;

/**
 *
 * @author sergi
 */
public class FormCombattimento extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FormCombattimento.class.getName());

    private GestoreCombattimento gestoreCombattimento;
    private JPanel panelCombattimento;
    private ArrayList<JProgressBar> progressBars = new ArrayList();
    private JButton[] bottoni = new JButton[3];
    /**
     * Creates new form FormCombattimento
     */
    public FormCombattimento(GestoreCombattimento gestoreCombattimento) {
        initComponents();
        PanelSfondo sfondo = new PanelSfondo("img/background.png");       
        this.setContentPane(sfondo);
        
        this.gestoreCombattimento = gestoreCombattimento;
        this.setLayout(new BorderLayout());
        
        creaPanelCombattimento();
        creaPanelBottoni();
               
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setVisible(true);
    }
    
    public void creaPanelCombattimento(){
        panelCombattimento = new JPanel();
        panelCombattimento.setLayout(new GridLayout(1, 2));
        panelCombattimento.setOpaque(false);
        
        creaPanelParty();
        creaPanelNemico();
        
        panelCombattimento.setOpaque(false);
        this.add(panelCombattimento, BorderLayout.CENTER);
    }
    
    public void creaPanelParty(){
        JPanel panelParty = new JPanel();
        panelParty.setOpaque(false);
        panelParty.setLayout(new GridLayout(1, gestoreCombattimento.getParty().size()));
        
        for(Giocabile giocatore : gestoreCombattimento.getParty()){
            JPanel panelPersonaggio = new JPanel();
            panelPersonaggio.setLayout(new BorderLayout());
            panelPersonaggio.setOpaque(false);
            
            JLabelPersonalizzato immagine = new JLabelPersonalizzato(giocatore.getSprite());
            immagine.setHorizontalAlignment(JLabel.CENTER);
            panelPersonaggio.add(immagine, BorderLayout.CENTER);
            
            JProgressBar barraVita = new JProgressBar(0, giocatore.getVitaMax());
            barraVita.setValue(giocatore.getVita());
            barraVita.setStringPainted(true);
            barraVita.setPreferredSize(new Dimension(0, 75));
            panelPersonaggio.add(barraVita, BorderLayout.NORTH);
            
            progressBars.add(barraVita);
            
            panelParty.add(panelPersonaggio);
        }
        
        panelCombattimento.add(panelParty);
    }
    
    public void creaPanelNemico(){
        JPanel panelCreabile = new JPanel();
        panelCreabile.setOpaque(false);
        panelCreabile.setLayout(new BorderLayout());       
        
        JLabelPersonalizzato immagine = new JLabelPersonalizzato(gestoreCombattimento.getNemico().getSprite());
        immagine.setHorizontalAlignment(JLabel.CENTER);
        panelCreabile.add(immagine, BorderLayout.CENTER);
        
        JProgressBar barraVita = new JProgressBar(0, gestoreCombattimento.getNemico().getVitaMax());
        barraVita.setValue(gestoreCombattimento.getNemico().getVita());
        barraVita.setStringPainted(true);
        barraVita.setPreferredSize(new Dimension(0, 75));
        panelCreabile.add(barraVita, BorderLayout.NORTH);
        
        progressBars.add(barraVita);
        
        panelCombattimento.add(panelCreabile);
    }
    
    public void aggiornaProgressBars(){
        int counter = 0;
        for(Giocabile g : gestoreCombattimento.getParty()){
            progressBars.get(counter++).setValue(g.getVita());
        }
        progressBars.getLast().setValue(gestoreCombattimento.getNemico().getVita());
    }
    
    public void creaPanelBottoni(){
        Font font = new Font("Dialog", 1, 20);
        JPanel panelBottoni = new JPanel();
        panelBottoni.setOpaque(false);
        panelBottoni.setLayout(new BoxLayout(panelBottoni, BoxLayout.X_AXIS));
        
        panelBottoni.add(Box.createHorizontalGlue());
        
        JButton bottoneAttacco = new JButton("Attacca");
        bottoneAttacco.setFont(font);
        bottoneAttacco.setAlignmentY(CENTER_ALIGNMENT);
        bottoneAttacco.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    gestoreCombattimento.getGiocabileCorrente().attacca();
                    GestoreForm.aggiornaProgressBars();
                    if(!gestoreCombattimento.controllaFineCombattimento())
                        gestoreCombattimento.cambiaTurno();
                }
            });
        panelBottoni.add(bottoneAttacco);
        
        panelBottoni.add(Box.createRigidArea(new Dimension(50, 0)));
        
        JButton bottoneAbilita = new JButton("Abilita Speciale");
        bottoneAbilita.setFont(font);
        bottoneAbilita.setAlignmentY(CENTER_ALIGNMENT);
        bottoneAbilita.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    ((Giocatore) gestoreCombattimento.getGiocabileCorrente()).utilizzaAbilita();
                    GestoreForm.aggiornaProgressBars();
                    if(!gestoreCombattimento.controllaFineCombattimento())
                        gestoreCombattimento.cambiaTurno();
                }
            });
        panelBottoni.add(bottoneAbilita);
        
        panelBottoni.add(Box.createRigidArea(new Dimension(50, 0)));
        
        JButton bottoneGuardia = new JButton("Guardia");
        bottoneGuardia.setFont(font);
        bottoneGuardia.setAlignmentY(CENTER_ALIGNMENT);
        bottoneGuardia.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    ((Giocatore)gestoreCombattimento.getGiocabileCorrente()).guardia();
                    gestoreCombattimento.cambiaTurno();
                }
            });
        panelBottoni.add(bottoneGuardia);
        
        panelBottoni.add(Box.createRigidArea(new Dimension(50, 0)));   
        
        JButton bottoneLog = new JButton("Log");
        bottoneLog.setFont(font);
        bottoneLog.setAlignmentY(CENTER_ALIGNMENT);
        bottoneLog.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    javax.swing.JScrollPane scrollPane = new javax.swing.JScrollPane(Logger.getTextArea());
                    javax.swing.JOptionPane.showMessageDialog(
                        null,              // The parent JFrame (FormCombattimento)
                        scrollPane,        // The component to show
                        "Registro Combattimento", // Title
                        javax.swing.JOptionPane.INFORMATION_MESSAGE
                    );
                }
            });
        panelBottoni.add(bottoneLog);
        
        panelBottoni.add(Box.createHorizontalGlue());
        
        this.add(panelBottoni, BorderLayout.SOUTH);
        
        bottoni[0] = bottoneAttacco;
        bottoni[1] = bottoneAbilita;
        bottoni[2] = bottoneGuardia;
    }
    
    public void disabilitaBottoni(){
        for(JButton b : bottoni){
            b.setEnabled(false);
        }
    }
    
    public void abilitaBottoni(){
        for(JButton b : bottoni){
            b.setEnabled(true);
        }
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
