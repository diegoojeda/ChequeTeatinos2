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
import src.Beans.detalleOfertaBean;
import src.Entities.Empresa;
import src.Entities.Oferta;
import src.Facades.OfertaFacade;

/**
 *
 * @author diegoojedagarcia
 */
@WebServlet(name = "viewOfferServlet", urlPatterns = {"/viewOfferServlet"})
public class viewOfferServlet extends HttpServlet {
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
        Oferta of = ofertaFacade.find(Integer.parseInt(request.getParameter("idOferta")));
        Empresa e = of.getEmpresa();
        detalleOfertaBean dob = new detalleOfertaBean();
        dob.setEmp(e);
        dob.setOfe(of);
        request.setAttribute("ofertaDetalle", dob);
        request.getRequestDispatcher("viewoffer.jsp").forward(request, response);
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
        super.doPost(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
