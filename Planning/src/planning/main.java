/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planning;

import View.*;
import DAO.*;
import DTO.Court;
import DTO.Personne;
import DTO.Tournoi;
import java.sql.*;
/**
 *
 * @author lucas
 */
public class main {
    private static DataSource DS = new DataSource();
    public static Connection c = DS.getConnection();
    
    public static void main(String[] args) {
        PersonneDAO personneManager = new PersonneDAO(c);
        personneManager.getAllPersonne();
        CourtDAO coursManager = new CourtDAO(c);
        coursManager.getAllCourt();
        HeureDAO heureManager = new HeureDAO(c);
        heureManager.getAllHeure();
        DateDAO dateManager = new DateDAO(c);
        dateManager.getAllDate();
        TournoiDAO tournoiManager = new TournoiDAO(planning.main.c);
        tournoiManager.getAllTournois();
        JFrameMain test = new JFrameMain();
    }
}
