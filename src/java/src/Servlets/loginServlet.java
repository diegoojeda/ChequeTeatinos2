package src.Servlets;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import src.Beans.loginBean;
import src.Facades.ClienteFacade;


@WebServlet(name = "loginServlet", urlPatterns = {"/loginServlet"})
public class loginServlet extends HttpServlet {

    @EJB
    private ClienteFacade clienteFacade;
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        super.doGet(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(request.getParameter("email").isEmpty() || request.getParameter("password").isEmpty()){
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
        else{
            String email = request.getParameter("email");
            String pass = request.getParameter("password");
            loginBean lb = new loginBean();
            try {
                lb.setCli(clienteFacade.findClienteEmailPass(email, pass));
            } catch (Exception e) {
                request.getRequestDispatcher("error.jsp").forward(request, response); //Crear pagina error de login
            }
            if(lb.getCli() == null || lb.getCli().getEsAdmin() == 1){
                request.setAttribute("errorlogin", "Usuario y/o contraseña incorrectos");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
            else{
                request.setAttribute("errorlogin", "");
                HttpSession sesion = request.getSession();
                sesion.setAttribute("login", lb);
                request.getRequestDispatcher("homeServlet").forward(request, response);
            }
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
