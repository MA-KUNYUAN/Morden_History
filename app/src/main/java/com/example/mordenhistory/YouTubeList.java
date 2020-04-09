package com.example.mordenhistory;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

public class YouTubeList extends AppCompatActivity {


    private boolean mTwoPane;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_you_tube_list);

        if (findViewById(R.id.detailContainer) != null) {
            mTwoPane = true;
        }


        // setting up the recycler view
        RecyclerView mRecyclerView = findViewById(R.id.youTube_rv);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        //get TopTen restaurant data by calling the getRest() method
        Intent intent=getIntent();
        Bundle extras=intent.getExtras();
        String topic= (String) extras.get("topic_title");
        RecyclerView.Adapter mAdapter = new YouTubeAdapter(this, YouTubeVideo.getVideo(topic), mTwoPane);
        mRecyclerView.setAdapter(mAdapter);
    }
}
