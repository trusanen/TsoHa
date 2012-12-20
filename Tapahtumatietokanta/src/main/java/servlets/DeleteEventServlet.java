package servlets;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import models.User;
import queries.EventQuery;

/**
 *
 * @author trusanen
 */
public class DeleteEventServlet extends MainServlet {

    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        if(confirmLogin(request, response)) {
            
            try {
                
                HttpSession session = request.getSession(true);
                User user = (User)session.getAttribute("user");
                
                if(user != null) {
                    
                    long eventKey = Long.parseLong(request.getParameter("event"));
                
                    if(user.isCreatorOfEvent(eventKey)) {
                        (new EventQuery()).deleteEvent(eventKey);
                    }
                }
                
                response.sendRedirect("userPage");
                
            } catch (Exception ex) {
                Logger.getLogger(DeleteEventServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
}
