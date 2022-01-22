package com.firmawan.cerdika;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.firmawan.cerdika.medicine.MedicineActivity;
import com.firmawan.cerdika.model.AccountModel;
import com.firmawan.cerdika.model.LogoutModel;
import com.google.android.material.textfield.TextInputLayout;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DashboardActivity extends AppCompatActivity {
    private RelativeLayout rlAlarm;
    private RelativeLayout rlHealthCheck;
    private RelativeLayout rlNoSmoking;
    private RelativeLayout rlDoingExercise;
    private RelativeLayout rlDoingDiet;
    private RelativeLayout rlTakeARest;
    private  RelativeLayout rlStressControl;
    private static final String TAG = "DashboardActivity";

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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.menu_hypertension:
                Intent intent = new Intent(DashboardActivity.this, HypertensionActivity.class);
                startActivity(intent);
                return true;
            case R.id.menu_blood_eval:
                Bundle extras = new Bundle();
                extras.putString("DATE_SISTOLIK",null);
                extras.putString("SISTOLIK",null);
                extras.putString("DATE_DIASTOLIK",null);
                extras.putString("DIASTOLIK",null);
                Intent intentBlood = new Intent(DashboardActivity.this, BloodEvaluationActivity.class);
                intentBlood.putExtras(extras);
                startActivity(intentBlood);
                return true;
            case R.id.menu_logbook:
                Intent intentLogbook = new Intent(DashboardActivity.this, LogBookActivity.class);
                startActivity(intentLogbook);
                return true;
            case R.id.menu_medicine_eval:
                Intent intentMedEval = new Intent(DashboardActivity.this, QuizActivity.class);
                startActivity(intentMedEval);
                return true;
            case R.id.menu_patient:
                Intent intentPatient = new Intent(DashboardActivity.this, PatientActivity.class);
                startActivity(intentPatient);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onBackPressed() {
        // Here you want to show the user a dialog box
        new AlertDialog.Builder(DashboardActivity.this)
                .setTitle("Exiting the App")
                .setMessage("Are you sure?")
                .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        // The user wants to leave - so dismiss the dialog and exit
                        SaveSharedPreference.setLoggedIn(getApplicationContext(), false, "null");
                        handleOnLogout();
                        finish();
                        dialog.dismiss();
                    }
                }).setNegativeButton("NO", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                // The user is not sure, so you can exit or just stay
                dialog.dismiss();
            }
        }).show();

    }

    private void handleOnLogout(){
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://secure-brushlands-20308.herokuapp.com")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        RetrofitAPI retrofitAPI = retrofit.create(RetrofitAPI.class);

        Call<LogoutModel> call = retrofitAPI.logoutGet("Bearer " +SaveSharedPreference.getHeaderToken(getApplicationContext()));
        call.enqueue(new Callback<LogoutModel>() {
            @Override
            public void onResponse(Call<LogoutModel> call, Response<LogoutModel> response) {
                if (response.isSuccessful() && response.code() == 200){
                    Log.d("DashboardActivity", "Message: "+response.body().getData().getMessage());
                    Intent intent = new Intent(DashboardActivity.this, LoginActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(DashboardActivity.this, "Logout failed", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<LogoutModel> call, Throwable t) {

                Log.d(TAG, "Invalid logout"+t.getMessage());
                Toast.makeText(DashboardActivity.this, "Error : " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}