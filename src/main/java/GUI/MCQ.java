/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author student
 */
public class MCQ extends Question{
    private String question;
    private String correctAnswer;
    private ArrayList<String> answers;
    private ArrayList<String> oanswers;
    
    public MCQ(String question, int dif, ArrayList<String> answers){
        super(question, dif, 1);
        this.question = question;
        oanswers = new ArrayList<String>();
        for(int i = 0; i < answers.size(); i++){
            oanswers.add(answers.get(i));
        }
        this.answers = answers;
        correctAnswer = answers.get(0);
        Collections.shuffle(this.answers);
    }
    
    public boolean checkAnswer(int choice){
        int ind = 0;
        for(int i = 0; i < answers.size(); i++){
            if(correctAnswer.equals(answers.get(i))){
                ind = i;
            }
        }
        if(ind == choice){
            return true;
        }
        return false;
    }
    
    public String getAnswer(int x){
        return answers.get(x);
    }
    
    public String getOAnswer(int x){
        return oanswers.get(x);
    }
    
    public String getQ(){
        return question;
    }
    public boolean isMCQ(){
        return true;
    }
    
    public boolean isSAQ(){
        return false;
    }

    public boolean isMatching(){
        return false;
    }
}
