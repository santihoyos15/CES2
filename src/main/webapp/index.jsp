<%@ page import="java.util.List" %>
<%@ page import="ces3.entidades.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hello World!</title>
    </head>
<body>
    <%
        List<Object> vehiculos = (List<Object>) request.getAttribute("vehiculos");

        if (vehiculos != null) {
            for (Object vehiculo : vehiculos) {
                if (vehiculo instanceof VehiculoCarga) {
    %>
                    <span><%= ((VehiculoCarga) vehiculo).cargar(30) %></span><br/>
    <%
                }

                if (vehiculo instanceof Localizable) {
    %>
                    <span><%= ((Localizable) vehiculo).localizar() %></span><br/>
    <%
                }

                if (vehiculo instanceof Avion) {
    %>
                    <span><%= ((Avion) vehiculo).volar() %></span><br/>
    <%
                }

                if (vehiculo instanceof Barco) {
    %>
                    <span><%= ((Barco) vehiculo).navegar() %></span><br/>
    <%
                }

                if (vehiculo instanceof Camion) {
    %>
                    <span><%= ((Camion) vehiculo).iniciarRuta() %></span><br/><br/>
    <%
                }
            }
        }
    %>
    <br>
    <br>
    <h2>Ingrese aqu&iacute;</h2>
    <form action="ControladorServlet" method="POST">
        <label for="nombre">Nombre del vehiculo</label>
        <br>
        <input id="nombre" name="nombre" type="text" placeholder="Nombre del vehiculo">
        <br>
        <br>
        <label for="tipoVehiculo">Tipo de vehiculo</label>
        <select id="tipoVehiculo" name="tipoVehiculo">
            <option value="1">Avion</option>
            <option value="2">Barco</option>
            <option value="3">Camion</option>
        </select>
        <br>
        <br>
        <input type="submit" value="Enviar">
    </form>
</body>
</html>
