package ces2.servlets;

import ces2.entidades.Banco;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Servlet1", value = "/Servlet1")
public class Servlet1 extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {

            // Para crear la sesión, y si ya existe la traemos
            HttpSession sesion = request.getSession(true);

            // Buscamos si la sesión ya tiene el objeto banco
            Banco banco = (Banco) sesion.getAttribute("banco");
            // Validar para la priemera vez que se crea la sesión.
            if (banco == null) {
                banco = new Banco();
                banco.nuevaCuenta(1, true);
                banco.nuevaCuenta(2, false);
                sesion.setAttribute("banco", banco);
            }

            String formulario = request.getParameter("formulario");

            if (formulario.equals("accion1")) {
                String tipoForm = request.getParameter("tipo");
                int tipo = (tipoForm.equals("ahorros")) ? 1 : 2;

                String nacionalidad = request.getParameter("nacionalidad");
                boolean extranjero = !(nacionalidad.equals("loacal"));

                banco.nuevaCuenta(tipo, extranjero);
            }

            banco = (Banco) sesion.getAttribute("banco");
            request.setAttribute("cuentas", banco.getCuentas());
            request.getRequestDispatcher("jsp/cuentas.jsp").forward(request, response);
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