<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    <link href="./css/estilos1.css" rel="stylesheet" type="text/css" />
</head>
<body>
    <div align="center" id="content">
        <h2>Pila</h2>
        <form action="Servlet1" method="POST">
            <input type="number" name="value" placeholder="Ingrese un numero para ingresar a la pila">
            <input type="submit" name="action" value="push">
            <input type="submit" name="action" value="pop">
        </form>
        <c:if test="${not empty message}">
            <p><c:out value="${message}" /></p>
        </c:if>
        <div>
            <c:out escapeXml="false" value="${stack.imprimir()}" />
        </div>

        <br />
        <br />
        <br />
        <br />
        <br />

        <h2>Cola</h2>

        <form action="Servlet2" method="POST">
            <input type="number" name="value" placeholder="Ingrese un numero para ingresar a la cola">
            <input type="submit" name="action" value="enqueue">
            <input type="submit" name="action" value="dequeue">
        </form>
        <c:if test="${not empty message2}">
            <p><c:out value="${message2}" /></p>
        </c:if>
        <div>
            <c:out escapeXml="false" value="${queue.imprimir()}" />
        </div>
    </div>
</body>
</html>
