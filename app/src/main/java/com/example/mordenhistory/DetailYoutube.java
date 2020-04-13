package com.example.mordenhistory;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class DetailYoutube extends YouTubeBaseActivity {
    Button button;
    private YouTubePlayerView youTubePlayerView;
    private YouTubePlayer.OnInitializedListener onInitializedListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_youtube);

        YouTubeVideo video = getIntent().getParcelableExtra("selected_note1");
        final String url=video.getURL();

        youTubePlayerView=findViewById(R.id.youtube_view);

        onInitializedListener=new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo(url);
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        };
        Button button1=(Button) findViewById(R.id.playVid);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                youTubePlayerView.initialize("AIzaSyB-RAX1KfKRKCEEHq-NEABlmBCmy0MiMCY", onInitializedListener);

            }
        });

        if (getIntent().hasExtra("selected_note1")) {
            YouTubeVideo video1 = getIntent().getParcelableExtra("selected_note1");

            //set the TextView to the name of the object
            TextView title=(TextView)findViewById(R.id.youTubeTitle);
            title.setText(video1.getName());


        }
    }
}
