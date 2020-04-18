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

    //Initializing current user of the System Peter White
    User user=new User(0, 0, 0, 0, 0 , 0 ,0 , 0 ,0, 0 ,0  );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard);


        myDB = new DatabaseHelp2(this);
 boolean inInserted = myDB.insertData("Amy Wilson","Amy",56,"amy.wilson@gmail.com", "amy123", 15, 1, 10, 1, 12, 1, 9, 1, 10, 1);
 boolean inInserted2 = myDB.insertData("Kathy Jones","Kathy",49,"kathy.Jones@gmail.com", "kathy123", 12, 1, 5, 1, 11, 1, 12, 1, 9, 1);
 boolean inInserted3 = myDB.insertData("Alec Hughes","Alec",65,"alecHughes@gmail.com", "alec123", 15, 1, 15, 1, 11, 1, 12, 1, 12, 1);
 boolean inInserted4 = myDB.insertData("John Smith","John",40,"johm.Smith100@gmail.com", "john3000", 10, 1, 10, 1, 5, 1, 5, 1, 10, 1);
 boolean inInserted5 = myDB.insertData("Shelly Woolcot","Shelly",50,"shelly.woolcot@gmail.com", "shelly1000", 12, 1, 12, 1, 9, 1, 8, 1, 11, 1);
 boolean inInserted6 = myDB.insertData(user.getName(),user.getUsername(), user.getScore(), user.getEmail(),user.getPassword(), user.getEnlightenmentScore(), user.getEnlightenmentAttempt(), user.getAmericanRevolutionScore(), user.getAmericanRevolutionAttempt(), user.getFrenchRevolutionScore(), user.getFrenchRevolutionAttempt(), user.getIndustrialRevolutionScore(), user.getIndustrialRevolutionAttempt(),user.getImperialismScore(), user.getImperialismAttempt());


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

