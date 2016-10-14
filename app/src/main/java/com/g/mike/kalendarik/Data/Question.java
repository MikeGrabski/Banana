package com.g.mike.kalendarik.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by iosuser12 on 10/14/16.
 */
public class Question {
    private String question;
    private List<String> answers = new ArrayList<>();

    public Question(String question, List<String> answers) {
        this.question = question;
        if (answers.size() <= 5) {
            this.answers = answers;
        }
    }
    public Question(String question) {
        this.question = question;
    }
    public Boolean addAnswer(String answer){
        if(answers.size()<5){
            answers.add(answer);
            return true;
        }
        else return false;
    }

    public List<String> getAnswers() {
        return answers;
    }
    public static Question[] buildQuestionArray(char language){
        Question[] questions = new Question[365];
        String[] questionStrings = Questions365.getQuestions(language);
        for(int i = 0 ; i < 365; i ++){
            questions[i] = new Question(questionStrings[i]);
        }
        return questions;
    }
}
