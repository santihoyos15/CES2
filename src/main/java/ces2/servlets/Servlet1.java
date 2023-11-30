package ces2.servlets;

import ces2.entidades.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "Servlet1", value = "/Servlet1")
public class Servlet1 extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            String formulario = request.getParameter("formulario");

            if (formulario.equals("index")) {
                List<String> ganadores = new ArrayList<>();
                ganadores.add("Maria");
                ganadores.add("Rodrigo");
                ganadores.add("Juan");
                ganadores.add("Pablo");

                boolean tengoAJuan = false;
                String datos = "";;
                String datos2 = "";;

                for (String ganador : ganadores) {
                    if (ganador.equals("Juan")) {
                        tengoAJuan = true;

                        datos = "Estilo imperativo. Juan gano? " + tengoAJuan;
                        break;
                    }
                }

                datos2 = "Estilo declarativo/funcional. Juan gano? " + ganadores.stream().anyMatch(g -> g.equals("Juan"));

                IndiceMasaCorporal imc = (p, e) -> {
                    double r = Math.round(p / (e * e));

                    if (r < 10.5) {
                        return "IMC: " + r + " Bajo peso. ";
                    } else if (r >= 18.5 && r <= 24.9) {
                        return "IMC: " + r + " Peso normal. ";
                    } else if (r >= 25.0 && r <= 29.9) {
                        return "IMC: " + r + " Sobrepeso. ";
                    } else if (r >= 30) {
                        return "IMC: " + r + " Obesidad. ";
                    }

                    return "Valor no válido";
                };

                double peso = 73;
                double estatura = 1.83;

                String calculo = imc.calcularIndice(peso, estatura);

                Impuesto imp1 = new Impuesto();
                imp1.setIngresoNeto(50000);
                imp1.calcularImpuesto();

                FuncionalImpuesto funcionalImpuesto = (ingreso) -> {
                    if (ingreso < 30000) {
                        return ingreso * 0.05;
                    }
                    return ingreso * 0.06;
                };

                FuncionalImpuesto impuestoPoliticos = (ingreso) -> {
                    if (ingreso < 30000) {
                        return ingreso * 0.01;
                    }
                    return ingreso * 0.02;
                };

/*
                Cliente personaNatural = new Cliente();
                personaNatural.nombre = "Maria perez";
                personaNatural.ingresoNeto = 50000;

                Cliente politico = new Cliente();
                politico.nombre = "Tu politico favorito";
                politico.ingresoNeto = 100000;
*/

                Cliente[] clientes = new Cliente[3];

                clientes[0] = new Cliente("John", 'E');
                clientes[1] = new Cliente("Mary", 'C');
                clientes[2] = new Cliente("Steven", 'E');

                List<Cliente> clientesList = Arrays.asList(clientes);

                String mensaje = "1. Ejecutando un loop de manera iterativa<br /><br />";

                for (Cliente cli: clientesList) {
                    if ('E' == cli.getStatus()) {
                        mensaje += cli.getNombre() + " es empleado <br />";
                    } else {
                        mensaje += cli.getNombre() + " es contratista <br />";
                    }
                }

                List<String> output = new ArrayList<>();
                output.add("2. Ejecutando un loop de manera funcional<br /><br />");

                clientesList.forEach(cli -> {
                    if ('E' == cli.getStatus()) {
                        output.add(cli.getNombre() + " es empleado <br />");
                    } else {
                        output.add(cli.getNombre() + " es contratista <br />");
                    }
                });


                request.setAttribute("datos", mensaje);
                request.setAttribute("datos2", output);
                request.getRequestDispatcher("jsp/pagina2.jsp").forward(request,response);
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}