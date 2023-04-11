<%-- 
    Document   : pagBDetalle
    Created on : 5 abr. 2023, 23:48:39
    Author     : usuario
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<table class="mt-3 table table-bordered text-center bordered">

    <thead class="bg-info">
        <tr>
            <th class="col-2">Cantidad</th>
            <th class="col-5">Producto</th>
            <th class="col-2">Precio</th>
            <th class="col-3">Importe</th>
        </tr>
    </thead>

    <tbody>
        <c:forEach var="x" items="${ListarCarrito}">
            <tr>
                <td>${x.getCantidad()}</td>
                <td>${x.getDescripcion()}</td>
                <td>${x.getPrecioPro()}</td>
                <td>${x.Importe()}</td>
            </tr>
        </c:forEach>
    </tbody>

    <tfoot>
        <tr>
            <td class="bg-secondary"></td>
            <td class="bg-secondary"></td>
            <td class="bg-info">Total</td>
            <td class="bg-info">${Total}</td>
        </tr>
    </tfoot>

</table>
