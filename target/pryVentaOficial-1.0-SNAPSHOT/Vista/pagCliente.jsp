<%-- 
    Document   : pagCliente
    Created on : 2 abr. 2023, 0:27:09
    Author     : usuario
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Clientes</title>

        <jsp:include page="../includes/RecursosCSS.jsp"></jsp:include>
        </head>
        <body>
            <script src="js/Cliente.js" type="text/javascript"></script>
        <jsp:include page="../includes/RecursosJS.jsp"></jsp:include>
        <jsp:include page="../includes/Navegacion.jsp"></jsp:include>

            <div class="container-fluid mt-3">

                <h5>Gestión de Clientes</h5>
                <hr>

                <button type="button" class="btn btn-success" data-bs-toggle="modal" data-bs-target="#modalAgregar">
                    Nuevo
                </button><br><br>

                <div>
                    <table id="tabla" class="table table-striped table-bordered text-center" style="width:100%">
                        <thead>
                            <tr>
                                <th class="text-center">Código</th>
                                <th class="text-center">Doc.</th>
                                <th class="text-center">Número</th>
                                <th class="text-center">Nombre / Razón</th>
                                <th class="text-center">Correo</th>
                                <th class="text-center">Contraseña</th>
                                <th class="text-center">Estado</th>
                                <th class="text-center">#Boletas</th>
                                <th class="text-center">Acción</th>
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="i" items="${ListarCliente}">
                            <tr>
                                <td>${i.getIdCli()}</td>
                                <td>${i.getDocCli()}</td>
                                <td>${i.getNumCli()}</td>
                                <td>${i.getNomCli()}</td>
                                <td>${i.getCorreoCli()}</td>
                                <td>${i.getPassCli()}</td>
                                <td>${i.getEstadoCli()}</td>
                                <td>${i.getNumBoletas()}</td>
                                <td>
                                    <button onclick="PasarDatosUpdate(${i.getIdCli()}, '${i.getDocCli()}', '${i.getNumCli()}',
                                                    '${i.getNomCli()}', '${i.getCorreoCli()}', '${i.getPassCli()}', '${i.getEstadoCli()}')" 
                                            type="button" class="btn btn-info" data-bs-toggle="modal" data-bs-target="#modalActualizar">
                                        <i class="fa fa-edit" ></i>
                                    </button>
                                    <a  href="javascript:ConfirmarEliminacion(${i.getIdCli()} ,'${i.getNomCli()}' )" onclick="return ValidarEliminacion(${i.getNumBoletas()})" class="btn btn-danger"><i class="fa-solid fa-trash"></i></a>
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
                        <h1 class="modal-title fs-5">::: Eliminar Cliente :::</h1>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <form action="ControlCliente" method="POST">
                        <div class="modal-body">
                            <p>¿Está seguro que desea eliminar el Cliente <span id="lbTexto"></span>?</p>
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
                        <h1 class="modal-title fs-5" id="exampleModalLabel">::: Nuevo Cliente :::</h1>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <form action="ControlCliente" method="POST" class="form" onsubmit="return ValidarClienteAgregar()">
                        <div class="modal-body">

                            <label class="form-label">Código:</label>
                            <input type="number" name="txtIDcli" id="txtIDcli" value="${codigo}" readonly="" class="form-control">

                            <label class="form-label">Documento:</label>
                            <select class="form-select" name="txtDocCli" id="txtDocCli">
                                <option value="">:::Seleccionar:::</option>
                                <option value="DNI">DNI</option>
                                <option value="RUC">RUC</option>
                            </select>

                            <label class="form-label">Número:</label>
                            <input type="text" name="txtNumCli" id="txtNumCli"  class="form-control">

                            <label class="form-label">Nombre / Razón:</label>
                            <input type="text" name="txtNomCli" id="txtNomCli"  class="form-control">

                            <label class="form-label">Correo:</label>
                            <input type="text" name="txtCorreoCli" id="txtCorreoCli"  class="form-control">

                            <label class="form-label">Contraseña:</label>
                            <input type="text" name="txtPassCli" id="txtPassCli"  class="form-control">

                            <label class="form-label">Estado:</label>
                            <select class="form-select" name="txtEstadoCli" id="txtEstadoCli">
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
                        <h1 class="modal-title fs-5" id="exampleModalLabel">::: Editar Cliente :::</h1>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <form action="ControlCliente" method="POST" class="form" onsubmit="return ValidarClienteActualizar()">
                        <div class="modal-body">

                            <label class="form-label">Código:</label>
                            <input type="number" name="lblIDcli" id="lblIDcli" readonly="" class="form-control">

                            <label class="form-label">Documento:</label>
                            <select class="form-select" name="lblDocCli" id="lblDocCli">
                                <option value="">:::Seleccionar:::</option>
                                <option value="DNI">DNI</option>
                                <option value="RUC">RUC</option>
                            </select>

                            <label class="form-label">Número:</label>
                            <input type="text" name="lblNumCli" id="lblNumCli"  class="form-control">

                            <label class="form-label">Nombre / Razón:</label>
                            <input type="text" name="lblNomCli" id="lblNomCli"  class="form-control">

                            <label class="form-label">Correo:</label>
                            <input type="text" name="lblCorreoCli" id="lblCorreoCli"  class="form-control">

                            <label class="form-label">Contraseña:</label>
                            <input type="text" name="lblPassCli" id="lblPassCli"  class="form-control">

                            <label class="form-label">Estado:</label>
                            <select class="form-select" name="lblEstadoCli" id="lblEstadoCli">
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
