package ces2.servlets;

import ces2.entidades.Carro;
import ces2.entidades.Cliente;
import ces2.entidades.Pedidos;
import ces2.entidades.PedidoAbstracta;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "Servlet2", value = "/Servlet2")
public class Servlet2 extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession(true);

            ArrayList<Cliente> pedidosClientes = (ArrayList) session.getAttribute("pedidosClientes");
            ArrayList<Carro> pedidosVehiculos = (ArrayList) session.getAttribute("pedidosVehiculos");

            Pedidos<PedidoAbstracta> pedidos = new Pedidos<>();

            for (Cliente cliente: pedidosClientes) {
                pedidos.add(cliente);
            }

            for (Carro carro: pedidosVehiculos) {
                pedidos.add(carro);
            }

            request.setAttribute("pedidos", pedidos.getPedidos());

            request.getRequestDispatcher("jsp/informacion.jsp").forward(request, response);
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