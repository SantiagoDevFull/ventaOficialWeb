<%@page import="Modelo.Usuario"%>
<%

    Usuario u = (Usuario) request.getSession().getAttribute("usuario");
%>
<nav class="navbar navbar-dark bg-primary">
    <div class="container-fluid">
        <a class="navbar-brand">
            <i class="bi bi-house-check-fill"></i>
            Sistema de Venta Balbin
        </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasDarkNavbar" aria-controls="offcanvasDarkNavbar">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="offcanvas offcanvas-end text-bg-dark" tabindex="-1" id="offcanvasDarkNavbar" aria-labelledby="offcanvasDarkNavbarLabel">
            <div class="offcanvas-header">
                <h5 class="offcanvas-title" id="offcanvasDarkNavbarLabel">Bienvenido</h5>
                <button type="button" class="btn-close btn-close-white" data-bs-dismiss="offcanvas" aria-label="Close"></button>
            </div>

            <div class="offcanvas-body">

                <div class="text-center">
                    <hr>

                    <i class="bi bi-person-circle" style="font-size: 6em"></i><br>
                    ${usuario.getNomUsu()} ${usuario.getPatUsu()} ${usuario.getMatUsu()} <br> ${usuario.getRol().getNomRol()}
                    <form action="" method="">
                        <button class="btn btn-danger" name="accion" value="CerrarSesion">Cerrar sesión</button>
                    </form>

                    <hr> 
                </div>

                <ul class="navbar-nav justify-content-end flex-grow-1 pe-3">

                    <li class="nav-item">
                        <a class="nav-link" href="ControlUsuario?accion=Inicio"><i class="bi bi-house-check-fill"></i>&nbsp;Inicio</a>
                        <a class="nav-link" href="ControlRol?accion=Listar"><i class="bi bi-shield-lock-fill"></i>&nbsp;Rol de Usuarios</a>
                        <a class="nav-link" href="ControlUsuario?accion=Listar"><i class="bi bi-person-fill-check"></i>&nbsp;Usuarios</a>
                        <a class="nav-link" href="ControlCliente?accion=Listar"><i class="bi bi-person-badge-fill"></i>&nbsp;Clientes</a>
                        <a class="nav-link" href="ControlProveedor?accion=Listar"><i class="bi bi-browser-edge"></i>&nbsp;Proveedores de Productos</a>
                        <a class="nav-link" href="ControlCategoria?accion=Listar"><i class="bi bi-bar-chart-steps"></i>&nbsp;Categoría de Productos</a>
                        <a class="nav-link" href="ControlProducto?accion=Listar"><i class="bi bi-box-seam-fill"></i>&nbsp;Productos</a>
                        <a class="nav-link" href="ControlBoleta?accion=Nueva"><i class="fa-solid fa-cart-shopping"></i>&nbsp;Nueva Boleta</a>
                        <a class="nav-link" href="ControlBoleta?accion=Consultar"><i class="fa-solid fa-cart-shopping"></i>&nbsp;Consultar Boleta</a>
                    </li>

                </ul>
            </div>
        </div>
    </div>
</nav>

<%

    String mensaje = "";

    if (request.getSession().getAttribute("success") != null) {
        mensaje = (String) request.getSession().getAttribute("success");
        out.print("<script>fnToast('success','" + mensaje + "')</script>");
    }

    if (request.getSession().getAttribute("error") != null) {
        mensaje = (String) request.getSession().getAttribute("error");
        out.print("<script>fnToast('error','" + mensaje + "')</script>");
    }
    
    if (request.getSession().getAttribute("warning") != null) {
        mensaje = (String) request.getSession().getAttribute("warning");
        out.print("<script>fnToast('warning','" + mensaje + "')</script>");
    }
    
    if (request.getSession().getAttribute("info") != null) {
        mensaje = (String) request.getSession().getAttribute("info");
        out.print("<script>fnToast('info','" + mensaje + "')</script>");
    }

    request.getSession().removeAttribute("success");
    request.getSession().removeAttribute("error");
    request.getSession().removeAttribute("info");
    request.getSession().removeAttribute("warning");

%>