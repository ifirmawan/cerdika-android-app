
package com.firmawan.cerdika.model;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Membership implements Serializable
{

    @SerializedName("id")
    @Expose
    private Long id;
    @SerializedName("uuid")
    @Expose
    private String uuid;
    @SerializedName("first_name")
    @Expose
    private String firstName;
    @SerializedName("last_name")
    @Expose
    private String lastName;
    @SerializedName("gender")
    @Expose
    private Object gender;
    @SerializedName("verified")
    @Expose
    private Boolean verified;
    @SerializedName("old")
    @Expose
    private Object old;
    @SerializedName("education")
    @Expose
    private Object education;
    @SerializedName("height_body")
    @Expose
    private Object heightBody;
    @SerializedName("weight_body")
    @Expose
    private Object weightBody;
    @SerializedName("image_url")
    @Expose
    private Object imageUrl;
    @SerializedName("identities")
    @Expose
    private List<Object> identities = null;
    private final static long serialVersionUID = 2835311565992298483L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

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

    public Object getGender() {
        return gender;
    }

    public void setGender(Object gender) {
        this.gender = gender;
    }

    public Boolean getVerified() {
        return verified;
    }

    public void setVerified(Boolean verified) {
        this.verified = verified;
    }

    public Object getOld() {
        return old;
    }

    public void setOld(Object old) {
        this.old = old;
    }

    public Object getEducation() {
        return education;
    }

    public void setEducation(Object education) {
        this.education = education;
    }

    public Object getHeightBody() {
        return heightBody;
    }

    public void setHeightBody(Object heightBody) {
        this.heightBody = heightBody;
    }

    public Object getWeightBody() {
        return weightBody;
    }

    public void setWeightBody(Object weightBody) {
        this.weightBody = weightBody;
    }

    public Object getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(Object imageUrl) {
        this.imageUrl = imageUrl;
    }

    public List<Object> getIdentities() {
        return identities;
    }

    public void setIdentities(List<Object> identities) {
        this.identities = identities;
    }

}
