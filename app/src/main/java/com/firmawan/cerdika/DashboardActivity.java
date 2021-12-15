package com.firmawan.cerdika;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.RelativeLayout;

import com.firmawan.cerdika.medicine.MedicineActivity;

public class DashboardActivity extends AppCompatActivity {
    private RelativeLayout rlAlarm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        rlAlarm = findViewById(R.id.rl_alarm);
        rlAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DashboardActivity.this, MedicineActivity.class);
                startActivity(intent);
            }
        });
    }
}