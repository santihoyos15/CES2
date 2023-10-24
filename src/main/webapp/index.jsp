<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
<body>
<div align="center">
    <h1>El gran banco</h1>
    <br />
    <!-- Formulario para crear una nueva cuenta -->
    <form action="Servlet1" method="POST">
        <table border="1" cellpadding="5">
            <thead>
                <tr>
                    <th>Tipo de Cuenta</th>
                    <th>Nacionalidad</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>
                        <select name="tipo" size="2">
                            <option value="ahorros" selected>Ahorros</option>
                            <option value="corriente">Corriente</option>
                        </select>
                    </td>
                    <td>
                        <select name="nacionalidad" size="2">
                            <option value="local" selected>Local</option>
                            <option value="extranjero">Extraniero</option>
                        </select>
                    </td>
                </tr>
                <tr colspan="2">
                    <td>
                        <input type="hidden" value="accion1" name="formulario" />
                        <input type="submit" value="Crear Cuenta" />
                    </td>
                </tr>
            </tbody>
        </table>
    </form>

    <br /> <br />
    <!-- Formulario para ir a la ventana cuentas.jsp -->
    <form action="Servlet1" method="POST">
        <input type="hidden" value="accion2" name="formulario" /> Ir a:<input type="submit" value="Cuentas" />
    </form>
</div>
</body>
</html>
