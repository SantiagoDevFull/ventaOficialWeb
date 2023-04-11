package Controlador;

import Modelo.Rol;
import ModeloDAO.RolDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControlRol extends HttpServlet {

    private RolDAO daoRol = new RolDAO();

    private String pagListar = "Vista/pagRol.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String accion = request.getParameter("accion");

        switch (accion) {
            case "Listar":
                Listar(request, response);
                break;
            case "Agregar":
                Agregar(request, response);
                break;
            case "Eliminar":
                Eliminar(request, response);
                break;
            case "Actualizar":
                Actualizar(request, response);
                break;
        }

    }

    protected void Listar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        request.setAttribute("codigo", daoRol.RetornarCodigoRol());
        request.setAttribute("ListarRol", daoRol.ListarRol());
        request.getRequestDispatcher(pagListar).forward(request, response);

    }

    protected void Agregar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        int res = 0;

        int id = 0;
        String rol = request.getParameter("txtNomRol");
        String estado = request.getParameter("txtEstadoRol");

        Rol r = new Rol(id, rol, estado);
        res = daoRol.AgregarRol(r);

        if (res > 0) {
            request.getSession().setAttribute("success", "Rol agregado exitosamente");
        } else {
            request.getSession().setAttribute("error", "No se pudo agregar el Rol");
        }

        response.sendRedirect("ControlRol?accion=Listar");

    }

    protected void Eliminar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        int res = 0;

        int id = Integer.parseInt(request.getParameter("id"));
        res = daoRol.EliminarRol(id);

        if (res > 0) {
            request.getSession().setAttribute("success", "Rol eliminado exitosamente");
        } else {
            request.getSession().setAttribute("error", "No se pudo eliminar el Rol");
        }

        response.sendRedirect("ControlRol?accion=Listar");

    }

    protected void Actualizar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        int res = 0;

        int id = Integer.parseInt(request.getParameter("lblIDrol"));
        String rol = request.getParameter("lblNomRol");
        String estado = request.getParameter("lblEstadoRol");

        Rol r = new Rol(id, rol, estado);
        res = daoRol.EditarRol(r);

        if (res > 0) {
            request.getSession().setAttribute("success", "Rol actualizado exitosamente");
        } else {
            request.getSession().setAttribute("error", "No se pudo actualizar el Rol");
        }

        response.sendRedirect("ControlRol?accion=Listar");

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
        processRequest(request, response);
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
    }// </editor-fold>

}
