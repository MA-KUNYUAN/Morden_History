package com.example.mordenhistory;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

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

    public void toNotebook(View v){
        //invoke the fragment of notebook
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        Fragment fragment = new NoteFragment();
//        Bundle bundle = new Bundle();
//        bundle.putInt("SSDetail",coinnumber);
//        fragment.setArguments(bundle);
        transaction.replace(R.id.ReplaceableLayout, fragment);
        transaction.commit();
    }
}
