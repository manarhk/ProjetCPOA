/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Heure;
import java.sql.*;
/**
 *
 * @author lucas
 */
public class HeureDAO {
    private Connection conn;

    public HeureDAO(Connection conn) {
        this.conn = conn;
    }
    
    public void getAllHeure() {
        ResultSet rset;
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            rset = stmt.executeQuery("SELECT * FROM heures");
            while (rset.next()) {
                new Heure(rset.getInt("id_heures"),rset.getString("time"));
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
