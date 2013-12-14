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
import src.Entities.Cliente;
import src.Facades.ClienteFacade;

/**
 *
 * @author escabia
 */
@WebServlet(name = "modificaUsuarioServlet", urlPatterns = {"/modificaUsuarioServlet"})
public class modificaUsuarioServlet extends HttpServlet {
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
        String email = request.getParameter("email");
        Cliente c = clienteFacade.find(email);
        if (c != null){
            c.setPass(request.getParameter("password"));
            c.setApellidos(request.getParameter("apellidos"));
            c.setNombre(request.getParameter("nombre"));
            c.setTelefono(Integer.parseInt(request.getParameter("telefono")));
            clienteFacade.edit(c);
            request.getRequestDispatcher("loginServlet").forward(request, response);
        }
        else{
            System.out.println("Email no encontrado. No debería meterse aquí");
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
