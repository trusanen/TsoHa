package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import models.User;

/**
 *
 * @author trusanen
 */

public class MainServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    protected boolean confirmLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        
        HttpSession session = request.getSession(true);
        User user = (User)session.getAttribute("user");
        if (user != null) {
            request.setAttribute("user", user);
            return true;
        }
        
        response.sendRedirect("login");
        return false;
    }
}
