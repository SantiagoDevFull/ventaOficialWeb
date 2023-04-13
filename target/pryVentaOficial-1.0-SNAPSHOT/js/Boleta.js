function CargarCliente(id, nombre) {

    $('#txtIDcli').val(id);
    $('#txtCliente').val(nombre);
    $('#BuscarCliente').modal("hide");

}

function CargarProducto(id, nombre, stock, precio) {

    $('#txtIDpro').val(id);
    $('#txtNomPro').val(nombre);
    $('#txtStockPro').val(stock);
    $('#txtPrecioPro').val(precio);
    $('#BuscarProducto').modal('hide');

}

function ValidarCarrito() {

    var nombre = document.getElementById("txtNomPro").value;
    var cantidad = document.getElementById("txtCantidadPro").value;

    if (nombre.trim().length <= 0) {
        fnToast("warning", ":::Seleccionar Producto:::");
        return false;
    }

    if (cantidad === "") {
        fnToast("error", "Ingresar la cantidad que desea comprar");
        return false;
    }

    if (cantidad <= 0) {
        fnToast("error", "Debe ingresar un número positivo");
        return false;
    }

    return true;

}

function CargarCarrito() {

    if (!ValidarCarrito()) {
        return;
    }
    var id = document.getElementById("txtIDpro").value;
    var nombre = document.getElementById("txtNomPro").value;
    var cantidad = document.getElementById("txtCantidadPro").value;
    var precio = document.getElementById("txtPrecioPro").value;

    $('#carrito').load("ControlBoleta?accion=Agregar&txtIDpro=" + id + "&txtNomPro=" + nombre + "&txtCantidadPro=" + cantidad + "&txtPrecioPro=" + precio);
    
    fnToast("success","Producto agregado exitosamente");

    document.getElementById("txtCantidadPro").value = "";

}

function LimpiarProducto(){
    
    $('#txtIDpro').val("");
    $('#txtNomPro').val("");
    $('#txtStockPro').val("");
    $('#txtPrecioPro').val("");
    $('#txtCantidadPro').val("");
    
}

function ValidarProceso(){
    
    var cliente=document.getElementById("txtCliente").value;
    
    if(cliente.trim().length<=0){
        fnToast("warning",":::Seleccionar cliente:::");
        return false;
    }
    
    return true;
    
}

function VerDetalle(id){
    
    $('#detalle').load("ControlBoleta?accion=VerDetalle&id="+id);
    $('#modalDetalle').modal("show");
    
}
