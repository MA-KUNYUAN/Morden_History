package com.example.mordenhistory;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

//setting up the topicAdapter that will be used in the MainActivity that will display all the topics through the use of a recyclerView
public class TopicAdapter extends RecyclerView.Adapter<TopicAdapter.ViewHolder> {

    private final OnClickListener onCklickListner;



    //private final OnClickListener OnCklickListner;

    //setting up the OnClickListener Interface that will be implemented by the main activity as wel as the recyclerView
    public interface OnClickListener {
        void OnClick(int position);
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView topicName;
        public TextView peroid;
        OnClickListener onClickListener;

        public ViewHolder(View itemView, OnClickListener onClickListener){

            super(itemView);

            topicName=(TextView) itemView.findViewById(R.id.topicName);
            peroid=(TextView) itemView.findViewById(R.id.peroid);
            this.onClickListener=onClickListener;
            itemView.setOnClickListener(this);

        }


// OnClick method which will help determine which item was selected by the used
        @Override
        public void onClick(View v) {
            onClickListener.OnClick(getAdapterPosition());
        }
    }

    private List<Topics> mTopic;

    public  TopicAdapter(List<Topics> coins, OnClickListener mOnClickListner){
        mTopic=coins;
        this.onCklickListner=mOnClickListner;

    }

    @Override
    public TopicAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View coinView = inflater.inflate(R.layout.topic_item, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(coinView, onCklickListner);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(TopicAdapter.ViewHolder viewHolder, int position) {
        // Get the data model based on position
        Topics topic = mTopic.get(position);

        // Set item views based on your views and data model
        TextView textView;
        textView = viewHolder.topicName;
        textView.setText(topic.getName());

        TextView textView2 = viewHolder.peroid;
        textView2.setText(topic.getPeroid());



    }


    @Override
    public int getItemCount() {
        return mTopic.size();
    }


}
