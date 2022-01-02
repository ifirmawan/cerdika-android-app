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
import android.widget.Toast;

import java.util.ArrayList;

public class QuizActivity extends AppCompatActivity {
    String[] arrayString = new String[]{
            "Pernahkah anda lupa minum obat?",
            "Dalam 2 minggu terakhir, apakah anda pernah tidak minum obat?",
            "Pernahkah anda mengurangi atau berhenti minum obat tanpa sepengetahuan dokter karena anda merasa obat yang diberikan membuat keadaan anda menjadi lebih buruk?",
            "Pernahkah anda lupa membawa obat ketika bepergian?",
            "Apakah anda masih minum obat kemarin?",
            "Apakah anda berhenti minum obat ketika anda merasa gejala yang dialami telah teratasi?",
            "Meminum obat setiap hari merupakan sesuatu ketidaknyamanan untuk beberapa orang. Apakah anda merasa terganggu harus minum obat setiap hari?",
            "Berapa sering anda lupa minum obat?"
    };
    QuizModel list;
    ListView listView;
    ArrayList<QuizModel> arrayList = new ArrayList<QuizModel>();
    QuizAdapter adapter;

    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        Toolbar toolbar = (Toolbar) findViewById(R.id.quiz_toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_back_button);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuizActivity.this, DashboardActivity.class);
                startActivity(intent);
            }
        });

        /**
         * List Items
         */
        listView = (ListView) findViewById(R.id.quiz_medicine_list);
        setData();
        Resources resources = getResources();
        adapter = new QuizAdapter(this, arrayList, resources);
        listView.setAdapter(adapter);
        ListHelper.getListViewSize(listView);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), list.getQuiz() + "\n" + list.getId(), Toast.LENGTH_SHORT).show();
            }
        });
        /**
         * Submit Data
         */
        btnSubmit = (Button) findViewById(R.id.btn_quiz_submit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(QuizActivity.this, DashboardActivity.class);
                startActivity(intent);
            }
        });
    }

    public void setData() {
        for (int i = 0; i <= arrayString.length - 1; i++) {
            list = new QuizModel();
            list.setQuiz(arrayString[i]);
            list.setId(i);
            arrayList.add(list);
        }
    }
}