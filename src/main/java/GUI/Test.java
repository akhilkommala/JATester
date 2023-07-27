/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.util.ArrayList;

/**
 *
 * @author student
 */
public class Test {
    private ArrayList<Question> questions;
    private int length;
    boolean incorrect=false;
    int placement=0;
    private String name;
    public Test(String name){
        this.name = name;
        questions = new ArrayList<Question>();
        length = questions.size();
    }
    public Test(String name, ArrayList<Question> questions){
        this.name = name;
        this.questions = questions;
        length = questions.size();
    }
    
    public String getName(){
        return name;
    }
    
    public void addQuestion(Question q){
        questions.add(q);
        length++;
    }
    
    public Question getQuestion(int x){
        return questions.get(x);
    }
    
    public ArrayList<Question> getQuestions(){
        return questions;
    }
    
    public int getLength(){
        return length;
    }
    
    public String toString(){
        String a = "";
        a += name + ",";
        for(int i = 0; i < questions.size(); i++){
            if(questions.get(i).getType() == 1) {
                MCQ q = (MCQ)questions.get(i);
                a += 1 + "," + q.getQ() + "," + q.getOAnswer(0) + "," + q.getOAnswer(1) + "," + q.getOAnswer(2) + "," + q.getOAnswer(3) + ",";
            }
            else if(questions.get(i).getType() == 2){
                Matching m = (Matching) questions.get(i);
                a += 2 + "," + m.getQ() + "," + m.getA1().get(0) + "," + m.getA1().get(1) + "," + m.getA1().get(2) + "," + m.getA1().get(3) + "," + m.getA1().get(4) + "," + m.getA2or().get(0) + "," + m.getA2or().get(1) + "," + m.getA2or().get(2) + "," + m.getA2or().get(3) + "," + m.getA2or().get(4) + ",";
            }
            else{
                SAQ s = (SAQ) questions.get(i);
                a += 3 + "," + s.getQ() + "," + s.getAnswer() + ",";
            }
        }
        return a;
    }

}
