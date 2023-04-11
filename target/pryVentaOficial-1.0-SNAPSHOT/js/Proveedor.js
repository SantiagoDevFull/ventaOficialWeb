function ValidarProveedorAgregar() {

    var nombre = document.getElementById("txtNomProve").value;
    var telefono = document.getElementById("txtTelProve").value;
    var direccion = document.getElementById("txtDireProve").value;
    var estado = document.getElementById("txtEstadoProve").value;

    if (nombre.trim().length <= 0) {
        fnToast("error", "Nombre vacío");
        return false;
    }

    if (telefono.trim().length <= 0) {
        fnToast("error", "Teléfono vacío");
        return false;
    }

    if (direccion.trim().length <= 0) {
        fnToast("error", "Dirección vacío");
        return false;
    }

    if (estado === "") {
        fnToast("warning", ":::Seleccionar estado:::");
        return false;
    }

    return true;

}

function ValidarProveedorActualizar() {

    var nombre = document.getElementById("lblNomProve").value;
    var telefono = document.getElementById("lblTelProve").value;
    var direccion = document.getElementById("lblDireProve").value;
    var estado = document.getElementById("lblEstadoProve").value;

    if (nombre.trim().length <= 0) {
        fnToast("error", "Nombre vacío");
        return false;
    }

    if (telefono.trim().length <= 0) {
        fnToast("error", "Teléfono vacío");
        return false;
    }

    if (direccion.trim().length <= 0) {
        fnToast("error", "Dirección vacío");
        return false;
    }

    if (estado === "") {
        fnToast("warning", ":::Seleccionar estado:::");
        return false;
    }

    return true;

}

function PasarDatosUpdate(id, nombre, tel, dire, estado) {

    document.getElementById("lblIDprove").value = id;
    document.getElementById("lblNomProve").value = nombre;
    document.getElementById("lblTelProve").value = tel;
    document.getElementById("lblDireProve").value = dire;
    document.getElementById("lblEstadoProve").value = estado;

}

function ConfirmarEliminacion(id, nombre) {

    $('#lbTexto').html(nombre);
    $('#id').val(id);
    $('#modalEliminar').modal('show')

}

function ValidarRegistrados(num) {

    if (num > 0) {
        fnToast("error", "El proveedor seleccionado tiene productos a su cargo");
        return false;
    }

    return true;

}
