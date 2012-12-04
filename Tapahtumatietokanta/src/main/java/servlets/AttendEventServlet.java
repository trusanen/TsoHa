package servlets;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
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
            try {
                int eventKey = Integer.parseInt(request.getParameter("event"));

                HttpSession session = request.getSession(true);
                User user = (User)session.getAttribute("user");

                if(!user.isAttendingEvent(eventKey)) {
                    user.attendEvent(eventKey);
                }
                
                RequestDispatcher dispatcher = request.getRequestDispatcher("eventPage?event=" + eventKey);
                dispatcher.forward(request, response);
                
            } catch (Exception ex) {
                Logger.getLogger(AttendEventServlet.class.getName()).log(Level.SEVERE, null, ex);
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
