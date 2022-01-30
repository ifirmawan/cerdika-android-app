package com.firmawan.cerdika;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.firmawan.cerdika.model.PatientModel;
import com.firmawan.cerdika.model.ProfileModel;
import com.firmawan.cerdika.utils.SaveSharedPreference;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PatientActivity extends AppCompatActivity {
    private Button btnSubmit;
    private EditText etFullname;
    private EditText etWeight;
    private EditText etHeight;
    private RadioGroup rgOld;
    private RadioGroup rgGender;
    private RadioGroup rgEdu;
    private static final String TAG = "PatientActivity";
    private PatientModel patientModel;
    private ProgressBar pgPatient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient);

        etFullname = (EditText) findViewById(R.id.et_fullname);
        etWeight = (EditText) findViewById(R.id.et_weight);
        etHeight = (EditText) findViewById(R.id.et_height);
        rgOld = (RadioGroup) findViewById(R.id.rg_old);
        rgGender = (RadioGroup) findViewById(R.id.rg_gender);
        rgEdu = (RadioGroup) findViewById(R.id.rg_education);
        pgPatient = (ProgressBar) findViewById(R.id.pgPatient);
        patientModel = new PatientModel();

        rgOld.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int ckOld) {
                switch (ckOld){
                    case R.id.rb_gt_fifty:
                        patientModel.setOld("35<51");
                        break;
                    case R.id.rb_lt_fifty:
                        patientModel.setOld(">50");
                        break;
                }
            }
        });

        rgGender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int ckGen) {
                switch (ckGen){
                    case R.id.rb_male:
                        patientModel.setGender("male");
                        break;
                    case R.id.rb_female:
                        patientModel.setGender("female");
                        break;
                }
            }
        });

        rgEdu.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int ckEdu) {
                switch (ckEdu){
                    case R.id.rb_elementary_school:
                        patientModel.setEducation("SD");
                        break;
                    case R.id.rb_junior_high_school:
                        patientModel.setEducation("SMP");
                        break;
                    case R.id.rb_high_school:
                        patientModel.setEducation("SMA");
                        break;
                    case R.id.rb_academy:
                        patientModel.setEducation("D3/S1");
                        break;
                }
            }
        });

        btnSubmit = this.findViewById(R.id.btn_submit_patient);
        btnSubmit.setOnClickListener((view) -> {

            String[] names = etFullname.getText().toString().split("\\s+");
            patientModel.setFirstName(names[0]);
            if (names.length > 1){
                patientModel.setLastName(names[1]);
            }else{
                patientModel.setLastName(" ");
            }
            patientModel.setWeightBody(Double.valueOf(etWeight.getText().toString()));
            patientModel.setHeightBody(Long.valueOf(etHeight.getText().toString()));

            handleOnUpdateProfile();
        });
    }

    private void handleOnUpdateProfile(){

        pgPatient.setVisibility(View.VISIBLE);
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://secure-brushlands-20308.herokuapp.com")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        RetrofitAPI retrofitAPI = retrofit.create(RetrofitAPI.class);

        Call<ProfileModel> call = retrofitAPI.updateProfilePost("Bearer " + SaveSharedPreference.getHeaderToken(getApplicationContext()), patientModel);
        call.enqueue(new Callback<ProfileModel>() {
            @Override
            public void onResponse(Call<ProfileModel> call, Response<ProfileModel> response) {
                if (response.isSuccessful() && response.code() == 200){
                    pgPatient.setVisibility(View.GONE);
                    Intent intent = new Intent(PatientActivity.this, DashboardActivity.class);
                    startActivity(intent);
                }else{
                    pgPatient.setVisibility(View.GONE);
                    Toast.makeText(PatientActivity.this, "Error! profile not found", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ProfileModel> call, Throwable t) {
                pgPatient.setVisibility(View.GONE);
                Log.d(TAG, "Invalid profile"+t.getMessage());
                Toast.makeText(PatientActivity.this, "Error : " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}