package TriviaDB;
    
import TriviaGame.Question;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBUtils {
    
    public static final String DbUrl = "jdbc:derby://localhost:1527/BooksDB";
    public static final String DbDriverClass = "org.apache.derby.jdbc.ClientDriver";
    public static final String DbUser = "root";
    public static final String DbPassword = "root";
    
    
    public static ArrayList<Question> getAllQuestions()
    {
        ArrayList<Question> allQuestions = new ArrayList<Question>();
        
        try {
            Class.forName(DBUtils.DbDriverClass);
       
          
            Connection connection = DriverManager.getConnection(
                   DBUtils.DbUrl , 
                   DBUtils.DbUser , 
                   DBUtils.DbPassword);
            
            Statement st = connection.createStatement();
            ResultSet results = st.executeQuery("Select * from root.triviadbtest");
            
            
            while (results.next()) {
                 
                String question = results.getString("question");
                String[] answers = new String[4];
                answers[0] = results.getString("answer1");
                answers[1] = results.getString("answer2");
                answers[2] = results.getString("answer3");
                answers[3] = results.getString("answer4");
                int rightAns = results.getInt("CORRECT_ANSWER");
                int Points = results.getInt("Points");
                Question q = new Question(question, answers, Points, rightAns);
                allQuestions.add(q);
                System.out.println(question);
                System.out.println(rightAns);
            }
            results.close();
         } catch (Exception ex) {
            Logger.getLogger(DBUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return allQuestions;
    }
    
    public static void createNewUser(String username, String password)
    {

        try {
            //load the Driver class to memory
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Scanner input = new Scanner(System.in);
            
            //הזנת שאלות ותשובות למאגר
            //System.out.println("Please enter ID of question, the question, 4 answers, the index of the correct answer:");
            
            /*String ID = input.nextLine();
            String question = input.nextLine();
            boolean was = false;
            String answer1 = input.nextLine();
            String answer2 = input.nextLine();
            String answer3 = input.nextLine();
            String answer4 = input.nextLine();
            String currectAnswer = input.nextLine();
            int Points = input.nextInt();
*/
            //System.out.println("Please enter your user name and your password:");
            //String userName = input.nextLine();
            //String password = input.nextLine();
            
            Connection connection = DriverManager.getConnection(
                    DBUtils.DbUrl,
                    DBUtils.DbUser,
                    DBUtils.DbPassword);

            //הזנת שאלות לטבלה
            //PreparedStatement pstatement = connection.prepareStatement("insert into root.triviadbtest values (?,?,?,?,?,?,?,?,?)");

            //הזנת משתמשים לטבלת המשתמשים
             PreparedStatement pstatement = connection.prepareStatement("insert into root.trivia_users values (?,?)");
            
             /*
            pstatement.setString(1, ID);
            pstatement.setString(2, question);
            pstatement.setBoolean(3, was);
            pstatement.setString(4, answer1);
            pstatement.setString(5, answer2);
            pstatement.setString(6, answer3);
            pstatement.setString(7, answer4);
            pstatement.setString(8, currectAnswer);
            pstatement.setInt(9, Points);
*/
             pstatement.setString(1, username);
             pstatement.setString(2, password);
             
            int result = pstatement.executeUpdate();

            if (result > 0) {
                System.out.println("Value insertsd succssfuly");
            } else {
                System.out.println("Problem in insert");
            }

            connection.close();
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver class not found! have you added it to project?");
        } catch (SQLException ex) {
            Logger.getLogger(JDBC.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}

