<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="../css/styles.css">
</head>
<body>
    <div align="center">
        <div class="error-message">
            <c:if test="${not empty mensaje}">
                <c:out value="${mensaje}" />
                <br /><br />
            </c:if>
        </div>
        <table border="1" cellpadding="5">
            <caption><h2>Asignar dia libre</h2></caption>
            <tbody>
            <c:forEach var="persona" items="${trabajadores}">
                <tr>
                    <td>Id</td>
                    <td><c:out value="${id}" /></td>
                </tr>
                <tr>
                    <td>Nombre</td>
                    <td><c:out value="${nombre}" /></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <form action="Servlet2" method="POST">
                            <input type="hidden" name="formulario" value="diaslibres" />
                            <input type="hidden" name="id" value="${id}" />
                            <input type="hidden" name="nombre" value="${nombre}" />
                            <label for="dias">Numero de dias:</label>
                            <input
                                id="dias"
                                name="dias"
                                type="number"
                                value="1"
                                min="1"
                                style="width: 3em"
                            />
                            <button type="submit">Asignar</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

    <br/><br/>

    <form action="Servlet1" method="POST">
        <input type="hidden" name="formulario" value="empleados">
        Ir a <button type="submit">Volver</button>
    </form>
</body>
</html>
