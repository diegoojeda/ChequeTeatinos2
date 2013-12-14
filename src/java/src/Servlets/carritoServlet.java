package src.Servlets;

import java.io.IOException;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import src.Entities.Oferta;
import src.Facades.OfertaFacade;


@WebServlet(name = "carritoServlet", urlPatterns = {"/carritoServlet"})
public class carritoServlet extends HttpServlet {
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
        Oferta o = ofertaFacade.find(request.getParameter("idOferta"));
        if (request.getSession().getAttribute("login") != null){
            //Usuario logueado, procedemos a añadir a su carrito el objeto
            if (request.getSession().getAttribute("carrito") == null){
                //En caso de que no exista el carrito aun
                ArrayList<Oferta> carrito = new ArrayList<>();
                request.getSession().setAttribute("carrito", carrito);
            }
            ((ArrayList<Oferta>)request.getSession().getAttribute("carrito")).add(o);
            request.getRequestDispatcher("home.jsp").forward(request, response);
        }
        else{
            //Usuario no logueado, le redirigimos a la pagina de login
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
        
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
