<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Hello World!</title>
    <link rel="stylesheet" type="text/css" href="./css/styles.css">
</head>
<body>
    <c:if test="${(not empty trabajadores)}">
        <fmt:parseNumber var="aumento" value="${porcentajeAumento}" integerOnly="true" />

        <c:forEach var="persona" items="${trabajadores}">
            <span style="white-space: pre;"><c:out escapeXml="false" value="${persona.ascender(porcentajeAumento)}" /></span><br/>
            <br/>
        </c:forEach>
    </c:if>

    <br/><br/>

    <h2>Ingrese aqu&iacute;</h2>
    <div class="error-message">
        <c:if test="${not empty mensaje}">
            <c:out value="${mensaje}" />
            <br /><br />
        </c:if>
    </div>

    <form action="Servlet1" method="POST">
        <fieldset>
            <legend>Nuevo empleado:</legend>
            <label for="nombre">Nombre de Usuario</label>
            <br>
            <input id="nombre" name="nombre" type="text" placeholder="Nombre de usuario">

            <br>
            <br>

            <label for="tipoEmpleado">Tipo de empleado</label>
            <select id="tipoEmpleado" name="tipoEmpleado">
                <option value="1">Empleado</option>
                <option value="2">Contratista</option>
            </select>

            <br/><br/>

            <label for="porcentajeAumento">Porcentaje Aumento</label>
            <input
                id="porcentajeAumento"
                name="porcentajeAumento"
                type="number"
                value="1"
                min="1"
                style="width: 3em"
            />

            <br/><br/>

            <input type="hidden" name="formulario" value="index">
            <button type="submit">Ingresar</button>
        </fieldset>
    </form>

    <br /><br />

    <form action="Servlet2" method="POST">
        <input type="hidden" name="formulario" value="index">
        Ir a <button type="submit">Empleados</button>
    </form>
</body>
</html>
