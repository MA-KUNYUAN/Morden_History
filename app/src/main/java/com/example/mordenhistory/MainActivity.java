package com.example.mordenhistory;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

//Main Activity implementing the OnClickListener that was created in the recyclerview
public class MainActivity extends AppCompatActivity implements TopicAdapter.OnClickListener {

    ArrayList<Topics> topic;
    BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //setting up bottom navigation view
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(navigationItemSelectedListener);
        if(bottomNavigationView == null){
            System.out.println("Reference is null");
        }
        //BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
        //connecting bottom navigataion view with menu
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(0);
        menuItem.setChecked(true);


/*
        //setting up the actions of the OnClickListener when each Icon is pressed
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){

                    case R.id.dashboard:

                        break;

                    case R.id.leaderboard:
                        Intent intent2 = new Intent(MainActivity.this, Leaderboard.class);
                        startActivity(intent2);
                        //BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigationView);
                        //BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
                        break;

                    case R.id.settings:
                        Intent intent3 = new Intent(MainActivity.this, Settings.class);
                        startActivity(intent3);
                        break;

                }


                return false;
            }
        });
*/
         /*
mitchtabian, AppBarLayouts(2017)
https://github.com/mitchtabian/AppBarLayouts/tree/master/ActionBar%20Bottom%20Navigation
  */

        //recycler view method is called

        launchApp();
    }

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
                            //BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigationView);
                            //BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
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
}
