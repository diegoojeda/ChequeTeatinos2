
package src.Servlets;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;
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


@WebServlet(name = "anadeOfertaServlet", urlPatterns = {"/anadeOfertaServlet"})
public class anadeOfertaServlet extends HttpServlet {
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
        Oferta o = new Oferta(ofertaFacade.getNextSeqVal());
        o.setDescripcion(request.getParameter("descripcion"));
        o.setEmpresa(empresaFacade.find(request.getParameter("empresa"))); //Provisional
        o.setExistencias((short)Integer.parseInt(request.getParameter("existencias")));
        o.setFechaValidez(Date.valueOf(request.getParameter("fechaValidez")));
        o.setNombreOferta(request.getParameter("nombre"));
        o.setPrecioConOferta(BigDecimal.valueOf(Double.parseDouble(request.getParameter("precioConOferta"))));
        o.setPrecioOriginal(BigDecimal.valueOf(Double.parseDouble(request.getParameter("precioOriginal"))));
        
        ofertaFacade.create(o);
        empresaFacade.find(o.getId()).getOfertaCollection().add(o); //Ligamos la oferta a la empresa
        
        homeBean h = new homeBean();
        h.setOfertas(ofertaFacade.findAll());
        request.setAttribute("ofertas", h);
        request.getRequestDispatcher("paneladmin.jsp").forward(request, response); //Crear pagina error de login        
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
