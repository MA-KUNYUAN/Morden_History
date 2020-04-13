package com.example.mordenhistory;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class PdfList extends AppCompatActivity implements PdfAdapter.OnClickListener {



    ArrayList<Pdf> pdf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_list);

        RecyclerView rvPdf = (RecyclerView) findViewById(R.id.pdf_rv);

        Intent intent=getIntent();
        Bundle extras=intent.getExtras();
        String topic= (String) extras.get("topic_title1");

        pdf = Pdf.getPdf(topic);




        // String pdfname=pdf.get(0).namePDF;


        PdfAdapter adapter=new PdfAdapter(pdf, (PdfAdapter.OnClickListener)this);

        //TopicAdapter adapter = new TopicAdapter(topic, (TopicAdapter.OnClickListener) this);

        rvPdf.setAdapter(adapter);
        rvPdf.setLayoutManager(new LinearLayoutManager(this));

    }


    /*
    private void launchApp() {

        RecyclerView rvPdf = (RecyclerView) findViewById(R.id.pdf_rv);

        Intent intent=getIntent();
        Bundle extras=intent.getExtras();
        String topic= (String) extras.get("topic_title1");

       pdf = Pdf.getPdf(topic);




      // String pdfname=pdf.get(0).namePDF;


        PdfAdapter adapter=new PdfAdapter(pdf, (PdfAdapter.OnClickListener)this);

        //TopicAdapter adapter = new TopicAdapter(topic, (TopicAdapter.OnClickListener) this);

        rvPdf.setAdapter(adapter);
        rvPdf.setLayoutManager(new LinearLayoutManager(this));

    }

     */

    @Override
    public void OnClick(int position) {

        Intent intent =new Intent (this, PdfView.class);
        //data of selected item is passed
        intent.putExtra("selected_note2",  pdf.get(position));
        startActivity(intent);

    }
}
