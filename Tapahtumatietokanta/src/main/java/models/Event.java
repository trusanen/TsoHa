package models;

/**
 *
 * @author trusanen
 */
public class Event {
    
    private long id;
    private String name;
    
    public Event(long id, String name) {
        
        this.id = id;
        this.name = name;
        
    }
    
    public String getName() {
        return name;
    }
    
}
