package com.example.foster;



import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.foster.WorkoutActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class SpecificExerciseActivity extends AppCompatActivity {
    Fragment fragmentBeginner = new BeginnerFragment();
    Fragment fragmentIntermediate = new IntermediateFragment();
    Fragment fragmentExpert = new ExpertFragment();
    Fragment fragmentFatLoss = new FatLossFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specific_exercise);

        Bundle b = getIntent().getExtras();
        int condition = b.getInt("key");
        switch (condition) {
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

    }


//    @Override
//    public void onClick(View v) {
//        System.out.println(123);
//        switch (v.getId()) {
//            case R.id.backButtonASE:
//                Intent i = new Intent(SpecificExerciseActivity.this, WorkoutActivity.class);
//                startActivity(i);
//                break;
//        }
//
//    }

    public void backButton(View v){
        Intent i = new Intent(SpecificExerciseActivity.this, WorkoutActivity.class);
        startActivity(i);
    }
    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//frame_container is your layout name in xml file
        transaction.replace(R.id.NHFSpecificExercise, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}