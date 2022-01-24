
package com.firmawan.cerdika.model;

import java.io.Serializable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data implements Serializable
{

    @SerializedName("token")
    @Expose
    private String token;

    @SerializedName("user")
    @Expose
    private User user;

    @SerializedName("message")
    @Expose
    private String message;

    private final static long serialVersionUID = 3076660452769303607L;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
