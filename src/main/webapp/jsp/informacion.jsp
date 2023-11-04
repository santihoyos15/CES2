<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Title</title>
</head>
<body>
    <div align="center">
        <h1>Información Pedidos</h1>
        <table border="1" cellpadding="2">
            <thead>
                <tr>
                    <th>Información</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="pedido" items="${pedidos}">
                    <tr>
                        <td>
                            <c:out value="${pedido.mostrarInformacion()}"/>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <br />
        <br />
        <form action="Servlet1" method="POST">
            <input type="hidden" name="formulario" value="nextpage" />
            Volver a: <input type="submit" value="Pedir Carro">
        </form>
    </div>
</body>
</html>
