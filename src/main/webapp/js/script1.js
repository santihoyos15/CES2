function validarDatos () {
    let codigo = document.forms["form1"]["codigo"].value;
    let valor = document.forms["form1"]["valor"].value;

    let mensajeEl = document.getElementById("mensaje");

    if (!codigo || codigo.length === 0) {
        mensajeEl.innerHTML = "Ingrese el codigo del vendedor";
        return false;
    } else if (!valor || valor.length === 0){
        mensajeEl.innerHTML = "Ingrese el valor de lo vendido";
        return false;
    }

    return true;
}