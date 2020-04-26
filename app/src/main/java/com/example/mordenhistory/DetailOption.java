package com.example.mordenhistory;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mordenhistory.Models.Topics;

public class DetailOption extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_options);

        if (getIntent().hasExtra("selected_note")) {
            Topics topic = getIntent().getParcelableExtra("selected_note");

            //set the title of the Action Bar to the name of the object
            setTitle(topic.getName());

        }


    }

    //Onclick method for You Tube Videos Button
    //the method will take the user to the YouTubeList activity if the Video button is pressed and will pass the relevant topic name to the activity
    public void YouTubeVideo(View v) {

        Intent intent = new Intent(DetailOption.this, YouTubeList.class);
        Topics topic = getIntent().getParcelableExtra("selected_note");
        intent.putExtra("topic_title", topic.getName());
        startActivity(intent);

    }

    //Onclick method for Pdf Button
    //Onclick method for You Tube Videos Button
    //the method will take the user to the PdfList activity if the Pdf button is pressed and will pass the relevant topic name to the activity
    public void PdfView(View view) {

        Intent intent = new Intent(DetailOption.this, PdfList.class);
        Topics topic = getIntent().getParcelableExtra("selected_note");
        intent.putExtra("topic_title1", topic.getName());
        startActivity(intent);

    }

    //Onclick method for Quiz Button
    //the method will take the user to the startQuiz activity if the quiz button is pressed and will pass the relevant topic name to the activity
    public void takeQuiz(View view) {

        Intent intent = new Intent(DetailOption.this, StartQuiz.class);
        Topics topic = getIntent().getParcelableExtra("selected_note");
        intent.putExtra("topic_title1", topic.getName());
        startActivity(intent);

    }

}
