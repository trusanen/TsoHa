package models;

import java.sql.SQLException;
import java.util.ArrayList;
import queries.EventQuery;
import queries.UserQuery;

/**
 *
 * @author trusanen
 */
public class User {
    
    private long id;
    private String name;
    
    public User(long id, String name) {
        this.id = id;
        this.name = name;
    }
    
    public long getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public ArrayList<Event> getCreatedEvents() 
            throws ClassNotFoundException, SQLException {
        
        return (new EventQuery()).getEventsCreatedByUser(this.id);
        
    }
    
    public ArrayList<Event> getAttendedEvents() 
            throws ClassNotFoundException, SQLException {
        
        return (new EventQuery()).getEventsAttendedByUser(this.id);
    }
    
    public void attendEvent(long eventKey) throws ClassNotFoundException, SQLException {

        (new UserQuery()).attendEvent(id, eventKey);
    }
    
    public void unattendEvent(long eventKey) throws ClassNotFoundException, SQLException {

        (new UserQuery()).unattendEvent(id, eventKey);
    }
    
    public static User loginUser(String name, String password) 
            throws ClassNotFoundException, SQLException {
        
        return (new UserQuery()).getUserByName(name, password);
    }
    
}
