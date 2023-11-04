<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    <link href="./css/estilos1.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="./js/script1.js"></script>
</head>
<body>
    <div id="contenido">
        <h1>Pide tu carro ya</h1>
        <form name="form1" action="Servlet1" method="POST" onsubmit="return validarDatos()">
            <div class="formulario">
                <fieldset>
                    <legend>Ingresar Cliente</legend>
                    <label for="nombre">Nombre</label>
                    <input type="text" id="nombre" name="nombre" value="" />
                    <br /><br />
                    <label for="celular">Celular</label>
                    <input type="text" id="celular" name="celular" value="" />
                </fieldset>
                <br />
                <span id="mensaje"></span>
            </div>
            <div class="formulario" id="form2">
                <fieldset>
                    <legend>Ingresar Orden Vehiculo</legend>
                    <label for="vehiculo">Carros</label>
                    <select name="vehiculo" id="vehiculo" size="5">
                        <option value="Volvo" selected>Volvo</option>
                        <option value="Mercedez">Mercedez</option>
                        <option value="Audi">Audi</option>
                        <option value="Jeta">Jeta</option>
                        <option value="Toyota">Toyota</option>
                    </select>
                    <input type="hidden" name="formulario" value="ingresar" />
                    <input id="ingresar" type="submit" value="Ingresar" name="ingresar" />
                    <input id="limpiar" type="reset" value="Limpiar">
                </fieldset>
            </div>
        </form>
        <br />
        <br />

        <form style="clear: left;" action="Servlet1" method="POST">
            <input type="hidden" name="formulario" value="accion2" />
            Ir a: <input type="submit" value="Clientes" />
        </form>

        <br />
        <br />

        <form style="clear: left;" action="Servlet2" method="POST">
            <input type="hidden" name="formulario" value="accion3" />
            Ir a: <input type="submit" value="Información" />
        </form>

        <br />
        <br />

        <form style="clear: left;" action="Servlet3" method="POST">
            Ir a: <input type="submit" value="Información Clientes" />
        </form>
    </div>
</body>
</html>
