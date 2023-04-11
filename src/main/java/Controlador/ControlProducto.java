package Controlador;

import Modelo.Categoria;
import Modelo.Producto;
import Modelo.Proveedor;
import ModeloDAO.CategoriaDAO;
import ModeloDAO.ProductoDAO;
import ModeloDAO.ProveedorDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControlProducto extends HttpServlet {

    private ProductoDAO daoProducto = new ProductoDAO();
    private CategoriaDAO daoCategoria = new CategoriaDAO();
    private ProveedorDAO daoProveedor = new ProveedorDAO();

    private String pagListar = "Vista/pagProducto.jsp";

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

        request.setAttribute("codigo", daoProducto.RetornarCodigoProducto());
        request.setAttribute("ListarCategoria", daoCategoria.ListarCategoria());
        request.setAttribute("ListarProveedor", daoProveedor.ListarProveedor());
        request.setAttribute("ListarProducto", daoProducto.ListarProducto());
        request.getRequestDispatcher(pagListar).forward(request, response);

    }

    protected void Agregar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        int res = 0;

        int id = 0;
        String nombre = request.getParameter("txtNomPro");
        int stock = Integer.parseInt(request.getParameter("txtStockPro"));
        double precio = Double.parseDouble(request.getParameter("txtPrecioPro"));
        String estado = request.getParameter("txtEstadoPro");
        int idcat = Integer.parseInt(request.getParameter("txtCategoria"));
        int idProve = Integer.parseInt(request.getParameter("txtProveedor"));

        Categoria c = new Categoria();
        Proveedor pr = new Proveedor();

        c.setIdCat(idcat);
        pr.setIdProve(idProve);

        Producto p = new Producto(id, nombre, stock, precio, estado, c, pr);
        res = daoProducto.AgregarProducto(p);

        if (res > 0) {
            request.getSession().setAttribute("success", "Producto agregado correctamente");
        } else {
            request.getSession().setAttribute("error", "Producto no se pudo agregar");
        }

        response.sendRedirect("ControlProducto?accion=Listar");

    }

    protected void Actualizar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        int res = 0;

        int id = Integer.parseInt(request.getParameter("lblIDpro"));
        String nombre = request.getParameter("lblNomPro");
        int stock = Integer.parseInt(request.getParameter("lblStockPro"));
        double precio = Double.parseDouble(request.getParameter("lblPrecioPro"));
        String estado = request.getParameter("lblEstadoPro");
        int idcat = Integer.parseInt(request.getParameter("lblCategoria"));
        int idProve = Integer.parseInt(request.getParameter("lblProveedor"));

        Categoria c = new Categoria();
        Proveedor pr = new Proveedor();

        c.setIdCat(idcat);
        pr.setIdProve(idProve);

        Producto p = new Producto(id, nombre, stock, precio, estado, c, pr);
        res = daoProducto.EditarProducto(p);

        if (res > 0) {
            request.getSession().setAttribute("success", "Producto actualizado correctamente");
        } else {
            request.getSession().setAttribute("error", "Producto no se pudo actualizar");
        }

        response.sendRedirect("ControlProducto?accion=Listar");

    }

    protected void Eliminar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        int res = 0;

        int id = Integer.parseInt(request.getParameter("id"));

        res = daoProducto.EliminarProducto(id);

        if (res > 0) {
            request.getSession().setAttribute("success", "Producto eliminado correctamente");
        } else {
            request.getSession().setAttribute("error", "Producto no se pudo eliminar");
        }

        response.sendRedirect("ControlProducto?accion=Listar");

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
