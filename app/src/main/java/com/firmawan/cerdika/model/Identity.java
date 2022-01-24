
package com.firmawan.cerdika.model;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Identity implements Serializable
{

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("member_id")
    @Expose
    private Integer memberId;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("document")
    @Expose
    private String document;
    @SerializedName("number")
    @Expose
    private Object number;
    @SerializedName("verified")
    @Expose
    private Boolean verified;
    @SerializedName("image_url")
    @Expose
    private String imageUrl;
    private final static long serialVersionUID = -8913471887156293013L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public Object getNumber() {
        return number;
    }

    public void setNumber(Object number) {
        this.number = number;
    }

    public Boolean getVerified() {
        return verified;
    }

    public void setVerified(Boolean verified) {
        this.verified = verified;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

}
