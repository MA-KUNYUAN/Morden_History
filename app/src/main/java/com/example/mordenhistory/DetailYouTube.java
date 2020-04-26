package com.example.mordenhistory;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.mordenhistory.Models.YouTubeVideo;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

//Using the YouTube Android Player Api which will  incorporate video playback functionality
//DetailYouTube is a subclass of YouTubeBaseActivity which is required to make YouTubePlayerView
public class DetailYouTube extends YouTubeBaseActivity {
    Button button;
    private YouTubePlayerView youTubePlayerView;
    private YouTubePlayer.OnInitializedListener onInitializedListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_youtube);

        YouTubeVideo video = getIntent().getParcelableExtra("selected_note1");
        final String url = video.getId();

        youTubePlayerView = findViewById(R.id.youtube_view);

        //will listen for initialising success or failure
        //if successful we will load the video url
        onInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo(url);
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        };

        //if play button is pressed the youTube video will start playing
        Button button1 = findViewById(R.id.playVid);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                youTubePlayerView.initialize("AIzaSyB-RAX1KfKRKCEEHq-NEABlmBCmy0MiMCY", onInitializedListener);

            }
        });

        //setting the TextView as the You Tube Video's name
        if (getIntent().hasExtra("selected_note1")) {
            YouTubeVideo video1 = getIntent().getParcelableExtra("selected_note1");

            //set the TextView to the name of the object
            TextView title = findViewById(R.id.youTubeTitle);
            title.setText(video1.getName());


        }
    }
}
