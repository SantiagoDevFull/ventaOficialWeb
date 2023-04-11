<%-- 
    Document   : index
    Created on : 29 mar. 2023, 1:11:26
    Author     : usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Iniciar Sesión</title>

        <jsp:include page="includes/RecursosCSS.jsp"></jsp:include>

        </head>


        <body>

        <jsp:include page="includes/RecursosJS.jsp"></jsp:include>
            <script src="js/Usuario.js" type="text/javascript"></script>

            <div class=" row align-items-center justify-content-center vh-100 mx-auto">
                <div class="container-fluid col-3 border rounded" style="padding: 0% 1% 1% 1%">

                    <form action="ControlUsuario" method="POST" class="form" onsubmit="return ValidarUsuario()">

                        <div class="text-center">
                            <img src="Imagenes/fondoIndex.png" class="img-fluid">
                        </div>

                        <label class="form-label">Correo</label>
                        <input class="form-control form-control-lg" type="text" name="txtCorreo" id="txtCorreo" >

                        <label class="form-label">Contraseña</label>
                        <input class="form-control form-control-lg" type="password" name="txtPass" id="txtPass">

                        <div class="text-center mt-3">
                            <button class="btn btn-primary btn-lg" type="submit" name="accion" value="Login">Iniciar Sesión</button>
                        </div>

                    </form>

                </div>
            </div>

        <%
            
            String mensaje = "";
            
            if (request.getSession().getAttribute("error") != null) {
                mensaje = (String) request.getSession().getAttribute("error");
                out.print("<script>fnToast('error','" + mensaje + "')</script>");
            }
            
            request.getSession().removeAttribute("error");
            
        %>

    </body>
</html>
