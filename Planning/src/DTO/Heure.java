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
public class Heure {
    private int id_heure;
    private String heure;
    private static ArrayList<Heure> creneau_heure = new ArrayList();
    
    public Heure() {
        
    }
    
    public Heure(int id, String h) {
        this.id_heure = id;
        this.heure = h;
        creneau_heure.add(this);
    }

    public int getId_heure() {
        return id_heure;
    }

    public void setId_heure(int id_heure) {
        this.id_heure = id_heure;
    }

    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

    public static ArrayList<Heure> getCreneau_heure() {
        return creneau_heure;
    }

    public static void setCreneau_heure(ArrayList<Heure> creneau_heure) {
        Heure.creneau_heure = creneau_heure;
    }
    
    
}
