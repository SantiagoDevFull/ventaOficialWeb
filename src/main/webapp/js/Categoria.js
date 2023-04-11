function ValidarCategoriaAgregar(){
    
    var nombre=document.getElementById("txtNomCat").value;
    var estado=document.getElementById("txtEstadoCat").value;
    
    if(nombre.trim().length<=0){
        fnToast("error","Nombre vacío");
        return false;
    }
    
    if(estado===""){
        fnToast("warning",":::Seleccionar estado:::");
        return false;
    }
    
    return true;
    
}

function ValidarCategoriaActualizar(){
    
    var nombre=document.getElementById("lblNomCat").value;
    var estado=document.getElementById("lblEstadoCat").value;
    
    if(nombre.trim().length<=0){
        fnToast("error","Nombre vacío");
        return false;
    }
    
    if(estado===""){
        fnToast("warning",":::Seleccionar estado:::");
        return false;
    }
    
    return true;
    
}

function PasarDatosUpdate(codigo,nombre,estado){
    
    document.getElementById("lblIDcat").value=codigo;
   document.getElementById("lblNomCat").value=nombre;
    document.getElementById("lblEstadoCat").value=estado;
    
}

function ConfirmarEliminacion(id,nombre){
    
    $('#lbTexto').html(nombre);
    $('#id').val(id);
    $('#modalEliminar').modal("show");
    
}


function ValidarRegistrados(num){
    
    if(num>0){
        fnToast("error","La categoría a eliminar tiene productos registrados");
        return false;
    }
    
    return true;
    
}


