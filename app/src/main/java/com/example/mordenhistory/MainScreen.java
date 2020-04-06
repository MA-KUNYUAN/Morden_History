package com.example.mordenhistory;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainScreen extends AppCompatActivity {

    RecyclerView TopicView;
    RecyclerView LeaderboardView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_screen);
        TopicView = findViewById(R.id.TopicView);
        TopicView.setHasFixedSize(true);
        LeaderboardView = findViewById(R.id.LeaderboardView);
        LeaderboardView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        TopicView.setLayoutManager(layoutManager);
        LeaderboardView.setLayoutManager(layoutManager);
    }
}
