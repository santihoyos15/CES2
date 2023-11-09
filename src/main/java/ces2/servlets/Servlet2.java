package ces2.servlets;

import ces2.entidades.Queue;

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
            Queue<Integer> queue = (Queue<Integer>) session.getAttribute("queue");

            if (queue == null) {
                queue = new Queue<>();
                session.setAttribute("queue", queue);
            }

            if (action.equals("enqueue")) {
                try {
                    int value = Integer.parseInt(request.getParameter("value"));
                    queue.enqueue(value);
                } catch (Exception e) {
                    request.setAttribute("message2", "Input invalido");
                }
            } else if (action.equals("dequeue")) {
                try {
                    queue.dequeue();
                } catch (Exception e) {
                    request.setAttribute("message2", e.getMessage());
                }
            }

            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }
}