/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DTO.Personne;
import DTO.Rencontre;
import View.JFrameMain;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author lucas
 */
public class BoiteRencontre extends JPanel {
    public static final Dimension TAILLEMONITEUR = Toolkit.getDefaultToolkit().getScreenSize();
    public static final int LONGUEUR = TAILLEMONITEUR.width *4/5;
    public static final int HAUTEUR = TAILLEMONITEUR.height *4/5;
    private int num_rencontre;
    private Rencontre rencontre;
    private JLabel topScore;
    private JLabel botScore;
    private JLabel topLabel;
    private JLabel botLabel;
    private JButton top = new JButton();
    private JButton bot = new JButton();
    private boolean isFinished = false;
    private Personne personneVide = new Personne();
    
    
    public BoiteRencontre() {
        topScore = new JLabel("0 ");
        botScore = new JLabel("0 ");
        rencontre= new Rencontre();
        topLabel = new JLabel(" En attente");
        botLabel = new JLabel(" En attente");
        constrPan();
    }
    
    public BoiteRencontre(Rencontre r) {
        this.num_rencontre =r.getNum_rencontre();
        this.rencontre=r;
        String[] score = r.getScore().split("-");
        topScore = new JLabel(score[0]+" ");
        botScore = new JLabel(score[1]+" ");
        if(r.getJoueur1() != null) {
            topLabel = new JLabel(r.getJoueur1().getNom());
        } else {
            topLabel = new JLabel(" [En attente]");
        }
        if(r.getJoueur2() != null) {
            botLabel = new JLabel(r.getJoueur2().getNom());
        } else {
            botLabel = new JLabel(" [En attente]");
        }
        constrPan();
    }
    
    public JPanel constrPan() {
        
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        setPreferredSize(new Dimension( (int) Math.ceil(LONGUEUR*0.1), (int) Math.ceil(HAUTEUR*0.12)));
        setMaximumSize(new Dimension( (int) Math.ceil(LONGUEUR*0.1),(int) Math.ceil(HAUTEUR*0.12)));
        top.setLayout(new BorderLayout());
        top.add(topLabel, BorderLayout.LINE_START);
        top.add(topScore, BorderLayout.LINE_END);
        top.setBorder(BorderFactory.createLineBorder(Color.black));
        top.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nouvScore = (String)JOptionPane.showInputDialog(JFrameMain.self, "Entrez le score de cette manière : setJ1-setJ2", "Score match", JOptionPane.PLAIN_MESSAGE);
                rencontre.setScore(nouvScore);
                JFrameMain.saveAndRefresh(rencontre.getTournoi());
            }
        });
        add(top);
        bot.setLayout(new BorderLayout());
        bot.add(botLabel, BorderLayout.LINE_START);
        bot.add(botScore, BorderLayout.LINE_END);
        bot.setBorder(BorderFactory.createLineBorder(Color.black));
        bot.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nouvScore = (String)JOptionPane.showInputDialog(JFrameMain.self, "Entrez le score de cette manière : setJ1-setJ2", "Score match", JOptionPane.PLAIN_MESSAGE);
                rencontre.setScore(nouvScore);
                JFrameMain.saveAndRefresh(rencontre.getTournoi(), rencontre);
                
            }
        });
        add(bot);
        return this;
    }
}
