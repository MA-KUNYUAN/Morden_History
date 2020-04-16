package com.example.mordenhistory;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PdfAdapter extends RecyclerView.Adapter<PdfAdapter.ViewHolder> {

    private final OnClickListener onCklickListner;




    //setting up the OnClickListener Interface that will be implemented by the main activity as wel as the recyclerView
    public interface OnClickListener {
        void OnClick(int position);
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView pdfName1;
        //public TextView peroid;
        OnClickListener onClickListener;



        public ViewHolder(View itemView, OnClickListener onClickListener) {

            super(itemView);

            pdfName1 = (TextView) itemView.findViewById(R.id.pdfName);
            this.onClickListener = onClickListener;
            itemView.setOnClickListener(this);

        }


        // OnClick method which will help determine which item was selected by the user
        @Override
        public void onClick(View v) {
            onClickListener.OnClick(getAdapterPosition());
        }
    }

    private List<Pdf> mPdf;

    public PdfAdapter(List<Pdf> coins, OnClickListener mOnClickListner) {
        mPdf = coins;
        this.onCklickListner = mOnClickListner;

    }

    @Override
    public PdfAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View coinView = inflater.inflate(R.layout.pdf_item, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(coinView, onCklickListner);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(PdfAdapter.ViewHolder viewHolder, int position) {
        // Get the data model based on position
        Pdf topic = mPdf.get(position);

        // Set item views based on your views and data model
        TextView textView;
        textView = viewHolder.pdfName1;
        textView.setText(topic.getNamePDF());


    }


    @Override
    public int getItemCount() {
        return mPdf.size();
    }


}
