package com.example.foster;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.media.Image;
import android.os.Bundle;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.example.foster.databinding.ActivityWorkoutBinding;

public class WorkoutActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    //    private ActivityWorkoutBinding binding;
    BottomNavigationView bottomNavigationView;
    NavigationView navigationView;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout);

        Toolbar toolbar = findViewById(R.id.TBWorkoutAct);
        setSupportActionBar(toolbar);
        navigationView = findViewById(R.id.sideNav);
        navigationView.setItemIconTintList(null);
        navigationView.setNavigationItemSelectedListener(this);

        drawerLayout = findViewById(R.id.DLWorkout);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        int Beg = R.drawable.img_begg;
        ImageView imageView = (ImageView) findViewById(R.id.IV1);
        roundImage(imageView, Beg);
        imageView.setOnClickListener(this);
        int Inter = R.drawable.img_inter;
        ImageView imageView1 = (ImageView) findViewById(R.id.IV2);
        roundImage(imageView1, Inter);
        imageView1.setOnClickListener(this);

        int Fat = R.drawable.img_fatloss;
        ImageView imageView2 = (ImageView) findViewById(R.id.IV3);
        roundImage(imageView2, Fat);
        imageView2.setOnClickListener(this);

        int Exp = R.drawable.img_exp;
        ImageView imageView3 = (ImageView) findViewById(R.id.IV4);
        roundImage(imageView3, Exp);
        imageView3.setOnClickListener(this);

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
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Intent i;
        if (item.getItemId() == R.id.DestHome) {
            i = new Intent(WorkoutActivity.this, MainActivity.class);
            startActivity(i);
        } else if (item.getItemId() == R.id.DestAboutApp) {
//            i = new Intent(WorkoutActivity.this, AboutappActivity.class);
//            startActivity(i);
        } else if (item.getItemId() == R.id.DestLogout) {
//            i=new Intent(WorkoutActivity.this,LogoutActivity.class);
//            startActivity(i);
        } else if (item.getItemId() == R.id.DestMusicPage) {
            i=new Intent(WorkoutActivity.this,MusicActivity.class);
            startActivity(i);

        } else if (item.getItemId() == R.id.DestSettings) {
            i=new Intent(WorkoutActivity.this,SettingsActivity.class);
            startActivity(i);
        } else if (item.getItemId() == R.id.DestWorkoutPage) {
           i = new Intent(WorkoutActivity.this, WorkoutActivity.class);
            startActivity(i);
        } else if (item.getItemId() == R.id.DestStepsPage) {
//            i = new Intent(WorkoutActivity.this, StepsActivity.class);
//            startActivity(i);
        }

        drawerLayout = findViewById(R.id.DLWorkout);

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    public void roundImage(ImageView mimageView, int i) {
        Bitmap mbitmap = ((BitmapDrawable) getResources().getDrawable(i)).getBitmap();
        Bitmap imageRounded = Bitmap.createBitmap(mbitmap.getWidth(), mbitmap.getHeight(), mbitmap.getConfig());
        Canvas canvas = new Canvas(imageRounded);
        Paint mpaint = new Paint();
        mpaint.setAntiAlias(true);
        mpaint.setShader(new BitmapShader(mbitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
        canvas.drawRoundRect((new RectF(0, 0, mbitmap.getWidth(), mbitmap.getHeight())), 35, 35, mpaint); // Round Image Corner 100 100 100 100
        mimageView.setImageBitmap(imageRounded);
    }

    public int condition;

    @Override
    public void onClick(View v) {
//        Fragment fragmentBeginner = new BeginnerFragment();
//        Fragment fragmentIntermediate = new IntermediateFragment();
//        Fragment fragmentExpert = new ExpertFragment();
//        Fragment fragmentFatLoss = new FatLossFragment();

        FloatingActionButton fab = findViewById(R.id.fab);
        switch (v.getId()) {
            case R.id.IV1:
                condition = 1;
                break;
            case R.id.IV2:
                condition = 2;
                break;
            case R.id.IV3:
                condition = 3;
                break;
            case R.id.IV4:
                condition = 4;
                break;
            case R.id.fab:
                Snackbar.make(v, "blabla", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                break;

        }
        Intent i = new Intent(WorkoutActivity.this, SpecificExerciseActivity.class);
        Bundle b = new Bundle();
        b.putInt("key", condition);
        i.putExtras(b);
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