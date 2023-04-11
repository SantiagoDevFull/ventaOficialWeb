package Controlador;

import Modelo.Proveedor;
import ModeloDAO.ProveedorDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControlProveedor extends HttpServlet {

    private ProveedorDAO daoProveedor = new ProveedorDAO();

    private String pagListar = "Vista/pagProveedor.jsp";

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
            case "Actualizar":
                Actualizar(request, response);
                break;
            case "Eliminar":
                Eliminar(request, response);
                break;
        }

    }

    protected void Listar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        request.setAttribute("codigo", daoProveedor.RetornarCodigoProveedor());
        request.setAttribute("ListarProveedor", daoProveedor.ListarProveedor());
        request.getRequestDispatcher(pagListar).forward(request, response);

    }

    protected void Agregar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        int res = 0;
        int id = 0;
        String nombre = request.getParameter("txtNomProve");
        String telefono = request.getParameter("txtTelProve");
        String direccion = request.getParameter("txtDireProve");
        String estado = request.getParameter("txtEstadoProve");

        Proveedor p = new Proveedor(id, nombre, telefono, direccion, estado);
        res = daoProveedor.AgregarProveedor(p);

        if (res > 0) {
            request.getSession().setAttribute("success", "Proveedor agregado correctamente");
        } else {
            request.getSession().setAttribute("error", "Proveedor no se pudo agregar");
        }

        response.sendRedirect("ControlProveedor?accion=Listar");

    }

    protected void Actualizar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        int res = 0;
        int id = Integer.parseInt(request.getParameter("lblIDprove"));
        String nombre = request.getParameter("lblNomProve");
        String telefono = request.getParameter("lblTelProve");
        String direccion = request.getParameter("lblDireProve");
        String estado = request.getParameter("lblEstadoProve");

        Proveedor p = new Proveedor(id, nombre, telefono, direccion, estado);
        res = daoProveedor.EditarProveedor(p);

        if (res > 0) {
            request.getSession().setAttribute("success", "Proveedor actualizado correctamente");
        } else {
            request.getSession().setAttribute("error", "Proveedor no se pudo actualizar");
        }

        response.sendRedirect("ControlProveedor?accion=Listar");

    }

    protected void Eliminar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        int res = 0;
        int id = Integer.parseInt(request.getParameter("id"));

        res = daoProveedor.EliminarProveedor(id);

        if (res > 0) {
            request.getSession().setAttribute("success", "Proveedor eliminado correctamente");
        } else {
            request.getSession().setAttribute("error", "Proveedor no se pudo eliminar");
        }

        response.sendRedirect("ControlProveedor?accion=Listar");

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
