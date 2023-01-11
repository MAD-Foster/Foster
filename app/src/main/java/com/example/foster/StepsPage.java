package com.example.foster;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.MutableData;
import com.google.firebase.database.Transaction;
import com.google.firebase.database.ValueEventListener;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class StepsPage extends AppCompatActivity implements SensorEventListener {
    private TextView textViewStepCounter, textViewStepDetector, textViewTotalStepsLeftCounter;
    private TextView textViewCaloriesBurned;

    private SensorManager sensorManager;
    private Sensor mStepCounter;
    private boolean isCounterSensorPresent;
    private DatabaseReference ref;

    private SharedPreferences sharedPreferences;
    int stepCount = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_steps_page);

        sharedPreferences = getPreferences(Context.MODE_PRIVATE);

        FirebaseApp.initializeApp(this);
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("users").child(user.getUid()).child("step_count");

        ref.setValue(stepCount);
        // Initialize views
        textViewStepCounter = findViewById(R.id.stepCounter);
        textViewStepDetector = findViewById(R.id.stepDetector);
        textViewTotalStepsLeftCounter = findViewById(R.id.totalStepLeftCounter);
        textViewCaloriesBurned = findViewById(R.id.caloriesBurned);

        TextView totalStepLeftCounter = findViewById(R.id.totalStepLeftCounter);
        totalStepLeftCounter.setText("Steps left: 10000");

        if(ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACTIVITY_RECOGNITION) == PackageManager.PERMISSION_DENIED){ //ask for permission
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(new String[]{Manifest.permission.ACTIVITY_RECOGNITION}, 0);
            }
        }

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if(sensorEvent.sensor == mStepCounter){
            stepCount = (int) sensorEvent.values[0];
            textViewStepCounter.setText(String.valueOf(stepCount));
            double caloriesBurned = stepCount * 0.03;
            textViewCaloriesBurned.setText("Calories burned: " + String.format("%.2f", caloriesBurned));
            int totalStepsLeft = 10000 - stepCount;
            textViewTotalStepsLeftCounter.setText("Steps left: " + totalStepsLeft);

            // Get the current date
            Date currentDate = Calendar.getInstance().getTime();

            // Get the date the step count was last updated
            String dateString = sharedPreferences.getString("last_update_date", null);
            Date lastUpdateDate = new Date();
            if (dateString != null) {
                try {
                    lastUpdateDate = new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }

            resetStepsCount();
        }
    }




    private void resetStepsCount() {
        Calendar now = Calendar.getInstance();
        Calendar lastReset = Calendar.getInstance();

        // Use the current step count as the last reset time
        lastReset.setTime(new Date(stepCount));

        if (now.get(Calendar.YEAR) > lastReset.get(Calendar.YEAR) ||
                now.get(Calendar.MONTH) > lastReset.get(Calendar.MONTH) ||
                now.get(Calendar.DAY_OF_MONTH) > lastReset.get(Calendar.DAY_OF_MONTH)) {
            // If it's a new day, reset the step count
            stepCount = 0;
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @Override
    protected void onResume() {
        super.onResume();
        if(sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER) != null) {
            sensorManager.registerListener(this, mStepCounter, SensorManager.SENSOR_DELAY_NORMAL);
        }
        resetStepsCount();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER) != null);
        sensorManager.unregisterListener(this, mStepCounter);

    }




}