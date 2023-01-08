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

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

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


        drawerLayout = findViewById(R.id.DLMain);
        navigationView.setNavigationItemSelectedListener((NavigationView.OnNavigationItemSelectedListener) this);
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
        if (item.getItemId() == R.id.DestHome) {

        } else if (item.getItemId() == R.id.DestAboutApp) {

        } else if (item.getItemId() == R.id.DestLogout) {
        } else if (item.getItemId() == R.id.DestMusicPage) {
        } else if (item.getItemId() == R.id.DestSettings) {
        } else if (item.getItemId() == R.id.DestWorkoutPage) {
            Intent i = new Intent(MainActivity.this, WorkoutActivity.class);
            startActivity(i);
        } else if (item.getItemId() == R.id.DestStepsPage) {

        }

        drawerLayout = findViewById(R.id.DLMain);

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
//        MenuItem logoutItem = menu.findItem(R.id.actionLogout);
//        logoutItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
//            @Override
//            public boolean onMenuItemClick(MenuItem item) {
//                FirebaseAuth.getInstance().signOut();
//                startActivity(new Intent(MainActivity.this, LoginActivity.class));
//                return true;
//            }
//        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        // Handle item selection
        switch (item.getItemId()) {
            case R.id.actionLogout:
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
                return true;

            case R.id.DestStepsPage:
                startActivity(new Intent(MainActivity.this, StepsPage.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}