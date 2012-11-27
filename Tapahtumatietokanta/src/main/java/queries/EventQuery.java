package queries;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import models.Comment;
import models.DatabaseConnection;
import models.Event;
import models.User;

/**
 *
 * @author trusanen
 */
public class EventQuery extends DatabaseConnection {
        
    public EventQuery() throws ClassNotFoundException, SQLException {
        super();
    }
    
    public Event getEvent(int eventKey) throws SQLException {
        
        PreparedStatement st = conn.prepareStatement("SELECT eventKey, name, createdBy FROM Events WHERE eventKey = ?");
        st.setInt(1, eventKey);
        
        ResultSet rs = st.executeQuery();
        Event event = null;
        
        if(rs.next()) {
            event = new Event(rs.getLong("eventKey"), rs.getString("name"), rs.getLong("createdBy"));
        }
        
        conn.close();
        return event;
    }
    
    public String getEventInformation(long key) throws SQLException {
        
        PreparedStatement st = conn.prepareStatement("SELECT information FROM Events WHERE eventKey = ?");
        st.setLong(1, key);
        
        ResultSet rs = st.executeQuery();
        
        if(rs.next()) {
            String info = rs.getString(1);
            rs.close();
            return info;
        }
        else {
            rs.close();
            return "";
        }
    }
    

    public ArrayList<Comment> getEventComments(long eventKey) throws SQLException {
        
        ArrayList<Comment> comments = new ArrayList<Comment>();
        
        PreparedStatement st = conn.prepareStatement("SELECT commentKey, commentedDate, name, text "
                + "FROM Comments "
                + "INNER JOIN Users "
                + "ON commentedBy = userKey "
                + "WHERE eventKey = ? "
                + "ORDER BY commentedDate desc");
        st.setLong(1, eventKey);
        
        ResultSet rs = st.executeQuery();
        
        while(rs.next()) {
            
            Comment comment = new Comment(rs.getLong("commentKey"),
                    rs.getDate("commentedDate"),
                    rs.getString("name"),
                    rs.getString("text"));
            comments.add(comment);
        }
        
        rs.close();
        
        return comments;
    }
    
    public ArrayList<User> getEventAttendees(long eventKey) throws SQLException {
        
        ArrayList<User> eventAttendees = new ArrayList<User>();
        
        PreparedStatement st = conn.prepareStatement("SELECT attends, name "
                + "FROM Attendees "
                + "INNER JOIN Users "
                + "ON attends = userKey "
                + "WHERE event = ?");
        st.setLong(1, eventKey);
        
        ResultSet rs = st.executeQuery();
        
        while(rs.next()) {
            User user = new User(rs.getInt("attends"), rs.getString("name"));
            eventAttendees.add(user);
        }
        
        rs.close();
        
        return eventAttendees;
    }

    public ArrayList<Event> getEventsCreatedByUser(long userId) throws SQLException {
        
        ArrayList<Event> userEvents = new ArrayList<Event>();
        
        PreparedStatement st = conn.prepareStatement("SELECT eventKey, name, createdBy FROM Events WHERE createdBy = ?");

        ResultSet rs = st.executeQuery();
        
        while(rs.next()) {
            Event event = new Event(rs.getLong("eventKey"), 
                    rs.getString("name"), 
                    rs.getLong("createdBy"));
            userEvents.add(event);
        }
        
        conn.close();
        
        return userEvents;
        
    }
    
    public ArrayList<Event> getEventsAttendedByUser(long userId) throws SQLException {
        
        ArrayList<Event> userEvents = new ArrayList<Event>();
        
        PreparedStatement st = conn.prepareStatement(
                "SELECT eventKey, name, createdBy "
                + "FROM Attendees "
                + "INNER JOIN Events "
                + "ON event = eventKey "
                + "WHERE attends = ?");
        st.setLong(1, userId);
        
        ResultSet rs = st.executeQuery();
        
        while(rs.next()) {
            userEvents.add(new Event(rs.getLong("eventKey"),
                    rs.getString("name"),
                    rs.getLong("createdBy")));
        }
        
        conn.close();
        
        return userEvents;
        
    }
    
}
