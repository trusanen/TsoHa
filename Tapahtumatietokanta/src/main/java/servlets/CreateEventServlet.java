package servlets;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import models.User;
import queries.EventQuery;

/**
 *
 * @author trusanen
 */

public class CreateEventServlet extends MainServlet {

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
            showForm(request, response);
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
        
        if(confirmLogin(request, response)) {
            
            String name = request.getParameter("name");
            String information = request.getParameter("information");
            
            if(!name.equals("") && !information.equals("")) {
            
                try {

                    HttpSession session = request.getSession(true);
                    long userId = ((User)session.getAttribute("user")).getId();

                    (new EventQuery()).createEvent(userId, name, information);
                    
                } catch (Exception ex) {
                    Logger.getLogger(CreateEventServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            response.sendRedirect("userPage");
        }
    }

    private void showForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("createEvent.jsp");
        dispatcher.forward(request, response);
    }
}
