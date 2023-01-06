package com.example.foster;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView bottomNavigationView;
    NavigationView navigationView;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toolbar toolbar = findViewById(R.id.TBMainAct);
        setSupportActionBar(toolbar);
        navigationView = findViewById(R.id.sideNavMain);
        navigationView.setItemIconTintList(null);
        navigationView.setNavigationItemSelectedListener(this);


        drawerLayout = findViewById(R.id.DLMain);
//        drawerLayout = (DrawerLayout) navigationView.getRootView().findViewById(R.id.DLMain);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);

        toggle.syncState();

//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


//    private void setupBottomNavMenu(NavController navController) {
//        BottomNavigationView bottomNav = findViewById(R.id.bottom_nav_view);
//        NavigationUI.setupWithNavController(bottomNav, navController, false);
//    }
//
//    //
//    private void setupNavMenu(NavController navController) {
//        NavigationView sideNav = findViewById(R.id.sideNav);
//        NavigationUI.setupWithNavController(sideNav, navController, false);
//    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Log.d("MainActivity", "onNavigationItemSelected: called");

        if (item.getItemId() == R.id.DestHome) {
            Intent i = new Intent(MainActivity.this, MainActivity.class);
            startActivity(i);
        } else if (item.getItemId() == R.id.DestAboutApp) {
//            Intent i = new Intent(MainActivity.this, AboutAppActivity.class);
//            startActivity(i);
        } else if (item.getItemId() == R.id.DestLogout) {
//            Intent i = new Intent(MainActivity.this, LogoutActivity.class);
//            startActivity(i);
        } else if (item.getItemId() == R.id.DestMusicPage) {
            Intent i = new Intent(MainActivity.this, MusicActivity.class);
            startActivity(i);
        } else if (item.getItemId() == R.id.DestSettings) {
            Intent i = new Intent(MainActivity.this, SettingsActivity.class);
            startActivity(i);
        } else if (item.getItemId() == R.id.DestWorkoutPage) {
            Intent i = new Intent(MainActivity.this, WorkoutActivity.class);
            startActivity(i);
        } else if (item.getItemId() == R.id.DestStepsPage) {
//            Intent i = new Intent(MainActivity.this, StepsActivity.class);
//            startActivity(i);
        }

//        drawerLayout = findViewById(R.id.DLMain);
        drawerLayout = (DrawerLayout) navigationView.getRootView().findViewById(R.id.DLMain);
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
        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}