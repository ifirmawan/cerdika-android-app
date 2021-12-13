package com.firmawan.cerdika;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class RegisterActivity extends AppCompatActivity {
    private Button btnSignIn;
    private Button btnSignUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        init();
    }

    private void init(){
        btnSignIn = this.findViewById(R.id.btn_sign_in);
        btnSignIn.setOnClickListener((view) -> {
            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
            startActivity(intent);
        });

        btnSignUp = this.findViewById(R.id.btn_sign_up_submit);
        btnSignUp.setOnClickListener((view -> {
            Intent intent = new Intent(RegisterActivity.this, DashboardActivity.class);
            startActivity(intent);
        }));
    }
}