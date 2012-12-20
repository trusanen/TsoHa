package servlets;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import models.User;
import queries.UserQuery;

/**
 *
 * @author trusanen
 */
public class CreateUserServlet extends MainServlet {

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
        showForm(request, response);
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
        
        // User information gets stored in the correct encoding
        // to the database.
        request.setCharacterEncoding("UTF-8");
        
        HttpSession session = request.getSession(true);
        
        String username = request.getParameter("un");
        String password = request.getParameter("pw");
        String name = request.getParameter("n");
        
        if(!name.equals("") && !username.equals("") && !password.equals("")) {
            
            try {                
                (new UserQuery()).createUser(username, password, name);
                        
                User newUser = User.loginUser(username, password);

                if(newUser != null) {
                    session.setAttribute("user", newUser);
                    response.sendRedirect("userPage");
                }
                else {
                    request.setAttribute("errormsg", "Failed to create an account.");
                    showForm(request, response);
                }
            } catch (Exception ex) {
                Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else {
            request.setAttribute("errormsg", "Failed to create an account.");
            showForm(request, response);
        }
    }

    private void showForm(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("createUserPage.jsp");
        dispatcher.forward(request, response);
    }

}
