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
    
    public User getUser(String name, String password) throws SQLException {
        
        PreparedStatement st = conn.prepareStatement("SELECT userKey FROM UserData WHERE userName = ? AND password = ?");
        st.setString(1, name);
        st.setString(2, password);
        
        ResultSet rs = st.executeQuery();
        
        if(rs.next()) {
            User user = new User(rs.getInt(1));
            rs.close();
            return user;
        }
        else {
            rs.close();
            return null;
        }
    }
    
}
