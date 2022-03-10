/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Court;
import java.sql.*;
/**
 *
 * @author lucas
 */
public class CourtDAO {
    private Connection conn;

    public CourtDAO(Connection conn) {
        this.conn = conn;
    }
    
    public void getAllCourt() {
        ResultSet rset;
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            rset = stmt.executeQuery("SELECT * FROM cours");
            while (rset.next()) {
                new Court(rset.getInt("id_cours"),rset.getString("type_cours"));
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
