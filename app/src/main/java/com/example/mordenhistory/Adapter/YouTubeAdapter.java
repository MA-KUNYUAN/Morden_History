package com.example.mordenhistory.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.mordenhistory.R;
import com.example.mordenhistory.Models.YouTubeVideo;

import java.util.List;


//adapter follows a similar logic to the TopicAdapter
public class YouTubeAdapter extends RecyclerView.Adapter<YouTubeAdapter.ViewHolder> {

    private final OnClickListener onCklickListner;

    public interface OnClickListener {
        void OnClick(int position);
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView videoName;
        OnClickListener onClickListener;



        public ViewHolder(View itemView, OnClickListener onClickListener) {

            super(itemView);

            videoName = (TextView) itemView.findViewById(R.id.youTubeName);
            this.onClickListener = onClickListener;
            itemView.setOnClickListener(this);

        }


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

        View coinView = inflater.inflate(R.layout.you_tube_item, parent, false);


        ViewHolder viewHolder = new ViewHolder(coinView, onCklickListner);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(YouTubeAdapter.ViewHolder viewHolder, int position) {

        YouTubeVideo topic = mVid.get(position);
        TextView textView;
        textView = viewHolder.videoName;
        textView.setText(topic.getName());


    }


    @Override
    public int getItemCount() {
        return mVid.size();
    }


}


