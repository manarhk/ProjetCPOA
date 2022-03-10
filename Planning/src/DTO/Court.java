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
public class Court {
    private int id_cours;
    private String cours;
    private static ArrayList<Court> cours_disponibles = new ArrayList();
    
    public Court() {
        
    }
    
    public Court(int id, String c) {
        this.id_cours = id;
        this.cours = c;
        cours_disponibles.add(this);
    }

    public int getId_cours() {
        return id_cours;
    }

    public void setId_cours(int id_cours) {
        this.id_cours = id_cours;
    }

    public String getCours() {
        return cours;
    }

    public void setCours(String cours) {
        this.cours = cours;
    }

    public static ArrayList<Court> getCours_disponibles() {
        return cours_disponibles;
    }


    @Override
    public String toString() {
        return "CoursDTO{" + "id_cours=" + id_cours + ", cours=" + cours + '}';
    }
    
    
}
