package ces2.controladores;

import ces2.entidades.Contratista;
import ces2.entidades.Empleado;
import ces2.entidades.Persona;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ejb.Stateful;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@Stateful(passivationCapable=false)
public class Servlet1 extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()){
            HttpSession session = request.getSession(true);

            String formulario = request.getParameter("formulario");

            if (!formulario.equals("index")) {
                request.getRequestDispatcher("index.jsp").forward(request, response);
                return;
            }

            String nombre = request.getParameter("nombre");
            String tipoEmpleado = request.getParameter("tipoEmpleado");
            String porcentajeAumento = request.getParameter("porcentajeAumento");

            if (nombre == null || nombre.trim().isEmpty() || porcentajeAumento == null || porcentajeAumento.isEmpty()) {
                request.setAttribute("mensaje", "Se debe ingresar el nombre, el tipo y el aumento.");
                request.getRequestDispatcher("index.jsp").forward(request, response);
                return;
            }

            Integer id = (Integer) session.getAttribute("contadorId");

            if (id == null) {
                id = 1000;
            } else {
                id++;
            }

            session.setAttribute("contadorId", id);

            String porcentajeAumentoSession = (String) session.getAttribute("porcentajeAumento");

            List<Persona> trabajadores = (List<Persona>) session.getAttribute("trabajadores");

            if (trabajadores == null) {
                trabajadores = new ArrayList<>();
            }

            if (tipoEmpleado.equals("1")) {
                Empleado empleado = new Empleado(id, nombre);
                trabajadores.add(empleado);
            } else if (tipoEmpleado.equals("2")) {
                Contratista contratista = new Contratista(id, nombre);
                trabajadores.add(contratista);
            }

            session.setAttribute("trabajadores", trabajadores);
            session.setAttribute("porcentajeAumento", porcentajeAumento);

            request.setAttribute("porcentajeAumento", porcentajeAumento);
            request.setAttribute("trabajadores", trabajadores);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.processRequest(request, response);
    }
}