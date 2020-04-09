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

public class YouTubeAdapter extends RecyclerView.Adapter<YouTubeAdapter.YouTubeViewHolder> {
    @NonNull


    private YouTubeList mParentActivity;
    private ArrayList<YouTubeVideo> mVid;
    private boolean mTwoPane;

    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            YouTubeVideo youTube = (YouTubeVideo) v.getTag();
            Topics topic=(Topics) v.getTag();
            //if device has a wide screen initialise fragment in the detail container
            //else switch to new activity
            if(mTwoPane) {
                Bundle arguments = new Bundle();
                arguments.putString(YouTubeVid.ARG_ITEM_ID, youTube.getName());
                YouTubeVid fragment = new YouTubeVid();
                fragment.setArguments(arguments);

                mParentActivity.getSupportFragmentManager().beginTransaction().replace(R.id.detailContainer, fragment).commit();
            } else {
                Context context = v.getContext();
                Intent intent = new Intent(context, DetailYoutube.class);
                intent.putExtra(YouTubeVid.ARG_ITEM_ID, youTube.getName());
                context.startActivity(intent);
            }
        }
    };

    public YouTubeAdapter(YouTubeList parent, ArrayList<YouTubeVideo> vid1, boolean twoPane) {
        mParentActivity = parent;
        mVid = vid1;
        mTwoPane = twoPane;
    }

    public static class YouTubeViewHolder extends RecyclerView.ViewHolder  {
        public TextView name;

        public YouTubeViewHolder(View v) {
            super(v);
            name = v.findViewById(R.id.yName);
        }
    }

    @Override
    public YouTubeAdapter.YouTubeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating itemr XML in recyclerview
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.you_tube_item, parent, false);
        return new YouTubeViewHolder(v);
    }

    @Override
    public void onBindViewHolder(YouTubeViewHolder holder, int position) {
        //populating textView with restaurant data by calling get methods.
        // and initialising the onClickListner
        YouTubeVideo video1 = mVid.get(position);
        holder.name.setText(video1.getName());
        holder.itemView.setTag(video1);
        holder.itemView.setOnClickListener(mOnClickListener);
    }

    @Override
    public int getItemCount() {
        return mVid.size();
    }

    /*

    public YouTubeAdapter.YouTubeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull YouTubeAdapter.YouTubeViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

     */
}
