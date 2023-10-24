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
    <h1>
        Cuentas favoritas de tu banco
    </h1>
    <c:choose>
        <c:when test="${fn:length(cuentas) > 0}">
            <table border="1" cellpadding="5">
                <thead>
                    <tr>
                        <th>Información de la Cuenta</th>
                        <th>Consultar</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="cuenta" items="${cuentas}">
                        <tr>
                            <td><c:out value="${cuenta.toString()}"/></td>
                            <br />
                            <td>
                                <form action="Servlet2" method="POST">
                                    <input type="hidden" name="cuenta" value="${cuentas.get(cuenta.key).getNumeroCuenta()}" />
                                    <input type="hidden" name="nacionalidad" value="${cuentas.get(cuenta.key).esExtranjero()}" />
                                    <input type="hidden" name="balance" value="${cuentas.get(cuenta.key).getBalance()}" />
                                    <input type="hidden" name="formulario" value="cuentas" />
                                    <input type="submit" value="Ver" />
                                </form>
                            <td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:when>
        <c:when test="${fn:length(cuentas) == 0}">
            <h2>No existen cuentas</h2>
        </c:when>
    </c:choose>
    <br />
    <br />
    <!-- Formulario para volver a la ventana index.jsp -->
    <form action="index.jsp">
        Volver a: <input type="submit" value="Crear Cuenta" />
    </form>
</div>
</body>
</html>
