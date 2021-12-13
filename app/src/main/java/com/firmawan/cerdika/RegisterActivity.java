package com.firmawan.cerdika;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RegisterActivity extends AppCompatActivity {
    private Button btnSignIn;
    private Button btnSignUp;
    private EditText emailEdit, passwordEdit;
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
        loadingPB = findViewById(R.id.idLoadingPB);
        btnSignIn = this.findViewById(R.id.btn_sign_in);
        //btnSignIn.setOnClickListener((view) -> {
          //  Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
            //startActivity(intent);
        //});

        btnSignUp = this.findViewById(R.id.btn_sign_up_submit);
        btnSignUp.setOnClickListener((view -> {
            if (emailEdit.getText().toString().isEmpty() && emailEdit.getText().toString().isEmpty()) {
                Toast.makeText(RegisterActivity.this, "Please enter both the values", Toast.LENGTH_SHORT).show();
                return;
            }
            // calling a method to post the data and passing our name and job.
            postData(emailEdit.getText().toString(), passwordEdit.getText().toString());
        }));
    }

    private void postData(String email, String password) {

        // below line is for displaying our progress bar.
        loadingPB.setVisibility(View.VISIBLE);

        // on below line we are creating a retrofit
        // builder and passing our base url
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://paman.app/")
                // as we are sending data in json format so
                // we have to add Gson converter factory
                .addConverterFactory(GsonConverterFactory.create())
                // at last we are building our retrofit builder.
                .build();
        // below line is to create an instance for our retrofit api class.
        RetrofitAPI retrofitAPI = retrofit.create(RetrofitAPI.class);

        // passing data from our text fields to our modal class.
        UserModel modal = new UserModel("android test",email, password, password);

        // calling a method to create a post and passing our modal class.
        Call<UserModel> call = retrofitAPI.createPost(modal);

        // on below line we are executing our method.
        call.enqueue(new Callback<UserModel>() {
            @Override
            public void onResponse(Call<UserModel> call, Response<UserModel> response) {

                // below line is for hiding our progress bar.
                loadingPB.setVisibility(View.GONE);

                // on below line we are setting empty text
                // to our both edit text.
                emailEdit.setText("");
                passwordEdit.setText("");

                // we are getting response from our body
                // and passing it to our modal class.
                UserModel responseFromAPI = response.body();

                // on below line we are getting our data from modal class and adding it to our string.
                String responseString = "Response Code : " + response.code() + "\nEmail : ";
                Toast.makeText(RegisterActivity.this, responseString, Toast.LENGTH_SHORT).show();

                if (response.code() == 201) {
                    Intent intent = new Intent(RegisterActivity.this, DashboardActivity.class);
                    startActivity(intent);
                }
            }

            @Override
            public void onFailure(Call<UserModel> call, Throwable t) {
                // setting text to our text view when
                // we get error response from API.
                Toast.makeText(RegisterActivity.this, "Error found is : " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}