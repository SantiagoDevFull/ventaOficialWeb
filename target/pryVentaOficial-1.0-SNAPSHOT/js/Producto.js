function ValidarProductoAgregar() {

    var nombre = document.getElementById("txtNomPro").value;
    var stock = document.getElementById("txtStockPro").value;
    var precio = document.getElementById("txtPrecioPro").value;
    var estado = document.getElementById("txtEstadoPro").value;
    var categoria = document.getElementById("txtCategoria").value;
    var proveedor = document.getElementById("txtProveedor").value;

    if (nombre.trim().length <= 0) {
        fnToast("error", "Nombre vacío");
        return false;
    }

    if (stock.length <= 0) {
        fnToast("error", "Stock vacío");
        return false;
    }

    if (stock < 0) {
        fnToast("error", "Stock negativo");
        return false;
    }

    if (precio.length <= 0) {
        fnToast("error", "Precio vacío");
        return false;
    }

    if (precio < 0) {
        fnToast("error", "Precio negativo");
        return false;
    }

    if (estado === "") {
        fnToast("warning", ":::Seleccionar estado:::");
        return false;
    }

    if (categoria === "") {
        fnToast("warning", ":::Seleccionar categoria:::");
        return false;
    }

    if (proveedor === "") {
        fnToast("warning", ":::Seleccionar proveedor:::");
        return false;
    }

    return true;

}

function ValidarProductoActualizar() {

    var nombre = document.getElementById("lblNomPro").value;
    var stock = document.getElementById("lblStockPro").value;
    var precio = document.getElementById("lblPrecioPro").value;
    var estado = document.getElementById("lblEstadoPro").value;
    var categoria = document.getElementById("lblCategoria").value;
    var proveedor = document.getElementById("lblProveedor").value;

    if (nombre.trim().length <= 0) {
        fnToast("error", "Nombre vacío");
        return false;
    }

    if (stock.length <= 0) {
        fnToast("error", "Stock vacío");
        return false;
    }

    if (stock < 0) {
        fnToast("error", "Stock negativo");
        return false;
    }

    if (precio.length <= 0) {
        fnToast("error", "Precio vacío");
        return false;
    }

    if (precio < 0) {
        fnToast("error", "Precio negativo");
        return false;
    }

    if (estado === "") {
        fnToast("warning", ":::Seleccionar estado:::");
        return false;
    }

    if (categoria === "") {
        fnToast("warning", ":::Seleccionar categoria:::");
        return false;
    }

    if (proveedor === "") {
        fnToast("warning", ":::Seleccionar proveedor:::");
        return false;
    }

    return true;

}

function PasarDatosUpdate(id, nombre, stock, precio, estado, idcat, idprove) {

    document.getElementById("lblIDpro").value = id;
    document.getElementById("lblNomPro").value = nombre;
    document.getElementById("lblStockPro").value = stock;
    document.getElementById("lblPrecioPro").value = precio;
    document.getElementById("lblEstadoPro").value = estado;
    document.getElementById("lblCategoria").value = idcat;
    document.getElementById("lblProveedor").value = idprove;

}

function ConfirmarEliminacion(id, nombre) {

    $('#lbTexto').html(nombre);
    $('#id').val(id);
    $('#modalEliminar').modal('show');

}


