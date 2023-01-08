package com.example.foster;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
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

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class StepsPage extends AppCompatActivity implements SensorEventListener {
    private TextView textViewStepCounter, textViewStepDetector, textViewTotalStepsCounter;
    private SensorManager sensorManager;
    private Sensor mStepCounter;
    private boolean isCounterSensorPresent;
    int stepCount = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_steps_page);

        if(ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACTIVITY_RECOGNITION) == PackageManager.PERMISSION_DENIED){ //ask for permission
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(new String[]{Manifest.permission.ACTIVITY_RECOGNITION}, 0);
            }
        }

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        textViewStepCounter = findViewById(R.id.stepCounter);
        textViewStepDetector = findViewById(R.id.stepDetector);
        textViewTotalStepsCounter = findViewById(R.id.totalStepCounter);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        if(sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER) != null){
            mStepCounter = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
            isCounterSensorPresent = true;
        }else{
            textViewStepCounter.setText("Counter Sensor is not Present");
            isCounterSensorPresent = false;
        }


        // create a new database reference
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("steps");

        // create a new child location for the current day
        String key = ref.push().getKey();
        DatabaseReference dayRef = ref.child(key);

        // store the step count data for the current day
        dayRef.setValue(stepCount);

        // attach a value event listener to the reference
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // get the step count data from the snapshot
                HashMap<String, Integer> stepCountMap = dataSnapshot.getValue(new GenericTypeIndicator<HashMap<String, Integer>>(){});

                // update the UI with the step count
                textViewTotalStepsCounter.setText(String.valueOf(stepCountMap.get("stepCountKey")));
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });



    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if(sensorEvent.sensor == mStepCounter){
            stepCount = (int) sensorEvent.values[0];
            textViewStepCounter.setText(String.valueOf(stepCount));
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
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER) != null);
        sensorManager.unregisterListener(this, mStepCounter);

    }




}