<%-- 
    Document   : pagBoleta
    Created on : 4 abr. 2023, 16:47:32
    Author     : usuario
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nueva Boleta</title>
        <jsp:include page="../includes/RecursosCSS.jsp"></jsp:include>
        </head>

        <body>

            <script src="js/Boleta.js" type="text/javascript"></script>
        <jsp:include page="../includes/RecursosJS.jsp"></jsp:include>
        <jsp:include page="../includes/Navegacion.jsp"></jsp:include>

            <div class="container-fluid  col-8 border bordered mt-3" style="padding: 1% 1% 1% 1%">

                <form action="ControlBoleta" method="GET" class="form" onsubmit="return ValidarProceso()">

                    <h3 class="text-center  text-warning">
                        Nueva Boleta N°0000
                    ${codigo}
                    <input type="hidden" name="txtIDboleta" value="${codigo}">
                </h3>

                <div class="col-12 d-flex row">

                    <div class="col-6">
                        <label class="form-label">Cliente:</label>

                        <div class="input-group">
                            <input type="hidden" name="txtIDcli" id="txtIDcli">
                            <input type="text" class="form-control" readonly=""" id="txtCliente">
                            <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#BuscarCliente">
                                Buscar
                            </button>
                        </div>
                    </div>

                    <div class="col-6">
                        <label class="form-label">Responsable de la Atencipón:</label>
                        <input type="hidden" name="txtIDusuario" id="txtIDusuario" value="${usuario.getIdUsu()}">
                        <input type="text" class="form-control" readonly="" id="txtUsuario" 
                               value="${usuario.getNomUsu()} ${usuario.getPatUsu()} ${usuario.getMatUsu()} | ${usuario.getRol().getNomRol()}">
                    </div>

                </div>

                <div class="d-flex col-12 row">

                    <div class="col-3">
                        <label class="form-label">Producto:</label>
                        <div class="input-group">
                            <input type="hidden" id="txtIDpro">
                            <input type="text" class="form-control" readonly="" id="txtNomPro">
                            <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#BuscarProducto">
                                Buscar
                            </button>
                        </div>
                    </div> 

                    <div class="col-3">
                        <label class="form-label">Stock:</label>
                        <input type="number" class="form-control" readonly="" id="txtStockPro">
                    </div> 

                    <div class="col-3">
                        <label class="form-label">Precio:</label>
                        <input type="number" step="0.01" readonly="" class="form-control"  id="txtPrecioPro">
                    </div> 

                    <div class="col-3">
                        <label class="form-label">Cantidad:</label>
                        <input type="number" class="form-control" id="txtCantidadPro">
                    </div> 

                </div>

                <div class="mt-3">
                    <div class="d-flex justify-content-end gap-2">
                        <button type="button"  onclick="CargarCarrito()" class="btn btn-success" data-bs-dismiss="modal">
                            <i class="fa-solid fa-check"></i>&nbsp;Agregar
                        </button>
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal" onclick="LimpiarProducto()">
                            <i class="fa-sharp fa-solid fa-spinner"></i>&nbsp;Cancelar
                        </button>
                        <button type="submit" name="accion" value="ProcesarBoleta" class="btn btn-primary" data-bs-dismiss="modal">
                            <i class="fa-solid fa-cart-plus"></i>&nbsp;Realizar Compra
                        </button>
                    </div>
                </div>

                <div id="carrito" class="">
                    <jsp:include page="pagBDetalle.jsp"></jsp:include>
                    </div>

                </form>

            </div>



        <%--BUSCAR CLIENTE--%>

        <div class="modal fade modal-lg" id="BuscarCliente" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h1 class="modal-title fs-5" id="staticBackdropLabel">::: Clientes disponibles :::</h1>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <table id="tabla" class="table table-striped table-bordered text-center" >
                            <thead class="bg-warning">
                                <tr>
                                    <th class="text-center">Seleccionar</th>
                                    <th class="text-center">Código</th>
                                    <th class="text-center">DNI</th>
                                    <th class="text-center">Nombre</th>
                                    <th class="text-center">Correo</th>
                                </tr>
                            </thead>

                            <tbody>
                                <c:forEach var="i" items="${ListarClientesDNIactivos}">
                                    <tr>
                                        <td>
                                            <a href="javascript:CargarCliente(${i.getIdCli()},'${i.getNomCli()}')"  class="btn btn-success btn-sm">
                                                <i class="fa fa-check-circle"></i>
                                            </a>
                                        </td>
                                        <td>${i.getIdCli()}</td>
                                        <td>${i.getNumCli()}</td>
                                        <td>${i.getNomCli()}</td>
                                        <td>${i.getCorreoCli()}</td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>

                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
                    </div>
                </div>
            </div>
        </div>


        <%--BUSCAR PRODUCTO--%>

        <div class="modal fade modal-lg" id="BuscarProducto" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h1 class="modal-title fs-5" id="staticBackdropLabel">::: Productos disponibles :::</h1>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <table id="tabla2" class="table table-striped table-bordered text-center" >
                            <thead class="bg-warning">
                                <tr>
                                    <th class="text-center">Seleccionar</th>
                                    <th class="text-center">Código</th>
                                    <th class="text-center">Producto</th>
                                    <th class="text-center">Stock</th>
                                    <th class="text-center">Precio</th>
                                    <th class="text-center">Categoría:</th>
                                </tr>
                            </thead>

                            <tbody>
                                <c:forEach var="i" items="${ListarProductosActivos}">
                                    <tr>
                                        <td>
                                            <a href="javascript:CargarProducto
                                               (${i.getIdPro()},'${i.getNomPro()}',${i.getStockPro()},${i.getPrecioPro()})"  
                                               class="btn btn-success btn-sm">
                                                <i class="fa fa-check-circle"></i>
                                            </a>
                                        </td>
                                        <td>${i.getIdPro()}</td>
                                        <td>${i.getNomPro()}</td>
                                        <td>${i.getStockPro()}</td>
                                        <td>${i.getPrecioPro()}</td>
                                        <td>${i.getCategoria().getNomCat()}</td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>

                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
                    </div>
                </div>
            </div>
        </div>


    </body>
</html>
