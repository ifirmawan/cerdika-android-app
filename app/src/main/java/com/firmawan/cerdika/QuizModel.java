package com.firmawan.cerdika;

public class QuizModel {
    private String quiz;
    private int  id;

    public void setQuiz(String quiz) {
        this.quiz = quiz;
    }

    public void setId(int id)
    {
        this.id=id;
    }
    public String getQuiz()
    {
        return quiz;
    }

    public int getId()
    {
        return id;
    }
}
