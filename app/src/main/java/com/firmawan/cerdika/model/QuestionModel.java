
package com.firmawan.cerdika.model;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class QuestionModel {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("data")
    @Expose
    private List<QuestionDatum> data = null;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<QuestionDatum> getData() {
        return data;
    }

    public void setData(List<QuestionDatum> data) {
        this.data = data;
    }

}
