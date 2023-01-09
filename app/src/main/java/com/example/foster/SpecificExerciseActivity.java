package com.example.foster;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.foster.WorkoutActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class SpecificExerciseActivity extends AppCompatActivity {
    Fragment fragmentBeginner = new BeginnerFragment();
    Fragment fragmentIntermediate = new IntermediateFragment();
    Fragment fragmentExpert = new ExpertFragment();
    Fragment fragmentFatLoss = new FatLossFragment();
int whichFragment=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specific_exercise);

        Bundle b = getIntent().getExtras();
        int condition = b.getInt("key");
        switch (condition) {
            case 1:
                whichFragment=1;
                loadFragment(fragmentBeginner);
                break;
            case 2:
                whichFragment=2;
                loadFragment(fragmentIntermediate);
                break;
            case 3:
                whichFragment=3;
                loadFragment(fragmentFatLoss);
                break;
            case 4:
                whichFragment=4;
                loadFragment(fragmentExpert);
                break;
        }

    }



    public void backButton(View v) {
        StartingWorkoutFragment startingWorkoutFragment = (StartingWorkoutFragment) getSupportFragmentManager().findFragmentByTag("starting_workout_fragment");
        if (startingWorkoutFragment != null && startingWorkoutFragment.isVisible()) {
            switch (whichFragment){
                case 1:
                    loadFragment(fragmentBeginner);
                    break;
                case 2:
                    loadFragment(fragmentIntermediate);
                    break;
                case 3:
                    loadFragment(fragmentFatLoss);
                    break;
                case 4:
                    loadFragment(fragmentExpert);
                    break;
            }
        }else {
            Intent i = new Intent(SpecificExerciseActivity.this, WorkoutActivity.class);
            startActivity(i);
        }
    }

    String stringCondition;

    public void goButton(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.GO_beginner_day1:
                stringCondition = "beginner_day1";
                break;
            case R.id.GO_beginner_day2:
                stringCondition = "beginner_day2";
                break;
            case R.id.GO_beginner_day3:
                stringCondition = "beginner_day3";
                break;
            case R.id.GO_beginner_day4:
                stringCondition = "beginner_day4";
                break;
            case R.id.GO_beginner_day5:
                stringCondition = "beginner_day5";
                break;
            case R.id.GO_beginner_day6:
                stringCondition = "beginner_day6";
                break;
            case R.id.GO_beginner_day7:
                stringCondition = "beginner_day7";
                break;
            //@@@@@@@@@@@@@@@@@@@@@@@@@
            case R.id.GO_intermediate_day1:
                stringCondition = "intermediate_day1";
                break;
            case R.id.GO_intermediate_day2:
                stringCondition = "intermediate_day2";
                break;
            case R.id.GO_intermediate_day3:
                stringCondition = "intermediate_day3";
                break;
            case R.id.GO_intermediate_day4:
                stringCondition = "intermediate_day4";
                break;
            case R.id.GO_intermediate_day5:
                stringCondition = "intermediate_day5";
                break;
            case R.id.GO_intermediate_day6:
                stringCondition = "intermediate_day6";
                break;
            case R.id.GO_intermediate_day7:
                stringCondition = "intermediate_day7";
                break;
            //@@@@@@@@@@@@@@@@@@@@@@@@@@
            case R.id.GO_expert_day1:
                stringCondition = "expert_day1";
                break;
            case R.id.GO_expert_day2:
                stringCondition = "expert_day2";
                break;
            case R.id.GO_expert_day3:
                stringCondition = "expert_day3";
                break;
            case R.id.GO_expert_day4:
                stringCondition = "expert_day4";
                break;
            case R.id.GO_expert_day5:
                stringCondition = "expert_day5";
                break;
            case R.id.GO_expert_day6:
                stringCondition = "expert_day6";
                break;
            case R.id.GO_expert_day7:
                stringCondition = "expert_day7";
                break;
            //@@@@@@@@@@@@@@@@@@@
            case R.id.GO_fatloss_day1:
                stringCondition = "fatloss_day1";
                break;
            case R.id.GO_fatloss_day2:
                stringCondition = "fatloss_day2";
                break;
            case R.id.GO_fatloss_day3:
                stringCondition = "fatloss_day3";
                break;
            case R.id.GO_fatloss_day4:
                stringCondition = "fatloss_day4";
                break;
            case R.id.GO_fatloss_day5:
                stringCondition = "fatloss_day5";
                break;
            case R.id.GO_fatloss_day6:
                stringCondition = "fatloss_day6";
                break;
            case R.id.GO_fatloss_day7:
                stringCondition = "fatloss_day7";
                break;
            default:
                stringCondition = "beginner_day7";
        }
        Fragment fragment = new StartingWorkoutFragment();
        Bundle b = new Bundle();
        b.putString("key", stringCondition);
        fragment.setArguments(b);


        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.NHFSpecificExercise, new StartingWorkoutFragment(), "starting_workout_fragment");
        transaction.addToBackStack(null);
        transaction.commit();
    }

    //TextView tt=findViewById(R.id.TVTimerWorkout);
//    public void timer(View v){
//        new CountDownTimer(60000, 1000) {
//            @Override
//            public void onTick(long l) {
//                tt.setText("Remaining :"+l/1000);
//            }
//
//            @Override
//            public void onFinish() {
//                tt.setText("Set Finished!");
//            }
//        }.start();
//    }
    public String getCondition() {
        return this.stringCondition;
    }


    public void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//frame_container is your layout name in xml file
        transaction.replace(R.id.NHFSpecificExercise, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}