package com.example.mordenhistory.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.mordenhistory.R;
import com.example.mordenhistory.Models.UserInfo;

import java.util.ArrayList;

public class LeaderAdapter extends RecyclerView.Adapter<LeaderAdapter.MyViewHolder> {
    ArrayList<UserInfo> myArray;


    public LeaderAdapter(ArrayList<UserInfo> myArray) {
        this.myArray = myArray;
    }

    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.leader_row_example, parent, false);
        return new MyViewHolder(v);
    }

    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.ScoreRank.setText(String.valueOf(position+1));
        holder.UserName.setText(myArray.get(position).getUserName());
        holder.UserScore.setText(String.valueOf(myArray.get(position).getScore())+" points");

    }

    public int getItemCount() {
        return myArray.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        //Declare the views from the row xml
        TextView ScoreRank;
        TextView UserName;
        TextView UserScore;

        //Constructor
        public MyViewHolder( View itemView) {
            super(itemView);

            //initialise views
            this.ScoreRank = itemView.findViewById(R.id.ScoreRank);
            this.UserName = itemView.findViewById(R.id.UserName);
            this.UserScore = itemView.findViewById(R.id.UserScore);

        }
    }

}
