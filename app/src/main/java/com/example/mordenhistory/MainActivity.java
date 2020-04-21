package com.example.mordenhistory;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.mordenhistory.Adapter.TopicAdapter;
import com.example.mordenhistory.Database.DatabaseHelp2;
import com.example.mordenhistory.Models.Topics;
import com.example.mordenhistory.Models.User;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

//Main Activity implementing the OnClickListener that was created in the recyclerview
public class MainActivity extends AppCompatActivity implements TopicAdapter.OnClickListener {

    ArrayList<Topics> topic;
    BottomNavigationView bottomNavigationView;

    DatabaseHelp2 myDB;

    User user=new User(0, 0, 0, 0, 0 , 0 ,0 , 0 ,0, 0 ,0  );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //setting up bottom navigation view
        //this will be done in the settings as well as the LeaderBoard activities
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(navigationItemSelectedListener);
        if(bottomNavigationView == null){
            System.out.println("Reference is null");

            getParent().getParent().setTitle("Modern History");

        }
        //BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
        //connecting bottom navigation view with menu
        //this will be done in the settings as well as the LeaderBoard activities
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(0);
        menuItem.setChecked(true);

        //recycler view method is called

        launchApp();

        //inserting data onto the database with all the users of the app as well as there scores
        // this data will be displayed by the leaderboard so that user can track their performance
        myDB = new DatabaseHelp2(this);
        boolean inInserted = myDB.insertData("Amy Wilson","Amy",56,"amy.wilson@gmail.com", "amy123", 15, 1, 10, 1, 12, 1, 9, 1, 10, 1);
        boolean inInserted2 = myDB.insertData("Kathy Jones","Kathy",49,"kathy.Jones@gmail.com", "kathy123", 12, 1, 5, 1, 11, 1, 12, 1, 9, 1);
        boolean inInserted3 = myDB.insertData("Alec Hughes","Alec",65,"alecHughes@gmail.com", "alec123", 15, 1, 15, 1, 11, 1, 12, 1, 12, 1);
        boolean inInserted4 = myDB.insertData("John Smith","John",40,"johm.Smith100@gmail.com", "john3000", 10, 1, 10, 1, 5, 1, 5, 1, 10, 1);
        boolean inInserted5 = myDB.insertData("Shelly Woolcot","Shelly",50,"shelly.woolcot@gmail.com", "shelly1000", 12, 1, 12, 1, 9, 1, 8, 1, 11, 1);
        boolean inInserted6 = myDB.insertData(user.getName(),user.getUsername(), user.getScore(), user.getEmail(),user.getPassword(), user.getEnlightenmentScore(), user.getEnlightenmentAttempt(), user.getAmericanRevolutionScore(), user.getAmericanRevolutionAttempt(), user.getFrenchRevolutionScore(), user.getFrenchRevolutionAttempt(), user.getIndustrialRevolutionScore(), user.getIndustrialRevolutionAttempt(),user.getImperialismScore(), user.getImperialismAttempt());


    }

    //this determines which activity the the user will go to when a particular item on the bottom navigation view is pressed
    //setting up the actions of the OnClickListener when each Icon is pressed
    //this will be done in the settings as well as the LeaderBoard activities
    BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.dashboard:

                            return true;

                        case R.id.leaderboard:
                            Intent intent2 = new Intent(MainActivity.this, Leaderboard.class);
                            startActivity(intent2);

                            return true;

                        case R.id.settings:
                            Intent intent3 = new Intent(MainActivity.this, Settings.class);
                            startActivity(intent3);
                            return true;

                    }
                    return false;
                }
            };


                //setting up the recyclerview
    private void launchApp() {

        RecyclerView rvTopic = (RecyclerView) findViewById(R.id.rvTopic);

        topic = Topics.getTopics();

        TopicAdapter adapter=new TopicAdapter(topic, (TopicAdapter.OnClickListener)this);

        //TopicAdapter adapter = new TopicAdapter(topic, (TopicAdapter.OnClickListener) this);

        rvTopic.setAdapter(adapter);
        rvTopic.setLayoutManager(new LinearLayoutManager(this));

    }


    //implementing the OnClickListener Interface's method
    //the method will determine what will occur a item in the recyclerview is presssed
    //Will navigate to detail_options.xml when item is clicked
    @Override
    public void OnClick(int position) {
        Intent intent =new Intent (this, Detail_Option.class);
        //data of selected item is passed
        intent.putExtra("selected_note", topic.get(position));
        startActivity(intent);

    }

    @Override
    protected void onResume() {
        super.onResume();
        bottomNavigationView.getMenu().getItem(0).setChecked(true);
    }

}
