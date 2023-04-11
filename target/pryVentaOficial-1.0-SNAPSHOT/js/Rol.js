function ValidarRolAgregar() {

    var rol = document.getElementById("txtNomRol").value;
    var estado = document.getElementById("txtEstadoRol").value;

    if (rol.trim().length <= 0) {
        fnToast("error", "Rol vacíos");
        return false;
    }

    if (estado === "") {
        fnToast("warning", ":::Seleccionar estado:::");
        return false;
    }

    return true;

}

function ValidarRolActualizar() {

    var rol = document.getElementById("lblNomRol").value;
    var estado = document.getElementById("lblEstadoRol").value;

    if (rol.trim().length <= 0) {
        fnToast("error", "Rol vacío");
        return false;
    }

    if (estado === "") {
        fnToast("warning", ":::Seleccionar estado:::");
        return false;
    }

    return true;

}

function ValidarRegistrados(num) {

    if (num > 0) {
        fnToast("error", "El rol seleccionado tiene usuarios registrados");
        return false;
    }

    return true;

}

function PasarDatosUpdate(id, nombre, estado) {

    document.getElementById("lblIDrol").value = id;
    document.getElementById("lblNomRol").value = nombre;
    document.getElementById("lblEstadoRol").value = estado;

}

function ConfirmarEliminacion(id, nombre) {
    $('#lbTexto').html(nombre);
    $('#id').val(id);
    $("#modalEliminar").modal("show");
}


