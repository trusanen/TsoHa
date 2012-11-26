package models;

import java.sql.SQLException;
import java.util.ArrayList;
import queries.EventQuery;

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
    
    public String getInformation() throws ClassNotFoundException, SQLException {
        
        EventQuery query = new EventQuery();
        
        String info = query.getEventInformation(id);
        
        return info;
        
    }
    
    public ArrayList<User> getAttendees() {
        return null;
    }
    
}
