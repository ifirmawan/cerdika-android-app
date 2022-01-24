
package com.firmawan.cerdika.model;

import java.io.Serializable;

import com.firmawan.cerdika.model.DataProfile;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProfileModel implements Serializable
{
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("data")
    @Expose
    private DataProfile data;
    private final static long serialVersionUID = -30749811612640460L;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public DataProfile getData() {
        return data;
    }

    public void setData(DataProfile data) {
        this.data = data;
    }

}
