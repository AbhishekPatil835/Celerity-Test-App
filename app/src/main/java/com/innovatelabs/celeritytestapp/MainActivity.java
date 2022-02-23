package com.innovatelabs.celeritytestapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.innovatelabs.celeritytestapp.Fragments.HomeFragment;
import com.innovatelabs.celeritytestapp.Fragments.MarketFragment;
import com.innovatelabs.celeritytestapp.Fragments.NewsFragment;
import com.innovatelabs.celeritytestapp.Fragments.PortfolioFragment;
import com.innovatelabs.celeritytestapp.Fragments.ProfileFragment;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    Fragment selectorfragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*ActionBar actionBar;
        actionBar = getSupportActionBar();


        ColorDrawable colorDrawable
                = new ColorDrawable(Color.parseColor("#000000"));
        actionBar.setBackgroundDrawable(colorDrawable);
        actionBar.setDisplayShowTitleEnabled(true);
*/
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Start Investing");
        toolbar.setTitleTextColor(Color.BLACK);
        setSupportActionBar(toolbar);

        bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId())
                {
                    case R.id.nav_home:
                        selectorfragment = new HomeFragment();
                        toolbar.setTitle("Start Investing");
                        break;

                    case R.id.nav_portpholio:
                        selectorfragment = new PortfolioFragment();
                        toolbar.setTitle("Your Portfolio");
                        break;

                    case R.id.nav_market:
                        selectorfragment = new MarketFragment();
                        toolbar.setTitle("Market");
                        break;

                    case R.id.nav_news:
                        selectorfragment = new NewsFragment();
                        toolbar.setTitle("News");
                        break;

                    case R.id.nav_profile:
                        selectorfragment = new ProfileFragment();
                        toolbar.setTitle("Profile");
                        break;
                }
                if(selectorfragment != null)
                {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,selectorfragment).commit();
                }

               return true;

            }
        });
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new HomeFragment()).commit();
    }
}