package com.example.mordenhistory;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.mordenhistory.Adapter.LeaderAdapter;
import com.example.mordenhistory.Database.DatabaseHelp2;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class Leaderboard extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    DatabaseHelp2 myDB;

    ArrayList<UserInfo> myArray;

    RecyclerView LeaderView;

    RecyclerView.LayoutManager layoutManager;

    RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard);


        myDB = new DatabaseHelp2(this);
//        boolean inInserted = myDB.insertData("2354135@gmail.com","3413241","Kathy",55);
//        boolean inInserted2 = myDB.insertData("ee52134213@gmail.com","4234123","Blair",75);
//        boolean inInserted3 = myDB.insertData("276136ghe@gmail.com","23345","Yenny",52);
//        boolean inInserted4 = myDB.insertData("242314hue@gmail.com","2312312","Welbert",51);
//        boolean inInserted5 = myDB.insertData("12345678Chuck@gmail.com","123456","Chuck",0);
        Cursor c = myDB.getUserInfo();
        if(c != null){
            myArray = new ArrayList<UserInfo>();
            while(c.moveToNext()){
                myArray.add(new UserInfo(c.getInt(0),c.getString(1),c.getString(2),c.getString(3),c.getInt(4)));
            }
        }

        LeaderView = findViewById(R.id.LeaderView);
        LeaderView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        LeaderView.setLayoutManager(layoutManager);
        adapter = new LeaderAdapter(myArray);
        LeaderView.setAdapter(adapter);

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setOnNavigationItemSelectedListener(navigationItemSelectedListener);
        if(bottomNavigationView == null){
            System.out.println("Reference is null");
        }

        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(1);
        menuItem.setChecked(true);


    }

    BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.dashboard:

                            Intent intent2 = new Intent(Leaderboard.this, MainActivity.class);
                            startActivity(intent2);

                            return true;

                        case R.id.leaderboard:


                            return true;

                        case R.id.settings:
                            Intent intent3 = new Intent(Leaderboard.this, Settings.class);
                            startActivity(intent3);
                            return true;

                    }
                    return false;
                }
            };
    }

