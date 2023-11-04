function validarDatos() {
    const nombre = document.forms["form1"]["nombre"].value;
    const celular = document.forms["form1"]["celular"].value;
    const carro = document.forms["form1"]["carro"].value;

    let mensaje = document.getElementById("mensaje");

    if (!nombre || nombre.length === 0) {
        mensaje.innerHTML = "Ingrese el nombre del usuario";
        return false
    }

    if (!celular || celular.length === 0) {
        mensaje.innerHTML = "Ingrese el numero de celular de usuario";
        return false;
    }

    return true;
}