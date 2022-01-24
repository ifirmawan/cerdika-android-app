
package com.firmawan.cerdika.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class QuestionPivot {

    @SerializedName("question_id")
    @Expose
    private String questionId;
    @SerializedName("choice_id")
    @Expose
    private String choiceId;
    @SerializedName("score")
    @Expose
    private String score;

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getChoiceId() {
        return choiceId;
    }

    public void setChoiceId(String choiceId) {
        this.choiceId = choiceId;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

}
