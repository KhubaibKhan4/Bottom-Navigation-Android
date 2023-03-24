package com.example.bottomnavigationandroid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.bottomnavigationandroid.Fragments.AddFragment;
import com.example.bottomnavigationandroid.Fragments.HomeFragment;
import com.example.bottomnavigationandroid.Fragments.NotificationsFragment;
import com.example.bottomnavigationandroid.Fragments.ProfileFragment;
import com.example.bottomnavigationandroid.Fragments.SearchFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bttom_nav);
        FragmentManager fm = (FragmentManager) getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.container, new HomeFragment());
        fragmentTransaction.commit();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.nav_home) {
                    loadFragment(new HomeFragment());
                } else if (id == R.id.nav_search) {
                    loadFragment(new SearchFragment());
                } else if (id == R.id.nav_add) {
                    loadFragment(new AddFragment());
                } else if (id == R.id.nav_notifications) {
                    loadFragment(new NotificationsFragment());
                } else if (id == R.id.nav_profile) {
                    loadFragment(new ProfileFragment());
                }
                return false;
            }
        });

    }


    private void loadFragment(Fragment fragment) {
        FragmentManager fm = (FragmentManager) getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
