package com.example.mordenhistory;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.mordenhistory.Models.Pdf;
import com.github.barteksc.pdfviewer.PDFView;

public class PdfView extends AppCompatActivity {

    //getting pdf from the intent then loading the book onto the screen
    PDFView book;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_view);

        book=(PDFView)findViewById(R.id.pdfBook);

        Pdf pdf = getIntent().getParcelableExtra("selected_note2");
        String actualBook=pdf.getNamePDF();

        book.fromAsset(actualBook).load();
    }
}
