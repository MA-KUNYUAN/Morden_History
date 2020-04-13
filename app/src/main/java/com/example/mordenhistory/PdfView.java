package com.example.mordenhistory;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class PdfView extends AppCompatActivity {
    PDFView book;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_view);

        book=(PDFView)findViewById(R.id.pdfBook);

        Pdf pdf = getIntent().getParcelableExtra("selected_note2");
        String actualBook=pdf.namePDF;

        book.fromAsset(actualBook).load();
    }
}
