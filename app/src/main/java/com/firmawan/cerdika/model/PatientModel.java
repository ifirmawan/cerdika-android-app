package com.firmawan.cerdika.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class PatientModel  implements Serializable {
    @SerializedName("first_name")
    @Expose
    private String firstName;
    @SerializedName("last_name")
    @Expose
    private String lastName;
    @SerializedName("old")
    @Expose
    private String old;
    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("education")
    @Expose
    private String education;
    @SerializedName("height_body")
    @Expose
    private Long heightBody;
    @SerializedName("weight_body")
    @Expose
    private Double weightBody;
    private final static long serialVersionUID = -3384681986457683620L;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getOld() {
        return old;
    }

    public void setOld(String old) {
        this.old = old;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public Long getHeightBody() {
        return heightBody;
    }

    public void setHeightBody(Long heightBody) {
        this.heightBody = heightBody;
    }

    public Double getWeightBody() {
        return weightBody;
    }

    public void setWeightBody(Double weightBody) {
        this.weightBody = weightBody;
    }
}
