/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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
    
    private int id;
    private String name;
    
    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }
    
    public int getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public ArrayList<Event> getCreatedEvents() 
            throws ClassNotFoundException, SQLException {
        
        EventQuery eventQuery = new EventQuery();
        
        ArrayList<Event> userEvents = eventQuery.getEventsCreatedByUser(this.id);
        
        return userEvents;
        
    }
    
    public ArrayList<Event> getAttendedEvents() 
            throws ClassNotFoundException, SQLException {

        EventQuery eventQuery = new EventQuery();
        
        ArrayList<Event> userEvents = eventQuery.getEventsAttendedByUser(this.id);
        
        return userEvents;
    }
    
    public static User loginUser(String name, String password) throws ClassNotFoundException, SQLException {
        
        UserQuery q = new UserQuery();
        
        User newUser = q.getUser(name, password);
        
        return newUser;
    }
    
}
