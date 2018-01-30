package hall;
import java.sql.*;

public class LoadBase {

   public String string;

 public void loadMSQL (){
     try {
         Class.forName("com.mysql.jdbc.Driver");
     } catch (ClassNotFoundException e) {
         e.printStackTrace();
     }try {
         Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/geography", "root", "root");
         PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO geography_test(question, variant1, variant2, variant3, correct) VALUES (?,?,?,?,?)");
         preparedStatement.setString(1, "Яке значення морських експедицій, очолював Х. Колумб?");
         preparedStatement.setString(2, "Відкрито нову частину світу для європейців");
         preparedStatement.setString(3, "Прокладено морський шлях з Єропи до Індії");
         preparedStatement.setString(4, "Створено першу карту шести континентів");
         preparedStatement.setString(5, "Відкрито нову частину світу для європейців");
         preparedStatement.executeUpdate();
         preparedStatement.setString(1, "У північній частині якого материка неможиливо побачити Полярну зірку?");
         preparedStatement.setString(2, "Євразії");
         preparedStatement.setString(3, "Африки");
         preparedStatement.setString(4, "Австралії");
         preparedStatement.setString(5, "Автралії");
         preparedStatement.executeUpdate();

         preparedStatement.close();
         connection.close();

     }catch (SQLException ex) {
         ex.printStackTrace();
     }
 }

}
