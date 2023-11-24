package ces2.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

@WebServlet(name = "Servlet2", value = "/Servlet2")
public class Servlet2 extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");

        String mensaje = "";

        try (PrintWriter out = response.getWriter()) {
            try {
                Class c = Class.forName("ces2.entidades.Empleado");
                Method[] methods = c.getDeclaredMethods();

                mensaje += "Métodos de la clase Empleado: <br />";

                for (int i = 0; i < methods.length; i++) {
                    mensaje += "*** Definicion del método: " + methods[i].toString() + "<br />";
                }

                Class superClass = c.getSuperclass();
                mensaje += "<br />El nombre de la superclase es: " + superClass.getName() + "<br />";

                Method[] superMethods = superClass.getDeclaredMethods();
                mensaje += "Métodos de la super clase: <br />";

                for (int i = 0; i < superMethods.length; i++) {
                    mensaje += "*** Definicion del método: " + superMethods[i].toString() + "<br />";

                    mensaje += "Tipo de retorno: " + superMethods[i].getReturnType().getName() + "<br />";
                }

                mensaje += "<br /> Mostrando sus atributos: <br />";
                Field[] fields = c.getFields();

                for (int i = 0; i < fields.length; i++) {
                    String name = fields[i].getName();
                    String type = fields[i].getType().getName();
                    mensaje += "Nombre del campo: " + name + ", Tipo: " + type + "<br />";
                }

                mensaje += "<br />Ejecutando un metodo: <br />";
                Method aumentarSalario = c.getMethod("aumentarSalario", null);
                mensaje += aumentarSalario.invoke(c.newInstance(), null);

                mensaje += "<br />Asignando un nombre y mostrandolo:<br />";
                Class[] parameterTypes = new Class[] {String.class};
                Method setName = c.getMethod("setName", parameterTypes);

                Object arguments[] = new Object[1];
                arguments[0] = "Pablo Ospina";
                Object empleado = c.newInstance();
                setName.invoke(empleado, arguments);

                Method getName = c.getMethod("getName", null);
                mensaje += "Nombre: " + getName.invoke(empleado, null) + "<br />";

                // Minute 3:39 clase 7-5

            } catch (Exception e) {
                mensaje = e.toString();
            }

            request.setAttribute("mensaje", mensaje);
            request.getRequestDispatcher("jsp/reflection.jsp").forward(request, response);
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