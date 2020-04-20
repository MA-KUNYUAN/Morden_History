package com.example.mordenhistory.Models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

//class for the YouTube videos
//the class contains the videos name as well as the video's URL
public class YouTubeVideo implements Parcelable {
    public String URL;
    public String name;

    public YouTubeVideo(){

    }

    public YouTubeVideo(String URL, String name) {
        this.URL = URL;
        this.name = name;
    }

    protected YouTubeVideo(Parcel in) {
        URL = in.readString();
        name = in.readString();
    }

    public static final Creator<YouTubeVideo> CREATOR = new Creator<YouTubeVideo>() {
        @Override
        public YouTubeVideo createFromParcel(Parcel in) {
            return new YouTubeVideo(in);
        }

        @Override
        public YouTubeVideo[] newArray(int size) {
            return new YouTubeVideo[size];
        }
    };

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    //The method will only get the YouTube Video's associated to the specific title

    public static ArrayList<YouTubeVideo> getVideo(String title){
        ArrayList<Topics> topic=Topics.getTopics();
        ArrayList<Topics> topic2=new ArrayList<>();
        ArrayList<YouTubeVideo> vid3=new ArrayList<>();
        for(int i=0; i<topic.size(); i++){
            if((topic.get(i).getName()).equals(title)) {
                topic2.add(topic.get(i));
            }
        }

        for(int i=0; i<topic2.size() ; i++){

            Topics topic3=topic2.get(i);

            ArrayList<YouTubeVideo> vid1=topic3.getYoutube();

            for(int k = 0; k<vid1.size(); k++){

                vid3.add(vid1.get(k));
            }


        }

        return vid3;


    }

    //this method will return only the Videos associated the a particular topic name
    public static YouTubeVideo pick(String nameR){
        ArrayList<Topics> topic=Topics.getTopics();
       ArrayList<YouTubeVideo> vid=new ArrayList<>();
        for(int i=0; i< topic.size();i++ ){
            Topics topic1=topic.get(i);

            ArrayList<YouTubeVideo> vid1=topic1.getYoutube();

            for(int k = 0; k<vid1.size(); k++){

                vid.add(vid1.get(k));
            }


        }

        for(YouTubeVideo l: vid){

            if (nameR.equals(l.getName())){
                return l;
            }
        }
        return null;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(URL);
        dest.writeString(name);
    }
}
