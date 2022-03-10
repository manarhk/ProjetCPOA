/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.*;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author lucas
 */
public class RencontreDAO {
    private Connection conn;

    public RencontreDAO(Connection conn) {
        this.conn = conn;
    }
    
    public void getRencontresTournoi(Tournoi t) {
        ResultSet rset;
        Statement stmt = null;
        try {
            String rqt = "SELECT * FROM rencontre WHERE id_tournoi=?";
            PreparedStatement pst = conn.prepareStatement(rqt);
            pst.setInt(1,t.getId_tournoi());
            rset = pst.executeQuery();
            while(rset.next()) {
                if (0<=rset.getInt("num_rencontre") && 15>=rset.getInt("num_rencontre")) {
                    Personne joueur1 = null, joueur2 = null, ac = null;
                    DTO.Date date = null;
                    Court cours = null;
                    Heure heure = null;
                    for(Personne p : Personne.getJoueurs()) {
                        if (p.getId()==rset.getInt("joueur1")) {
                            joueur1 = p;
                        }
                        if (p.getId()==rset.getInt("joueur2")) {
                            joueur2 = p;
                        }
                    }
                    for (Personne a : Personne.getArbitres_chaise()) {
                        if (a.getId()==rset.getInt("arbitre_chaise")) {
                            ac = a;
                        }
                    }
                    for (Heure h : Heure.getCreneau_heure()) {
                        if (h.getId_heure()==rset.getInt("heure")){
                            heure = h;
                        }
                    }
                    for (DTO.Date d : DTO.Date.getCreneau_date()) {
                        if (d.getId_date()==rset.getInt("date")) {
                            date = d;
                        }
                    }
                    for (Court c : Court.getCours_disponibles()) {
                        if (c.getId_cours()==rset.getInt("cours")) {
                            cours = c;
                        }
                    }
                    t.getRencontre16().add(new Rencontre(rset.getInt("id_rencontre"), joueur1, joueur2, ac, heure, date, cours, rset.getString("score"), t, rset.getInt("num_rencontre")));
                } else if (16<=rset.getInt("num_rencontre") && 23>=rset.getInt("num_rencontre")) {
                    Personne joueur1 = null, joueur2 = null, ac = null;
                    DTO.Date date = null;
                    Court cours = null;
                    Heure heure = null;
                    for(Personne p : Personne.getJoueurs()) {
                        if (p.getId()==rset.getInt("joueur1")) {
                            joueur1 = p;
                        }
                        if (p.getId()==rset.getInt("joueur2")) {
                            joueur2 = p;
                        }
                    }
                    for (Personne a : Personne.getArbitres_chaise()) {
                        if (a.getId()==rset.getInt("arbitre_chaise")) {
                            ac = a;
                        }
                    }
                    for (Heure h : Heure.getCreneau_heure()) {
                        if (h.getId_heure()==rset.getInt("heure")){
                            heure = h;
                        }
                    }
                    for (DTO.Date d : DTO.Date.getCreneau_date()) {
                        if (d.getId_date()==rset.getInt("date")) {
                            date = d;
                        }
                    }
                    for (Court c : Court.getCours_disponibles()) {
                        if (c.getId_cours()==rset.getInt("cours")) {
                            cours = c;
                        }
                    }
                    t.getRencontre8().add(new Rencontre(rset.getInt("id_rencontre"), joueur1, joueur2, ac, heure, date, cours, rset.getString("score"), t, rset.getInt("num_rencontre")));
                } else if (24<=rset.getInt("num_rencontre") && 27>=rset.getInt("num_rencontre")) {
                    Personne joueur1 = null, joueur2 = null, ac = null;
                    DTO.Date date = null;
                    Court cours = null;
                    Heure heure = null;
                    for(Personne p : Personne.getJoueurs()) {
                        if (p.getId()==rset.getInt("joueur1")) {
                            joueur1 = p;
                        }
                        if (p.getId()==rset.getInt("joueur2")) {
                            joueur2 = p;
                        }
                    }
                    for (Personne a : Personne.getArbitres_chaise()) {
                        if (a.getId()==rset.getInt("arbitre_chaise")) {
                            ac = a;
                        }
                    }
                    for (Heure h : Heure.getCreneau_heure()) {
                        if (h.getId_heure()==rset.getInt("heure")){
                            heure = h;
                        }
                    }
                    for (DTO.Date d : DTO.Date.getCreneau_date()) {
                        if (d.getId_date()==rset.getInt("date")) {
                            date = d;
                        }
                    }
                    for (Court c : Court.getCours_disponibles()) {
                        if (c.getId_cours()==rset.getInt("cours")) {
                            cours = c;
                        }
                    }
                    t.getRencontre4().add(new Rencontre(rset.getInt("id_rencontre"), joueur1, joueur2, ac, heure, date, cours, rset.getString("score"), t, rset.getInt("num_rencontre")));
                } else if (28<=rset.getInt("num_rencontre") && 29>=rset.getInt("num_rencontre")) {
                    Personne joueur1 = null, joueur2 = null, ac = null;
                    DTO.Date date = null;
                    Court cours = null;
                    Heure heure = null;
                    for(Personne p : Personne.getJoueurs()) {
                        if (p.getId()==rset.getInt("joueur1")) {
                            joueur1 = p;
                        }
                        if (p.getId()==rset.getInt("joueur2")) {
                            joueur2 = p;
                        }
                    }
                    for (Personne a : Personne.getArbitres_chaise()) {
                        if (a.getId()==rset.getInt("arbitre_chaise")) {
                            ac = a;
                        }
                    }
                    for (Heure h : Heure.getCreneau_heure()) {
                        if (h.getId_heure()==rset.getInt("heure")){
                            heure = h;
                        }
                    }
                    for (DTO.Date d : DTO.Date.getCreneau_date()) {
                        if (d.getId_date()==rset.getInt("date")) {
                            date = d;
                        }
                    }
                    for (Court c : Court.getCours_disponibles()) {
                        if (c.getId_cours()==rset.getInt("cours")) {
                            cours = c;
                        }
                    }
                    t.getRencontre2().add(new Rencontre(rset.getInt("id_rencontre"), joueur1, joueur2, ac, heure, date, cours, rset.getString("score"), t, rset.getInt("num_rencontre")));
                } else {
                    Personne joueur1 = null, joueur2 = null, ac = null;
                    DTO.Date date = null;
                    Court cours = null;
                    Heure heure = null;
                    for(Personne p : Personne.getJoueurs()) {
                        if (p.getId()==rset.getInt("joueur1")) {
                            joueur1 = p;
                        }
                        if (p.getId()==rset.getInt("joueur2")) {
                            joueur2 = p;
                        }
                    }
                    for (Personne a : Personne.getArbitres_chaise()) {
                        if (a.getId()==rset.getInt("arbitre_chaise")) {
                            ac = a;
                        }
                    }
                    for (Heure h : Heure.getCreneau_heure()) {
                        if (h.getId_heure()==rset.getInt("heure")){
                            heure = h;
                        }
                    }
                    for (DTO.Date d : DTO.Date.getCreneau_date()) {
                        if (d.getId_date()==rset.getInt("date")) {
                            date = d;
                        }
                    }
                    for (Court c : Court.getCours_disponibles()) {
                        if (c.getId_cours()==rset.getInt("cours")) {
                            cours = c;
                        }
                    }
                    t.setFinale(new Rencontre(rset.getInt("id_rencontre"), joueur1, joueur2, ac, heure, date, cours, rset.getString("score"), t, rset.getInt("num_rencontre")));
                }
            }
        } catch (SQLException exc) {
            System.out.println(exc);
        }
    }

