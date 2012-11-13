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
    
    int id;
    
    public User(int id) {
        this.id = id;
    }
    
    public void loginUser(String name, String password) throws ClassNotFoundException, SQLException {
        
        UserQuery q = new UserQuery();
        
        User newUser = q.getUser(name);
        
        if(!(newUser == null)) {
            
        }
    }
    
}
