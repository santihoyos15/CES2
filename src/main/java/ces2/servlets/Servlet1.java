package ces2.servlets;

import ces2.entidades.Carro;
import ces2.entidades.Cliente;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ClientInfoStatus;
import java.util.ArrayList;

@WebServlet(name = "Servlet1", value = "/Servlet1")
public class Servlet1 extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession(true);

            Integer idCliente = (Integer) session.getAttribute("idCliente");

            boolean isClienteNew = idCliente != null;

            Integer idVehiculo = (Integer) session.getAttribute("idVehiculo");

            boolean isVehiculoNew = idVehiculo != null;

            ArrayList<Cliente> pedidosClientes = (ArrayList) session.getAttribute("pedidosClientes");
            ArrayList<Carro> pedidosVehiculos = (ArrayList) session.getAttribute("pedidosVehiculos");

            String nombre = request.getParameter("nombre");
            String celular = request.getParameter("celular");
            String vehiculo = request.getParameter("vehiculo");

            String formulario = request.getParameter("formulario");

            if (formulario.equals("ingresar")) {
                if (!isClienteNew) {
                    idCliente = 1000;
                } else {
                    idCliente +=1;
                }

                session.setAttribute("idCliente" , idCliente);

                if (!isVehiculoNew) {
                    idVehiculo = 1000;
                } else {
                    idVehiculo +=1;
                }

                Cliente cliente = new Cliente(idCliente, nombre, celular);

                Double precio = 0.0;

                switch (vehiculo) {
                    case "Volvo":
                        precio = 150.0;
                        break;
                    case "Mercedes":
                        precio = 120.0;
                        break;
                    case "Audi":
                        precio = 100.0;
                        break;
                    case "Jeta":
                        precio = 70.0;
                        break;
                    case "Toyota":
                        precio = 50.0;
                        break;
                }

                Carro carro = new Carro(idVehiculo, precio, vehiculo, idCliente);

                if (pedidosClientes == null) {
                    pedidosClientes = new ArrayList<>();
                    pedidosVehiculos = new ArrayList<>();

                    pedidosClientes.add(cliente);
                    pedidosVehiculos.add(carro);
                    session.setAttribute("pedidosClientes", pedidosClientes);
                    session.setAttribute("pedidosVehiculos", pedidosVehiculos);
                } else {
                    pedidosClientes.add(cliente);
                    pedidosVehiculos.add(carro);
                }

                request.setAttribute("pedidosClientes", pedidosClientes);
                request.setAttribute("pedidosVehiculos", pedidosVehiculos);
                request.getRequestDispatcher("jsp/clientes.jsp").forward(request, response);

            } else if (formulario.equals("carros")) {
                request.setAttribute("pedidosVehiculos", pedidosVehiculos);
                request.getRequestDispatcher("jsp/carros.jsp").forward(request, response);
            } else if (formulario.equals("accion2")) {
                request.setAttribute("pedidosClientes", pedidosClientes);
                request.getRequestDispatcher("jsp/clientes.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("index.jsp").forward(request, response);
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