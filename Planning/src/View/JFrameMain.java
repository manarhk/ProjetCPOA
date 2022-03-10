/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import DAO.*;
import DTO.*;
import java.awt.Window;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;
import planning.main;

/**
 *
 * @author lucas
 */
public class JFrameMain extends JFrame {
    
    //Création des Panels
    public static JFrameMain self;
    private JPanel panel = new JPanel();
    private JPanel navigation = new JPanel();
    private JPanel main = new JPanel();
    private JPanel home = new JPanel();
    private JPanel choix_tournoi = new JPanel();
    private JPanel buttons_tournoi = new JPanel();
    
    //Création des boutons
    private JButton butDemar = new JButton("Démarrer");
    private JButton butTour1 = new JButton();
    private JButton butTour2 = new JButton();
    private JButton butTour3 = new JButton();
    private JButton butSupp1 = new JButton("Supprimer");
    private JButton butSupp2 = new JButton("Supprimer");
    private JButton butSupp3 = new JButton("Supprimer");
    private JButton butNouvTour = new JButton("Nouveau Tournoi");
            
    
    //Card Layout
    private CardLayout card = new CardLayout();
    
    public JFrameMain () {
        super("Planning");
        this.self = this;
        setSize(500,200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setContentPane(constrPane());
    }
    
    public JPanel constrPane() {
        
        //Mise en place des listener sur les boutons
        butDemar.addActionListener(new ActionButton());
        butTour1.addActionListener(new ActionButton());
        butTour2.addActionListener(new ActionButton());
        butTour3.addActionListener(new ActionButton());
        butSupp1.addActionListener(new ActionButton());
        butSupp2.addActionListener(new ActionButton());
        butSupp3.addActionListener(new ActionButton());
        butNouvTour.addActionListener(new ActionButton());
        
        
        //Ajout des composants aux panels du main
        JLabel bienvenue = new JLabel("Bienvenue sur votre application d'aide au planning !");
        home.add(bienvenue);
        
        
        buttons_tournoi.setLayout(new BoxLayout(buttons_tournoi, BoxLayout.PAGE_AXIS));
        JLabel lab1 = new JLabel("A quel arbre de tournoi voulez-vous accéder ?");
        JPanel pane1 = new JPanel();
        JPanel pane2 = new JPanel();
        JPanel pane3 = new JPanel();
        switch (Tournoi.getListe_tournoi().size()) {
            case 3:
                
                butTour1.setText(Tournoi.getListe_tournoi().get(0).getNom_tournoi());
                pane1.add(butTour1);
                pane1.add(butSupp1);
                butTour2.setText(Tournoi.getListe_tournoi().get(1).getNom_tournoi());
                pane2.add(butTour2);
                pane2.add(butSupp2);
                butTour3.setText(Tournoi.getListe_tournoi().get(2).getNom_tournoi());
                pane3.add(butTour3);
                pane3.add(butSupp3);
                buttons_tournoi.add(pane1);
                buttons_tournoi.add(pane2);
                buttons_tournoi.add(pane3);
                break;
            case 2:
                
                butTour1.setText(Tournoi.getListe_tournoi().get(0).getNom_tournoi());
                pane1.add(butTour1);
                pane1.add(butSupp1);
                butTour2.setText(Tournoi.getListe_tournoi().get(1).getNom_tournoi());
                pane2.add(butTour2);
                pane2.add(butSupp2);
                buttons_tournoi.add(pane1);
                buttons_tournoi.add(pane2);
                break;
            case 1:
                butTour1.setText(Tournoi.getListe_tournoi().get(0).getNom_tournoi());
                pane1.add(butTour1);
                pane1.add(butSupp1);
                buttons_tournoi.add(pane1);
                break;
            default:
                break;
        }
        buttons_tournoi.add(butNouvTour);
        
        
        
        
        choix_tournoi.add(lab1);
        choix_tournoi.add(buttons_tournoi);
        
        //Ajout des différents panels au main panel
        main.setLayout(card);
        main.add(home, "home");
        main.add(choix_tournoi, "choix");
        card.show(main, "home");
        
        //Ajout des boutons à la barre de navigation
        navigation.add(butDemar);
        
        //Ajout de la nav et du main à la frame
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        panel.add(navigation);
        panel.add(main);
        
        
        return panel;
    }
    
    public class ActionButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent clic) {
            if (clic.getSource() == butDemar) {
                card.show(main, "choix");
            }
            if (clic.getSource() == butTour1) {
                Tournoi actuel = null;
                for (Tournoi t : Tournoi.getListe_tournoi()) {
                    if (t.getNom_tournoi()==butTour1.getText()) {
                        actuel = t;
                    }
                }
                new JFrameTournoi(actuel);
            }
            if (clic.getSource() == butTour2) {
                Tournoi actuel = null;
                for (Tournoi t : Tournoi.getListe_tournoi()) {
                    if (t.getNom_tournoi()==butTour2.getText()) {
                        actuel = t;
                    }
                }
                new JFrameTournoi(actuel);
            }
            if (clic.getSource() == butTour3) {
                Tournoi actuel = null;
                for (Tournoi t : Tournoi.getListe_tournoi()) {
                    if (t.getNom_tournoi()==butTour3.getText()) {
                        actuel = t;
                    }
                }
                new JFrameTournoi(actuel);
            }
            if (clic.getSource() == butNouvTour) {
                Icon icon = null;
                Object[] types = {"Simple", "Double", "Qualifications"}; 
                String nomTour = (String)JOptionPane.showInputDialog(self, "Quel nom voulez vous donner à votre Tournoi", "Nouveau Tournoi", JOptionPane.PLAIN_MESSAGE);
                String typeTour = (String)JOptionPane.showInputDialog(self, "Quel est le type de votre Tournoi", "Nouveau Tournoi", JOptionPane.PLAIN_MESSAGE, icon, types, "Simple");
                Tournoi nouvTournoi = new Tournoi(nomTour, typeTour);
                new JFrameTournoi(nouvTournoi);
                TournoiDAO tournoiManager = new TournoiDAO(planning.main.c);
                if(Tournoi.getListe_tournoi().size() < 3) {
                    tournoiManager.saveTournoi(nouvTournoi);
                } else {
                    System.out.println("Déjà trois tournois enregistrés");
                }
            }
            if(clic.getSource() == butSupp1) {
                int reply = JOptionPane.showConfirmDialog(null, "Cette action est définitive, êtes-vous sûr ?", "Supprimer Tournoi", JOptionPane.YES_NO_OPTION);
                if (reply == JOptionPane.YES_OPTION) {
                    Tournoi actuel = null;
                    for (Tournoi t : Tournoi.getListe_tournoi()) {
                        if (t.getNom_tournoi()==butTour1.getText()) {
                            actuel = t;
                        }
                    }
                    TournoiDAO tournoiManager = new TournoiDAO(planning.main.c);
                    tournoiManager.supprTournoi(actuel);
                }
            }
            
