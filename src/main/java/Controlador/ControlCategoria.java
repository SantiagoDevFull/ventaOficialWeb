package Controlador;

import Modelo.Categoria;
import ModeloDAO.CategoriaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControlCategoria extends HttpServlet {

    private CategoriaDAO daoCategoria = new CategoriaDAO();

    private String pagListar = "Vista/pagCategoria.jsp";

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

        request.setAttribute("codigo", daoCategoria.RetornarCodigoCategoria());
        request.setAttribute("ListarCategoria", daoCategoria.ListarCategoria());
        request.getRequestDispatcher(pagListar).forward(request, response);

    }

    protected void Agregar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        int res = 0;
        int id = 0;
        String nombre = request.getParameter("txtNomCat");
        String estado = request.getParameter("txtEstadoCat");

        Categoria c = new Categoria(id, nombre, estado);
        res = daoCategoria.AgregarCategoria(c);

        if (res > 0) {
            request.getSession().setAttribute("success", "Categoría agregado correctamente");
        } else {
            request.getSession().setAttribute("error", "Categoría no se pudo agregar");
        }

        response.sendRedirect("ControlCategoria?accion=Listar");

    }

    protected void Actualizar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        int res = 0;
        int id = Integer.parseInt(request.getParameter("lblIDcat"));
        String nombre = request.getParameter("lblNomCat");
        String estado = request.getParameter("lblEstadoCat");

        Categoria c = new Categoria(id, nombre, estado);
        res = daoCategoria.EditarCategoria(c);

        if (res > 0) {
            request.getSession().setAttribute("success", "Categoría actualizado correctamente");
        } else {
            request.getSession().setAttribute("error", "Categoría no se pudo actualizar");
        }

        response.sendRedirect("ControlCategoria?accion=Listar");

    }

    protected void Eliminar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        int res = 0;
        int id = Integer.parseInt(request.getParameter("id"));

        res = daoCategoria.EliminarCategoria(id);

        if (res > 0) {
            request.getSession().setAttribute("success", "Categoría eliminado correctamente");
        } else {
            request.getSession().setAttribute("error", "Categoría no se pudo eliminar");
        }

        response.sendRedirect("ControlCategoria?accion=Listar");

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
