package com.example.mordenhistory;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Detail_Option extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_options);

        if (getIntent().hasExtra("selected_note")) {
            Topics topic = getIntent().getParcelableExtra("selected_note");

            //set the TextView to the name of the object
            TextView title=(TextView)findViewById(R.id.title1);
            title.setText(topic.getName());

        }


    }

    //Onclick method for You Tube Videos Button
    public void YouTubeVideo(View v){
        Intent intent=new Intent(Detail_Option.this, YouTubeList.class );
        TextView title2=(TextView)findViewById(R.id.title1);
        String title= (String) title2.getText();
        intent.putExtra("topic_title", title );
        startActivity(intent);

    }

    //Onclick method for Pdf Videos Button
    public void PdfView(View view){
        Intent intent=new Intent(Detail_Option.this, PdfList.class );
        TextView title2=(TextView)findViewById(R.id.title1);
        String title= (String) title2.getText();
        intent.putExtra("topic_title1", title );
        startActivity(intent);

    }

    //Onclick method for Pdf Quiz Button
    public void takeQuiz(View view){
        Intent intent=new Intent(Detail_Option.this, StartQuiz.class);
        TextView title2=(TextView)findViewById(R.id.title1);
        String title= (String) title2.getText();
        intent.putExtra("topic_title1", title );
        startActivity(intent);

    }

}
