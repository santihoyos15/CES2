<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    <script type="text/javascript" src="js/script1.js"></script>
</head>
<body>
    <h2>Index</h2>
<%--
    <form name="form1" action="Servlet1" method="POST">
        <input type="hidden" name="formulario" value="index">
        <input type="submit" name="submit1" value="OK">
    </form>
--%>
    <%-- /////////////// --%>
<%--
    <form name="form1" action="Servlet1" method="POST">
        <input type="radio" name="edades" value="30" checked="checked" id="edad1">
        <label for="edad1">0-30</label>

        <input type="radio" name="edades" value="60" checked="checked" id="edad2">
        <label for="edad2">31-60</label>

        <input type="radio" name="edades" value="100" checked="checked" id="edad3">
        <label for="edad3">61-100</label>

        <input type="hidden" name="formulario" value="index">
        <input type="submit" name="submit2" value="Enviar">
    </form>
--%>

    <span style="color: green;"><c:out value="${mensaje}"/></span>
    <span style="color: red;" id="mensaje"></span>
    <br/>

    <form name="form1" action="Servlet1" method="POST" onsubmit="return validarDatos()">
        <label style="display: inline-block; width: 150px;" for="codigo">Código:</label>
        <input type="text" name="codigo" id="codigo"/>
        <br/>
        <br/>

        <label style="display: inline-block; width: 150px;" for="valor">Valor vendido:</label>
        <input type="text" name="valor" id="valor"/>

        <input type="hidden" name="formulario" value="index">
        <br/>
        <br/>
        <input type="submit" value="Enviar">
    </form>
</body>
</html>
