package com.firmawan.cerdika;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class LogBookActivity extends AppCompatActivity {
    String[] arrayString = new String[]{
            "Apakah anda sudah menghindari rokok maupun asap rokok?",
            "Apakah anda sudah melakukan olahraga hari ini?",
            "Apakah anda makan sesuai diet yang telah dianjurkan?",
            "Apakah anda tidur selama 7-8 jam tadi malam?",
            "Apakah anda telah mengelola stress anda hari ini?",
            "Apakah anda sudah meminum obat hari ini?"
    };
    QuizModel list;
    ListView listView;
    ArrayList<QuizModel> arrayList = new ArrayList<QuizModel>();
    QuizAdapter adapter;

    ImageView imgPreview;
    Button btnUpload;
    private static final int PICK_IMAGE = 100;
    Uri imageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_book);
        /**
         * List Items
         */
        listView = (ListView) findViewById(R.id.quiz_list);
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
         * Upload Image
         */
        btnUpload = (Button) findViewById(R.id.btn_logbook_upload);
        btnUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openGallery();
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

    private void openGallery() {
        // Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        // startActivityForResult(gallery, PICK_IMAGE);
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == PICK_IMAGE){
            imageUri = data.getData();
            imgPreview = (ImageView) findViewById(R.id.iv_logbook_preview);
            imgPreview.setImageURI(imageUri);
        }
    }
}