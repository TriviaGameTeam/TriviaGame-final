package TriviaGame;
//כרגע לא נעשה שימוש במחלקה הנל ויש צורך בכך!
public class Question {

    private String questionString;
    private String[] answers;
    private int rightAnswer;
    private int points;
    private boolean shown = false;
//    private int level;

    public boolean isShown() {
        return shown;
    }

    public void setShown(boolean shown) {
        this.shown = shown;
    }

    public String getQuestionString() {
        return questionString;
    }

    public void setQuestionString(String question) {
        this.questionString = question;
    }

    public String[] getAnswers() {
        return answers;
    }

    public void setAnswers(String[] answers) {
        String [] temp =new String[4];
        for(int i =0;i<4;i++){
            temp[i]=answers[i];
        }
        this.answers = temp;
    }

    public int getRightAnswer() {
        
        return rightAnswer;
    }

    public void setRightAnswer(int rightAnswer) {
        this.rightAnswer = rightAnswer;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return questionString + "?(" + points + ")";
    }

    public Question() {
    }

    @Override
    public boolean equals(Object obj) {
        Question other = (Question) obj;
        if(this.questionString.equals(other.questionString))
            return true;
        
        return false;
    }

    
    
    
    public Question(String Question, String[] answer, int points,int rightAns) {

        setQuestionString(Question);
        setAnswers(answer);
        setPoints(points);
        setRightAnswer(rightAns);
    }
}