package com.firmawan.cerdika;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.firmawan.cerdika.medicine.MedicineActivity;

public class HypertensionActivity extends AppCompatActivity {
    private RelativeLayout rlHyDesc;
    private RelativeLayout rlHyCaused;
    private RelativeLayout rlHySymptom;
    private RelativeLayout rlHyClasify;
    private RelativeLayout rlHyComplication;
    private  RelativeLayout rlHyHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hypertension);
        // Pengertian
        rlHyDesc = (RelativeLayout) findViewById(R.id.rl_hypertension_desc);
        rlHyDesc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle extras = new Bundle();
                extras.putString("PAGE_FILE","hypertension_desc.html");
                Intent intent = new Intent(HypertensionActivity.this, ArticleActivity.class);
                intent.putExtras(extras);
                startActivity(intent);
            }
        });

        // Penyebab
        rlHyCaused = (RelativeLayout) findViewById(R.id.rl_hypertension_caused);
        rlHyCaused.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle extras = new Bundle();
                extras.putString("PAGE_FILE","hypertension_caused.html");
                Intent intent = new Intent(HypertensionActivity.this, ArticleActivity.class);
                intent.putExtras(extras);
                startActivity(intent);
            }
        });

        // Gejala
        rlHySymptom = (RelativeLayout) findViewById(R.id.rl_hypertension_symptom);
        rlHySymptom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle extras = new Bundle();
                extras.putString("PAGE_FILE","hypertension_symptom.html");
                Intent intent = new Intent(HypertensionActivity.this, ArticleActivity.class);
                intent.putExtras(extras);
                startActivity(intent);
            }
        });

        // Klasifikasi
        rlHyClasify = (RelativeLayout) findViewById(R.id.rl_hypertension_clasify);
        rlHyClasify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle extras = new Bundle();
                extras.putString("PAGE_FILE","hypertension_clasification.html");
                Intent intent = new Intent(HypertensionActivity.this, ArticleActivity.class);
                intent.putExtras(extras);
                startActivity(intent);
            }
        });

        // Komplikasi
        rlHyComplication = (RelativeLayout) findViewById(R.id.rl_hypertension_complication);
        rlHyComplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle extras = new Bundle();
                extras.putString("PAGE_FILE","hypertension_complication.html");
                Intent intent = new Intent(HypertensionActivity.this, ArticleActivity.class);
                intent.putExtras(extras);
                startActivity(intent);
            }
        });

        // Penanganan
        rlHyHandler = (RelativeLayout) findViewById(R.id.rl_hypertension_handler);
        rlHyHandler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle extras = new Bundle();
                extras.putString("PAGE_FILE","hypertension_handler.html");
                Intent intent = new Intent(HypertensionActivity.this, ArticleActivity.class);
                intent.putExtras(extras);
                startActivity(intent);
            }
        });
    }
}