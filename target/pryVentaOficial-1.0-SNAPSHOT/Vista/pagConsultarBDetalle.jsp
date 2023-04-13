<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<table class="table table-bordered table-striped text-center">
    <thead class="bg-primary">
        <tr>
            <th>Cantidad</th>
            <th>Producto</th>
            <th>Precio</th>
            <th>Importe</th>
        </tr>
    </thead>

    <tbody>
        <c:forEach var="i" items="${ListarDetalle}">
            <tr>
                <td>${i.getCantidad()}</td>
                <td>${i.getDescripcion()}</td>
                <td>${i.getPrecioPro()}</td>
                <td>${i.getTotal()}</td>
            </tr>
        </c:forEach>
    </tbody>
    
    <tfoot>
        <tr>
            <td></td>
            <td></td>
            <td>Total</td>
            <td>${totalpago}</td>
        </tr>
    </tfoot>
</table>
