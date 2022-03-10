/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author lucas
 */
public class Rencontre {
    private int id_rencontre;
    private Personne joueur1;
    private Personne joueur2;
    private Personne arbitre_chaise;
    private Heure heure;
    private Date date;
    private Court cours;
    private String score;
    private Tournoi tournoi;
    private int num_rencontre;
    
    public Rencontre() {
        
    }
    
    public Rencontre(Tournoi tournoi, int num_rencontre) {
        this.tournoi = tournoi;
        this.num_rencontre = num_rencontre;
        this.score = "0-0";
    }
    
    public Rencontre(Personne joueur1, Personne joueur2, Tournoi tournoi, int num_rencontre) {
        this.joueur1 = joueur1;
        this.joueur2 = joueur2;
        this.tournoi = tournoi;
        this.num_rencontre = num_rencontre;
        this.score = "0-0";
    }

    public Rencontre(int id_rencontre, Personne joueur1, Personne joueur2, Personne arbitre_chaise, Heure heure, Date date, Court cours, String score, Tournoi tournoi, int num_rencontre) {
        this.id_rencontre = id_rencontre;
        this.joueur1 = joueur1;
        this.joueur2 = joueur2;
        this.arbitre_chaise = arbitre_chaise;
        this.heure = heure;
        this.date = date;
        this.cours = cours;
        this.score = score;
        this.tournoi = tournoi;
        this.num_rencontre = num_rencontre;
    }

    public int getId_rencontre() {
        return id_rencontre;
    }

    public void setId_rencontre(int id_rencontre) {
        this.id_rencontre = id_rencontre;
    }

    public Personne getJoueur1() {
        return joueur1;
    }

    public void setJoueur1(Personne joueur1) {
        this.joueur1 = joueur1;
    }

    public Personne getJoueur2() {
        return joueur2;
    }

    public void setJoueur2(Personne joueur2) {
        this.joueur2 = joueur2;
    }

    public Personne getArbitre_chaise() {
        return arbitre_chaise;
    }

    public void setArbitre_chaise(Personne arbitre_chaise) {
        this.arbitre_chaise = arbitre_chaise;
    }

    public Heure getHeure() {
        return heure;
    }

    public void setHeure(Heure heure) {
        this.heure = heure;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Court getCours() {
        return cours;
    }

    public void setCours(Court cours) {
        this.cours = cours;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public Tournoi getTournoi() {
        return tournoi;
    }

    public void setTournoi(Tournoi tournoi) {
        this.tournoi = tournoi;
    }

    public int getNum_rencontre() {
        return num_rencontre;
    }

    public void setNum_rencontre(int num_rencontre) {
        this.num_rencontre = num_rencontre;
    }
    
    
}
