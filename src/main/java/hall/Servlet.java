package hall;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "Servlet", urlPatterns = "/servlet")
public class Servlet extends HttpServlet {
    private BeanTask beanTask;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        beanTask = new BeanTask();
        beanTask.setBeanTask();
        HttpSession session = request.getSession();
        session.setAttribute("userbase", beanTask);
        RequestDispatcher rDispatch = getServletContext().getRequestDispatcher("/example.jsp");
        rDispatch.forward(request, response);
    }
}
