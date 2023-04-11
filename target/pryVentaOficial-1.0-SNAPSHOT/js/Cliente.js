function PasarDatosUpdate(id, doc, num, nom, correo, pass, estado) {

    document.getElementById("lblIDcli").value = id;
    document.getElementById("lblDocCli").value = doc;
    document.getElementById("lblNumCli").value = num;
    document.getElementById("lblNomCli").value = nom;
    document.getElementById("lblCorreoCli").value = correo;
    document.getElementById("lblPassCli").value = pass;
    document.getElementById("lblEstadoCli").value = estado;

}

function ValidarEliminacion(num) {
    if (num > 0) {
        fnToast("error", "El cliente a eliminar tiene boletas registradas");
        return false;
    }

    return true;
}

function ConfirmarEliminacion(id, nombre) {

    $('#lbTexto').html(nombre);
    $('#id').val(id);
    $('#modalEliminar').modal('show');

}

function ValidarClienteAgregar() {

    var documento = document.getElementById("txtDocCli").value;
    var numero = document.getElementById("txtNumCli").value;
    var nombre = document.getElementById("txtNomCli").value;
    var correo = document.getElementById("txtCorreoCli").value;
    var pass = document.getElementById("txtPassCli").value;
    var estado = document.getElementById("txtEstadoCli").value;

    if (documento === "") {
        fnToast("warning", ":::Seleccionar documento:::");
        return false;
    }

    if (documento == "DNI") {
        if (numero.trim().length < 8 || numero.trim().length > 8) {
            fnToast("error", "El número de DNI debe contener  8 dígitos");
            return false;
        }
    }

    if (documento == "RUC") {
        if (numero.trim().length < 11 || numero.trim().length > 11) {
            fnToast("error", "El número de RUC debe contener  11 dígitos");
            return false;
        }
    }

    if (nombre.trim().length <= 0) {
        fnToast("error", "(Nombre / Razón) -> vacío");
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

    if (estado === "") {
        fnToast("warning", ":::Seleccionar estado:::");
        return false;
    }

    return true;

}

function ValidarClienteActualizar() {

    var documento = document.getElementById("lblDocCli").value;
    var numero = document.getElementById("lblNumCli").value;
    var nombre = document.getElementById("lblNomCli").value;
    var correo = document.getElementById("lblCorreoCli").value;
    var pass = document.getElementById("lblPassCli").value;
    var estado = document.getElementById("lblEstadoCli").value;

    if (documento === "") {
        fnToast("warning", ":::Seleccionar documento:::");
        return false;
    }

    if (documento == "DNI") {
        if (numero.trim().length < 8 || numero.trim().length > 8) {
            fnToast("error", "El número de DNI debe contener  8 dígitos");
            return false;
        }
    }

    if (documento == "RUC") {
        if (numero.trim().length < 11 || numero.trim().length > 11) {
            fnToast("error", "El número de RUC debe contener  11 dígitos");
            return false;
        }
    }

    if (nombre.trim().length <= 0) {
        fnToast("error", "(Nombre / Razón) -> vacío");
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

    if (estado === "") {
        fnToast("warning", ":::Seleccionar estado:::");
        return false;
    }

    return true;

}


