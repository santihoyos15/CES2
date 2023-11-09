package ces2.servlets;

import ces2.entidades.Stack;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Servlet1", value = "/Servlet1")
public class Servlet1 extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);

        try (PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession(true);

            String action = request.getParameter("action");
            Stack<Integer> stack = (Stack<Integer>) session.getAttribute("stack");

            if (stack == null) {
                stack = new Stack<>();
                session.setAttribute("stack", stack);
            }

            if (action.equals("push")) {
                try {
                    int value = Integer.parseInt(request.getParameter("value"));
                    stack.push(value);
                } catch (Exception e) {
                    request.setAttribute("message", "Input invalido");
                }
            } else if (action.equals("pop")) {
                try {
                    stack.pop();
                } catch (Exception e) {
                    request.setAttribute("message", e.getMessage());
                }
            }

            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }
}