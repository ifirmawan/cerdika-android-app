package com.firmawan.cerdika;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.firmawan.cerdika.utils.BloodSharedPreferences;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class BloodMeasureActivity extends AppCompatActivity {
    private TextView tvSistolik;
    private TextView tvDiastolik;
    private TextView tvRecommendation;
    private TextView tvSisDate;
    private TextView tvDiasDate;
    private FloatingActionButton fabAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood_measure);

        Toolbar toolbar = (Toolbar) findViewById(R.id.blood_measure_toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_back_button);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BloodMeasureActivity.this, DashboardActivity.class);
                startActivity(intent);
            }
        });

        tvSistolik = (TextView) findViewById(R.id.tvSisValue);
        tvDiastolik= (TextView) findViewById(R.id.tvDiasValue);
        tvSisDate = (TextView) findViewById(R.id.tvSisDate);
        tvDiasDate = (TextView) findViewById(R.id.tvDiasDate);
        tvRecommendation = (TextView) findViewById(R.id.tvRecommendation);


        Integer sistolik = BloodSharedPreferences.getSistolik(getApplicationContext());
        Integer diastolik = BloodSharedPreferences.getDiastolik(getApplicationContext());
        String sistolikDate = BloodSharedPreferences.getSistolikDate(getApplicationContext());
        String diastolikDate = BloodSharedPreferences.getDiastolikDate(getApplicationContext());

        String recommendation = "Belum ada rekomendasi";
        if ((sistolik >= 120 && sistolik <= 139) && (diastolik >= 80 && diastolik <=89)) {
            recommendation = "Lanjutkan terapi farmakologi dari dokter, dan lakukan terapi musik dan aromaterapi";
        } else if ((sistolik >= 140 && sistolik <= 149) && (diastolik >= 90 && diastolik <= 99)) {
            recommendation = "Lanjutkan terapi farmakologi dari dokter, murothal al-qur’an, terapi musik, senam ergonomis";
        } else if ((sistolik >= 150 && sistolik <= 159) &&  (diastolik >= 90 && diastolik <= 99)) {
            recommendation = "Lanjutkan terapi farmakologi dari dokter, slow deep breathing, senam hipertensi, susu kacang kedelai";
        } else if((sistolik >= 160 && sistolik <= 179) && (diastolik >= 100 && diastolik <= 199)){
            recommendation = "Lanjutkan terapi farmakologi dari dokter, jus mentimun/sari mentimun, susu kacang kedelai, relaksasi benson";
        } else if((sistolik > 180 && diastolik > 120)) {
            recommendation = "Konsultasikan terapi farmakologi ke dokter, batasi konsumsi makanan tinggi garam dan lemak, jus mentimun/sari mentimun, susu kacang kedelai";
        }

        tvSistolik.setText(String.valueOf(sistolik)+ " mmHg");
        tvDiastolik.setText(String.valueOf(diastolik)+ " mmHg");
        tvSisDate.setText(sistolikDate);
        tvDiasDate.setText(diastolikDate);
        tvRecommendation.setText(recommendation);

        fabAdd = (FloatingActionButton) findViewById(R.id.fabAddBloodMeasure);
        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BloodMeasureActivity.this, AddBloodActivity.class);
                startActivity(intent);
            }
        });
    }
}