package com.firmawan.cerdika;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.firmawan.cerdika.medicine.MedicineActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Random;

public class BloodEvaluationActivity extends AppCompatActivity {
    String[] arrayString = new String[]{"Tanggal", "Sistolik", "Tanggal", "Diastolik"};
    BloodModel list;
    ListView listView;
    ArrayList<BloodModel> arrayList = new ArrayList<BloodModel>();
    BloodAdapter adapter;

    private Button btnChart;
    private FloatingActionButton fabAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood_evaluation);

        Toolbar toolbar = (Toolbar) findViewById(R.id.blood_eval_toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_back_button);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BloodEvaluationActivity.this, DashboardActivity.class);
                startActivity(intent);
            }
        });

        listView = (ListView) findViewById(R.id.blood_pressure_list);

        setHeader();
        setDataFromExtra();

        Resources resources = getResources();
        adapter = new BloodAdapter(this, arrayList, resources);
        listView.setAdapter(adapter);

        btnChart = (Button) findViewById(R.id.btn_blood_chart);
        btnChart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle extras = new Bundle();
                extras.putString("PAGE_FILE","evaluasi_tekanan_darah.html");
                Intent intent = new Intent(BloodEvaluationActivity.this, ArticleActivity.class);
                intent.putExtras(extras);
                startActivity(intent);
            }
        });

        fabAdd = (FloatingActionButton) findViewById(R.id.fab_add_blood_pressure);
        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BloodEvaluationActivity.this, AddBloodActivity.class);
                startActivity(intent);
            }
        });
    }

    public void setHeader() {
        list = new BloodModel();
        list.setBloodDateSistolik(arrayString[0]);
        list.setBloodSistolik(arrayString[1]);
        list.setBloodDateDiastolik(arrayString[2]);
        list.setBloodDiastolik(arrayString[3]);
        arrayList.add(list);
    }

    public void setDataFromExtra(){
        //get the intent in the target activity
        Intent intent = getIntent();
        //get the attached bundle from the intent
        Bundle extras = intent.getExtras();
        //Extracting the stored data from the bundle
        String dateSistolik = extras.getString("DATE_SISTOLIK");
        String dateDiastolik = extras.getString("DATE_DIASTOLIK");
        String sistolik = extras.getString("SISTOLIK");
        String diastolik = extras.getString("DIASTOLIK");
        if (dateDiastolik != null && sistolik != null && dateDiastolik !=null && diastolik != null) {
            list = new BloodModel();
            list.setBloodDateSistolik(dateSistolik);
            list.setBloodSistolik(sistolik+" mmHg");
            list.setBloodDateDiastolik(dateDiastolik);
            list.setBloodDiastolik(diastolik+" mmHg");
            arrayList.add(list);
        }
    }
}