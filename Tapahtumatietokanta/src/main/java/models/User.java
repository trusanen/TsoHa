/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.SQLException;
import queries.UserQuery;

/**
 *
 * @author trusanen
 */
public class User {
    
    private int id;
    
    public User(int id) {
        this.id = id;
    }
    
    public int getId() {
        return id;
    }
    
    public static User loginUser(String name, String password) throws ClassNotFoundException, SQLException {
        
        UserQuery q = new UserQuery();
        
        User newUser = q.getUser(name, password);
        
        return newUser;
    }
    
}
