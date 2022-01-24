package com.firmawan.cerdika;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.firmawan.cerdika.medicine.MedicineActivity;
import com.firmawan.cerdika.utils.BloodSharedPreferences;

import java.util.Calendar;

public class AddBloodActivity extends AppCompatActivity {
    DatePickerDialog picker;
    EditText dateSistolik;
    EditText dateDiastolik;
    EditText sistolik;
    EditText diastolik;
    Button btnSubmit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_blood);

        dateSistolik = (EditText) findViewById(R.id.et_sistolik_date);
        dateDiastolik = (EditText) findViewById(R.id.et_diastolik_date);
        sistolik = (EditText) findViewById(R.id.et_sistolik_value);
        diastolik = (EditText) findViewById(R.id.et_diastolik_value);

        btnSubmit = (Button) findViewById(R.id.btn_submit_blood);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BloodSharedPreferences.setBloodMeasure(
                        getApplicationContext(),
                        Integer.valueOf(sistolik.getText().toString()),
                        Integer.valueOf(diastolik.getText().toString()),
                        dateSistolik.getText().toString(),
                        dateDiastolik.getText().toString()
                );
                Intent intent = new Intent(AddBloodActivity.this, BloodMeasureActivity.class);
                startActivity(intent);
            }
        });
        /**
         * Sistolik
         */

        dateSistolik.setInputType(InputType.TYPE_NULL);
        dateSistolik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                // date picker dialog
                picker = new DatePickerDialog(AddBloodActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                dateSistolik.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                            }
                        }, year, month, day);
                picker.show();
            }
        });

        /**
         * Diastolik
         */

        dateDiastolik.setInputType(InputType.TYPE_NULL);
        dateDiastolik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                // date picker dialog
                picker = new DatePickerDialog(AddBloodActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                dateDiastolik.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                            }
                        }, year, month, day);
                picker.show();
            }
        });
    }
}