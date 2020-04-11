package com.example.mordenhistory;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class DetailYoutube extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_youtube);

        if (savedInstanceState == null) {
            Bundle arguments = new Bundle();
            arguments.putString(YouTubeVid.ARG_ITEM_ID, getIntent().getStringExtra(YouTubeVid.ARG_ITEM_ID));
            YouTubeVid fragment = new YouTubeVid();
            fragment.setArguments(arguments);

            //Initialising fragment in the detailContainer
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.detailContainer, fragment)
                    .commit();
        }
    }
}
