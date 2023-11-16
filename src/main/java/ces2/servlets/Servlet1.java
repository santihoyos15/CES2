package ces2.servlets;

import ces2.entidades.TestStackTrace;
import ces2.entidades.Vendedor;
import ces2.entidades.VendedorException;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

@WebServlet(name = "Servlet1", value = "/Servlet1")
public class Servlet1 extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {

            String datos = "";

            String formulario = request.getParameter("formulario");

            if (formulario.equals("index")) {

                HashMap<Integer, Vendedor> vendedores = new HashMap<>();

                vendedores.put(1000, new Vendedor(1000, "Cartagena"));
                vendedores.put(2000, new Vendedor(2000, "Bogota"));
                vendedores.put(3000, new Vendedor(3000, "Medellin"));

                String codigo = request.getParameter("codigo");
                String valor = request.getParameter("valor");

                Vendedor vendedor = vendedores.get(Integer.parseInt(codigo));
                vendedor.setVentas(Double.parseDouble(valor));

                try {
                    if (vendedor.getCiudad().equals("Cartagena") && vendedor.getVentas() < 800) {
                        throw new VendedorException("Sus ventas deben ser mayores a 800");
                    } else if (vendedor.getCiudad().equals("Bogota") && vendedor.getVentas() < 500) {
                        throw new VendedorException("Sus ventas deben ser mayores a 500");
                    } else if (vendedor.getCiudad().equals("Medellin") && vendedor.getVentas() < 300) {
                        throw new VendedorException("Sus ventas deben ser mayores a 300");
                    }

                    datos = "Transaccion exitosa. Vendedor: " + codigo;
                } catch (VendedorException e) {
                    datos = e.getMessage();
                }

                /////////////////////
                ////////////////////
/*
                try {
                    new TestStackTrace();
                } catch (ArithmeticException e) {
                    datos = e.toString();
                }
*/

                ///////////////////
                ///////////////////


/*
                String edades = request.getParameter("edades");

                Exception e;

                try {
                    if (edades.equals("30")) {
                        e = new Exception("Excepcion de menor de 30 años");
                    } else if (edades.equals("60")) {
                        e = new Exception("Excepcion de menor de 60 años");
                    } else {
                        e = new Exception("Excepcion de menor de 100 años");
                    }

                    throw e;
                } catch (Exception ex) {
                    datos = ex.getMessage();
                }
*/

                ///////////////////
                ///////////////////

/*
                String path = "C:\\Users\\ASUS\\IdeaProjects\\CES2\\datos.txt";

                try (
                        FileInputStream myFile = new FileInputStream(path);
                        InputStreamReader inputStreamReader = new InputStreamReader(myFile, StandardCharsets.UTF_8);
                        BufferedReader reader = new BufferedReader(inputStreamReader);
                ) {
                    String lectura = "";

                    while ((lectura = reader.readLine()) != null) {
                        datos += lectura;
                    }
*/

                    //datos = "Pasó con extio";
                /*} catch (IOException | ArithmeticException e) {
                    datos = e.getMessage();
                }*/ /*finally {
                    datos = "Así no lo quieras, siempre pasaras por mi";
                }*/

                request.setAttribute("mensaje", datos);
/*
                request.getRequestDispatcher("jsp/page1.jsp").forward(request, response);
*/
            } /*else if (formulario.equals("page1")) {*/
                request.getRequestDispatcher("index.jsp").forward(request, response);
/*
            }
*/
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