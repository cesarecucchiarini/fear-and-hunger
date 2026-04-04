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
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author sergi
 */
public class FormCombattimento extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FormCombattimento.class.getName());

    private GestoreCombattimento gestoreCombattimento;
    private JPanel panelCombattimento;
    /**
     * Creates new form FormCombattimento
     */
    public FormCombattimento(GestoreCombattimento gestoreCombattimento) {
        initComponents();
        this.gestoreCombattimento = gestoreCombattimento;
        this.setLayout(new BorderLayout());
        
        creaPanelCombattimento();
        creaPanelBottoni();
        
        this.getContentPane().setBackground(Color.red);
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
        
        for(Giocabile g : gestoreCombattimento.getParty()){
            JLabel immagine = new JLabel(g.getNome());
            immagine.setHorizontalAlignment(JLabel.CENTER);
            panelParty.add(immagine);
        }
        
        panelCombattimento.add(panelParty);
    }
    
    public void creaPanelNemico(){
        JPanel panelCreabile = new JPanel();
        panelCreabile.setOpaque(false);
        panelCreabile.setLayout(new BorderLayout());       
        
        JLabel immagine = new JLabel(gestoreCombattimento.getNemico().getNome());
        immagine.setHorizontalAlignment(JLabel.CENTER);
        panelCreabile.add(immagine);
        
        panelCombattimento.add(panelCreabile);
    }
    
    public void creaPanelBottoni(){
        Font font = new Font("Dialog", 1, 20);
        JPanel panelBottoni = new JPanel();
        panelBottoni.setOpaque(false);
        panelBottoni.setLayout(new BoxLayout(panelBottoni, BoxLayout.X_AXIS));
        
        panelBottoni.add(Box.createHorizontalGlue());
        
        JButton bottoneAttacca = new JButton("Attacca");
        bottoneAttacca.setFont(font);
        bottoneAttacca.setAlignmentY(CENTER_ALIGNMENT);
        bottoneAttacca.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    gestoreCombattimento.getGiocabileCorrente().attacca();
                    if(!gestoreCombattimento.controllaFineCombattimento())
                        gestoreCombattimento.cambiaTurno();
                }
            });
        panelBottoni.add(bottoneAttacca);
        
        panelBottoni.add(Box.createRigidArea(new Dimension(50, 0)));
        
        JButton bottoneAbilita = new JButton("Abilita Speciale");
        bottoneAbilita.setFont(font);
        bottoneAbilita.setAlignmentY(CENTER_ALIGNMENT);
        bottoneAbilita.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    ((Giocatore) gestoreCombattimento.getGiocabileCorrente()).utilizzaAbilita();
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
        
        panelBottoni.add(Box.createHorizontalGlue());
        
        this.add(panelBottoni, BorderLayout.SOUTH);
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
