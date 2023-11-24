package ces2.servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;

@WebServlet(name = "Servlet1", value = "/Servlet1")
public class Servlet1 extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {

            String datos = "";

            int salario = 3;
             datos = calcularBonus(salario);

             request.setAttribute("mensaje", datos);
             request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    @SuppressWarnings("UnusedAssignment")
    public String calcularBonus (int salario) {
        int bonus;
        String datos = "";

        switch (salario) {
            case 1:
                bonus = 1000;
                datos = "Salario nivel 1.<br /> Dando bonus de: " + bonus;
                break;
            case 2:
                bonus = 2000;
                datos = "Salario nivel 2.<br /> Dando bonus de: " + bonus;
                break;
            case 3:
                bonus = 6000;
                datos = "Salario nivel 3.<br /> Dando bonus de: " + bonus;
            case 4:
                bonus = 1000;
                datos = "Salario nivel 4.<br /> Dando bonus de: " + bonus;
                break;
            default:
                datos = "Nivel de salario invalido: " + salario;
        }

        return datos;
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