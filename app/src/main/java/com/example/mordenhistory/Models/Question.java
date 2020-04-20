package com.example.mordenhistory.Models;

import java.util.ArrayList;
import java.util.List;

//Questions class which contains the each questions relevant atributes
//Each question will have a question a topic that is associated with that question
//Then 3 possible options the user can choose
//The right question is represented by the answer number
public class Question {
    private String question;
    private String topic;
    private String option1;
    private String option2;
    private String option3;
    private int answerNr;

    public  Question(){

    }

    public Question(String question, String topic, String option1, String option2, String option3, int answerNr) {
        this.question = question;
        this.topic = topic;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.answerNr = answerNr;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public int getAnswerNr() {
        return answerNr;
    }

    public void setAnswerNr(int answerNr) {
        this.answerNr = answerNr;
    }

    //mehtod which will return only the relevant questions associated with the topic name
    public static ArrayList<Question> getQuestions(String title, List<Question> array){


        ArrayList<Question> question=new ArrayList<>();
        for(int i=0; i<array.size(); i++){
            if((array.get(i).getTopic()).equals(title)) {
                question.add(array.get(i));
            }
        }


        return question;


    }


}
