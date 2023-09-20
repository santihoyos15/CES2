package ces2.controladores;

import ces2.entidades.Empleado;
import ces2.entidades.Persona;

import javax.ejb.Stateful;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Optional;

@Stateful(passivationCapable=false)
public class Servlet2 extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()){

            String formulario = request.getParameter("formulario");

            if (formulario.equals("empleados")) {
                request.setAttribute("id", request.getParameter("id"));
                request.setAttribute("nombre", request.getParameter("nombre"));
                request.getRequestDispatcher("jsp/diaslibres.jsp").forward(request, response);
            }

            HttpSession session = request.getSession();

            List<Persona> trabajadores = (List<Persona>) session.getAttribute("trabajadores");

            if (formulario.equals("index")) {
                request.setAttribute("trabajadores", trabajadores);
                request.getRequestDispatcher("jsp/empleados.jsp").forward(request, response);
                return;
            } else if (formulario.equals("empleados")) {
                request.setAttribute("id", request.getParameter("id"));
                request.setAttribute("nombre", request.getParameter("nombre"));
                request.getRequestDispatcher("jsp/diaslibres.jsp").forward(request, response);
                return;
            } else if (formulario.equals("diaslibres")) {
                Integer diasForm = Integer.parseInt(request.getParameter("dias"));
                Integer idForm = Integer.parseInt(request.getParameter("id"));
                String nombreForm = request.getParameter("nombre");

                String mensaje = "";
                for (Persona trabajador : trabajadores) {
                    if (idForm.equals(trabajador.getId())) {
                        mensaje = trabajador.setDiasLibres(diasForm);
                        break;
                    }
                }

                if (mensaje.equals("OK")) {
                    request.setAttribute("trabajadores",trabajadores);
                    //session.setAttribute("trabajadores", trabajadores);
                    request.getRequestDispatcher("jsp/empleados.jsp").forward(request, response);
                } else {
                    request.setAttribute("mensaje", mensaje);
                    request.setAttribute("id", idForm);
                    request.setAttribute("nombre", nombreForm);
                    request.getRequestDispatcher("jsp/diaslibres.jsp").forward(request, response);
                }

            }

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