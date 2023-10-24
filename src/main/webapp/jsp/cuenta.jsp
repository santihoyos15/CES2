<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
<body>
<div align="center">
    <h1>Cuenta seleccionada</h1>
    <br />

    <table border="1" cellpadding="3">
        <tbody>
            <tr colspan="3">
                <td>Cuenta</td>
                <td><c:out value="${cuenta}" /></td>
            </tr>
            <tr>
                <td>Extranjero</td>
                <td><c:out value="${nacionalidad}" /></td>
                <td>
                    <form action="Servlet2" method="POST">
                        <input type="hidden" name="cuenta" value="${cuenta}">
                        <input type="hidden" name="nacionalidad" value="${not nacionalidad}">
                        <input type="hidden" name="balance" value="${balance}">
                        <input type="hidden" name="formulario" value="nacionalidad">
                        <input type="submit" value="Cambiar">
                    </form>
                </td>
            </tr>
            <tr colspan="3">
                <td>Balance</td>
                <td><c:out value="${balance}" /></td>
            </tr>
            <tr>
                <td>Hacer deposito</td>
                <td>
                    <form action="Servlet2" method="POST">
                        <input type="hidden" name="cuenta" value="${cuenta}" />
                        <input type="hidden" name="nacionalidad" value="${nacionalidad}" />
                        <input type="text" name="balance" style="width: 120px;" />
                        <input type="hidden" name="formulario" value="depositar" />
                        <input type="submit" value="Enviar" />
                    </form>
                </td>
                <td>
                    <c:if test="${not empty mensaje1}">
                        <p style="color: red;">
                            <c:out value="${mensaje1}" />
                        </p>
                    </c:if>
                </td>
            </tr>
            <tr>
                <td>Autorizar prestamo</td>
                <td>
                    <form action="Servlet2" method="POST">
                        <input type="hidden" name="cuenta" value="${cuenta}" />
                        <input type="hidden" name="nacionalidad" value="${nacionalidad}" />
                        <input type="text" name="balance" style="width: 120px;" />
                        <input type="hidden" name="formulario" value="prestamo" />
                        <input type="submit" value="Enviar" />
                    </form>
                </td>
                <td>
                    <c:if test="${not empty mensaje2}">
                        <p style="color: red;">
                            <c:out value="${mensaje2}" />
                        </p>
                    </c:if>
                </td>
            </tr>
            <tr>
                <td>Sumar interes</td>
                <td></td>
                <td></td>
            </tr>
        </tbody>
    </table>
    <br />
    <br />

    <form action="Servlet1" method="POST">
        <input name="formulario" hidden value="accion2" />
        Volver a: <input type="submit" value="Cuentas"/>
    </form>
</div>
</body>
</html>
