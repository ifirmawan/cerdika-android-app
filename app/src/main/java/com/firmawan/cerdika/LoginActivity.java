package com.firmawan.cerdika;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.firmawan.cerdika.medicine.MedicineActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {
    private Button btnSignUp;
    private Button btnSignIn;
    private Button donThaveAnAccounButton;
    private TextView welcomBackLogInTextView;
    private TextView emailAddressTextView;
    private TextView passwordTextView;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        //updateUI(currentUser);
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
            Intent intent = new Intent(LoginActivity.this, MedicineActivity.class);
            startActivity(intent);
        });

        // Configure Don't have an accoun component
        donThaveAnAccounButton = this.findViewById(R.id.dont_have_an_account_button);
        donThaveAnAccounButton.setOnClickListener((view) -> {
            this.onDonTHaveAnAccounPressed();
        });

        // Configure Welcom back. Log in component
        welcomBackLogInTextView = this.findViewById(R.id.welcom_back_log_in_text_view);

        // Configure Email Address component
        emailAddressTextView = this.findViewById(R.id.email_address_text_view);

        // Configure Password component
        passwordTextView = this.findViewById(R.id.password_text_view);
    }

    public void onButtonTwoPressed() {

    }

    public void onButtonPressed() {

    }

    public void onDonTHaveAnAccounPressed() {

    }
}