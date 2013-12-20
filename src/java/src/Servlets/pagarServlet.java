/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

package src.Servlets;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import src.Entities.Cliente;
import src.Entities.Oferta;
import src.Entities.Pedido;
import src.Entities.PedidoOferta;
import src.Facades.PedidoFacade;
import src.Facades.PedidoOfertaFacade;

/**
 *
 * @author diegoojedagarcia
 */
@WebServlet(name = "pagarServlet", urlPatterns = {"/pagarServlet"})
public class pagarServlet extends HttpServlet {
    @EJB
    private PedidoFacade pedidoFacade;
    @EJB
    private PedidoOfertaFacade pedidoOfertaFacade;
    
    
    private ArrayList<Oferta> carrito;
//    private ArrayList<Integer> unidades;
    private BigDecimal total;
    
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
//        super.doGet(request, response);
        carrito = (ArrayList<Oferta>)request.getSession().getAttribute("carrito");
//        unidades = (ArrayList<Integer>) request.getSession().getAttribute("unidades");
        total = (BigDecimal) request.getSession().getAttribute("precio");
        PedidoOferta pedOfer;
        int maxId = 0;
        int codPedido = 0;
        //calcular id pedidoOferta
        if (!pedidoOfertaFacade.findAll().isEmpty()){
            for (PedidoOferta po : pedidoOfertaFacade.findAll()){
                if (po.getId() > maxId){
                    maxId = po.getId();
                }
            }
            maxId++;
        }
        if (!pedidoFacade.findAll().isEmpty()){
            for (Pedido ped : pedidoFacade.findAll()){
                if (ped.getCodigoPedido() > codPedido){
                    codPedido = ped.getCodigoPedido();
                }
            }
            codPedido++;
        }
        Pedido p = new Pedido(codPedido);
        p.setFecha(new Date());
        p.setTotal(total);
        pedidoFacade.create(p);
        for (Oferta o : carrito){
            pedOfer = new PedidoOferta(maxId);
            pedOfer.setCodigoOferta(o);
            pedOfer.setCodigoPedido(p);
            pedidoOfertaFacade.create(pedOfer);
            maxId++;
        }
        ArrayList<Oferta> compra = new ArrayList<>(carrito);
        request.getSession().setAttribute("compra", carrito);
        
        //Vaciar carrito de la sesión
        request.getSession().setAttribute("carrito", new ArrayList<Oferta>());
        request.getSession().setAttribute("unidades", new ArrayList<Integer>());
        request.getSession().setAttribute("precio", BigDecimal.ZERO);
        request.getRequestDispatcher("orderPlaced.jsp").forward(request, response);
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
