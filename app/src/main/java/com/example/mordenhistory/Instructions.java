package com.example.mordenhistory;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Instructions extends AppCompatActivity {

    //the instruction text has been hardcoded into the xml file
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructions);
        setTitle("Instructions");
    }
}
