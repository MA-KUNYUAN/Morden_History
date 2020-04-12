package com.example.mordenhistory;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DetailYoutube extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_youtube);

        if (getIntent().hasExtra("selected_note1")) {
            YouTubeVideo video = getIntent().getParcelableExtra("selected_note1");

            //set the TextView to the name of the object
            TextView title=(TextView)findViewById(R.id.youTubeTitle);
            title.setText(video.getName());
        }
    }
}
