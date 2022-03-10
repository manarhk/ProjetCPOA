/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.*;
import DTO.*;
/**
 *
 * @author lucas
 */
public class DateDAO {
    private Connection conn;

    public DateDAO(Connection conn) {
        this.conn = conn;
    }
    
    public void getAllDate() {
        ResultSet rset;
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            rset = stmt.executeQuery("SELECT * FROM dates");
            while (rset.next()) {
                new DTO.Date(rset.getInt("id_dates"),rset.getString("date"));
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
