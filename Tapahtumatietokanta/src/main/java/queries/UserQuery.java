package queries;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
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
    
    public User getUser(long id) throws SQLException {
        
        PreparedStatement st = conn.prepareStatement("SELECT userKey, name FROM Users WHERE userKey = ?");
        st.setLong(1, id);
        
        ResultSet rs = st.executeQuery();
        
        User user = null;
        
        if(rs.next()) {
            user = new User(rs.getLong("userKey"), rs.getString("name"));
        }
        
        conn.close();
        
        return user;
        
    }
    
    public User getUserByName(String name, String password) throws SQLException {
        
        PreparedStatement st = conn.prepareStatement("SELECT userKey, name FROM Users WHERE userName = ? AND password = ?");
        st.setString(1, name);
        st.setString(2, password);
        
        ResultSet rs = st.executeQuery();
        User user = null;
        
        if(rs.next()) {
            user = new User(rs.getLong("userKey"), rs.getString("name"));
        }
        
        conn.close();
        return user;
    }    
    
    public void attendEvent(long userKey, long eventKey) throws SQLException {
        
        PreparedStatement st = conn.prepareStatement("INSERT INTO Attendees VALUES (?, ?, NOW())");
        st.setLong(1, userKey);
        st.setLong(2, eventKey);
        
        st.execute();
        
        conn.close();
    }
    
}
