package ces2.servlets;

import ces2.entidades.GetDatos;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.lang.reflect.Method;

@WebServlet(name = "Servlet1", value = "/Servlet1")
public class Servlet1 extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {

            String datos = "";

            int salario = 3;
             datos = calcularBonus(salario);

             String archivo = "sin datos";

             try {
                 Class<?> clase = Class.forName("ces2.servlets.Servlet1");

                 Method[] methods = clase.getMethods();

                 for (Method method : methods) {
                     if (method.isAnnotationPresent(GetDatos.class)) {
                         GetDatos getDatos = method.getAnnotation(GetDatos.class);
                         archivo = getDatos.archivo();
                     }
                 }
             } catch (ClassNotFoundException e) {
                 datos = e.toString();
             }

             if (!archivo.equals("sin datos")) {
                 try (
                         FileInputStream myFile = new FileInputStream(archivo);
                         InputStreamReader inputStreamReader = new InputStreamReader(myFile, "UTF-8");
                         BufferedReader reader = new BufferedReader(inputStreamReader);
                 ){
                     String lectura = "";

                     while ((lectura = reader.readLine()) != null) {
                         datos += lectura;
                     }
                 } catch (IOException e) {
                     datos = e.toString();
                 }
             }

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

    @GetDatos(archivo = "C:\\Users\\ASUS\\IdeaProjects\\CES2\\datos.txt")
    public void getDatos() {

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