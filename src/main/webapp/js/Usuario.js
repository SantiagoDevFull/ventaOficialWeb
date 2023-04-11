function ValidarUsuario() {

    var correo = document.getElementById("txtCorreo").value;
    var pass = document.getElementById("txtPass").value;

    if (correo.trim().length <= 0) {
        fnToast("error", "Correo vacío");
        return false;
    }

    if (pass.length <= 0) {
        fnToast("error", "Contraseña vacío");
        return false;
    }

    return true;

}

function ValidarUsuarioAgregar() {

    var nombre = document.getElementById("txtNomUsu").value;
    var paterno = document.getElementById("txtPatUsu").value;
    var materno = document.getElementById("txtMatUsu").value;
    var correo = document.getElementById("txtCorreoUsu").value;
    var pass = document.getElementById("txtPassUsu").value;
    var fecha = document.getElementById("txtFechaUsu").value;
    var estado = document.getElementById("txtEstadoUsu").value;
    var rol = document.getElementById("txtRolUsu").value;

    if (nombre.trim().length <= 0) {
        fnToast("error", "Nombre vacío");
        return false;
    }
    
    if (paterno.trim().length <= 0) {
        fnToast("error", "A.Paterno vacío");
        return false;
    }
    
    if (materno.trim().length <= 0) {
        fnToast("error", "A.Materno vacío");
        return false;
    }
    
    if (correo.trim().length <= 0) {
        fnToast("error", "Correo vacío");
        return false;
    }
    
    if (pass.trim().length <= 0) {
        fnToast("error", "Contraseña vacío");
        return false;
    }
    
    if (fecha.trim().length <= 0) {
        fnToast("warning", "::: Seleccionar fecha de contrato :::");
        return false;
    }
    
    if (estado==="") {
        fnToast("warning", "::: Seleccionar estado :::");
        return false;
    }
    
    if (rol==="") {
        fnToast("warning", "::: Seleccionar rol :::");
        return false;
    }

    return true;

}

function ValidarUsuarioActualizar(){
    
    var nombre = document.getElementById("lblNomUsu").value;
    var paterno = document.getElementById("lblPatUsu").value;
    var materno = document.getElementById("lblMatUsu").value;
    var correo = document.getElementById("lblCorreoUsu").value;
    var pass = document.getElementById("lblPassUsu").value;
    var fecha = document.getElementById("lblFechaUsu").value;
    var estado = document.getElementById("lblEstadoUsu").value;
    var rol = document.getElementById("lblRolUsu").value;

    if (nombre.trim().length <= 0) {
        fnToast("error", "Nombre vacío");
        return false;
    }
    
    if (paterno.trim().length <= 0) {
        fnToast("error", "A.Paterno vacío");
        return false;
    }
    
    if (materno.trim().length <= 0) {
        fnToast("error", "A.Materno vacío");
        return false;
    }
    
    if (correo.trim().length <= 0) {
        fnToast("error", "Correo vacío");
        return false;
    }
    
    if (pass.trim().length <= 0) {
        fnToast("error", "Contraseña vacío");
        return false;
    }
    
    if (fecha.trim().length <= 0) {
        fnToast("warning", "::: Seleccionar fecha de contrato :::");
        return false;
    }
    
    if (estado==="") {
        fnToast("warning", "::: Seleccionar estado :::");
        return false;
    }
    
    if (rol==="") {
        fnToast("warning", "::: Seleccionar rol :::");
        return false;
    }

    return true;
    
}

function PasarDatosUpdate(id, nombre, paterno, materno, correo, pass, fecha, estado, idrol) {

document.getElementById("lblIDusu").value=id;
document.getElementById("lblNomUsu").value=nombre;
  document.getElementById("lblPatUsu").value=paterno;
 document.getElementById("lblMatUsu").value=materno;
  document.getElementById("lblCorreoUsu").value=correo;
  document.getElementById("lblPassUsu").value=pass;
  document.getElementById("lblFechaUsu").value=fecha;
 document.getElementById("lblEstadoUsu").value=estado;
 document.getElementById("lblRolUsu").value=idrol;

}

function ConfirmarEliminacion(id, nombre) {

    $('#lbTexto').html(nombre);
    $('#id').val(id);
    $('#modalEliminar').modal("show");

}