    public void saveRencontreTournoi(Tournoi t) {
        ArrayList<Rencontre> rencontres = new ArrayList();
        for (Rencontre r : t.getRencontre16()) {
            rencontres.add(r);
        }
        for (Rencontre r : t.getRencontre8()) {
            rencontres.add(r);
        }
        for (Rencontre r : t.getRencontre4()) {
            rencontres.add(r);
        }
        for (Rencontre r : t.getRencontre2()) {
            rencontres.add(r);
        }
        rencontres.add(t.getFinale());
        for (Rencontre r : rencontres) {
            Statement stmt = null;
            try {
                String rqt = "INSERT INTO rencontre VALUES (?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement pst = conn.prepareStatement(rqt);
                pst.setInt(1,r.getId_rencontre());
                if (r.getJoueur1() != null)
                    pst.setInt(2, r.getJoueur1().getId());
                else 
                    pst.setInt(2, 1000);
                if (r.getJoueur2() != null)
                    pst.setInt(3, r.getJoueur2().getId());
                else 
                    pst.setInt(3, 1000);
                if (r.getArbitre_chaise()!= null)
                    pst.setInt(4, r.getArbitre_chaise().getId());
                else 
                    pst.setInt(4, 1000);
                pst.setInt(5, r.getHeure().getId_heure());
                pst.setInt(6, r.getDate().getId_date());
                pst.setInt(7, r.getCours().getId_cours());
                pst.setString(8, r.getScore());
                pst.setInt(9, r.getTournoi().getId_tournoi());
                pst.setInt(10, r.getNum_rencontre());
                pst.executeUpdate();
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

    void supprimeRencontreTournoi(Tournoi t) {
        Statement stmt = null;
        try {
            String rqt = "DELETE FROM rencontre WHERE id_tournoi=?";
            PreparedStatement pst = conn.prepareStatement(rqt);
            pst.setInt(1,t.getId_tournoi());
            pst.executeUpdate();
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

    public void updateScoreRencontre(int id, String score) {
        Statement stmt = null;
        try {
            String rqt = "UPDATE rencontre SET score=? WHERE id_rencontre=?";
            PreparedStatement pst = conn.prepareStatement(rqt);
            pst.setString(1, score);
            pst.setInt(2, id);
            pst.executeUpdate();
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

