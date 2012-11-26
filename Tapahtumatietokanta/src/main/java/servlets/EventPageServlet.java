package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import models.Event;
import queries.EventQuery;

/**
 *
 * @author trusanen
 */
public class EventPageServlet extends MainServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        if(confirmLogin(request, response)) {
            int eventKey = Integer.parseInt(request.getParameter("event"));
            
            try {
                EventQuery query = new EventQuery();
                Event event = query.getEvent(eventKey);
                request.setAttribute("event", event);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(EventPageServlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(EventPageServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("eventPage.jsp");
            dispatcher.forward(request, response);
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
