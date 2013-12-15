/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package src.Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import src.Beans.homeBean;
import src.Beans.loginBean;
import src.Facades.ClienteFacade;
import src.Facades.OfertaFacade;

/**
 *
 * @author escabia
 */
@WebServlet(name = "loginadminServlet", urlPatterns = {"/loginadminServlet"})
public class loginadminServlet extends HttpServlet {

    @EJB
    private ClienteFacade clienteFacade;
    
    @EJB
    private OfertaFacade ofertaFacade;
    
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
            if(lb.getCli() == null || lb.getCli().getEsAdmin() != 1){
                request.getRequestDispatcher("admin.jsp").forward(request, response);
            }
            else{
                homeBean h = new homeBean();
                h.setOfertas(ofertaFacade.findAll());
                request.setAttribute("ofertas", h);
                
                HttpSession sesion = request.getSession();
                sesion.setAttribute("login", lb);
                request.getRequestDispatcher("paneladmin.jsp").forward(request, response);
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
