<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Title</title>
</head>
<body>
    <div align="center">
        <c:choose>
            <c:when test="${fn:length(trabajadores) == 0}">
                <h2>No existen empleados</h2>
            </c:when>
            <c:when test="${fn:length(trabajadores) > 0}">
                <table border="1" cellpadding="5">
                    <caption><h2>Lista de empleados</h2></caption>
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Nombre</th>
                            <th>Dias libres</th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="persona" items="${trabajadores}">
                        <tr>
                            <td><c:out value="${persona.getId()}" /></td>
                            <td><c:out value="${persona.getNombre()}" /></td>
                            <td><c:out value="${persona.getDiasLibres()}" /></td>
                            <td>
                                <form action="Servlet2" method="POST">
                                <input type="hidden" name="formulario" value="empleados">
                                <input type="hidden" name="id" value="${persona.getId()}">
                                <input type="hidden" name="nombre" value="${persona.getNombre()}">
                                <button type="submit">Dar dia libre</button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </c:when>
        </c:choose>
    </div>

    <br/><br/>

    <form action="Servlet1" method="POST">
        <input type="hidden" name="formulario" value="empleados">
        Ir a <button type="submit">Volver</button>
    </form>
</body>
</html>
