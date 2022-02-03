package com.firmawan.cerdika;


import com.firmawan.cerdika.model.AccountModel;
import com.firmawan.cerdika.model.LogoutModel;
import com.firmawan.cerdika.model.NewAccountModel;
import com.firmawan.cerdika.model.PatientModel;
import com.firmawan.cerdika.model.ProfileModel;
import com.firmawan.cerdika.model.UserModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface RetrofitAPI {

    // as we are making a post request to post a data
    // so we are annotating it with post
    // and along with that we are passing a parameter as users
    @POST("/api/membership/register")
    Call<NewAccountModel> registerPost(@Body NewAccountModel newAccountModel);

    @POST("/api/membership/login")
    Call<AccountModel> loginPost(@Body AccountModel accountModel);

    @GET("/api/membership/logout")
    Call<LogoutModel> logoutGet(@Header("Authorization") String authHeader);

    @GET("/api/membership")
    Call<ProfileModel> profileGet(@Header("Authorization") String authHeader);

    @POST("/api/membership/update")
    Call<ProfileModel> updateProfilePost(@Header("Authorization") String authHeader, @Body PatientModel patientModel);
}