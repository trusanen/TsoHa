/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package queries;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import models.DatabaseConnection;
import models.User;

/**
 *
 * @author trusanen
 */
public class UserQuery extends DatabaseConnection {
    
    public UserQuery() throws ClassNotFoundException, SQLException {
        super();
        
    }
    
    public User getUser(String name) throws SQLException {
        
        PreparedStatement st = conn.prepareStatement("SELECT password FROM Kayttaja WHERE name = ?");
        st.setString(1, name);
        
        ResultSet rs = st.executeQuery();
        
        if(rs.next()) {
            User user = new User(rs.getInt(1));
            return user;
        }
        else {
            return null;
        }
    }
    
}
