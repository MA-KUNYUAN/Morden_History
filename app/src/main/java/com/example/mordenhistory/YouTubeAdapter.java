package com.example.mordenhistory;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class YouTubeAdapter extends RecyclerView.Adapter<YouTubeAdapter.ViewHolder> {

    private final OnClickListener onCklickListner;


    //private final OnClickListener OnCklickListner;

    //setting up the OnClickListener Interface that will be implemented by the main activity as wel as the recyclerView
    public interface OnClickListener {
        void OnClick(int position);
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView videoName;
        //public TextView peroid;
        OnClickListener onClickListener;



        public ViewHolder(View itemView, OnClickListener onClickListener) {

            super(itemView);

            videoName = (TextView) itemView.findViewById(R.id.youTubeName);
            //peroid=(TextView) itemView.findViewById(R.id.peroid);
            this.onClickListener = onClickListener;
            itemView.setOnClickListener(this);

        }


        // OnClick method which will help determine which item was selected by the used
        @Override
        public void onClick(View v) {
            onClickListener.OnClick(getAdapterPosition());
        }
    }

    private List<YouTubeVideo> mVid;

    public YouTubeAdapter(List<YouTubeVideo> coins, OnClickListener mOnClickListner) {
        mVid = coins;
        this.onCklickListner = mOnClickListner;

    }

    @Override
    public YouTubeAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View coinView = inflater.inflate(R.layout.you_tube_item, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(coinView, onCklickListner);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(YouTubeAdapter.ViewHolder viewHolder, int position) {
        // Get the data model based on position
        YouTubeVideo topic = mVid.get(position);

        // Set item views based on your views and data model
        TextView textView;
        textView = viewHolder.videoName;
        textView.setText(topic.getName());


    }


    @Override
    public int getItemCount() {
        return mVid.size();
    }


}


