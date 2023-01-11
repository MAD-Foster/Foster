package com.example.foster;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class StepsPage extends AppCompatActivity implements SensorEventListener,View.OnClickListener,NavigationView.OnNavigationItemSelectedListener {
    private TextView textViewStepCounter, textViewStepDetector, textViewTotalStepsCounter;
    private TextView textViewCaloriesBurned;

    private SensorManager sensorManager;
    private Sensor mStepCounter;
    private boolean isCounterSensorPresent;
    int stepCount = 0;

    BottomNavigationView bottomNavigationView;
    NavigationView navigationView;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_steps_page);

        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACTIVITY_RECOGNITION) == PackageManager.PERMISSION_DENIED) { //ask for permission
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(new String[]{Manifest.permission.ACTIVITY_RECOGNITION}, 0);
            }
        }
        FloatingActionButton floatingActionButton = findViewById(R.id.fabSteps);
        floatingActionButton.setOnClickListener(this);
        Toolbar toolbar = findViewById(R.id.TBStepsAct);
        bottomNavigationView = findViewById(R.id.bottom_nav_view_steps);
        bottomNavigationView.setSelectedItemId(R.id.DestStepsPage);


        setSupportActionBar(toolbar);
        navigationView = findViewById(R.id.sideNavSteps);
        navigationView.setItemIconTintList(null);
        navigationView.setNavigationItemSelectedListener(this);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                System.out.println("bottom nav");
                Intent i;
                switch (item.getItemId()) {
                    case R.id.DestHome:
                        i = new Intent(StepsPage.this, MainActivity.class);
                        startActivity(i);
                        return true;
                    case R.id.DestSettings:
                        i = new Intent(StepsPage.this, SettingsMain.class);
                        startActivity(i);
                        return true;

                    case R.id.DestWorkoutPage:
                        i = new Intent(StepsPage.this, WorkoutActivity.class);
                        startActivity(i);
                        return true;

                    case R.id.DestMusicPage:
                        i = new Intent(StepsPage.this, MusicActivity.class);
                        startActivity(i);
                        return true;

                    case R.id.DestStepsPage:
//                Intent i = new Intent(MainActivity.this, StepsActivity.class);
//                startActivity(i);
                        return true;

                }
                return false;
            }

        });
        drawerLayout = findViewById(R.id.DLSteps);
//        drawerLayout = (DrawerLayout) navigationView.getRootView().findViewById(R.id.DLMain);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);

        toggle.syncState();


        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        textViewStepCounter = findViewById(R.id.stepCounter);
        textViewStepDetector = findViewById(R.id.stepDetector);
        textViewTotalStepsCounter = findViewById(R.id.totalStepCounter);
        textViewCaloriesBurned = findViewById(R.id.caloriesBurned);


        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        if (sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER) != null) {
            mStepCounter = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
            isCounterSensorPresent = true;
        } else {
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
                HashMap<String, Integer> stepCountMap = dataSnapshot.getValue(new GenericTypeIndicator<HashMap<String, Integer>>() {
                });

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
        if (sensorEvent.sensor == mStepCounter) {
            stepCount = (int) sensorEvent.values[0];
            textViewStepCounter.setText(String.valueOf(stepCount));
            double caloriesBurned = stepCount * 0.03;
            textViewCaloriesBurned.setText("Calories burned: " + String.format("%.2f", caloriesBurned));
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
        if (sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER) != null) {
            sensorManager.registerListener(this, mStepCounter, SensorManager.SENSOR_DELAY_NORMAL);
        }
        resetStepsCount();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER) != null) ;
        sensorManager.unregisterListener(this, mStepCounter);

    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        System.out.println("overflow menu");
        Intent i;
        switch (item.getItemId()) {
            case R.id.DestHome:
                i = new Intent(StepsPage.this, MainActivity.class);
                startActivity(i);
                break;
            case R.id.DestSettings:
                i = new Intent(StepsPage.this, SettingsActivity.class);
                startActivity(i);
                break;
            case R.id.DestWorkoutPage:
                i = new Intent(StepsPage.this, WorkoutActivity.class);
                startActivity(i);
                break;
            case R.id.DestMusicPage:
                i = new Intent(StepsPage.this, MusicActivity.class);
                startActivity(i);
                break;
            case R.id.DestStepsPage:
                i = new Intent(StepsPage.this, StepsPage.class);
                startActivity(i);
                break;

        }
//        if (toggle.onOptionsItemSelected(item)) {
//            return true;
//        }
        return super.onOptionsItemSelected(item);

    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_overflow, menu);
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        System.out.println("side nav");
        //side nav
        if (item.getItemId() == R.id.DestHome) {
            Intent i = new Intent(StepsPage.this, MainActivity.class);
            startActivity(i);
        } else if (item.getItemId() == R.id.DestAboutApp) {
            Intent i = new Intent(StepsPage.this, AboutUsActivity.class);
            startActivity(i);
        } else if (item.getItemId() == R.id.DestLogout) {
            Intent i = new Intent(StepsPage.this, LoginActivity.class);
            startActivity(i);
        } else if (item.getItemId() == R.id.DestMusicPage) {
            Intent i = new Intent(StepsPage.this, MusicActivity.class);
            startActivity(i);
        } else if (item.getItemId() == R.id.DestSettings) {
            Intent i = new Intent(StepsPage.this, SettingsActivity.class);
            startActivity(i);
        } else if (item.getItemId() == R.id.DestWorkoutPage) {
            Intent i = new Intent(StepsPage.this, WorkoutActivity.class);
            startActivity(i);
        } else if (item.getItemId() == R.id.DestStepsPage) {
            Intent i = new Intent(StepsPage.this, StepsPage.class);
            startActivity(i);
        }

//        drawerLayout = findViewById(R.id.DLMain);
        drawerLayout = (DrawerLayout) navigationView.getRootView().findViewById(R.id.DLSteps);
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View v) {
        System.out.println("fab");
        System.out.println("fab");
        System.out.println("fab");
        System.out.println("fab");
        System.out.println("fab");

        if (v.getId() == R.id.fabSteps) {
            Intent i = new Intent(StepsPage.this, MainActivity.class);
            startActivity(i);
        }
    }

}