            if(clic.getSource() == butSupp2) {
                int reply = JOptionPane.showConfirmDialog(null, "Cette action est définitive, êtes-vous sûr ?", "Supprimer Tournoi", JOptionPane.YES_NO_OPTION);
                if (reply == JOptionPane.YES_OPTION) {
                    Tournoi actuel = null;
                    for (Tournoi t : Tournoi.getListe_tournoi()) {
                        if (t.getNom_tournoi()==butTour2.getText()) {
                            actuel = t;
                        }
                    }
                    TournoiDAO tournoiManager = new TournoiDAO(planning.main.c);
                    tournoiManager.supprTournoi(actuel);
                }
            }
            if(clic.getSource() == butSupp3) {
                int reply = JOptionPane.showConfirmDialog(null, "Cette action est définitive, êtes-vous sûr ?", "Supprimer Tournoi", JOptionPane.YES_NO_OPTION);
                if (reply == JOptionPane.YES_OPTION) {
                    Tournoi actuel = null;
                    for (Tournoi t : Tournoi.getListe_tournoi()) {
                        if (t.getNom_tournoi()==butTour2.getText()) {
                            actuel = t;
                        }
                    }
                    TournoiDAO tournoiManager = new TournoiDAO(planning.main.c);
                    tournoiManager.supprTournoi(actuel);
                }
            }
        }
    }
    
    public static void saveAndRefresh(Tournoi t, Rencontre r) {
        TournoiDAO tournoiManager = new TournoiDAO(planning.main.c);
        RencontreDAO rencontreManager = new RencontreDAO(planning.main.c);
        tournoiManager.saveTournoi(t);
        rencontreManager.updateScoreRencontre(r.getId_rencontre(), r.getScore());
        tournoiManager.getAllTournois();
        JFrameTournoi suppr = null;
        for (JFrameTournoi f : JFrameTournoi.getListeFrame()) {
            if (f.getMonTournoi().equals(t)) {
                suppr = f;
            }
        }
        suppr.dispose();
        JFrameTournoi.getListeFrame().remove(suppr);
        boolean cond = false;
        for (Tournoi tour : Tournoi.getListe_tournoi()) {
            if (tour.getId_tournoi()==t.getId_tournoi() && !cond) {
                new JFrameTournoi(tour);
                cond = true;
            }
        }
    }
    
    public static void saveAndRefresh(Tournoi t) {
        TournoiDAO tournoiManager = new TournoiDAO(planning.main.c);
        RencontreDAO rencontreManager = new RencontreDAO(planning.main.c);
        tournoiManager.saveTournoi(t);
        for (Rencontre r : t.getRencontre16()) {
            rencontreManager.updateScoreRencontre(r.getId_rencontre(), r.getScore());
        }
        for (Rencontre r : t.getRencontre8()) {
            rencontreManager.updateScoreRencontre(r.getId_rencontre(), r.getScore());
        }
        for (Rencontre r : t.getRencontre4()) {
            rencontreManager.updateScoreRencontre(r.getId_rencontre(), r.getScore());
        }
        for (Rencontre r : t.getRencontre2()) {
            rencontreManager.updateScoreRencontre(r.getId_rencontre(), r.getScore());
        }
        rencontreManager.updateScoreRencontre(t.getFinale().getId_rencontre(), t.getFinale().getScore());
        tournoiManager.getAllTournois();
        JFrameTournoi suppr = null;
        for (JFrameTournoi f : JFrameTournoi.getListeFrame()) {
            if (f.getMonTournoi().equals(t)) {
                suppr = f;
            }
        }
        suppr.dispose();
        JFrameTournoi.getListeFrame().remove(suppr);
        boolean cond = false;
        for (Tournoi tour : Tournoi.getListe_tournoi()) {
            if (tour.getId_tournoi()==t.getId_tournoi() && !cond) {
                new JFrameTournoi(tour);
                cond = true;
            }
        }
        
        
    }
    
    
}
