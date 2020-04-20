package com.example.mordenhistory;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class Settings extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        setTitle("Settings");
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setOnNavigationItemSelectedListener(navigationItemSelectedListener);
        if (bottomNavigationView == null) {
            System.out.println("Reference is null");
        }

        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(2);
        menuItem.setChecked(true);

        //setting up Settings ListView
        ListView list = (ListView) findViewById(R.id.settingsList);

        ArrayList<String> item = new ArrayList<>();
        item.add("Profile");
        item.add("Instructions");

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, item);

        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // if the first item is clicked then user will move to the the Profile Activity
                if(position==0){
                    Intent intent4=new Intent(view.getContext(), Profile.class);
                    startActivity(intent4);
                }


                //if the 2nd item is clicked then the user will move to the Instructions activity
                if(position==1){
                    Intent intent5=new Intent(view.getContext(), Instructions.class);
                    startActivity(intent5);
                }
            }
        });

    }



    BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.dashboard:

                            Intent intent2 = new Intent(Settings.this, MainActivity.class);
                            startActivity(intent2);

                            return true;

                        case R.id.leaderboard:

                            Intent intent3 = new Intent(Settings.this, Leaderboard.class);
                            startActivity(intent3);
                            return true;


                        case R.id.settings:

                            return true;

                    }
                    return false;
                }
            };
}
