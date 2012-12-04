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
    
    public Event getEvent(long eventKey) throws SQLException {
        
        PreparedStatement st = conn.prepareStatement("SELECT eventKey, name, createdBy FROM Events WHERE eventKey = ?");
        st.setLong(1, eventKey);
        
        ResultSet rs = st.executeQuery();
        Event event = null;
        
        if(rs.next()) {
            event = new Event(rs.getLong("eventKey"), rs.getString("name"), rs.getLong("createdBy"));
        }
        
        conn.close();
        return event;
    }
    
    public ArrayList<Event> getEvents() throws SQLException {
        
        ArrayList<Event> events = new ArrayList<Event>();
        
        PreparedStatement st = conn.prepareStatement("SELECT eventKey, name, createdBy "
                + "FROM Events");
        
        ResultSet rs = st.executeQuery();
        
        while(rs.next()) {
            
            Event event = new Event(rs.getLong("eventKey"), rs.getString("name"), rs.getLong("createdBy"));
            events.add(event);
        }
        
        conn.close();
        
        return events;
        
    }
    
    public String getEventInformation(long key) throws SQLException {
        
        PreparedStatement st = conn.prepareStatement("SELECT information FROM Events WHERE eventKey = ?");
        st.setLong(1, key);
        
        ResultSet rs = st.executeQuery();
        String info = "";
        
        if(rs.next()) {
            info = rs.getString("information");
        }
        
        conn.close();
        
        return info;
    }

    public ArrayList<Comment> getEventComments(long eventKey) throws SQLException {
        
        ArrayList<Comment> comments = new ArrayList<Comment>();
        
        PreparedStatement st = conn.prepareStatement("SELECT commentKey, commentedDate, name, text "
                + "FROM Comments "
                + "INNER JOIN Users "
                + "ON commentedBy = userKey "
                + "WHERE event = ? "
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
        
        conn.close();
        
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
            User user = new User(rs.getLong("attends"), rs.getString("name"));
            eventAttendees.add(user);
        }
        
        conn.close();
        
        return eventAttendees;
    }
    
    public ArrayList<Event> getEventsCreatedByUser(long userId) throws SQLException {
        
        ArrayList<Event> userEvents = new ArrayList<Event>();
        
        PreparedStatement st = conn.prepareStatement("SELECT eventKey, name, createdBy FROM Events WHERE createdBy = ?");
        st.setLong(1, userId);

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
    
    public void createEvent(long createdBy, String name, String information) throws SQLException {
        
        PreparedStatement st = conn.prepareStatement("INSERT INTO Events (createdBy, name, information) "
                + "VALUES (?, ?, ?)");
        st.setLong(1, createdBy);
        st.setString(2, name);
        st.setString(3, information);
        
        st.execute();
        
        conn.close();
        
    }
}
