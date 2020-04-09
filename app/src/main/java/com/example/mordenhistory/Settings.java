package com.example.mordenhistory;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);



        //setting up bottom navigation view
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigationView);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
        //connecting bottom navigation view with menu
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(2);
        menuItem.setChecked(true);
        //setting up the actions of the OnClickListener when each Icon is pressed
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){

                    case R.id.dashboard:
                        Intent intent1 = new Intent(Settings.this, MainActivity.class);
                        startActivity(intent1);
                        break;

                    case R.id.leaderboard:
                        Intent intent2 = new Intent(Settings.this, Leaderboard.class);
                        startActivity(intent2);
                        break;

                    case R.id.settings:
                        Intent intent3 = new Intent(Settings.this, Settings.class);
                        startActivity(intent3);
                        break;

                }


                return false;
            }
        });

         /*
mitchtabian, AppBarLayouts(2017)
https://github.com/mitchtabian/AppBarLayouts/tree/master/ActionBar%20Bottom%20Navigation
  */
    }
}
