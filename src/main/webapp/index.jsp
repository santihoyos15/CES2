<%@ page import="ces3.entidades.Persona" %>
<%@ page import="java.util.List" %>
<%@ page import="ces3.entidades.Empleado" %>
<%@ page import="ces3.entidades.Contratista" %>
<%@ page import="ces3.entidades.Pago" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hello World!</title>
    </head>
<body>
    <%
        List<Pago> trabajadores = (List<Pago>) request.getAttribute("trabajadores");

        if (trabajadores != null) {
            for (Pago p: trabajadores) {
    %>
        <span><%= p.aumentarSalario(30) %></span><br/>
    <%
            }
        }
    %>
    <br>
    <br>
    <h2>Ingrese aqu&iacute;</h2>
    <form action="ControladorServlet" method="POST">
        <label for="username">Nombre de usuario</label>
        <br>
        <input id="username" name="username" type="text" placeholder="Nombre de usuario">
        <br>
        <br>
        <label for="tipoEmpleado">Tipo de empleado</label>
        <select id="tipoEmpleado" name="tipoEmpleado">
            <option value="1">Empleado</option>
            <option value="2">Contratista</option>
        </select>
        <br>
        <br>
        <input type="submit" value="Enviar">
    </form>
</body>
</html>
