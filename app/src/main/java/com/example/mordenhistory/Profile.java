package com.example.mordenhistory;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;

import com.example.mordenhistory.Database.DatabaseHelp2;

public class Profile extends AppCompatActivity {

    DatabaseHelp2 myDB=new DatabaseHelp2(this);
    User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Cursor c = myDB.getCurrentUserInfor();
        if (c != null) {
            //myArray = new ArrayList<User>();
            while (c.moveToNext()) {
                user = new User(c.getInt(3), c.getInt(6), c.getInt(7), c.getInt(8), c.getInt(9), c.getInt(10), c.getInt(11), c.getInt(12), c.getInt(13), c.getInt(14), c.getInt(15));
            }
        }

        TextView name=(TextView)findViewById(R.id.name1);
        TextView userName=(TextView)findViewById(R.id.userName);
        TextView email=(TextView)findViewById(R.id.eMail);
        TextView totalScore=(TextView)findViewById(R.id.totalScore);



        name.setText(user.getName());
        userName.setText(user.getUsername());
        email.setText(user.getEmail());
        totalScore.setText( String.valueOf(user.getScore()));



    }
}
