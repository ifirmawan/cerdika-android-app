
package com.firmawan.cerdika.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Choice {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("pivot")
    @Expose
    private QuestionPivot pivot;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public QuestionPivot getPivot() {
        return pivot;
    }

    public void setPivot(QuestionPivot pivot) {
        this.pivot = pivot;
    }

}
