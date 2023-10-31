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
                        if (Double.parseDouble(varbalance) < 0) {
                            mensaje1 = "La cantidad a depositar deber ser mayor a cero";
                        } else {
                            banco.depositar(Double.parseDouble(varbalance), Integer.parseInt(varcuenta));

                            mensaje1 = "Dinero depositado exitosamente";
                        }
                    } else {
                        mensaje1 = "La cantidad debe ser numerica";
                    }
                } else {
                    mensaje1 = "Debe ingresar la cantidad a depositar";
                }

                request.setAttribute("mensaje1", mensaje1);
            } else if (formulario.equals("retirar")) {
                String mensaje4 = "";

                if ((!varbalance.trim().isEmpty()) && (varbalance != null)) {
                    if (isNumber(varbalance)) {
                        if (Double.parseDouble(varbalance) < 0) {
                            mensaje4 = "La cantidad a retirar deber ser mayor a cero";
                        } else {
                            banco.retirar(Double.parseDouble(varbalance), Integer.parseInt(varcuenta));

                            mensaje4 = "Dinero depositado exitosamente";
                        }
                    } else {
                        mensaje4 = "La cantidad debe ser numerica";
                    }
                } else {
                    mensaje4 = "Debe ingresar la cantidad a depositar";
                }

                request.setAttribute("mensaje4", mensaje4);
            } else if (formulario.equals("prestamo")) {
                String mensaje2 = "";

                if ((!varbalance.trim().isEmpty()) && (varbalance != null)) {
                    if (isNumber(varbalance)) {
                        if (Double.parseDouble(varbalance) < 0) {
                            mensaje2 = "La cantidad del prestamo deber ser mayor a cero";
                        } else {

                            boolean isPrestamoAutorizado = banco.autorizarPrestamo(Double.parseDouble(varbalance), Integer.parseInt(varcuenta));

                            mensaje2 = isPrestamoAutorizado ? "El prestamo fue aprobado" : "No cumple las condiciones";
                        }
                    } else {
                        mensaje2 = "La cantidad debe ser numerica";
                    }
                } else {
                    mensaje2 = "Debe ingresar la cantidad del prestamo";
                }

                request.setAttribute("mensaje2", mensaje2);
            } else if (formulario.equals("interes")) {
                boolean resultado = banco.addInteres(Integer.parseInt(varcuenta));

                String mensaje3 = resultado ? "Se ha sumado el interés a su cuenta" : "Es una cuenta corriente";
                request.setAttribute("mensaje3", mensaje3);
            }

            varbalance = Double.toString(banco.getBalance(Integer.parseInt(varcuenta)));

            request.setAttribute("cuenta", varcuenta);
            request.setAttribute("nacionalidad", varnacionalidad);
            request.setAttribute("balance", varbalance);
            request.setAttribute("movimientos", banco.auditoria.mostrarTodosMovimientosCuenta(Integer.parseInt(varcuenta)));
            request.getRequestDispatcher ("jsp/cuenta.jsp").forward (request, response);
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