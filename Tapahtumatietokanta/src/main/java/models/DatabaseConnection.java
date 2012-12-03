/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author trusanen
 */
public class DatabaseConnection {
    
    protected Connection conn;
    
    public DatabaseConnection() throws ClassNotFoundException, SQLException {
        
            Class.forName("org.postgresql.Driver");

            conn = DriverManager.getConnection("jdbc:postgresql://localhost/trusanen", "trusanen", "newPass");
    }
}
