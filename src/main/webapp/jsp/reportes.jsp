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
    <h2>
        Tus cuentas favoritas
    </h2>
    <table border="1" cellspacing="1" cellpadding="3">
        <thead>
            <tr colpsan="2">
                Su reporte de cuentas favoritas
            </tr>
        </thead>
        <tbody>
            <tr colspan="2">
                <td>Máximo balance</td>
                <td><c:out value="${cuentaMayorBalance}"/></td>
            </tr>
            <tr colspan="2">
                <td>Minimo balance</td>
                <td><c:out value="${cuentaMenorBalance}"/></td>
            </tr>
        </tbody>
    </table>
    <c:if test="${not empty mensaje}">
        <p style="color: red;"><c:out value="${mensaje}" /></p>
    </c:if>

    <c:if test="${not empty allCuentas}">
        <h3>Todas las cuentas</h3>
        <p><c:out escapeXml="false" value="${allCuentas}" /></p>
    </c:if>

    <br/>
    <br/>

    <form action="Servlet3" method="POST">
        <p>Buscar cuenta</p>
        <input name="numeroCuenta" type="number" placeholder="Número de cuenta"/>
        <input name="formulario" hidden value="buscarCuenta"/>
        <input type="submit" value="Buscar Cuenta"/>
    </form>

    <c:if test="${not empty infoCuenta}">
        <p><c:out value="${infoCuenta}" /></p>
    </c:if>

    <br/>
    <br/>

    <form action="Servlet1" method="POST">
        <input name="formulario" hidden value="accion2" />
        Volver a: <input type="submit" value="Cuentas"/>
    </form>
</div>
</body>
</html>
