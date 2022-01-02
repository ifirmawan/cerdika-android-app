package com.firmawan.cerdika;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.firmawan.cerdika.medicine.MedicineActivity;

public class AddBloodActivity extends AppCompatActivity {
    Button btnSubmit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_blood);

        btnSubmit = (Button) findViewById(R.id.btn_submit_blood);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddBloodActivity.this, BloodEvaluationActivity.class);
                startActivity(intent);
            }
        });
    }
}