/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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
        
        if(rs.next()) {
            Event event = new Event(rs.getInt(1), rs.getString(2));
            rs.close();
            return event;
        }
        else {
            rs.close();
            return null;
        }
    }
    
    public ArrayList<Event> getEventsCreatedByUser(int userId) throws SQLException {
        
        ArrayList<Event> userEvents = new ArrayList<Event>();
        
        PreparedStatement st = conn.prepareStatement("SELECT eventKey, name FROM Event WHERE createdBy = ?");
        st.setInt(1, userId);
        
        ResultSet rs = st.executeQuery();
        
        while(rs.next()) {
            Event event = new Event(rs.getInt(1), rs.getString(2));
            userEvents.add(event);
        }
        
        rs.close();
        
        return userEvents;
        
    }
    
    public ArrayList<Event> getEventsAttendedByUser(int userId) throws SQLException {
        
        ArrayList<Event> userEvents = new ArrayList<Event>();
        
        PreparedStatement st = conn.prepareStatement(
                "SELECT eventKey, name "
                + "FROM Attendees "
                + "INNER JOIN Event "
                + "ON event = eventKey "
                + "WHERE attends = ?");
        st.setInt(1, userId);
        
        ResultSet rs = st.executeQuery();
        
        while(rs.next()) {
            Event event = new Event(rs.getInt(1), rs.getString(2));
            userEvents.add(event);
        }
        
        rs.close();
        
        return userEvents;
        
    }
    
}
