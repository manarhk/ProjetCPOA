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
public class Personne {
    private int id;
    private String nom;
    private String prenom;
    private String telephone;
    private String email;
    private String nationalite;
    private int type;
    private static ArrayList<Personne> joueurs = new ArrayList();
    private static ArrayList<Personne> arbitres_chaise = new ArrayList();
    private static ArrayList<Personne> arbitres_ligne = new ArrayList();
    private static ArrayList<Personne> ramasseurs = new ArrayList();
    
    public Personne() {
        
    }

    public Personne(int id, String nom, String prenom, String telephone, String email, String nationalite, int type) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.email = email;
        this.nationalite = nationalite;
        this.type = type;
        switch(type) {
            case 1:
                joueurs.add(this);
                break;
            case 2:
                arbitres_chaise.add(this);
                break;
            case 3:
                ramasseurs.add(this);
            case 4:
                arbitres_ligne.add(this);
                break;
            default:
                break;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNationalite() {
        return nationalite;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public static ArrayList<Personne> getJoueurs() {
        return joueurs;
    }

    public static ArrayList<Personne> getArbitres_chaise() {
        return arbitres_chaise;
    }

    public static ArrayList<Personne> getArbitres_ligne() {
        return arbitres_ligne;
    }
    
    public static ArrayList<Personne> getRamasseurs() {
        return ramasseurs;
    }

    @Override
    public String toString() {
        return "PersonneDTO{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + '}';
    }
    
    
}
