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
import src.Facades.EmpresaFacade;
import sun.misc.BASE64Decoder;

/**
 *
 * @author masterinftel11
 */
@WebServlet(name = "cargarImagenBD", urlPatterns = {"/cargarImagenBD"})
public class cargarImagenBD extends HttpServlet {
    @EJB
    private EmpresaFacade empresaFacade;
    
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
        // Cargamos desde la BD
        
        ServletOutputStream out = response.getOutputStream();
        String datos = cargarDesdeLaBaseDeDatos(Integer.parseInt(request.getParameter("id")));
        // Decodificamos
        BASE64Decoder d = new BASE64Decoder();
        byte[] datosImagen = d.decodeBuffer(datos);
        out.write(datosImagen);
        out.flush();
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
    
    public String cargarDesdeLaBaseDeDatos(int id){
        String datos = (String) empresaFacade.find(id).getImagen();
        return datos;
    }
}
