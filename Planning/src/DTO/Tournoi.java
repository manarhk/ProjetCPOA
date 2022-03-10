/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.ArrayList;
/**
 *
 * @author lucas
 */
public class Tournoi {
    private int id_tournoi;
    private String nom_tournoi;
    private int type_tournoi;
    private static ArrayList<Tournoi> liste_tournoi = new ArrayList();
    private ArrayList<Rencontre> rencontre16 = new ArrayList();
    private ArrayList<Rencontre> rencontre8 = new ArrayList();
    private ArrayList<Rencontre> rencontre4 = new ArrayList();
    private ArrayList<Rencontre> rencontre2 = new ArrayList();
    private Rencontre finale;
    private ArrayList<Personne> joueurs_tournoi = new ArrayList();

    public Tournoi(int id, String nom, int type) {
        this.id_tournoi = id;
        this.nom_tournoi = nom;
        this.type_tournoi = type;
        liste_tournoi.add(this);
    }
    
    public Tournoi(String nom, String type) {
        if (liste_tournoi.size() != 0) {
            this.id_tournoi = liste_tournoi.get(liste_tournoi.size()-1).getId_tournoi() + 1;
        } else {
            this.id_tournoi = 1;
        }
        this.nom_tournoi = nom;
        switch(type) {
            case "Simple":
                this.type_tournoi = 1;
                break;
            case "Double":
                this.type_tournoi = 2;
                break;
            case "Qualifications":
                this.type_tournoi = 0;
                break;
            default:
                this.type_tournoi = 1;
        }
        for (int i = 0; i<=15; i++) {
            this.rencontre16.add(new Rencontre(this,i));
        }
        for (int i = 16; i<=23; i++) {
            this.rencontre8.add(new Rencontre(this,i));
        }
        for (int i = 24; i<=27; i++) {
            this.rencontre4.add(new Rencontre(this,i));
        }
        for (int i = 28; i<=29; i++) {
            this.rencontre2.add(new Rencontre(this,i));
        }
        this.finale = new Rencontre(this, 30);
        ArrayList<Personne> liste_joueur = Personne.getJoueurs();
        for (int i = 0 ; i <32; i++) {
            int random = (int)(Math.random()*(liste_joueur.size()));
            this.joueurs_tournoi.add(liste_joueur.get(random));
            liste_joueur.remove(random);
            
        }
        ArrayList<Personne> liste_ac = Personne.getArbitres_chaise();
        int i = 0;
        int j = 31;
        for (Rencontre r : this.rencontre16) {
            int rand = (int)(Math.random()*(liste_joueur.size()));
            r.setArbitre_chaise(liste_ac.get(rand));
            r.setCours(Court.getCours_disponibles().get(0));
            r.setJoueur1(joueurs_tournoi.get(i));
            r.setJoueur2(joueurs_tournoi.get(j));
            i++;
            j--;
            r.setHeure(Heure.getCreneau_heure().get(0));
            r.setDate(Date.getCreneau_date().get(0));
        }
        for (Rencontre r : this.rencontre8) {
            r.setCours(Court.getCours_disponibles().get(0));
            r.setHeure(Heure.getCreneau_heure().get(0));
            r.setDate(Date.getCreneau_date().get(0));
        }
        for (Rencontre r : this.rencontre4) {
            r.setCours(Court.getCours_disponibles().get(0));
            r.setHeure(Heure.getCreneau_heure().get(0));
            r.setDate(Date.getCreneau_date().get(0));
        }
        for (Rencontre r : this.rencontre2) {
            r.setCours(Court.getCours_disponibles().get(0));
            r.setHeure(Heure.getCreneau_heure().get(0));
            r.setDate(Date.getCreneau_date().get(0));
        }
        this.finale.setCours(Court.getCours_disponibles().get(0));
        this.finale.setHeure(Heure.getCreneau_heure().get(0));
        this.finale.setDate(Date.getCreneau_date().get(0));
        liste_tournoi.add(this);
    } 
    

    public int getId_tournoi() {
        return id_tournoi;
    }

    public void setId_tournoi(int id_tournoi) {
        this.id_tournoi = id_tournoi;
    }

    public String getNom_tournoi() {
        return nom_tournoi;
    }

    public void setNom_tournoi(String nom_tournoi) {
        this.nom_tournoi = nom_tournoi;
    }

    public int getType_tournoiInt() {
        return type_tournoi;
    }
    
    public String getType_tournoi() {
        switch(type_tournoi) {
            case 1:
                return "Simple";
            case 2:
                return "Double";
            case 0:
                return "Qualifications";
            default:
                return "Simple";
        }
    }

    public void setType_tournoi(String type) {
        switch(type) {
            case "Simple":
                this.type_tournoi = 1;
                break;
            case "Double":
                this.type_tournoi = 2;
                break;
            case "Qualifications":
                this.type_tournoi = 0;
                break;
            default:
                this.type_tournoi = 1;
        }
    }

    public ArrayList<Rencontre> getRencontre16() {
        return rencontre16;
    }

    public ArrayList<Rencontre> getRencontre8() {
        return rencontre8;
    }

    public ArrayList<Rencontre> getRencontre4() {
        return rencontre4;
    }

    public ArrayList<Rencontre> getRencontre2() {
        return rencontre2;
    }

    public Rencontre getFinale() {
        return finale;
    }

    public void setFinale(Rencontre finale) {
        this.finale = finale;
    } 

    public static ArrayList<Tournoi> getListe_tournoi() {
        return liste_tournoi;
    }

    public ArrayList<Personne> getJoueurs_tournoi() {
        return joueurs_tournoi;
    }
    
    @Override
    public String toString() {
        return "Tournoi{" + "id_tournoi=" + id_tournoi + ", nom_tournoi=" + nom_tournoi + ", type_tournoi=" + type_tournoi + '}';
    }
    
    
}
