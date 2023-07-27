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
public class SAQ extends Question{
    private String answer;
    private String question;
    
    public SAQ(String question, String answer, int dif){
        super(question, dif, 3);
        this.question = question;
        this.answer = answer;
    }
    
    public boolean checkAnswer(String answer){
        return this.answer.equalsIgnoreCase(answer);
    }
    
    public String getQ(){
        return question;
    }
    
    public String getAnswer(){
        return answer;
    }
    
    public boolean isMCQ(){
        return false;
    }
    
    public boolean isSAQ(){
        return true;
    }

    public boolean isMatching(){
        return false;
    }
}
