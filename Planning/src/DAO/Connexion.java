/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author lucas
 */
public class Connexion {
    public Connection getConnection() {
                // Votre fonction Run
                // Vos information de connexion à une base de données
                Connection conn ;
                
                String BDD = "cpoa";
                String url = "jdbc:mysql://127.0.0.1/" + BDD;
                String user = "root";
                String passwrd = "";
                
                
                // L'essaie de connexion à votre base de donées
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    conn = DriverManager.getConnection(url, user, passwrd);
                    System.out.println("Connecter");
                    
                    
                } catch (Exception e){
                    e.printStackTrace();
                    System.out.println("Erreur");
                    conn = null;
                    System.exit(0);
                }
                
                return conn ;
               
            }
}
