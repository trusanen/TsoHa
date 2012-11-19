/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author trusanen
 */
public class Event {
    
    private int id;
    private String name;
    
    public Event(int id, String name) {
        
        this.id = id;
        this.name = name;
        
    }
    
    public String getName() {
        return name;
    }
    
}
