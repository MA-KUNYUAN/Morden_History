package com.example.mordenhistory;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class StartQuiz extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_quiz);

        Button buttonStartQuiz=findViewById(R.id.button_start_quiz);


        buttonStartQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startQuiz();
            }
        });
    }


    public void startQuiz(){

        Intent intent=getIntent();
        Bundle extras=intent.getExtras();
        String topic= (String) extras.get("topic_title1");
        Intent intent1=new Intent(StartQuiz.this, ActualQuiz.class);

        intent1.putExtra("topic_title", topic );

        //gets result back from the activity it starts
        startActivity(intent1);

    }


}
