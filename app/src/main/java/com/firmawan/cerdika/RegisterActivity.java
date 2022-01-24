package com.firmawan.cerdika;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.firmawan.cerdika.model.NewAccountModel;
import com.firmawan.cerdika.utils.SaveSharedPreference;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RegisterActivity extends AppCompatActivity {
    private Button btnSignIn;
    private Button btnSignUp;
    private EditText emailEdit, passwordEdit, passwordConfirmEdit;
    private ProgressBar loadingPB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        init();
    }

    private void init(){
        emailEdit = this.findViewById(R.id.email_edit_text);
        passwordEdit = this.findViewById(R.id.password_edit_text);
        passwordConfirmEdit = this.findViewById(R.id.password_confirm_edit_text);
        loadingPB = findViewById(R.id.idLoadingPB);
        btnSignIn = this.findViewById(R.id.btn_sign_in);
        btnSignIn.setOnClickListener((view) -> {
            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
            startActivity(intent);
        });

        btnSignUp = this.findViewById(R.id.btn_sign_up_submit);
        btnSignUp.setOnClickListener((view -> {
            if (emailEdit.getText().toString().isEmpty() && emailEdit.getText().toString().isEmpty()) {
                Toast.makeText(RegisterActivity.this, "Please enter both the values", Toast.LENGTH_SHORT).show();
                return;
            }
            // calling a method to post the data and passing our name and job.
            postData(emailEdit.getText().toString(), passwordEdit.getText().toString(), passwordConfirmEdit.getText().toString());
            // Intent intent = new Intent(RegisterActivity.this, PatientActivity.class);
            // startActivity(intent);
        }));
    }

    private void postData(String email, String password, String passwordConfirm) {
        // below line is for displaying our progress bar.
        loadingPB.setVisibility(View.VISIBLE);
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://secure-brushlands-20308.herokuapp.com")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        RetrofitAPI retrofitAPI = retrofit.create(RetrofitAPI.class);
        // passing data from our text fields to our modal class.
        NewAccountModel newAccount = new NewAccountModel("cerdika user", email, password, passwordConfirm);

        // calling a method to create a post and passing our modal class.
        Call<NewAccountModel> call = retrofitAPI.registerPost(newAccount);

        // on below line we are executing our method.
        call.enqueue(new Callback<NewAccountModel>() {
            @Override
            public void onResponse(Call<NewAccountModel> call, Response<NewAccountModel> response) {
                // below line is for hiding our progress bar.
                loadingPB.setVisibility(View.GONE);
                // on below line we are setting empty text
                // to our both edit text.
                emailEdit.setText("");
                passwordEdit.setText("");
                // on below line we are getting our data from modal class and adding it to our string.
                if (response.code() == 201) {
                    SaveSharedPreference.setLoggedIn(getApplicationContext(), true, response.body().getData().getToken());
                    Intent intent = new Intent(RegisterActivity.this, PatientActivity.class);
                    startActivity(intent);
                }else{
                    String responseString = "Response Code : " + response.code();
                    Toast.makeText(RegisterActivity.this, responseString, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<NewAccountModel> call, Throwable t) {
                // setting text to our text view when
                // we get error response from API.
                Toast.makeText(RegisterActivity.this, "Error found is : " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}