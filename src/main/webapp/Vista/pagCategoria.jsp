<%-- 
    Document   : pagCategoria
    Created on : 3 abr. 2023, 23:16:47
    Author     : usuario
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Categoría de Productos</title>
        <jsp:include page="../includes/RecursosCSS.jsp"></jsp:include>
        </head>

        <body>
            <script src="js/Categoria.js" type="text/javascript"></script>
        <jsp:include page="../includes/RecursosJS.jsp"></jsp:include>
        <jsp:include page="../includes/Navegacion.jsp"></jsp:include>

            <div class="container-fluid mt-3">

                <h5>Gestión de Roles de Usuarios</h5>
                <hr>

                <button type="button" class="btn btn-success" data-bs-toggle="modal" data-bs-target="#modalAgregar">
                    Nuevo
                </button><br><br>

                <div>
                    <table id="tabla" class="table table-striped table-bordered text-center" style="width:100%">
                        <thead>
                            <tr>
                                <th class="text-center">Código</th>
                                <th class="text-center">Categoría</th>
                                <th class="text-center">Estado</th>
                                <th class="text-center">#Productos Reg.</th>
                                <th class="text-center">Acción</th>
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="i" items="${ListarCategoria}">
                        <tr>
                            <td>${i.getIdCat()}</td>
                            <td>${i.getNomCat()}</td>
                            <td>${i.getEstadoCat()}</td>
                            <td>${i.getNumProdReg()}</td>
                            <td>
                                <button onclick="PasarDatosUpdate(${i.getIdCat()}, '${i.getNomCat()}', '${i.getEstadoCat()}')" type="button" class="btn btn-info" data-bs-toggle="modal" data-bs-target="#modalActualizar">
                                    <i class="fa fa-edit" ></i>
                                </button>
                                <a  href="javascript:ConfirmarEliminacion(${i.getIdCat()} ,'${i.getNomCat()}' )" onclick="return ValidarRegistrados(${i.getNumProdReg()})" class="btn btn-danger"><i class="fa-solid fa-trash"></i></a>
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
                        <h1 class="modal-title fs-5">::: Eliminar Categoría :::</h1>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <form action="ControlCategoria" method="POST">
                        <div class="modal-body">
                            <p>¿Está seguro que desea eliminar la categoría <span id="lbTexto"></span>?</p>
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
                        <h1 class="modal-title fs-5" id="exampleModalLabel">::: Nueva Categoría :::</h1>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <form action="ControlCategoria" method="POST" class="form" onsubmit="return ValidarCategoriaAgregar()">
                        <div class="modal-body">



                            <label class="form-label">Código:</label>
                            <input type="number" name="txtIDcat" id="txtIDcat" value="${codigo}" readonly="" class="form-control">

                            <label class="form-label">Categoría:</label>
                            <input type="text" name="txtNomCat" id="txtNomCat" value="" class="form-control">

                            <label class="form-label">Estado:</label>
                            <select class="form-select" name="txtEstadoCat" id="txtEstadoCat">
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
                        <h1 class="modal-title fs-5" id="exampleModalLabel">::: Editar Categoría :::</h1>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <form action="ControlCategoria" method="POST" class="form" onsubmit="return ValidarCategoriaActualizar()">
                        <div class="modal-body">

                            <label class="form-label">Código:</label>
                            <input type="number" name="lblIDcat" id="lblIDcat" readonly="" class="form-control">

                            <label class="form-label">Rol:</label>
                            <input type="text" name="lblNomCat" id="lblNomCat" value="" class="form-control">

                            <label class="form-label">Estado:</label>
                            <select class="form-select" name="lblEstadoCat" id="lblEstadoCat">
                                <option value="">:::Seleccionar:::</option>
                                <option value="ON">ON</option>
                                <option value="OFF">OFF</option>
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
