package com.firmawan.cerdika;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import com.firmawan.cerdika.model.ProfileModel;
import com.firmawan.cerdika.utils.SaveSharedPreference;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PatientActivity extends AppCompatActivity {
    private Button btnSubmit;
    private static final String TAG = "PatientActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient);

        handleOnLoadProfile();

        btnSubmit = this.findViewById(R.id.btn_submit_patient);
        btnSubmit.setOnClickListener((view) -> {
            Intent intent = new Intent(PatientActivity.this, DashboardActivity.class);
            startActivity(intent);
        });
    }

    private void handleOnLoadProfile(){
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://secure-brushlands-20308.herokuapp.com")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        RetrofitAPI retrofitAPI = retrofit.create(RetrofitAPI.class);

        Call<ProfileModel> call = retrofitAPI.profileGet("Bearer " + SaveSharedPreference.getHeaderToken(getApplicationContext()));
        call.enqueue(new Callback<ProfileModel>() {
            @Override
            public void onResponse(Call<ProfileModel> call, Response<ProfileModel> response) {
                if (response.isSuccessful() && response.code() == 200){
                    Log.d(TAG, "Message: "+response.body().getData().getEmail());
                }else{
                    Toast.makeText(PatientActivity.this, "Error! profile not found", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ProfileModel> call, Throwable t) {

                Log.d(TAG, "Invalid profile"+t.getMessage());
                Toast.makeText(PatientActivity.this, "Error : " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}