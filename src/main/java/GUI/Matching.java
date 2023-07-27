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
public class Matching extends Question {
    private String question;
    private ArrayList<String> a1;
    private ArrayList<String> a2;
    private ArrayList<String> a2or;
    private ArrayList<Integer> answers;
    
    public Matching(String question, ArrayList<String> a1, ArrayList<String> a22, int dif){
        super(question, dif, 2);
        this.question = question;
        a2or = a22;
        this.a1 = a1;
        a2 = new ArrayList<String>();
        for(int a = 0; a < a22.size(); a++){
            a2.add(a22.get(a));
        }
        Collections.shuffle(a2);
        answers = new ArrayList<Integer>();
        for(int i = 0; i < a2.size(); i++){
            for(int j = 0; j < a22.size(); j++){
                if(a22.get(i).equals(a2.get(j))){
                    answers.add(j + 1);
                }
            }
        }
    }
    
    public String getQ(){
        return question;
    }
    
    public ArrayList<Integer> getAnswers(){
        return answers;
    }
    
    public void newPair(String a, String b){
        a1.add(a);
        a2.add(b);
    }
    
    public ArrayList<String> getA1(){
        return a1;
    }
    
    public ArrayList<String> getA2(){
        return a2;
    }
    
    public ArrayList<String> getA2or(){
        return a2or;
    }
    
    public boolean checkAnswer(ArrayList<String> c1, ArrayList<String> c2){
        int index = 0;
        for(int i = 0; i < a1.size(); i++){
            for(int c = 0; c < c1.size(); c++){
                if(c1.get(i).equals(a1.get(c))){
                    index = c;
                    break;
                }
            }
            if(!c2.get(index).equals(a2.get(index))){
                return false;
            }
        }
        return true;
    }
    
    public boolean isMCQ(){
        return false;
    }
    
    public boolean isSAQ(){
        return false;
    }

    public boolean isMatching(){
        return true;
    }
}
