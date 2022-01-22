package com.firmawan.cerdika.model;

import com.google.gson.annotations.SerializedName;

public class NewAccountModel extends  AccountModel {
    @SerializedName("name")
    String name;

    @SerializedName("password_confirmation")
    String password_confirmation;

    public  NewAccountModel(String name, String email, String password, String password_confirmation){
        super(email, password);
        this.name = name;
        this.password_confirmation = password_confirmation;
    }
}
