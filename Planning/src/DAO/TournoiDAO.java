/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.*;
import DTO.*;
import java.util.ArrayList;
/**
 *
 * @author lucas
 */
public class TournoiDAO {
    private Connection conn;

    public TournoiDAO(Connection conn) {
        this.conn = conn;
    }
    
    public Tournoi getTournoiParId(int id) {
        ResultSet rset;
        Statement stmt = null;
        try {
            //stmt = connexionBD.createStatement();
            String rqt = "SELECT * FROM tournoi WHERE id=?";
            PreparedStatement pst = conn.prepareStatement(rqt);
            pst.setInt(1,id);
            rset = pst.executeQuery();
            rset.next();
            System.out.println("ID LOADED : "+rset.getInt("id"));
            int id_tournoi = rset.getInt("id_tournoi");
            Tournoi t = new Tournoi(rset.getInt("id_tournoi"),rset.getString("nom_tournoi"),rset.getInt("type_tournoi"));
            RencontreDAO rencontreManager = new RencontreDAO(conn);
            rencontreManager.getRencontresTournoi(t);
            for (Rencontre r : t.getRencontre16()) {
                t.getJoueurs_tournoi().add(r.getJoueur1());
                t.getJoueurs_tournoi().add(r.getJoueur2());
            }
            System.out.println(t);
            return t;
        } catch (SQLException exc) {
            System.out.println(exc.getMessage());
            return null;
        } finally {
            try {
                // la clause finally est toujours executée, quoi qu'il arrive
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException ex) {
                return null;
            }
        }
    }
    
    public void getAllTournois() {
        ResultSet rset;
        Statement stmt = null;
        RencontreDAO rencontreManager = new RencontreDAO(conn);
        try {
            //stmt = connexionBD.createStatement();
            String rqt = "SELECT * FROM tournoi";
            PreparedStatement pst = conn.prepareStatement(rqt);
            rset = pst.executeQuery();
            while(rset.next()) {
                rencontreManager.getRencontresTournoi(new Tournoi(rset.getInt("id_tournoi"), rset.getString("nom_tournoi"), rset.getInt("type_tournoi")));
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }
    }
    
    public void saveTournoi(Tournoi t) {
        Statement stmt = null;
        RencontreDAO rencontreManager = new RencontreDAO(conn);
        boolean existe = false;
        try {
            //stmt = connexionBD.createStatement();
            for (Tournoi tour : Tournoi.getListe_tournoi()) {
                if (t.getId_tournoi() == tour.getId_tournoi()) {
                    existe = true;
                }
            }
            if (existe) {
                
            } else {
                String rqt = "INSERT INTO tournoi VALUES (?,?,?)";
                PreparedStatement pst = conn.prepareStatement(rqt);
                pst.setInt(1,t.getId_tournoi());
                pst.setString(2, t.getNom_tournoi());
                pst.setInt(3, t.getType_tournoiInt());
                pst.executeUpdate();
                rencontreManager.saveRencontreTournoi(t);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }
    }
    
    public void supprTournoi(Tournoi t) {
        Statement stmt = null;
        RencontreDAO rencontreManager = new RencontreDAO(conn);
        rencontreManager.supprimeRencontreTournoi(t);
        try {
            //stmt = connexionBD.createStatement();
            String rqt = "DELETE FROM tournoi WHERE id_tournoi=?";
            PreparedStatement pst = conn.prepareStatement(rqt);
            pst.setInt(1,t.getId_tournoi());
            pst.executeUpdate();
            rencontreManager.saveRencontreTournoi(t);
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }
    }
}
