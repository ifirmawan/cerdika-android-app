package com.firmawan.cerdika;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class PatientActivity extends AppCompatActivity {
    private Button btnSubmit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient);

        btnSubmit = this.findViewById(R.id.btn_submit_patient);
        btnSubmit.setOnClickListener((view) -> {
            Intent intent = new Intent(PatientActivity.this, DashboardActivity.class);
            startActivity(intent);
        });
    }
}