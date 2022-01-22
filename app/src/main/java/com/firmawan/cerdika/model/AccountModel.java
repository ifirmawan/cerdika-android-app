
package com.firmawan.cerdika.model;

import java.io.Serializable;

import com.firmawan.cerdika.Data;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class AccountModel implements Serializable
{
    @SerializedName("email")
    String email;

    @SerializedName("password")
    String password;

    @SerializedName("status")
    @Expose
    private String status;

    @SerializedName("data")
    @Expose
    private Data data;

    public AccountModel(String email, String password){
        this.email = email;
        this.password = password;
    }

    private final static long serialVersionUID = 4792790218001841476L;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

}
