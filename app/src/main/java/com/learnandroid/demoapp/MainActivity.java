package com.learnandroid.demoapp;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.learnandroid.demoapp.Fragment.HomeFragment;
import com.learnandroid.demoapp.Fragment.ProfileFragment;
import com.learnandroid.demoapp.Fragment.ReelsFragment;
import com.learnandroid.demoapp.Fragment.SearchFragment;
import com.learnandroid.demoapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    private boolean doubleBackToExitPressedOnce = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        loadFragment(new HomeFragment());

        binding.bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                if(id == R.id.nav_Home){
                    loadFragment(new HomeFragment());

                } else if (id == R.id.nav_Search) {
                    loadFragment(new SearchFragment());

                }
                  else if (id == R.id.nav_Reels) {
                    loadFragment(new ReelsFragment());

                }
                  else if (id == R.id.nav_Profile) {
                    loadFragment(new ProfileFragment());
                  }
                return true;
            }
        });

        getOnBackPressedDispatcher().addCallback(new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {


                Fragment currentFragment = getSupportFragmentManager().findFragmentById(R.id.containerMA);
                // If the current fragment is not Home1Fragment, go to Home1Fragment
                if (!(currentFragment instanceof HomeFragment)) {
                    loadFragment(new HomeFragment());
                    binding.bottomNav.setSelectedItemId(R.id.nav_Home);  // Set the home item selected

                } else {
                    // If already in Home1Fragment, handle double back press to exit
                    if (doubleBackToExitPressedOnce) {
                        finish();
                    } else {
                        doubleBackToExitPressedOnce = true;
                        Toast.makeText(MainActivity.this, "Press back again to exit", Toast.LENGTH_SHORT).show();

                        // Reset the flag after 2 seconds
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                doubleBackToExitPressedOnce = false;
                            }
                        }, 2000);
                    }
                }
            }
        });
    }



    private void loadFragment(Fragment fragment) {

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.containerMA,fragment);
        ft.commit();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding = null;
    }
}