/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

/**
 *
 * @author student
 */
public class Question {
    private String question;
    private int difficulty;
    private int type;
    
    
    public Question(String question, int dif, int type){
        this.question = question;
        difficulty = dif;
        this.type = type;
    }
    
    public int getType(){
        return type;
    }
    
    public String getQuestion(){
        return question;
    }
    
    public int getDifficulty(){
        return difficulty;
    }
    public static void ojeo() {
    /*
    if previous question was correct, difficulty goes up 1
    if incorrect, repeat question with same difficulty,
    if incorrect again, difficulty goes down 1
    */
    
    /*
    boolean incorrect=false;
    if(user.answerCorrect()&&topic.getDifficulty()!=MAX_DIFFICULTY){
        topic.setDifficulty(topic.getDifficulty()+1);
    }
    if(!user.answerCorrect()&&topic.getDifficulty()!=1&&!incorrect){
        
        incorrect = true;
        topic.setDifficulty(topic.getDifficulty());
    }
    if(!user.answerCorrect()&&topic.getDifficulty()!=1&&incorrect){
        
        incorrect = false;
        topic.setDifficulty(topic.getDifficulty()-1);
    }
    

    */
    
    }
}
