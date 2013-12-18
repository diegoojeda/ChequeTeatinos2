package Servlets;

import java.io.IOException;
import java.math.BigDecimal;
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
    
    private ArrayList<Oferta> carrito = new ArrayList<>();
    private ArrayList<Integer> unidades = new ArrayList<>();

    
    private int encontrada(Oferta o, ArrayList<Oferta> carrito){
        int pos = -1;
        
        for(int i=0; i<carrito.size(); i++){
            if(carrito.get(i).getId() == o.getId())
                pos = i;
        }
        
        return pos;
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
        int ofertaId = Integer.parseInt(request.getParameter("idOferta"));
        Oferta o = ofertaFacade.find(ofertaId);
        if (request.getSession().getAttribute("login") != null){
            //Usuario logueado, procedemos a añadir a su carrito el objeto
            if (request.getSession().getAttribute("carrito") == null && request.getSession().getAttribute("unidades") == null && request.getSession().getAttribute("precio") == null){
                //En caso de que no exista el carrito aun
                request.getSession().setAttribute("carrito", carrito);
                request.getSession().setAttribute("unidades", unidades);
                request.getSession().setAttribute("precio", BigDecimal.ZERO);
            }
            int pos = encontrada(o, carrito);
            BigDecimal result = ((BigDecimal)request.getSession().getAttribute("precio")).add(o.getPrecioConOferta());
                request.getSession().setAttribute("precio", result);
            
            if(pos < 0){
                Integer n = 1;
                ((ArrayList<Oferta>)request.getSession().getAttribute("carrito")).add(o);
                ((ArrayList<Integer>)request.getSession().getAttribute("unidades")).add(n);
            }
            else{
                 ((ArrayList<Integer>)request.getSession().getAttribute("unidades")).set(pos, ((ArrayList<Integer>)request.getSession().getAttribute("unidades")).get(pos));
            }
            
            request.getRequestDispatcher("homeServlet").forward(request, response);
        }
        else{
            //Usuario no logueado, le redirigimos a la pagina de login
            request.setAttribute("info", "Debe autentificarse para añadir ofertas al carrito");
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
