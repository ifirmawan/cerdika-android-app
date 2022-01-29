package com.firmawan.cerdika;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class RecommendActivity extends AppCompatActivity {
    private RecommendAdapter mAdapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommend);

        /**
         * List Items
         */
        listView = (ListView) findViewById(R.id.lvRecommend);

        mAdapter = new RecommendAdapter(this);
        mAdapter.addSectionHeaderItem("Farmakologi");
        mAdapter.addItem("Obat Anti Hipertensi");
        mAdapter.addSectionHeaderItem("Non Farmakologi");
        mAdapter.addItem("Slow Deep Breathing");
        mAdapter.addItem("Aroma Terapi");
        mAdapter.addItem("Relaksasi Benson");
        mAdapter.addItem("Murottal Al-qur’an");
        mAdapter.addItem("Terapi Musik");
        mAdapter.addItem("Senam Hipertensi");
        mAdapter.addItem("Senam Ergonomis");
        mAdapter.addItem("Mengkonsumsi Susu Kedelai");
        mAdapter.addItem("Mengkonsumsi Mentimun");
        listView.setAdapter(mAdapter);
        ListHelper.getListViewSize(listView);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Bundle extras = new Bundle();
                extras.putString("PAGE_FILE","rekomendasi_"+l+".html");
                Intent intent = new Intent(RecommendActivity.this, ArticleActivity.class);
                intent.putExtras(extras);
                startActivity(intent);
            }
        });
    }
}