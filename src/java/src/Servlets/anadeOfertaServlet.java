
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
import src.Beans.ofertasBean;
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
     * Limpia atributos temporales, guardados en la sesión, si al usuario le ha faltado algún campo por validar
     * @param request 
     */
    private void limpiaAtributos(HttpServletRequest request){
        request.getSession().setAttribute("nombre", null);
        request.getSession().setAttribute("empresa", null);
        request.getSession().setAttribute("descripcion", null);
        request.getSession().setAttribute("existencias", null);
        request.getSession().setAttribute("fechaValidez", null);
        request.getSession().setAttribute("precioConOferta", null);
        request.getSession().setAttribute("precioOriginal", null);
        
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
            
        if(request.getParameter("nombre").isEmpty() || request.getParameter("empresa").isEmpty() || request.getParameter("descripcion").isEmpty()
                || request.getParameter("existencias").isEmpty() || request.getParameter("fechaValidez").isEmpty() || request.getParameter("precioConOferta").isEmpty() || 
                request.getParameter("precioOriginal").isEmpty()){
            
            if(!request.getParameter("nombre").isEmpty())
                request.getSession().setAttribute("nombre", request.getParameter("nombre"));
            if(!request.getParameter("empresa").isEmpty())
                request.getSession().setAttribute("empresa", request.getParameter("empresa"));
            if(!request.getParameter("descripcion").isEmpty())
                request.getSession().setAttribute("descripcion", request.getParameter("descripcion"));
            if(!request.getParameter("existencias").isEmpty())
                request.getSession().setAttribute("existencias", request.getParameter("existencias"));
            if(!request.getParameter("fechaValidez").isEmpty())
                request.getSession().setAttribute("fechaValidez", request.getParameter("fechaValidez"));
            if(!request.getParameter("precioConOferta").isEmpty())
                request.getSession().setAttribute("precioConOferta", request.getParameter("precioConOferta"));
            if(!request.getParameter("precioOriginal").isEmpty())
                request.getSession().setAttribute("precioOriginal", request.getParameter("precioOriginal"));
            
            request.getRequestDispatcher("addofferadmin.jsp").forward(request, response); //Crear pagina error de login
        }
        else{
            limpiaAtributos(request);
            Oferta o = new Oferta(ofertaFacade.getNextSeqVal());
            o.setNombreOferta(request.getParameter("nombre"));
            o.setEmpresa(empresaFacade.find(request.getParameter("empresa"))); //Provisional
            o.setDescripcion(request.getParameter("descripcion"));
            o.setExistencias((short)Integer.parseInt(request.getParameter("existencias")));
            o.setFechaValidez(Date.valueOf(request.getParameter("fechaValidez")));
            o.setPrecioConOferta(BigDecimal.valueOf(Double.parseDouble(request.getParameter("precioConOferta"))));
            o.setPrecioOriginal(BigDecimal.valueOf(Double.parseDouble(request.getParameter("precioOriginal"))));

            ofertaFacade.create(o);
            empresaFacade.find(o.getId()).getOfertaCollection().add(o); //Ligamos la oferta a la empresa

            ofertasBean h = new ofertasBean();
            h.setOfertas(ofertaFacade.findAll());
            request.setAttribute("ofertas", h);
            request.getRequestDispatcher("offersadmin.jsp").forward(request, response); //Crear pagina error de login        
            
            
            
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
