<%-- 
    Document   : pagProveedor
    Created on : 2 abr. 2023, 23:26:43
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
            <script src="js/Proveedor.js" type="text/javascript"></script>
        <jsp:include page="../includes/RecursosJS.jsp"></jsp:include>
        <jsp:include page="../includes/Navegacion.jsp"></jsp:include>

            <div class="container-fluid mt-3">

                <h5>Gestión de Proveedores de Productos</h5>
                <hr>

                <button type="button" class="btn btn-success" data-bs-toggle="modal" data-bs-target="#modalAgregar">
                    Nuevo
                </button><br><br>

                <div>
                    <table id="tabla" class="table table-striped table-bordered text-center" style="width:100%">
                        <thead>
                            <tr>
                                <th class="text-center">Código</th>
                                <th class="text-center">Nombre</th>
                                <th class="text-center">Teléfono</th>
                                <th class="text-center">Dirección</th>
                                <th class="text-center">Estado</th>
                                <th class="text-center">#Prod. Reg.</th>
                                <th class="text-center">Acción</th>
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="i" items="${ListarProveedor}">
                        <tr>
                            <td>${i.getIdProve()}</td>
                            <td>${i.getNomProve()}</td>
                            <td>${i.getTelProve()}</td>
                            <td>${i.getDireProve()}</td>
                            <td>${i.getEstadoProve()}</td>
                            <td>${i.getNumProductosReg()}</td>
                            <td>
                                <button onclick="PasarDatosUpdate(${i.getIdProve()}, '${i.getNomProve()}', '${i.getTelProve()}',
                                                '${i.getDireProve()}', '${i.getEstadoProve()}')" 
                                        type="button" class="btn btn-info" data-bs-toggle="modal" data-bs-target="#modalActualizar">
                                    <i class="fa fa-edit" ></i>
                                </button>
                                <a  href="javascript:ConfirmarEliminacion(${i.getIdProve()} ,'${i.getNomProve()}' )" onclick="return ValidarRegistrados(${i.getNumProductosReg()})" class="btn btn-danger"><i class="fa-solid fa-trash"></i></a>
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
                        <h1 class="modal-title fs-5">::: Eliminar Proveedor :::</h1>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <form action="ControlProveedor" method="POST">
                        <div class="modal-body">
                            <p>¿Está seguro que desea eliminar el Proveedor <span id="lbTexto"></span>?</p>
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
                        <h1 class="modal-title fs-5" id="exampleModalLabel">::: Nuevo Proveedor :::</h1>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <form action="ControlProveedor" method="POST" class="form" onsubmit="return ValidarProveedorAgregar()">
                        <div class="modal-body">

                            <label class="form-label">Código:</label>
                            <input type="number" name="txtIDprove" id="txtIDprove" value="${codigo}" readonly="" class="form-control">

                            <label class="form-label">Nombre:</label>
                            <input type="text" name="txtNomProve" id="txtNomProve" value="" class="form-control">

                            <label class="form-label">Teléfono:</label>
                            <input type="text" name="txtTelProve" id="txtTelProve" value="" class="form-control">

                            <label class="form-label">Dirección:</label>
                            <input type="text" name="txtDireProve" id="txtDireProve" value="" class="form-control">

                            <label class="form-label">Estado:</label>
                            <select class="form-select" name="txtEstadoProve" id="txtEstadoProve">
                                <option value="">:::Seleccionar:::</option>
                                <option value="ON">ON</option>
                                <option value="OFF">OFF</option>
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
                        <h1 class="modal-title fs-5" id="exampleModalLabel">::: Editar Proveedor :::</h1>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <form action="ControlProveedor" method="POST" class="form" onsubmit="return ValidarProveedorActualizar()">
                        <div class="modal-body">



                            <label class="form-label">Código:</label>
                            <input type="number" name="lblIDprove" id="lblIDprove" value="${codigo}" readonly="" class="form-control">

                            <label class="form-label">Nombre:</label>
                            <input type="text" name="lblNomProve" id="lblNomProve" value="" class="form-control">

                            <label class="form-label">Teléfono:</label>
                            <input type="text" name="lblTelProve" id="lblTelProve" value="" class="form-control">

                            <label class="form-label">Dirección:</label>
                            <input type="text" name="lblDireProve" id="lblDireProve" value="" class="form-control">

                            <label class="form-label">Estado:</label>
                            <select class="form-select" name="lblEstadoProve" id="lblEstadoProve">
                                <option value="">:::Seleccionar:::</option>
                                <option value="ON">ON</option>
                                <option value="OFF">OFF</option>
                            </select>

                        </div>
                        <div class="modal-footer">
                            <button type="reset" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
                            <button type="submit" name="accion" value="Actualizar" class="btn btn-info">Actualizar</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>


    </body>
</html>
