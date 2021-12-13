package com.firmawan.cerdika;

public class UserModel {
    private String name;
    private String email;
    private String password;
    private String password_confirmation;

    public UserModel(String name,String email, String password, String password_confirmation) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.password_confirmation = password_confirmation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPasswordConfirmation(String password_confirmation) {
        this.password_confirmation = password_confirmation;
    }
}
