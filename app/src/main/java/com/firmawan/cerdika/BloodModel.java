package com.firmawan.cerdika;

public class BloodModel {
    private String bloodDateSistolik;
    private String bloodDateDiastolik;
    private String bloodSistolik;
    private String bloodDiastolik;

    public void setBloodDateSistolik(String date) {
        this.bloodDateSistolik = date;
    }

    public void setBloodDateDiastolik(String date) {
        this.bloodDateDiastolik = date;
    }

    public void setBloodSistolik(String sistolik)
    {
        this.bloodSistolik=sistolik;
    }
    public void setBloodDiastolik(String diastolik)
    {
        this.bloodDiastolik=diastolik;
    }

    public String getBloodDateSistolik()
    {
        return bloodDateSistolik;
    }

    public String getBloodDateDiastolik()
    {
        return bloodDateDiastolik;
    }

    public String getSistolik()
    {
        return bloodSistolik;
    }

    public String getDiastolik()
    {
        return bloodDiastolik;
    }
}
