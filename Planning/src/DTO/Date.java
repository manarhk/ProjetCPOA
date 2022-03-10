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
public class Date {
    private int id_date;
    private String date;
    private static ArrayList<Date> creneau_date = new ArrayList();
    
    public Date() {
        
    }
    
    public Date(int id, String h) {
        this.id_date = id;
        this.date = h;
        creneau_date.add(this);
    }

    public int getId_date() {
        return id_date;
    }

    public void setId_date(int id_date) {
        this.id_date = id_date;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public static ArrayList<Date> getCreneau_date() {
        return creneau_date;
    }

    public static void setCreneau_date(ArrayList<Date> creneau_date) {
        Date.creneau_date = creneau_date;
    }
}
