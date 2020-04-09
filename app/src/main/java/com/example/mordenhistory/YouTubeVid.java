package com.example.mordenhistory;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class YouTubeVid extends Fragment {

    public static final String ARG_ITEM_ID = "item_id";
    private Topics topic;
    private YouTubeVideo video;



    public YouTubeVid() {
        // Required empty public constructor
    }




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments().containsKey(ARG_ITEM_ID)) {
            video=YouTubeVideo.pick(getArguments().getString(ARG_ITEM_ID));
            this.getActivity().setTitle(video.getName());
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_you_tube_vid, container, false);

        if(topic != null) {

            ((TextView) rootView.findViewById(R.id.youTubeTitle)).setText(video.getName());


            //finding the image in the drawable file




            /*
            photo=(ImageView)findViewById(R.id.photo);
            String nameP=rest.getPic();

            int photo1=getResources().getIdentifier(nameP,"drawable", "com.example.top10");

            photo.setImageResource(photo1);

             */

        }

        return rootView;
    }
}
