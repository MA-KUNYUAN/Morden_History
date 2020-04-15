package com.example.mordenhistory;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

//        ImageView imageView1 = findViewById(R.id.imageView);
//        ImageView imageView2 = findViewById(R.id.imageView2);
//        imageView1.setImageResource(R.drawable.france_revolution);
//        imageView2.setImageResource(R.drawable.morden_history);
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigationView);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(0);
        menuItem.setChecked(true);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){

                    /*
                    case R.id.back:

                        break;

                     */

                    case R.id.dashboard:

                        break;

                    case R.id.leaderboard:
                        Intent intent2 = new Intent(dashboard.this, Leaderboard.class);
                        startActivity(intent2);
                        break;

                    case R.id.settings:
                        Intent intent3 = new Intent(dashboard.this, Settings.class);
                        startActivity(intent3);
                        break;

                }


                return false;
            }
        });
    }
}
