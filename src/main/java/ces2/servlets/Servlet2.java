package ces2.servlets;

import ces2.entidades.Banco;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Servlet2", value = "/Servlet2")
public class Servlet2 extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {

            HttpSession sesion = request.getSession();

            Banco banco = (Banco) sesion.getAttribute("banco");

            String formulario = request.getParameter("formulario");

            String varcuenta = request.getParameter("cuenta");
            String varnacionalidad = request.getParameter ("nacionalidad");
            String varbalance = request.getParameter("balance");

            if (formulario.equals("nacionalidad")) {
                banco.cambiarNacionalidad(Boolean.parseBoolean(varnacionalidad), Integer.parseInt(varcuenta));
            } else if (formulario.equals("depositar")) {
                String mensaje1 = "";

                if ((!varbalance.trim().isEmpty()) && (varbalance != null)) {
                    if (isNumber(varbalance)) {
                        if (Integer.parseInt(varbalance) < 0) {
                            mensaje1 = "La cantidad a depositar deber ser mayor a cero";
                        } else {
                            banco.depositar(Integer.parseInt(varbalance), Integer.parseInt(varcuenta));

                            varbalance = Integer.toString(banco.getBalance(Integer.parseInt(varcuenta)));
                        }
                    } else {
                        mensaje1 = "La cantidad debe ser numerica";
                    }
                } else {
                    mensaje1 = "Debe ingresar la cantidad a depositar";
                }

                request.setAttribute("mensaje1", mensaje1);
            } else if (formulario.equals("prestamo")) {
                String mensaje2 = "";

                if ((!varbalance.trim().isEmpty()) && (varbalance != null)) {
                    if (isNumber(varbalance)) {
                        if (Integer.parseInt(varbalance) < 0) {
                            mensaje2 = "La cantidad del prestamo deber ser mayor a cero";
                        } else {

                            boolean resultado = banco.autorizarPrestamo(Integer.parseInt(varbalance), Integer.parseInt(varcuenta));

                            if (resultado) {
                                varbalance = Integer.toString(banco.getBalance(Integer.parseInt(varcuenta)));
                            }

                            mensaje2 = resultado ? "El prestamo fue aprobado" : "No cumple las condiciones";
                        }
                    } else {
                        mensaje2 = "La cantidad debe ser numerica";
                    }
                } else {
                    mensaje2 = "Debe ingresar la cantidad del prestamo";
                }

                request.setAttribute("mensaje2", mensaje2);
            }

            // Continue on clase 4-2 1:22:18

            request.setAttribute("cuenta", varcuenta);
            request.setAttribute("nacionalidad", varnacionalidad);
            request.setAttribute("balance", varbalance);
            request.getRequestDispatcher ("jsp/cuenta.jsp").forward (request, response);
        }
    }

    public boolean isNumber(String strNum) {
        try {
            Integer.parseInt(strNum);
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