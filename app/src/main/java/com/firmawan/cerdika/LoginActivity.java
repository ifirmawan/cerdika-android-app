package com.firmawan.cerdika;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.firmawan.cerdika.medicine.MedicineActivity;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {
    private Button btnSignUp;
    private Button btnSignIn;
    private TextInputLayout etEmail;
    private TextInputLayout etPassword;
    private static final String TAG = "LoginActivity";
    private ProgressBar loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
    }

    private void init() {
        // Configure Button component
        btnSignUp = this.findViewById(R.id.btn_sign_up);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
        // Configure Button component
        btnSignIn = this.findViewById(R.id.btn_sign_in);
        btnSignIn.setOnClickListener((view) -> {
            handleOnLogin();
        });

    }

    private void handleOnLogin(){
        loading = (ProgressBar) findViewById(R.id.progress_login);
        etEmail = (TextInputLayout) findViewById(R.id.textInputLayoutEmail);
        etPassword = (TextInputLayout) findViewById(R.id.textInputLayoutPassword);

        loading.setVisibility(View.VISIBLE);
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://secure-brushlands-20308.herokuapp.com")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        RetrofitAPI retrofitAPI = retrofit.create(RetrofitAPI.class);

        AccountModel loginData = new AccountModel(etEmail.getEditText().getText().toString(), etPassword.getEditText().getText().toString());
        Call<AccountModel> call = retrofitAPI.loginPost(loginData);
        call.enqueue(new Callback<AccountModel>() {
            @Override
            public void onResponse(Call<AccountModel> call, Response<AccountModel> response) {
                if (response.isSuccessful()){
                    loading.setVisibility(View.GONE);
                    Log.d(TAG, "login success with email: "+response.body().getData().getUser().getEmail());
                    SharedPreferences sharedPref = getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE);
                    SharedPreferences.Editor sharedEdit = sharedPref.edit();

                    sharedEdit.putString("token", response.body().getData().getToken());
                    sharedEdit.commit();
                    Intent intent = new Intent(LoginActivity.this, DashboardActivity.class);
                    startActivity(intent);
                }else{
                    loading.setVisibility(View.GONE);
                    Log.d(TAG, "login failed");
                    Toast.makeText(LoginActivity.this, "Incorrect email or password", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<AccountModel> call, Throwable t) {
                loading.setVisibility(View.GONE);
                Log.d(TAG, "Invalid input"+t.getMessage());
                Toast.makeText(LoginActivity.this, "Error found is : " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}