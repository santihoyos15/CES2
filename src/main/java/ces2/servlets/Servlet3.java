package ces2.servlets;

import ces2.entidades.Banco;
import ces2.entidades.CuentaBancaria;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@WebServlet(name = "Servlet2", value = "/Servlet2")
public class Servlet3 extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {

            HttpSession sesion = request.getSession();

            Banco banco = (Banco) sesion.getAttribute("banco");

            String formulario = request.getParameter("formulario");

            if (formulario.equals("accion3")) {
                if (banco == null) {
                    request.setAttribute("mensaje", "No existen cuentas");
                } else {
                    List<CuentaBancaria> cuentas = new ArrayList<>(banco.getCuentas().values());

                    CuentaBancaria maxbal = Collections.max(cuentas);
                    CuentaBancaria minbal = Collections.min(cuentas);

                    request.setAttribute("max", maxbal);
                    request.setAttribute("min", minbal);
                }
            }

            request.getRequestDispatcher("jsp/reportes.jsp").forward(request, response);
        }
    }

    public boolean isNumber(String strNum) {
        try {
            Double.parseDouble(strNum);
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
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