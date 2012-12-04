package queries;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import models.DatabaseConnection;

/**
 *
 * @author trusanen
 */
public class CommentQuery extends DatabaseConnection {
    
    public CommentQuery() throws ClassNotFoundException, SQLException {
        super();
    }
    
    public void createComment(long userKey, long eventKey, String comment) throws SQLException {
        
        PreparedStatement st = conn.prepareStatement("INSERT INTO Comments (commentedBy, event, text) VALUES (?, ?, ?)");
        st.setLong(1, userKey);
        st.setLong(2, eventKey);
        st.setString(3, comment);
        
        st.execute();
        
        conn.close();
    }
}
