/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Timestamp;

/**
 *
 * @author trusanen
 */
public class Comment {
    
    private long id;
    private Timestamp timePosted;
    private String commentedBy;
    private String text;
    
    public Comment(long id, Timestamp timePosted, String commentedBy, String text) {
        
        this.id = id;
        this.timePosted = timePosted;
        this.commentedBy = commentedBy;
        this.text = text;
        
    }
    
    public long getId() {
        return id;
    }
    
    public String getTimePosted() {
        
        String time = timePosted.toString();
        
        return time.substring(0, time.length() - 7);
    }
    
    public String getCommentator() {
        return commentedBy;
    }
    
    public String getText() {
        return text;
    }
    
}
