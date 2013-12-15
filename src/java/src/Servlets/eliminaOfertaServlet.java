/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package src.Servlets;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import src.Beans.homeBean;
import src.Entities.Oferta;
import src.Facades.EmpresaFacade;
import src.Facades.OfertaFacade;

/**
 *
 * @author escabia
 */
@WebServlet(name = "eliminaOfertaServlet", urlPatterns = {"/eliminaOfertaServlet"})
public class eliminaOfertaServlet extends HttpServlet {
    @EJB
    private EmpresaFacade empresaFacade;
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
        if(request.getParameter("oferta") != null){
            Integer ofertaid = Integer.parseInt(request.getParameter("oferta"));
            Oferta of = ofertaFacade.find(ofertaid);
            if(of != null){//Si existe la oferta, debería existir seguro...
                //ofertaFacade.remove(of);
            }
        }
        else{
            //GESTIONAR, PONER ERROR DE QUE NO SE HA SELECCIONADO NADA
        }
        homeBean h = new homeBean();
        h.setOfertas(ofertaFacade.findAll());
        request.setAttribute("ofertas", h);
        request.getRequestDispatcher("paneladmin.jsp").forward(request, response); //Crear pagina error de login        
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
