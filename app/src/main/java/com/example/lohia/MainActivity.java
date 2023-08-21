package com.example.lohia;

import android.os.Bundle;
import android.view.MenuItem;


import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.lohia.HomeFragment;
import com.example.lohia.ProfileFragment;
import com.example.lohia.R;
import com.example.lohia.SettingFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView bottomNavigationView;
    DrawerLayout drawerLayout;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout=findViewById(R.id.drawerLayout);
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle= new ActionBarDrawerToggle(this,drawerLayout, toolbar, R.string.open,R.string.close);

        drawerLayout.addDrawerListener(toggle);

        toggle.syncState();
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            int id = item.getItemId();

            if (id == R.id.home) {
                loadFragment(new HomeFragment());
            } else if (id == R.id.profile) {
                loadFragment(new ProfileFragment());
            } else if (id == R.id.setting) {
                loadFragment(new SettingFragment());
            }

            return true;
        });

        // Set the initial fragment
        bottomNavigationView.setSelectedItemId(R.id.home);

        // NavigationView setup
        NavigationView navigationView = findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(this);

    }

    private void loadFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_item1) {
            // Handle item 1 click
        } else if (id == R.id.nav_item2) {
            // Handle item 2 click
        }

        // Close the drawer after handling the item click
        DrawerLayout drawer = findViewById(R.id.navigationView);
        drawer.closeDrawer(GravityCompat.START);



        return true;
    }
}
