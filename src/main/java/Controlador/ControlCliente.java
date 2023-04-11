package Controlador;

import Modelo.Cliente;
import ModeloDAO.ClienteDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControlCliente extends HttpServlet {

    private ClienteDAO daoCliente = new ClienteDAO();

    private String pagListar = "Vista/pagCliente.jsp";

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

        request.setAttribute("codigo", daoCliente.RetornarCodigoCliente());
        request.setAttribute("ListarCliente", daoCliente.ListarCliente());
        request.getRequestDispatcher(pagListar).forward(request, response);

    }

    protected void Agregar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        int res = 0;
        int id = 0;
        String doc = request.getParameter("txtDocCli");
        String numero = request.getParameter("txtNumCli");
        String nombre = request.getParameter("txtNomCli");
        String correo = request.getParameter("txtCorreoCli");
        String pass = request.getParameter("txtPassCli");
        String estado = request.getParameter("txtEstadoCli");

        Cliente c = new Cliente(id, doc, numero, nombre, correo, pass, estado);
        res = daoCliente.AgregarCliente(c);

        if (res > 0) {
            request.getSession().setAttribute("success", "Cliente agregado correctamente");
        } else {
            request.getSession().setAttribute("error", "Cliente no se pudo agregar");
        }

        response.sendRedirect("ControlCliente?accion=Listar");

    }

    protected void Actualizar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        int res = 0;
        int id = Integer.parseInt(request.getParameter("lblIDcli"));
        String doc = request.getParameter("lblDocCli");
        String numero = request.getParameter("lblNumCli");
        String nombre = request.getParameter("lblNomCli");
        String correo = request.getParameter("lblCorreoCli");
        String pass = request.getParameter("lblPassCli");
        String estado = request.getParameter("lblEstadoCli");

        Cliente c = new Cliente(id, doc, numero, nombre, correo, pass, estado);
        res = daoCliente.EditarCliente(c);

        if (res > 0) {
            request.getSession().setAttribute("success", "Cliente actualizado correctamente");
        } else {
            request.getSession().setAttribute("error", "Cliente no se pudo actualizar");
        }

        response.sendRedirect("ControlCliente?accion=Listar");

    }

    protected void Eliminar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        int res = 0;
        int id = Integer.parseInt(request.getParameter("id"));

        res = daoCliente.EliminarCliente(id);

        if (res > 0) {
            request.getSession().setAttribute("success", "Cliente eliminado correctamente");
        } else {
            request.getSession().setAttribute("error", "Cliente no se pudo eliminar");
        }

        response.sendRedirect("ControlCliente?accion=Listar");

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
