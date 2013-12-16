package src.Servlets;

import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import src.Beans.homeBean;
import src.Entities.Oferta;
import src.Facades.OfertaFacade;

@WebServlet(name = "tiposOfertas", urlPatterns = {"/tiposOfertas"})
public class TiposOfertasServlet extends HttpServlet {
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
        List<Oferta> ofertas = ofertaFacade.findOfertasbyTipo(request.getParameter("tipo"));
        homeBean hb = new homeBean();
        hb.setOfertas(ofertas);
        request.setAttribute("ofertas", hb);
        request.getRequestDispatcher("home.jsp").forward(request, response);
//        ofertasBean o = new ofertasBean();
//        o.setOfer((Oferta)ofertaFacade.findAll());
//        request.setAttribute("ofertas", o);
//        request.getRequestDispatcher("home.jsp").forward(request, response);
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
    }

}
