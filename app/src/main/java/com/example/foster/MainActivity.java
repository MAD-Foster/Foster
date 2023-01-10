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
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    BottomNavigationView bottomNavigationView;
    NavigationView navigationView;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton floatingActionButton = findViewById(R.id.fabMain);
        floatingActionButton.setOnClickListener(this);
        Toolbar toolbar = findViewById(R.id.TBMainAct);
        bottomNavigationView = findViewById(R.id.bottom_nav_view);
        bottomNavigationView.setSelectedItemId(R.id.placeHolder);

        setSupportActionBar(toolbar);
        navigationView = findViewById(R.id.sideNavMain);
        navigationView.setItemIconTintList(null);
        navigationView.setNavigationItemSelectedListener(this);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                System.out.println("bottom nav");
                Intent i;
                switch (item.getItemId()) {
                    case R.id.DestHome:
                        i = new Intent(MainActivity.this, MainActivity.class);
                        startActivity(i);
                        return true;
                    case R.id.DestSettings:
                        i = new Intent(MainActivity.this, SettingsActivity.class);
                        startActivity(i);
                        return true;

                    case R.id.DestWorkoutPage:
                        i = new Intent(MainActivity.this, WorkoutActivity.class);
                        startActivity(i);
                        return true;

                    case R.id.DestMusicPage:
                        i = new Intent(MainActivity.this, MusicActivity.class);
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
    public void onClick(View v) {
        System.out.println("fab");
        System.out.println("fab");
        System.out.println("fab");
        System.out.println("fab");
        System.out.println("fab");

        if (v.getId() == R.id.fab) {
            Intent i = new Intent(MainActivity.this, MainActivity.class);
            startActivity(i);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        System.out.println("side nav");
        //side nav
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
        MenuItem logoutItem = menu.findItem(R.id.actionLogout);
        logoutItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
                return true;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        System.out.println("overflow menu");
        Intent i;
        switch (item.getItemId()) {
            case R.id.DestHome:
                i = new Intent(MainActivity.this, MainActivity.class);
                startActivity(i);
                break;
            case R.id.DestSettings:
                i = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(i);
                break;
            case R.id.DestWorkoutPage:
                i = new Intent(MainActivity.this, WorkoutActivity.class);
                startActivity(i);
                break;
            case R.id.DestMusicPage:
                i = new Intent(MainActivity.this, MusicActivity.class);
                startActivity(i);
                break;
            case R.id.DestStepsPage:
//                Intent i = new Intent(MainActivity.this, StepsActivity.class);
//                startActivity(i);
                break;
            case R.id.actionLogout:
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
//        if (toggle.onOptionsItemSelected(item)) {
//            return true;
//        }
        return super.onOptionsItemSelected(item);


    }
}