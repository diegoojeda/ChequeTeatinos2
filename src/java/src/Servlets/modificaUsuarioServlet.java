/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Servlets;

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
     * Limpia atributos temporales, guardados en la sesión, si al usuario le ha faltado algún campo por validar
     * @param request 
     */
    private void limpiaAtributos(HttpServletRequest request){
        request.getSession().setAttribute("email", null);
        request.getSession().setAttribute("password", null);
        request.getSession().setAttribute("nombre", null);
        request.getSession().setAttribute("apellidos", null);
        request.getSession().setAttribute("telefono", null);
    }   
    
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
        
        if(request.getParameter("email").isEmpty() || request.getParameter("password").isEmpty() || request.getParameter("nombre").isEmpty()
                || request.getParameter("apellidos").isEmpty() || request.getParameter("telefono").isEmpty()){
            if(!request.getParameter("email").isEmpty())
                request.getSession().setAttribute("email", request.getParameter("email"));
            if(!request.getParameter("password").isEmpty())
                request.getSession().setAttribute("password", request.getParameter("password"));
            if(!request.getParameter("nombre").isEmpty())
                request.getSession().setAttribute("nombre", request.getParameter("nombre"));
            if(!request.getParameter("apellidos").isEmpty())
                request.getSession().setAttribute("apellidos", request.getParameter("apellidos"));
            if(!request.getParameter("telefono").isEmpty())
                request.getSession().setAttribute("telefono", request.getParameter("telefono"));
            
            request.getRequestDispatcher("account.jsp").forward(request, response); //Crear pagina error de login
        }
        else{
            limpiaAtributos(request);
            Cliente c = clienteFacade.find(email);
            if (clienteFacade.find(email) != null){
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
