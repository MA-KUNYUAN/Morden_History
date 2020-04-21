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
import com.example.mordenhistory.Models.User;
import com.example.mordenhistory.Models.UserInfo;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

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

        setTitle("Leaderboard");


        //getting all user info
        myDB = new DatabaseHelp2(this);
        Cursor c = myDB.getUserInfo();
        if(c != null){
            myArray = new ArrayList<UserInfo>();
            while(c.moveToNext()){
                myArray.add(new UserInfo(c.getInt(0),c.getString(1),c.getString(2),c.getInt(3),c.getString(4),c.getString(5), c.getInt(6), c.getInt(7), c.getInt(8), c.getInt(9), c.getInt(10), c.getInt(11), c.getInt(12), c.getInt(13), c.getInt(14), c.getInt(15)));
            }
        }

        //setting up leaderboard recyclerview
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

    @Override
    protected void onResume() {
        super.onResume();
        bottomNavigationView.getMenu().getItem(1).setChecked(true);
    }
}

