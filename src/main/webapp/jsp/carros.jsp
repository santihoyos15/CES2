<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" >
    <title>Title</title>
</head>
<body>
    <div align="center">
        <h1>Carros</h1>
        <table border="1" cellpadding="2">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Precio</th>
                    <th>Marca</th>
                    <th>Cliente</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach var="item" items="${pedidosVehiculos}">
<%--
                <c:if test="${item.getClass().name eq 'ces2.entidades.Carro'}">
--%>
                    <tr>
                        <td><c:out value="${item.getId()}"/></td>
                        <td><c:out value="${item.getPrecio()}"/></td>
                        <td><c:out value="${item.getMarca()}"/></td>
                        <td><c:out value="${item.getIdCliente()}"/></td>
                    </tr>
<%--
                </c:if>
--%>
            </c:forEach>
            </tbody>
        </table>
        <br />
        <br />
        <form action="Servlet1" method="POST">
            <input type="hidden" name="formulario" value="nextpage" />
            Volver a: <input type="submit" value="Pedir Carro" />
        </form>
    </div>
</body>
</html>
