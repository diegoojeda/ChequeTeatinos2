package src.Servlets;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import src.Entities.Empresa;
import src.Facades.EmpresaFacade;

/**
 *
 * @author diegoojedagarcia
 */
@WebServlet(name = "anadeEmpresaServlet", urlPatterns = {"/anadeEmpresaServlet"})
public class anadeEmpresaServlet extends HttpServlet {
    @EJB
    private EmpresaFacade empresaFacade;

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
        Empresa e = new Empresa(empresaFacade.getNextSeqVal());
        e.setDireccion(request.getParameter("direccion"));
        e.setNombre(request.getParameter("nombre"));
        empresaFacade.create(e);
        request.getRequestDispatcher("admin.jsp").forward(request, response);
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
