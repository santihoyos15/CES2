package ces2.controladores;

import ces2.entidades.Avion;
import ces2.entidades.Barco;
import ces2.entidades.Camion;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ejb.Stateful;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@Stateful(passivationCapable=false)
public class ControladorServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()){
            String nombre = request.getParameter("nombre");
            String tipoVehiculo = request.getParameter("tipoVehiculo");

            boolean isAnyRequiredFieldEmpty = nombre == null || nombre.isEmpty() || tipoVehiculo == null || tipoVehiculo.isEmpty();

            if (isAnyRequiredFieldEmpty) {
                out.println("El nombre y el tipo de vehiculo son requeridos");
                return;
            }

            HttpSession session = request.getSession(true);

            List<Object> vehiculos = (List<Object>) session.getAttribute("vehiculos");

            if (vehiculos == null) {
                vehiculos = new ArrayList<>();
            }

            switch (tipoVehiculo) {
                case "1":
                    Avion avion = new Avion();
                    avion.setNombre(nombre);
                    vehiculos.add(avion);
                    break;
                case "2":
                    Barco barco = new Barco();
                    barco.setNombre(nombre);
                    vehiculos.add(barco);
                    break;
                case "3":
                    Camion camion = new Camion();
                    camion.setNombre(nombre);
                    vehiculos.add(camion);
                    break;
            }

            session.setAttribute("vehiculos", vehiculos);

            request.setAttribute("vehiculos", vehiculos);
            request.getRequestDispatcher("index.jsp")
                    .forward(request, response);
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(response.toString());
        this.doGet(request, response);
    }
}