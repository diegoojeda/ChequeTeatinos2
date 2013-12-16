/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package src.Servlets;

import java.io.DataInputStream;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import src.Entities.Oferta;
import src.Facades.OfertaFacade;
import sun.misc.BASE64Encoder;

/**
 *
 * @author masterinftel11
 */
@WebServlet(name = "guardarImagenBD", urlPatterns = {"/guardarImagenBD"})
public class guardarImagenBD extends HttpServlet {
    @EJB
    private OfertaFacade ofertaFacade;
    
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
        super.doGet(request, response);
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
        String contentType = request.getContentType();
        
        if ((contentType != null) && (contentType.indexOf("multipart/form-data") >= 0))
        {
            // Cogemos el flujo de entrada
            DataInputStream in = new DataInputStream(request.getInputStream());
            
            // Empezamos a leer
            int longitud = request.getContentLength();
            byte dataBytes[] = new byte[longitud];
            int byteLeido;
            int numBytesLeidos = 0;
            
            while (numBytesLeidos < longitud)
            {
                byteLeido = in.read(dataBytes, numBytesLeidos, longitud);
                numBytesLeidos += byteLeido;
            }
            
            // Extraemos la porción con el archivo añadido
            String archivo = new String(dataBytes);
            
            // Buscamos la posición de los datos
            int lastIndex = contentType.lastIndexOf("=");
            String boundary = contentType.substring(lastIndex + 1, contentType.length());
            int pos;
            
            pos = archivo.indexOf("filename=\"");
            pos = archivo.indexOf("\n", pos) + 1;
            pos = archivo.indexOf("\n", pos) + 1;
            pos = archivo.indexOf("\n", pos) + 1;
            
            int boundaryLocation = archivo.indexOf(boundary, pos) - 4;
            int startPos = ((archivo.substring(0, pos)).getBytes()).length;
            int endPos = ((archivo.substring(0, boundaryLocation)).getBytes()).length;
            
            // Copiamos los datos en un array
            byte[] datosArchivo = new byte[(endPos - startPos)];
            System.arraycopy(dataBytes, startPos, datosArchivo, 0, (endPos - startPos));
            
            // Codificamos a Base64
            BASE64Encoder e = new BASE64Encoder();
            String datos = e.encodeBuffer(datosArchivo);
            
            // Guardamos en la BD
            guardarEnLaBD(datos);
            request.getRequestDispatcher("formCargaImagen.jsp").forward(request, response);
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
    public void guardarEnLaBD(String datos){
        Oferta o = ofertaFacade.find(1);
//        o.setImagen(datos);
        ofertaFacade.edit(o);
    }
}
