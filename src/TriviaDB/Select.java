package TriviaDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class Select {

    public static void main(String[] args) throws ClassNotFoundException, SQLException{

        Class.forName(DBUtils.DbDriverClass);
          
            Connection connection = DriverManager.getConnection(
                   DBUtils.DbUrl , 
                   DBUtils.DbUser , 
                   DBUtils.DbPassword);
            
            Statement st = connection.createStatement();
            ResultSet results = st.executeQuery("Select * from root.triviadbtest Where ANSWER1 like '%26%'");
            
            
            while (results.next()) {
                 
                String question = results.getString("question");
                System.out.println(question);
            }
            results.close();
    }
}
