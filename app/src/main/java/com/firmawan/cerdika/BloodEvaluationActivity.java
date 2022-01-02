package com.firmawan.cerdika;

import androidx.appcompat.app.AppCompatActivity;

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
    String[] arrayString = new String[]{"12/01/2021", "11/02/2021", "20/03/2021", "05/04/2021", "15/05/2021", "28/06/2021"};
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
        listView = (ListView) findViewById(R.id.blood_pressure_list);
        setData();
        Resources resources = getResources();
        adapter = new BloodAdapter(this, arrayList, resources);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), list.getCompanyname() + "\n" + list.getid(), Toast.LENGTH_SHORT).show();
            }
        });

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

    public void setData() {
        for (int i = 0; i <= arrayString.length - 1; i++) {
            list = new BloodModel();
            list.setCompanyName(arrayString[i]);
            list.setName(getRandomValue()+" mmHg");
            arrayList.add(list);
        }
    }

    public int getRandomValue() {
        int[] values = new int[]{150,100, 80, 90, 65,77};
        //initialization
        Random generator = new Random();
        int randomIndex = generator.nextInt(values.length);
        return values[randomIndex];
    }
}