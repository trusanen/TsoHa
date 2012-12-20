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
        return parseTime(timePosted);
    }
    
    public String getCommentator() {
        return commentedBy;
    }
    
    public String getText() {
        return text;
    }
    
    private String parseTime(Timestamp time) {
        
        // Parses the time as a string from the SQL timestamp
        // object. At the moment uses the default string
        // presentation.
        
        String timeString = time.toString();
        
        return timeString.substring(0, timeString.length() - 7);
    }
    
}
