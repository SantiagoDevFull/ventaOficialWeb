<%-- 
    Document   : pagProducto
    Created on : 4 abr. 2023, 14:33:30
    Author     : usuario
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Productos</title>
        <jsp:include page="../includes/RecursosCSS.jsp"></jsp:include>
        </head>

        <body>
            <script src="js/Producto.js" type="text/javascript"></script>
        <jsp:include page="../includes/RecursosJS.jsp"></jsp:include>
        <jsp:include page="../includes/Navegacion.jsp"></jsp:include>


            <div class="container-fluid mt-3">

                <h5>Gestión de Productos</h5>
                <hr>

                <button type="button" class="btn btn-success" data-bs-toggle="modal" data-bs-target="#modalAgregar">
                    Nuevo
                </button><br><br>

                <div>
                    <table id="tabla" class="table table-striped table-bordered text-center" style="width:100%">
                        <thead>
                            <tr>
                                <th class="text-center">Código</th>
                                <th class="text-center">Producto</th>
                                <th class="text-center">Stock</th>
                                <th class="text-center">Precio</th>
                                <th class="text-center">Estado</th>
                                <th class="text-center">Categoría</th>
                                <th class="text-center">Proveedor</th>
                                <th class="text-center">Acción</th>
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="i" items="${ListarProducto}">
                            <tr>
                                <td>${i.getIdPro()}</td>
                                <td>${i.getNomPro()}</td>
                                <td>${i.getStockPro()}</td>
                                <td>${i.getPrecioPro()}</td>
                                <td>${i.getEstadoPro()}</td>
                                <td>${i.getCategoria().getNomCat()}</td>
                                <td>${i.getProveedor().getNomProve()}</td>
                                <td>
                                    <button onclick="PasarDatosUpdate(${i.getIdPro()}, '${i.getNomPro()}', ${i.getStockPro()},
                                            ${i.getPrecioPro()}, '${i.getEstadoPro()}',
                                            ${i.getCategoria().getIdCat()}, ${i.getProveedor().getIdProve()})" 
                                            type="button" class="btn btn-info" data-bs-toggle="modal" data-bs-target="#modalActualizar">
                                        <i class="fa fa-edit" ></i>
                                    </button>
                                    <a  href="javascript:ConfirmarEliminacion(${i.getIdPro()} ,'${i.getNomPro()}')" class="btn btn-danger"><i class="fa-solid fa-trash"></i></a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>


        <div class="modal fade" id="modalEliminar" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1"  data-keyboard="false">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h1 class="modal-title fs-5">::: Eliminar Producto :::</h1>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <form action="ControlProducto" method="POST">
                        <div class="modal-body">
                            <p>¿Está seguro que desea eliminar el Producto <span id="lbTexto"></span>?</p>
                        </div>
                        <div class="modal-footer">
                            <input type="hidden" name="id" id="id">
                            <input type="hidden" name="accion" value="Eliminar">
                            <button type="button" class="btn btn-default" data-bs-dismiss="modal">
                                <i class="fa fa-times"></i>&nbsp; Cancelar</button>
                            <button type="submit" h class="btn btn-primary">
                                <i class="fa fa-check"></i> &nbsp; Confirmar
                            </button>
                        </div>
                    </form>
                </div>
            </div>
        </div>



        <div class="modal fade" id="modalAgregar" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-sm">
                <div class="modal-content">
                    <div class="modal-header">
                        <h1 class="modal-title fs-5" id="exampleModalLabel">::: Nuevo Producto :::</h1>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <form action="ControlProducto" method="POST" class="form" onsubmit="return ValidarProductoAgregar()">
                        <div class="modal-body">

                            <label class="form-label">Código:</label>
                            <input type="number" name="txtIDpro" id="txtIDpro" value="${codigo}" readonly="" class="form-control">

                            <label class="form-label">Producto:</label>
                            <input type="text" name="txtNomPro" id="txtNomPro"  class="form-control">

                            <label class="form-label">Stock:</label>
                            <input type="number" name="txtStockPro" id="txtStockPro"  class="form-control">

                            <label class="form-label">Precio:</label>
                            <input type="number" name="txtPrecioPro" id="txtPrecioPro" step="0.01"  class="form-control">

                            <label class="form-label">Estado:</label>
                            <select class="form-select" name="txtEstadoPro" id="txtEstadoPro">
                                <option value="">:::Seleccionar:::</option>
                                <option value="ON">ON</option>
                                <option value="OFF">OFF</option>
                            </select>

                            <label class="form-label">Categoría:</label>
                            <select class="form-select" name="txtCategoria" id="txtCategoria">
                                <option value="">:::Seleccionar:::</option>
                                <c:forEach var="i" items="${ListarCategoria}">
                                    <option value="${i.getIdCat()}">${i.getNomCat()}</option>
                                </c:forEach>
                            </select>

                            <label class="form-label">Proveedor:</label>
                            <select class="form-select" name="txtProveedor" id="txtProveedor">
                                <option value="">:::Seleccionar:::</option>
                                <c:forEach var="i" items="${ListarProveedor}">
                                    <option value="${i.getIdProve()}">${i.getNomProve()}</option>
                                </c:forEach>
                            </select>

                        </div>
                        <div class="modal-footer">
                            <button type="reset" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
                            <button type="submit" name="accion" value="Agregar" class="btn btn-success">Agregar</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>



        <div class="modal fade" id="modalActualizar" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-sm">
                <div class="modal-content">
                    <div class="modal-header">
                        <h1 class="modal-title fs-5" id="exampleModalLabel">::: Editar Producto :::</h1>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <form action="ControlProducto" method="POST" class="form" onsubmit="return ValidarProductoActualizar()">
                        <div class="modal-body">

                            <label class="form-label">Código:</label>
                            <input type="number" name="lblIDpro" id="lblIDpro"  readonly="" class="form-control">

                            <label class="form-label">Producto:</label>
                            <input type="text" name="lblNomPro" id="lblNomPro"  class="form-control">

                            <label class="form-label">Stock:</label>
                            <input type="text" name="lblStockPro" id="lblStockPro"  class="form-control">

                            <label class="form-label">Precio:</label>
                            <input type="text" name="lblPrecioPro" id="lblPrecioPro"  class="form-control">

                            <label class="form-label">Estado:</label>
                            <select class="form-select" name="lblEstadoPro" id="lblEstadoPro">
                                <option value="">:::Seleccionar:::</option>
                                <option value="ON">ON</option>
                                <option value="OFF">OFF</option>
                            </select>

                            <label class="form-label">Categoría:</label>
                            <select class="form-select" name="lblCategoria" id="lblCategoria">
                                <option value="">:::Seleccionar:::</option>
                                <c:forEach var="i" items="${ListarCategoria}">
                                    <option value="${i.getIdCat()}">${i.getNomCat()}</option>
                                </c:forEach>
                            </select>

                            <label class="form-label">Proveedor:</label>
                            <select class="form-select" name="lblProveedor" id="lblProveedor">
                                <option value="">:::Seleccionar:::</option>
                                <c:forEach var="i" items="${ListarProveedor}">
                                    <option value="${i.getIdProve()}">${i.getNomProve()}</option>
                                </c:forEach>
                            </select>

                        </div>
                        <div class="modal-footer">
                            <button type="reset" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
                            <button type="submit" name="accion" value="Actualizar" class="btn btn-primary">Actualizar</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>


    </body>
</html>
