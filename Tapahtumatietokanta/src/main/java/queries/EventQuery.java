package queries;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import models.DatabaseConnection;
import models.Event;

/**
 *
 * @author trusanen
 */
public class EventQuery extends DatabaseConnection {
        
    public EventQuery() throws ClassNotFoundException, SQLException {
        super();
    }
    
    public Event getEvent(String name, String password) throws SQLException {
        
        PreparedStatement st = conn.prepareStatement("SELECT eventKey, name FROM UserData WHERE userName = ? AND password = ?");
        st.setString(1, name);
        st.setString(2, password);
        
        ResultSet rs = st.executeQuery();
        Event event = null;
        
        if(rs.next()) {
            event = new Event(rs.getLong("eventKey"), rs.getString("name"));
        }
        
        conn.close();
        return event;
    }
    
    public ArrayList<Event> getEventsCreatedByUser(long userId) throws SQLException {
        
        ArrayList<Event> userEvents = new ArrayList<Event>();
        
        PreparedStatement st = conn.prepareStatement("SELECT eventKey, name FROM Events WHERE createdBy = ?");
        st.setLong(1, userId);
        
        ResultSet rs = st.executeQuery();
        
        while(rs.next()) {
            Event event = new Event(rs.getLong("eventKey"), rs.getString("name"));
            userEvents.add(event);
        }
        
        conn.close();
        
        return userEvents;
        
    }
    
    public ArrayList<Event> getEventsAttendedByUser(long userId) throws SQLException {
        
        ArrayList<Event> userEvents = new ArrayList<Event>();
        
        PreparedStatement st = conn.prepareStatement(
                "SELECT eventKey, name "
                + "FROM Attendees "
                + "INNER JOIN Events "
                + "ON event = eventKey "
                + "WHERE attends = ?");
        st.setLong(1, userId);
        
        ResultSet rs = st.executeQuery();
        
        while(rs.next()) {
            Event event = new Event(rs.getLong("eventKey"), rs.getString("name"));
            userEvents.add(event);
        }
        
        conn.close();
        
        return userEvents;
        
    }
    
}
