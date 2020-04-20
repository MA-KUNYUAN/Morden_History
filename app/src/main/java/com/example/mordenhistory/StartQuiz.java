package com.example.mordenhistory;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.mordenhistory.Database.DatabaseHelp2;
import com.example.mordenhistory.Models.User;

public class StartQuiz extends AppCompatActivity {

    DatabaseHelp2 myDB=new DatabaseHelp2(this);


   User user;


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

        Cursor c = myDB.getCurrentUserInfor();
        if(c != null){
            while(c.moveToNext()){
                user=new User(c.getInt(3), c.getInt(6), c.getInt(7), c.getInt(8), c.getInt(9), c.getInt(10), c.getInt(11), c.getInt(12), c.getInt(13), c.getInt(14), c.getInt(15));
        }

            //The if else statement determines whether the current user have attempted the quiz previously
            // If user has the user will be unable to move to the next activity
            //If the user hasn't then the user will be able to attempt the quiz
            //The number of attempts will then be updated in the database
            if (topic.equals("Enlightenment")){
                int attempt=user.getEnlightenmentAttempt();
                if(attempt==0){
                    startActivity(intent1);
                    SQLiteDatabase db=myDB.getWritableDatabase();
                    db.execSQL("UPDATE user_table SET EnlightenmentAttempt=1 WHERE UserName='Peter'");

                }else{
                    Toast.makeText(this, "You have already attempted the quiz", Toast.LENGTH_SHORT).show();
                }
            }else if(topic.equals("American Revolution")){
                int attempt=user.getAmericanRevolutionAttempt();
                if(attempt==0){
                    startActivity(intent1);
                    SQLiteDatabase db=myDB.getWritableDatabase();
                    db.execSQL("UPDATE user_table SET americanRevolutionAttempt=1 WHERE UserName='Peter'");

                }else{
                    Toast.makeText(this, "You have already attempted the quiz", Toast.LENGTH_SHORT).show();
                }
            }else if(topic.equals("French Revolution")){
                int attempt=user.getFrenchRevolutionAttempt();
                if(attempt==0){
                    startActivity(intent1);
                    SQLiteDatabase db=myDB.getWritableDatabase();
                    db.execSQL("UPDATE user_table SET frenchRevolutionAttempt=1 WHERE UserName='Peter'");

                }else{
                    Toast.makeText(this, "You have already attempted the quiz", Toast.LENGTH_SHORT).show();
                }

            }else if(topic.equals("Industrial Revolution")){
                int attempt=user.getIndustrialRevolutionAttempt();
                if(attempt==0){
                    startActivity(intent1);
                    SQLiteDatabase db=myDB.getWritableDatabase();
                    db.execSQL("UPDATE user_table SET industrialRevolutionAttempt=1 WHERE UserName='Peter'");

                }else{
                    Toast.makeText(this, "You have already attempted the quiz", Toast.LENGTH_SHORT).show();
                }
            }else if(topic.equals("Imperialism")){
                int attempt=user.getImperialismAttempt();
                if(attempt==0){
                    startActivity(intent1);
                    SQLiteDatabase db=myDB.getWritableDatabase();
                    db.execSQL("UPDATE user_table SET imperialismAttempt=1 WHERE UserName='Peter'");

                }else{
                    Toast.makeText(this, "You have already attempted the quiz", Toast.LENGTH_SHORT).show();
                }
            }

        }


    }


}
