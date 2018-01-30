package hall;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet(name = "Totals", urlPatterns = "/totals")
public class Totals extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/geography", "root", "root");
            Statement statement = connection.createStatement();
            java.sql.ResultSet resultSet = statement.executeQuery("SELECT * from geography_test");

            String userAnswer = null;
            String jspAnswer = null;
            String correctAnswer = null;
            int correctCount = 0;
            int questionCount = 0;
            for (int i = 0; i < 10; i++) {
                    jspAnswer = request.getParameter("variant" + i);
                while (resultSet.next()) {
                    userAnswer = resultSet.getString(jspAnswer);
                    correctAnswer = resultSet.getString("correct");
                    break;
                }
                if (userAnswer.compareTo(correctAnswer) == 0){
                    correctCount = correctCount + 1;
                }
            questionCount = i+1;
            }
            PrintWriter out = response.getWriter();
            out.println("<head><title>Result</title></head>");
            out.println("Кількість запитань - " + questionCount + "<br>");
            out.println("Кількість правильних відповідей - " + correctCount + "<br>");
            out.println("Відсоток правильних відповідей - " + ((correctCount*100)/questionCount) + "%");
            resultSet.close();
            connection.close();
        }
        catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
