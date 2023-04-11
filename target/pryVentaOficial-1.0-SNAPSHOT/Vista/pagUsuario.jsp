<%-- 
    Document   : pagUsuario
    Created on : 31 mar. 2023, 23:27:09
    Author     : usuario
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Usuarios</title>

        <jsp:include page="../includes/RecursosCSS.jsp"></jsp:include>
        </head>
        <body>
            <script src="js/Usuario.js" type="text/javascript"></script>
        <jsp:include page="../includes/RecursosJS.jsp"></jsp:include>
        <jsp:include page="../includes/Navegacion.jsp"></jsp:include>

            <div class="container-fluid mt-3">

                <h5>Gestión de Usuarios</h5>
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
                                <th class="text-center">A.Paterno</th>
                                <th class="text-center">A.Materno</th>
                                <th class="text-center">Correo</th>
                                <th class="text-center">Contraseña</th>
                                <th class="text-center">Fecha Contrato</th>
                                <th class="text-center">Estado</th>
                                <th class="text-center">Rol</th>
                                <th class="text-center">Acción</th>
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="i" items="${ListarUsuario}">
                            <tr>
                                <td>${i.getIdUsu()}</td>
                                <td>${i.getNomUsu()}</td>
                                <td>${i.getPatUsu()}</td>
                                <td>${i.getMatUsu()}</td>
                                <td>${i.getCorreoUsu()}</td>
                                <td>${i.getPassUsu()}</td>
                                <td>${i.getFechcontUsu()}</td>
                                <td>${i.getEstadoUsu()}</td>
                                <td>${i.getRol().getNomRol()}</td>
                                <td>
                                    <button onclick="PasarDatosUpdate(${i.getIdUsu()}, '${i.getNomUsu()}', '${i.getPatUsu()}',
                                                    '${i.getMatUsu()}', '${i.getCorreoUsu()}', '${i.getPassUsu()}', '${i.getFechcontUsu()}',
                                                    '${i.getEstadoUsu()}', ${i.getRol().getIdRol()})" 
                                            type="button" class="btn btn-info" data-bs-toggle="modal" data-bs-target="#modalActualizar">
                                        <i class="fa fa-edit" ></i>
                                    </button>
                                    <a  href="javascript:ConfirmarEliminacion(${i.getIdUsu()} ,'${i.getNomUsu()} ${i.getPatUsu()} ${i.getMatUsu()}' )" class="btn btn-danger"><i class="fa-solid fa-trash"></i></a>
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
                        <h1 class="modal-title fs-5">::: Eliminar Usuario :::</h1>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <form action="ControlUsuario" method="POST">
                        <div class="modal-body">
                            <p>¿Está seguro que desea eliminar el Usuario <span id="lbTexto"></span>?</p>
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
                        <h1 class="modal-title fs-5" id="exampleModalLabel">::: Nuevo Usuario :::</h1>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <form action="ControlUsuario" method="POST" class="form" onsubmit="return ValidarUsuarioAgregar()">
                        <div class="modal-body">

                            <label class="form-label">Código:</label>
                            <input type="number" name="txtIDusu" id="txtIDusu" value="${codigo}" readonly="" class="form-control">

                            <label class="form-label">Nombre:</label>
                            <input type="text" name="txtNomUsu" id="txtNomUsu"  class="form-control">

                            <label class="form-label">A.Paterno:</label>
                            <input type="text" name="txtPatUsu" id="txtPatUsu"  class="form-control">

                            <label class="form-label">A.Materno:</label>
                            <input type="text" name="txtMatUsu" id="txtMatUsu"  class="form-control">

                            <label class="form-label">Correo:</label>
                            <input type="text" name="txtCorreoUsu" id="txtCorreoUsu"  class="form-control">

                            <label class="form-label">Contraseña:</label>
                            <input type="text" name="txtPassUsu" id="txtPassUsu"  class="form-control">

                            <label class="form-label">Fecha Contrato</label>
                            <input type="datetime-local" name="txtFechaUsu" id="txtFechaUsu"  class="form-control">

                            <label class="form-label">Estado:</label>
                            <select class="form-select" name="txtEstadoUsu" id="txtEstadoUsu">
                                <option value="">:::Seleccionar:::</option>
                                <option value="ON">ON</option>
                                <option value="OFF">OFF</option>
                            </select>

                            <label class="form-label">Rol:</label>
                            <select class="form-select" name="txtRolUsu" id="txtRolUsu">
                                <option value="">:::Seleccionar:::</option>
                                <c:forEach var="i" items="${ListarRol}">
                                    <option value="${i.getIdRol()}">${i.getNomRol()}</option>
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
                        <h1 class="modal-title fs-5" id="exampleModalLabel">::: Editar Usuario :::</h1>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <form action="ControlUsuario" method="POST" class="form" onsubmit="return ValidarUsuarioActualizar()">
                        <div class="modal-body">

                            <label class="form-label">Código:</label>
                            <input type="number" name="lblIDusu" id="lblIDusu" readonly="" class="form-control">

                            <label class="form-label">Nombre:</label>
                            <input type="text" name="lblNomUsu" id="lblNomUsu"  class="form-control">

                            <label class="form-label">A.Paterno:</label>
                            <input type="text" name="lblPatUsu" id="lblPatUsu"  class="form-control">

                            <label class="form-label">A.Materno:</label>
                            <input type="text" name="lblMatUsu" id="lblMatUsu"  class="form-control">

                            <label class="form-label">Correo:</label>
                            <input type="text" name="lblCorreoUsu" id="lblCorreoUsu"  class="form-control">

                            <label class="form-label">Contraseña:</label>
                            <input type="text" name="lblPassUsu" id="lblPassUsu"  class="form-control">

                            <label class="form-label">Fecha Contrato</label>
                            <input type="datetime-local" name="lblFechaUsu" id="lblFechaUsu"  class="form-control">

                            <label class="form-label">Estado:</label>
                            <select class="form-select" name="lblEstadoUsu" id="lblEstadoUsu">
                                <option value="">:::Seleccionar:::</option>
                                <option value="ON">ON</option>
                                <option value="OFF">OFF</option>
                            </select>

                            <label class="form-label">Rol:</label>
                            <select class="form-select" name="lblRolUsu" id="lblRolUsu">
                                <option value="">:::Seleccionar:::</option>
                                <c:forEach var="i" items="${ListarRol}">
                                    <option value="${i.getIdRol()}">${i.getNomRol()}</option>
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
