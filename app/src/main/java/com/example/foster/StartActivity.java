package com.example.foster;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;


public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        for(ExerciseEnum a:ExerciseEnum.values()){
            for(String b:a.getExercises().keySet()){
                System.out.println(a+" :"+b);

            }
        }
        Timer timer =new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent i = new Intent(new Intent(StartActivity.this, LoginActivity.class));
                startActivity(i);
                finish();
            }
        },2000);


    }
}