package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import models.Event;
import models.User;

/**
 *
 * @author trusanen
 */
public class AttendEventServlet extends MainServlet {

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
            // TÄHÄN TARKISTUS, ETTÄ EI OLE JO ILMOITTAUTUNUT?
            int eventKey = Integer.parseInt(request.getParameter("event"));
            
            HttpSession session = request.getSession(true);
            User user = (User)session.getAttribute("user");
            
            try {
                // Check, if user is attending event
                ArrayList<Event> attendedEvents = user.getAttendedEvents();

                for(Event e : attendedEvents) {
                    
                    if(eventKey == e.getId()) {
                        RequestDispatcher dispatcher = request.getRequestDispatcher("eventPage?event=" + eventKey);
                        dispatcher.forward(request, response);
                        return;
                    }
                }
            
                user.attendEvent(eventKey);
                
            } catch (Exception ex) {
                Logger.getLogger(AttendEventServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("eventPage?event=" + eventKey);
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
