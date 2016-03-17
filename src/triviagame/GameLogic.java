package TriviaGame;

import TriviaDB.DBUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class GameLogic {
    
    // this is the list of questions we will show in the game
    // it starts empty and we fill it inside the constructor
    ArrayList<Question> theQuestions = new ArrayList<Question>();
    private int currentQuestionIndex = 0;
    private int totalQuestions;
    
    public GameLogic(int numQuestions)
    {
        // this is the list of ALL questions in the DB
        ArrayList<Question> allQuestions = DBUtils.getAllQuestions();
        totalQuestions = numQuestions;
         Random rmd = new Random();
        int randomNumber, i=0;
        
        // loop until you find all the questions according to the number the user chose
        do{
            Question  ques= null;
            do{
                randomNumber = rmd.nextInt(allQuestions.size());
                ques = allQuestions.get(randomNumber);
            } while(theQuestions.contains(ques));
            
            theQuestions.add(ques);
            i++;
            
        }while(i<numQuestions);
        
    }
    
    public boolean isGameOver(){
        return (currentQuestionIndex == totalQuestions);  
    }
    
    public int getCurrentQuestionIndex() { return currentQuestionIndex; }
    public void moveToNextQuestion() { currentQuestionIndex++; }
    
    public Question getCurrentQuestion()
    {
        return theQuestions.get(currentQuestionIndex);
    }
}