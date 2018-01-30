package hall;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InitialTask {

    public InitialTask() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public List<Task> getTask() {

        Task task = null;
        List<Task> tasks = new ArrayList<Task>();
        try {

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/geography", "root", "root");
            Statement statement = connection.createStatement();
            java.sql.ResultSet resultSet = statement.executeQuery("SELECT * from geography_test");
            while (resultSet.next()) {
                task = new Task();
                task.setQuestion(resultSet.getString("question"));
                task.setVariant1(resultSet.getString("variant1"));
                task.setVariant2(resultSet.getString("variant2"));
                task.setVariant3(resultSet.getString("variant3"));
                task.setCorrect(resultSet.getString("correct"));
                task.setId(resultSet.getInt("id"));
                tasks.add(task);
            }
            resultSet.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tasks;
    }

}
