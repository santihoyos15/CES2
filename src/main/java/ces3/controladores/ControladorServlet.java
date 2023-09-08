package ces3.controladores;

import ces3.entidades.Contratista;
import ces3.entidades.Empleado;
import ces3.entidades.Persona;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//import javax.ejb.Stateful;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

//@Stateful(passivationCapable=false)
// @WebServlet(name = "ControladorServlet", value = "/ControladorServlet")
public class ControladorServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()){
            String nombre = request.getParameter("username");
            String tipo = request.getParameter("tipoEmpleado");

            boolean isAnyRequiredFieldEmpty = nombre == null || nombre.isEmpty() || tipo == null || tipo.isEmpty();

            if (isAnyRequiredFieldEmpty) {
                out.println("El nombre y el tipo de empleado son requeridos");
                return;
            }

            HttpSession session = request.getSession(true);

            List<Persona> trabajadores;

            if (session.isNew()) {
                trabajadores = (List<Persona>) session.getAttribute("trabajadores");
            } else {
                trabajadores = new ArrayList<>();
            }

            if (tipo.equals("1")) {
                Empleado empleado = new Empleado(nombre);
                trabajadores.add(empleado);
            } else if (tipo.equals("2")) {
                Contratista contratista = new Contratista(nombre);
                trabajadores.add(contratista);
            }

            session.setAttribute("trabajadores", trabajadores);

            request.setAttribute("trabajadores", trabajadores);
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