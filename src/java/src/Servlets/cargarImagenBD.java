/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package src.Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import src.Facades.OfertaFacade;
import sun.misc.BASE64Decoder;

/**
 *
 * @author masterinftel11
 */
@WebServlet(name = "cargarImagenBD", urlPatterns = {"/cargarImagenBD"})
public class cargarImagenBD extends HttpServlet {
    @EJB
    private OfertaFacade ofertaFacade;
    
    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet cargarImagenBD</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet cargarImagenBD at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //        processRequest(request, response);
        // Cargamos desde la BD
        
        ServletOutputStream out = response.getOutputStream();
        String datos = cargarDesdeLaBaseDeDatos(Integer.parseInt(request.getParameter("id")));
        // Decodificamos
        BASE64Decoder d = new BASE64Decoder();
        byte[] datosImagen = d.decodeBuffer(datos);

        out.write(datosImagen);
        out.flush();
//        request.setAttribute("imagen", datosImagen);
        //request.getRequestDispatcher("verImagen.jsp").forward(request, response);
    }
    
    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
    
    public String cargarDesdeLaBaseDeDatos(int id){
//        String datos = (String) ofertaFacade.find(id).getImagen();
//        return datos;
        return null;
    }
}
