package com.example.mordenhistory;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;

import java.util.ArrayList;

public class YouTubeList extends AppCompatActivity implements YouTubeAdapter.OnClickListener{


    ArrayList<YouTubeVideo> videos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_you_tube_list);

      launchApp();


    }


    private void launchApp() {

        RecyclerView rvTopic = (RecyclerView) findViewById(R.id.youTube_rv);

        Intent intent=getIntent();
        Bundle extras=intent.getExtras();
        String topic= (String) extras.get("topic_title");

        videos = YouTubeVideo.getVideo(topic);

      YouTubeAdapter adapter=new YouTubeAdapter(videos, (YouTubeAdapter.OnClickListener)this);

        //TopicAdapter adapter = new TopicAdapter(topic, (TopicAdapter.OnClickListener) this);

        rvTopic.setAdapter(adapter);
        rvTopic.setLayoutManager(new LinearLayoutManager(this));

    }


    //implementing the OnClickListener Interface's method
    //the method will determine what will occur a item in the recyclerview is presssed
    //Will navigate to detail_options.xml when item is clicked

    public void OnClick(int position) {
        Intent intent =new Intent (this, DetailYoutube.class);
        //data of selected item is passed
        intent.putExtra("selected_note1",  videos.get(position));
        startActivity(intent);

    }
}
