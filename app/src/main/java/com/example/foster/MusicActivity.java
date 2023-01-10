package com.example.foster;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;

public class MusicActivity extends AppCompatActivity implements View.OnClickListener,NavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView bottomNavigationView;
    NavigationView navigationView;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

        FloatingActionButton floatingActionButton = findViewById(R.id.fabMusic);
        floatingActionButton.setOnClickListener(this);
        Toolbar toolbar = findViewById(R.id.TBMusicAct);
        bottomNavigationView = findViewById(R.id.bottom_nav_view_music);
        bottomNavigationView.setSelectedItemId(R.id.DestMusicPage);


        setSupportActionBar(toolbar);
        navigationView = findViewById(R.id.sideNavMusic);
        navigationView.setItemIconTintList(null);
        navigationView.setNavigationItemSelectedListener(this);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                System.out.println("bottom nav");
                Intent i;
                switch (item.getItemId()) {
                    case R.id.DestHome:
                        i = new Intent(MusicActivity.this, MainActivity.class);
                        startActivity(i);
                        return true;
                    case R.id.DestSettings:
                        i = new Intent(MusicActivity.this, SettingsActivity.class);
                        startActivity(i);
                        return true;

                    case R.id.DestWorkoutPage:
                        i = new Intent(MusicActivity.this, WorkoutActivity.class);
                        startActivity(i);
                        return true;

                    case R.id.DestMusicPage:
                        i = new Intent(MusicActivity.this, MusicActivity.class);
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
        drawerLayout = findViewById(R.id.DLMusic);
//        drawerLayout = (DrawerLayout) navigationView.getRootView().findViewById(R.id.DLMain);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);

        toggle.syncState();

    }

    @Override
    public void onClick(View v) {
        System.out.println("fab");
        System.out.println("fab");
        System.out.println("fab");
        System.out.println("fab");
        System.out.println("fab");

        if (v.getId() == R.id.fab) {
            Intent i = new Intent(MusicActivity.this, MainActivity.class);
            startActivity(i);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        System.out.println("side nav");
        //side nav
        if (item.getItemId() == R.id.DestHome) {
            Intent i = new Intent(MusicActivity.this, MainActivity.class);
            startActivity(i);
        } else if (item.getItemId() == R.id.DestAboutApp) {
//            Intent i = new Intent(MusicActivity.this, AboutAppActivity.class);
//            startActivity(i);
        } else if (item.getItemId() == R.id.DestLogout) {
//            Intent i = new Intent(MusicActivity.this, LogoutActivity.class);
//            startActivity(i);
        } else if (item.getItemId() == R.id.DestMusicPage) {
            Intent i = new Intent(MusicActivity.this, MusicActivity.class);
            startActivity(i);
        } else if (item.getItemId() == R.id.DestSettings) {
            Intent i = new Intent(MusicActivity.this, SettingsActivity.class);
            startActivity(i);
        } else if (item.getItemId() == R.id.DestWorkoutPage) {
            Intent i = new Intent(MusicActivity.this, WorkoutActivity.class);
            startActivity(i);
        } else if (item.getItemId() == R.id.DestStepsPage) {
//            Intent i = new Intent(MusicActivity.this, StepsActivity.class);
//            startActivity(i);
        }

//        drawerLayout = findViewById(R.id.DLMain);
        drawerLayout = (DrawerLayout) navigationView.getRootView().findViewById(R.id.DLMusic);
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
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
        System.out.println("overflow menu");
        Intent i;
        switch (item.getItemId()) {
            case R.id.DestHome:
                i = new Intent(MusicActivity.this, MainActivity.class);
                startActivity(i);
                break;
            case R.id.DestSettings:
                i = new Intent(MusicActivity.this, SettingsActivity.class);
                startActivity(i);
                break;
            case R.id.DestWorkoutPage:
                i = new Intent(MusicActivity.this, WorkoutActivity.class);
                startActivity(i);
                break;
            case R.id.DestMusicPage:
                i = new Intent(MusicActivity.this, MusicActivity.class);
                startActivity(i);
                break;
            case R.id.DestStepsPage:
//                Intent i = new Intent(MusicActivity.this, StepsActivity.class);
//                startActivity(i);
                break;

        }
//        if (toggle.onOptionsItemSelected(item)) {
//            return true;
//        }
        return super.onOptionsItemSelected(item);
    }
}