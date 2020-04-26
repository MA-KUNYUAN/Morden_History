package com.example.mordenhistory;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.mordenhistory.Adapter.PdfAdapter;
import com.example.mordenhistory.Models.Pdf;

import java.util.ArrayList;

public class PdfList extends AppCompatActivity implements PdfAdapter.OnClickListener {


    ArrayList<Pdf> pdf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_list);

        RecyclerView rvPdf = findViewById(R.id.pdf_rv);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        String topic = (String) extras.get("topic_title1");
        setTitle(topic);
        //gets relevant pdf by passing the topic name to the method
        pdf = Pdf.getPdf(topic);

        //sets up the recyclerView
        PdfAdapter adapter = new PdfAdapter(pdf, this);
        rvPdf.setAdapter(adapter);
        rvPdf.setLayoutManager(new LinearLayoutManager(this));

    }


    //OnClick method if an item in the recyclerView is clicked then the user will go the the PdfView screen
    //The pdf name is also passed
    @Override
    public void OnClick(int position) {

        Intent intent = new Intent(this, PdfView.class);
        //data of selected item is passed
        intent.putExtra("selected_note2", pdf.get(position));
        startActivity(intent);

    }
}
