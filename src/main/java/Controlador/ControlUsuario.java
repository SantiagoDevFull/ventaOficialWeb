package Controlador;

import Modelo.Rol;
import Modelo.Usuario;
import ModeloDAO.RolDAO;
import ModeloDAO.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControlUsuario extends HttpServlet {

    private UsuarioDAO daoUsuario = new UsuarioDAO();
    private RolDAO daoRol = new RolDAO();

    private String Index = "index.jsp";
    private String Inicio = "inicio.jsp";
    private String Listar = "Vista/pagUsuario.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String accion = request.getParameter("accion");

        switch (accion) {
            case "Inicio":
                Inicio(request, response);
                break;
            case "NuevoIndex":
                NuevoIndex(request, response);
                break;
            case "Login":
                Login(request, response);
                break;
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

    protected void Eliminar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        int res = 0;
        int idUsu = Integer.parseInt(request.getParameter("id"));

        res = daoUsuario.EliminarUsuario(idUsu);

        if (res > 0) {
            request.getSession().setAttribute("success", "Usuario eliminado correctamente");
        } else {
            request.getSession().setAttribute("error", "Usuario no se pudo eliminar");
        }

        response.sendRedirect("ControlUsuario?accion=Listar");

    }

    protected void Actualizar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        int res = 0;
        int idUsu = Integer.parseInt(request.getParameter("lblIDusu"));
        String nombre = request.getParameter("lblNomUsu");
        String paterno = request.getParameter("lblPatUsu");
        String materno = request.getParameter("lblMatUsu");
        String correo = request.getParameter("lblCorreoUsu");
        String pass = request.getParameter("lblPassUsu");
        String fecha = request.getParameter("lblFechaUsu");
        String estado = request.getParameter("lblEstadoUsu");
        int idRol = Integer.parseInt(request.getParameter("lblRolUsu"));

        Rol r = new Rol();
        r.setIdRol(idRol);
        Usuario u = new Usuario(idUsu, nombre, paterno, materno, correo, pass, fecha, estado, r);

        res = daoUsuario.EditarUsuario(u);

        if (res > 0) {
            request.getSession().setAttribute("success", "Usuario actualizado correctamente");
        } else {
            request.getSession().setAttribute("error", "Usuario no se pudo actualizar");
        }

        response.sendRedirect("ControlUsuario?accion=Listar");

    }

    protected void Agregar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        int res = 0;
        int idUsu = 0;
        String nombre = request.getParameter("txtNomUsu");
        String paterno = request.getParameter("txtPatUsu");
        String materno = request.getParameter("txtMatUsu");
        String correo = request.getParameter("txtCorreoUsu");
        String pass = request.getParameter("txtPassUsu");
        String fecha = request.getParameter("txtFechaUsu");
        String estado = request.getParameter("txtEstadoUsu");
        int idRol = Integer.parseInt(request.getParameter("txtRolUsu"));

        Rol r = new Rol();
        r.setIdRol(idRol);
        Usuario u = new Usuario(idUsu, nombre, paterno, materno, correo, pass, fecha, estado, r);

        res = daoUsuario.AgregarUsuario(u);

        if (res > 0) {
            request.getSession().setAttribute("success", "Usuario agregado correctamente");
        } else {
            request.getSession().setAttribute("error", "Usuario no se pudo agregar");
        }

        response.sendRedirect("ControlUsuario?accion=Listar");

    }

    protected void Listar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        request.setAttribute("codigo", daoUsuario.RetornarCodigoUsuario());
        request.setAttribute("ListarRol", daoRol.ListarRol());
        request.setAttribute("ListarUsuario", daoUsuario.ListarUsuario());
        request.getRequestDispatcher(Listar).forward(request, response);

    }

    protected void Inicio(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        request.getRequestDispatcher(Inicio).forward(request, response);

    }

    protected void NuevoIndex(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        request.getRequestDispatcher(Index).forward(request, response);

    }

    protected void Login(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String correo = request.getParameter("txtCorreo");
        String pass = request.getParameter("txtPass");

        Usuario u = daoUsuario.ExisteUsuario(correo, pass);

        if (u != null) {
            if (u.getRol().getEstadoRol().equalsIgnoreCase("ON")) {
                if (u.getEstadoUsu().equalsIgnoreCase("ON")) {
                    request.getSession().setAttribute("usuario", u);
                    response.sendRedirect("ControlUsuario?accion=Inicio");
                    return;
                } else {
                    request.getSession().setAttribute("error", "Usuario inactivo");
                }
            } else {
                request.getSession().setAttribute("error", "Rol inactivo");
            }
        } else {
            request.getSession().setAttribute("error", "Correo y/o contraseña incorrecto");
        }

        response.sendRedirect("ControlUsuario?accion=NuevoIndex");
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
