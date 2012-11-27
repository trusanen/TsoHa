/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Date;

/**
 *
 * @author trusanen
 */
public class Comment {
    
    private long id;
    private Date date;
    private String commentedBy;
    private String text;
    
    public Comment(long id, Date date, String commentedBy, String text) {
        
        this.id = id;
        this.date = date;
        this.commentedBy = commentedBy;
        this.text = text;
        
    }
    
    public long getId() {
        return id;
    }
    
    public String getDate() {
        return date.toString();
    }
    
    public String getCommentator() {
        return commentedBy;
    }
    
    public String getText() {
        return text;
    }
    
}
