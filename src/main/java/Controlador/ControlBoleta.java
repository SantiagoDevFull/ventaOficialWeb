package Controlador;

import Modelo.BDetalle;
import Modelo.Boleta;
import ModeloDAO.BoletaDAO;
import ModeloDAO.ClienteDAO;
import ModeloDAO.ProductoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControlBoleta extends HttpServlet {
    
    private BoletaDAO daoBoleta = new BoletaDAO();
    private ProductoDAO daoProducto = new ProductoDAO();
    private ClienteDAO daoCliente = new ClienteDAO();
    
    private String pagNueva = "Vista/pagBoleta.jsp";
    private String pagDetalle = "Vista/pagBDetalle.jsp";
    private String pagConsultaBoleta = "Vista/pagConsultaBoleta.jsp";
    private String pagConsultarBDetalle="Vista/pagConsultarBDetalle.jsp";
    
    private ArrayList<BDetalle> detalle = new ArrayList();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String accion = request.getParameter("accion");
        switch (accion) {
            case "Nueva":
                Nueva(request, response);
                break;
            case "Agregar":
                Agregar(request, response);
                break;
            case "ListarCarrito":
                ListarCarrito(request, response);
                break;
            case "ProcesarBoleta":
                ProcesarBoleta(request, response);
                break;
            case "Consultar":
                Consultar(request, response);
                break;
            case "VerDetalle":
                VerDetalle(request, response);
                break;
        }
        
    }
    
    protected void VerDetalle(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        double suma=0;
        int id = Integer.parseInt(request.getParameter("id"));
        
        request.setAttribute("ListarDetalle", daoBoleta.ListarDetalle(id));
        
        for(BDetalle x:daoBoleta.ListarDetalle(id)){
            suma+=x.getCantidad()*x.getPrecioPro();
        }
        
        request.setAttribute("totalpago",suma);
        request.getRequestDispatcher(pagConsultarBDetalle).forward(request, response);
        
    }
    
    protected void Consultar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        request.setAttribute("ListarBoletas", daoBoleta.ListarBoleta());
        request.getRequestDispatcher(pagConsultaBoleta).forward(request, response);
        
    }
    
    protected void Nueva(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        request.setAttribute("codigo", daoBoleta.RetornarCodigoBoleta());
        request.setAttribute("ListarProductosActivos", daoProducto.ListarProductosActivos());
        request.setAttribute("ListarClientesDNIactivos", daoCliente.ListarClientesDNIactivos());
        request.setAttribute("ListarCarrito", detalle);
        request.setAttribute("Total", Total());
        request.getRequestDispatcher(pagNueva).forward(request, response);
        
    }
    
    protected void Agregar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        PrintWriter out = response.getWriter();
        
        int idPro = Integer.parseInt(request.getParameter("txtIDpro"));
        String nombre = request.getParameter("txtNomPro");
        int cantidad = Integer.parseInt(request.getParameter("txtCantidadPro"));
        double precio = Double.parseDouble(request.getParameter("txtPrecioPro"));
        
        BDetalle bd = new BDetalle(idPro, nombre, precio, cantidad);
        detalle.add(bd);
        
        ListarCarrito(request, response);
    }
    
    protected void ListarCarrito(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        request.setAttribute("ListarCarrito", detalle);
        request.setAttribute("Total", Total());
        request.getRequestDispatcher(pagDetalle).forward(request, response);
    }
    
    protected void ProcesarBoleta(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        if (detalle.size() <= 0) {
            
            out.print("<script>fnToast('warning','No hay productos registrados en su compra')</script>");
            
            return;
        }
        
        int idBoleta = Integer.parseInt(request.getParameter("txtIDboleta"));
        int idUsuario = Integer.parseInt(request.getParameter("txtIDusuario"));
        int idCliente = Integer.parseInt(request.getParameter("txtIDcli"));
        
        LocalDate fecha = LocalDate.now();
        LocalTime hora = LocalTime.now();
        String fecharegistro = fecha + " " + hora;
        
        double total = Total();
        
        Boleta b = new Boleta(idBoleta, idUsuario, idCliente, fecharegistro, total);
        b.setDetalle(detalle);
        
        if (daoBoleta.ProcesarBoleta(b) > 1) {
            request.getSession().setAttribute("success", "::: Boleta procesado exitosamente :::");
        } else {
            request.getSession().setAttribute("error", "::: Hubo un problema en la compra :::");
        }
        
        detalle.removeAll(detalle);
        
        response.sendRedirect("ControlBoleta?accion=Nueva");
        
    }
    
    public double Total() {
        double total = 0;
        for (BDetalle x : detalle) {
            total += x.Importe();
        }
        return total;
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
