/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.*;
import java.sql.*;
/**
 *
 * @author lucas
 */
public class PersonneDAO {
    private Connection conn;

    public PersonneDAO(Connection conn) {
        this.conn = conn;
    }
    
    public Personne getPersonneParId(int id) {
        ResultSet rset;
        Statement stmt = null;
        try {
            //stmt = connexionBD.createStatement();
            String rqt = "SELECT * FROM personne WHERE id=?";
            PreparedStatement pst = conn.prepareStatement(rqt);
            pst.setInt(1,id);
            rset = pst.executeQuery();
            rset.next();
            System.out.println("ID LOADED : "+rset.getInt("id"));
            Personne u =new Personne(rset.getInt("id"),rset.getString("nom"),rset.getString("prenom"),rset.getString("telephone"),rset.getString("email"),rset.getString("nationalite"),rset.getInt("type"));
            System.out.println(u.toString());
            return u;
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
    
    public void getAllPersonne() {
        ResultSet rset;
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            rset = stmt.executeQuery("SELECT * FROM personne");
            while (rset.next()) {
                new Personne(rset.getInt("id"),rset.getString("nom"),rset.getString("prenom"),rset.getString("telephone"),rset.getString("email"),rset.getString("nationalite"),rset.getInt("type"));
            }
        } catch (SQLException exc) {
            System.out.println(exc);
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
