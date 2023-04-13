<%-- 
    Document   : pagConsultaBoleta
    Created on : 12 abr. 2023, 0:51:16
    Author     : usuario
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <jsp:include page="../includes/RecursosCSS.jsp"></jsp:include>
        </head>

        <body>
            <script src="js/Boleta.js" type="text/javascript"></script>
        <jsp:include page="../includes/RecursosJS.jsp"></jsp:include>
        <jsp:include page="../includes/Navegacion.jsp"></jsp:include>

            <div class="container-fluid mt-3">

                <h5>Consultar Boleta</h5>
                <hr>

                <table id="tabla" class="text-center table table-bordered table-striped" style="width: 100%">
                    <thead class="bg-warning">
                        <tr>
                            <th class="text-center">ID Boleta</th>
                            <th class="text-center">Cliente</th>
                            <th class="text-center">Responsable</th>
                            <th class="text-center">Fecha Compra</th>
                            <th class="text-center">Total</th>
                            <th class="text-center">Detalle</th>
                        </tr>
                    </thead>

                    <tbody>
                    <c:forEach var="x" items="${ListarBoletas}">
                        <tr>
                            <td>${x.getIdBoleta()}</td>
                            <td>${x.getNombreCliente()}</td>
                            <td>${x.getNombreUsuario()}</td>
                            <td>${x.getFechaCompra()}</td>
                            <td>${x.getTotal()}</td>
                            <td>
                                <a href="javascript:VerDetalle(${x.getIdBoleta()})" class="btn btn-info">Ver</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>

        </div>


        <div class="modal fade" id="modalDetalle" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
            <div class="modal-dialog modal-lg">
                <div class="modal-content">
                    <div class="modal-header">
                        <h1 class="modal-title fs-5" id="staticBackdropLabel">::: Detalle Boleta :::</h1>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                       
                        <div id="detalle">
                            
                        </div>
                        
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
                    </div>
                </div>
            </div>
        </div>

    </body>
</html>
