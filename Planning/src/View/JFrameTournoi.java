/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import DTO.*;
import controller.BoiteRencontre;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.Border;


/**
 *
 * @author lucas
 */
public class JFrameTournoi extends JFrame {
    private JPanel ecran = new JPanel();
    private JButton sauvegarder = new JButton("Sauvegarder");
    private JPanel screen = new JPanel();
    private Tournoi monTournoi;
    private ArrayList<BoiteRencontre> boites16 = new ArrayList();
    private ArrayList<BoiteRencontre> boites8 = new ArrayList();
    private ArrayList<BoiteRencontre> boites4 = new ArrayList();
    private ArrayList<BoiteRencontre> boites2 = new ArrayList();
    private BoiteRencontre finale;
    private static ArrayList<JFrameTournoi> listeFrame = new ArrayList();
    
    public JFrameTournoi(Tournoi t) {
        super("Planning Tournoi");
        listeFrame.add(this);
        monTournoi = t;
        setSize(1700,850);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setContentPane(constrPane());
    }
    
    public JPanel constrPane() {
        sauvegarder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrameMain.saveAndRefresh(monTournoi);
            }
        });
        screen.setLayout(new GridLayout(1,5));
        JPanel round16 = new JPanel();
        round16.setLayout(new BoxLayout(round16, BoxLayout.Y_AXIS));
        round16.add(new JLabel("16° de finale"));

        JPanel round8 = new JPanel();
        round8.setLayout(new BoxLayout(round8, BoxLayout.Y_AXIS));
        round8.add(new JLabel("8° de finale"));

        JPanel quarter = new JPanel();
        quarter.setLayout(new BoxLayout(quarter, BoxLayout.Y_AXIS));
        quarter.add(new JLabel("Quarts de finale"));
        
        JPanel semi = new JPanel();
        semi.setLayout(new BoxLayout(semi, BoxLayout.Y_AXIS));
        semi.add(new JLabel("Demies-finale"));
        
        JPanel finalMat = new JPanel();
        finalMat.setLayout(new BoxLayout(finalMat, BoxLayout.Y_AXIS));
        finalMat.add(new JLabel("Grande finale"));
        for (Rencontre r : monTournoi.getRencontre16()) {
            boites16.add(new BoiteRencontre(r));
        }
        for (Rencontre r : monTournoi.getRencontre8()) {
            boites8.add(new BoiteRencontre(r));
        }
        for (Rencontre r : monTournoi.getRencontre4()) {
            boites4.add(new BoiteRencontre(r));
        }
        for (Rencontre r : monTournoi.getRencontre2()) {
            boites2.add(new BoiteRencontre(r));
        }
        finale = new BoiteRencontre(monTournoi.getFinale());
        

        Border border = BorderFactory.createRaisedSoftBevelBorder();
        
        round16.setBorder(border);
        round8.setBorder(border);
        quarter.setBorder(border);
        semi.setBorder(border);
        finalMat.setBorder(border);
        
        int space = 0;
        int cpt=0;
        for(int i=0;i<16;i++) {
            cpt++;
            JPanel n = new JPanel();
            n.setPreferredSize(new Dimension((int) Math.ceil(BoiteRencontre.LONGUEUR*0.1), space));
            n.setMaximumSize(new Dimension((int) Math.ceil(BoiteRencontre.LONGUEUR*0.1), space));
            n.setMinimumSize(new Dimension((int) Math.ceil(BoiteRencontre.LONGUEUR*0.1), space));
            round16.add(n);

            round16.add(boites16.get(i));

            JPanel m = new JPanel();
            m.setPreferredSize(new Dimension((int) Math.ceil(BoiteRencontre.LONGUEUR*0.1), space));
            m.setMaximumSize(new Dimension((int) Math.ceil(BoiteRencontre.LONGUEUR*0.1), space));
            m.setMinimumSize(new Dimension((int) Math.ceil(BoiteRencontre.LONGUEUR*0.1), space));
            round16.add(m);

            if(cpt==1) {
                JPanel f = new JPanel();
                f.setPreferredSize(new Dimension((int) Math.ceil(BoiteRencontre.LONGUEUR*0.1), 5));
                f.setMaximumSize(new Dimension((int) Math.ceil(BoiteRencontre.LONGUEUR*0.1), 5));
                f.setMinimumSize(new Dimension((int) Math.ceil(BoiteRencontre.LONGUEUR*0.1), 5));
                round16.add(f); 
            }

            if(cpt==2) {
                cpt=0;
                JPanel r = new JPanel();
                r.setPreferredSize(new Dimension((int) Math.ceil(BoiteRencontre.LONGUEUR*0.1), 20));
                r.setMaximumSize(new Dimension((int) Math.ceil(BoiteRencontre.LONGUEUR*0.1), 20));
                r.setMinimumSize(new Dimension((int) Math.ceil(BoiteRencontre.LONGUEUR*0.1), 20));
                round16.add(r);
            }

        }
        screen.add(round16);
        
        cpt=0;

        for(int i=0;i<8;i++) {
            cpt++;
            if(cpt!=1) {
                JPanel f = new JPanel();
                f.setPreferredSize(new Dimension((int) Math.ceil(BoiteRencontre.LONGUEUR*0.1), 5));
                f.setMaximumSize(new Dimension((int) Math.ceil(BoiteRencontre.LONGUEUR*0.1), 5));
                f.setMinimumSize(new Dimension((int) Math.ceil(BoiteRencontre.LONGUEUR*0.1), 5));
                round8.add(f); 
            }

            JPanel n = new JPanel();
            n.setPreferredSize(new Dimension((int) Math.ceil(BoiteRencontre.LONGUEUR*0.1), 5));
            n.setMaximumSize(new Dimension((int) Math.ceil(BoiteRencontre.LONGUEUR*0.1), 5));
            n.setMinimumSize(new Dimension((int) Math.ceil(BoiteRencontre.LONGUEUR*0.1), 5));
            round8.add(n);

            round8.add(boites8.get(i));

            JPanel m = new JPanel();
            m.setPreferredSize(new Dimension((int) Math.ceil(BoiteRencontre.LONGUEUR*0.1), 5));
            m.setMaximumSize(new Dimension((int) Math.ceil(BoiteRencontre.LONGUEUR*0.1), 5));
            m.setMinimumSize(new Dimension((int) Math.ceil(BoiteRencontre.LONGUEUR*0.1), 5));
            round8.add(m);

            JPanel r = new JPanel();
            r.setPreferredSize(new Dimension((int) Math.ceil(BoiteRencontre.LONGUEUR*0.1), 20));
            r.setMaximumSize(new Dimension((int) Math.ceil(BoiteRencontre.LONGUEUR*0.1), 20));
            r.setMinimumSize(new Dimension((int) Math.ceil(BoiteRencontre.LONGUEUR*0.1), 20));
            round8.add(r);


        }
        screen.add(round8);



        for(int i=0;i<4;i++) {

            JPanel f = new JPanel();
            f.setPreferredSize(new Dimension((int) Math.ceil(BoiteRencontre.LONGUEUR*0.1), 10));
            f.setMaximumSize(new Dimension((int) Math.ceil(BoiteRencontre.LONGUEUR*0.1), 10));
            f.setMinimumSize(new Dimension((int) Math.ceil(BoiteRencontre.LONGUEUR*0.1), 10));
            quarter.add(f); 

            JPanel n = new JPanel();
            n.setPreferredSize(new Dimension((int) Math.ceil(BoiteRencontre.LONGUEUR*0.1), 40));
            n.setMaximumSize(new Dimension((int) Math.ceil(BoiteRencontre.LONGUEUR*0.1), 40));
            n.setMinimumSize(new Dimension((int) Math.ceil(BoiteRencontre.LONGUEUR*0.1), 40));
            quarter.add(n);

            quarter.add(boites4.get(i));

            JPanel m = new JPanel();
            m.setPreferredSize(new Dimension((int) Math.ceil(BoiteRencontre.LONGUEUR*0.1), 40));
            m.setMaximumSize(new Dimension((int) Math.ceil(BoiteRencontre.LONGUEUR*0.1), 40));
            m.setMinimumSize(new Dimension((int) Math.ceil(BoiteRencontre.LONGUEUR*0.1), 40));
            quarter.add(m);

            JPanel r = new JPanel();
            r.setPreferredSize(new Dimension((int) Math.ceil(BoiteRencontre.LONGUEUR*0.1), 40));
            r.setMaximumSize(new Dimension((int) Math.ceil(BoiteRencontre.LONGUEUR*0.1), 40));
            r.setMinimumSize(new Dimension((int) Math.ceil(BoiteRencontre.LONGUEUR*0.1), 40));
            quarter.add(r);


        }
        screen.add(quarter);



        for(int i=0;i<2;i++) {

            JPanel f = new JPanel();
            f.setPreferredSize(new Dimension((int) Math.ceil(BoiteRencontre.LONGUEUR*0.1), 35));
            f.setMaximumSize(new Dimension((int) Math.ceil(BoiteRencontre.LONGUEUR*0.1), 35));
            f.setMinimumSize(new Dimension((int) Math.ceil(BoiteRencontre.LONGUEUR*0.1), 35));
            semi.add(f);


            JPanel n = new JPanel();
            n.setPreferredSize(new Dimension((int) Math.ceil(BoiteRencontre.LONGUEUR*0.1), 100));
            n.setMaximumSize(new Dimension((int) Math.ceil(BoiteRencontre.LONGUEUR*0.1), 100));
            n.setMinimumSize(new Dimension((int) Math.ceil(BoiteRencontre.LONGUEUR*0.1), 100));
            semi.add(n);

            semi.add(boites2.get(i));

            JPanel m = new JPanel();
            m.setPreferredSize(new Dimension((int) Math.ceil(BoiteRencontre.LONGUEUR*0.1), 100));
            m.setMaximumSize(new Dimension((int) Math.ceil(BoiteRencontre.LONGUEUR*0.1), 100));
            m.setMinimumSize(new Dimension((int) Math.ceil(BoiteRencontre.LONGUEUR*0.1), 100));
            semi.add(m);

            JPanel r = new JPanel();
            r.setPreferredSize(new Dimension((int) Math.ceil(BoiteRencontre.LONGUEUR*0.1), 75));
            r.setMaximumSize(new Dimension((int) Math.ceil(BoiteRencontre.LONGUEUR*0.1), 75));
            r.setMinimumSize(new Dimension((int) Math.ceil(BoiteRencontre.LONGUEUR*0.1), 75));
            semi.add(r);

            
        }
        screen.add(semi);
        
        JPanel f = new JPanel();
        f.setPreferredSize(new Dimension((int) Math.ceil(BoiteRencontre.LONGUEUR*0.1), 75));
        f.setMaximumSize(new Dimension((int) Math.ceil(BoiteRencontre.LONGUEUR*0.1), 75));
        f.setMinimumSize(new Dimension((int) Math.ceil(BoiteRencontre.LONGUEUR*0.1), 75));
        finalMat.add(f);


        JPanel n = new JPanel();
        n.setPreferredSize(new Dimension((int) Math.ceil(BoiteRencontre.LONGUEUR*0.1), 200));
        n.setMaximumSize(new Dimension((int) Math.ceil(BoiteRencontre.LONGUEUR*0.1), 200));
        n.setMinimumSize(new Dimension((int) Math.ceil(BoiteRencontre.LONGUEUR*0.1), 200));
        finalMat.add(n);

        finalMat.add(finale, BorderLayout.CENTER);

        screen.add(finalMat);
        ecran.setLayout(new BoxLayout(ecran, BoxLayout.PAGE_AXIS));
        ecran.add(sauvegarder);
        ecran.add(screen);
        return screen;
    }

    public static ArrayList<JFrameTournoi> getListeFrame() {
        return listeFrame;
    }
    
    public void disposeSelf() {
        this.dispose();
    }

    public Tournoi getMonTournoi() {
        return monTournoi;
    }
    
    
}
