package models;

import java.sql.SQLException;
import java.util.ArrayList;
import queries.EventQuery;
import queries.UserQuery;

/**
 *
 * @author trusanen
 */
public class Event {
    
    private long id;
    private String name;
    private long createdBy;
    
    public Event(long id, String name, long createdBy) {
        
        this.id = id;
        this.name = name;
        this.createdBy = createdBy;
        
    }
    
    public long getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public String getCreator() throws ClassNotFoundException, SQLException {
        
        return (new UserQuery()).getUser(createdBy).getName();
    }
    
    public String getInformation() throws ClassNotFoundException, SQLException {
        
        return (new EventQuery()).getEventInformation(id);
    }
    
    public ArrayList<User> getAttendees() throws ClassNotFoundException, SQLException {
        
        return (new EventQuery()).getEventAttendees(id);
    }
    
    public ArrayList<Comment> getComments() throws ClassNotFoundException, SQLException {
        
        return (new EventQuery()).getEventComments(id);
    }
}
