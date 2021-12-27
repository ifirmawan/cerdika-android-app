package com.firmawan.cerdika;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.GridView;
import android.widget.RelativeLayout;

import com.firmawan.cerdika.medicine.MedicineActivity;

public class DashboardActivity extends AppCompatActivity {
    private RelativeLayout rlAlarm;
    private RelativeLayout rlHealthCheck;
    private RelativeLayout rlNoSmoking;
    private RelativeLayout rlDoingExercise;
    private RelativeLayout rlDoingDiet;
    private RelativeLayout rlTakeARest;
    private  RelativeLayout rlStressControl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        Toolbar toolbar = (Toolbar) findViewById(R.id.dashboard_toolbar);
        setSupportActionBar(toolbar);
        toolbar.showOverflowMenu();

        rlAlarm = findViewById(R.id.rl_alarm);
        rlAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DashboardActivity.this, MedicineActivity.class);
                startActivity(intent);
            }
        });

        // Cek Kesehatan
        rlHealthCheck = (RelativeLayout) findViewById(R.id.rl_health_check);
        rlHealthCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle extras = new Bundle();
                extras.putString("PAGE_FILE","cek_kesehatan.html");
                Intent intent = new Intent(DashboardActivity.this, ArticleActivity.class);
                intent.putExtras(extras);
                startActivity(intent);
            }
        });

        // Enyakan Asap Rokok
        rlNoSmoking = (RelativeLayout) findViewById(R.id.rl_no_smoking);
        rlNoSmoking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle extras = new Bundle();
                extras.putString("PAGE_FILE","enyahkan_asap_rokok.html");
                Intent intent = new Intent(DashboardActivity.this, ArticleActivity.class);
                intent.putExtras(extras);
                startActivity(intent);
            }
        });

        // Rajin aktivitas Fisik
        rlDoingExercise = (RelativeLayout) findViewById(R.id.rl_doing_exercise);
        rlDoingExercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle extras = new Bundle();
                extras.putString("PAGE_FILE","rajin_aktivitas_fisik.html");
                Intent intent = new Intent(DashboardActivity.this, ArticleActivity.class);
                intent.putExtras(extras);
                startActivity(intent);
            }
        });

        // Diet Seimbang
        rlDoingDiet = (RelativeLayout) findViewById(R.id.rl_doing_diet);
        rlDoingDiet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle extras = new Bundle();
                extras.putString("PAGE_FILE","diet_seimbang.html");
                Intent intent = new Intent(DashboardActivity.this, ArticleActivity.class);
                intent.putExtras(extras);
                startActivity(intent);
            }
        });

        // Istirahat Cukup
        rlTakeARest = (RelativeLayout) findViewById(R.id.rl_take_a_rest);
        rlTakeARest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle extras = new Bundle();
                extras.putString("PAGE_FILE","istirahat_yang_cukup.html");
                Intent intent = new Intent(DashboardActivity.this, ArticleActivity.class);
                intent.putExtras(extras);
                startActivity(intent);
            }
        });

        // Kelola Stress
        rlStressControl = (RelativeLayout) findViewById(R.id.rl_stress_control);
        rlStressControl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle extras = new Bundle();
                extras.putString("PAGE_FILE","kelola_stress.html");
                Intent intent = new Intent(DashboardActivity.this, ArticleActivity.class);
                intent.putExtras(extras);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.cerdika_menu, menu);
        return true;
    }
}