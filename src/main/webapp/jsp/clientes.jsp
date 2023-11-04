<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" >
    <title>Clientes</title>
</head>
<body>
    <div align="center">
        <h1>Clientes</h1>
        <table border="1" cellpadding="2">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Nombre</th>
                    <th>Celular</th>
                    <th>Comprar carro?</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="item" items="${pedidosClientes}">
<%--
                    <c:if test="${item.getClass().name eq 'ces2.entidades.Cliente'}">
--%>
                        <tr>
                            <td><c:out value="${item.getId()}"/></td>
                            <td><c:out value="${item.getNombre()}"/></td>
                            <td><c:out value="${item.getCelular()}"/></td>
                            <td><c:out value="${item.getComprar()}"/></td>
                        </tr>
<%--
                    </c:if>
--%>
                </c:forEach>
            </tbody>
        </table>
        <br /><br />
        <form action="Servlet1" method="POST">
            <input type="hidden" name="formulario" value="nextpage" />
            Volver a: <input type="submit" value="Pedir Carro"/>
        </form>
        <br /><br />
        <form action="Servlet1" method="POST">
            <input type="hidden" name="formulario" value="carros" />
            Ir a: <input type="submit" value="Carros">
        </form>
    </div>
</body>
</html>
