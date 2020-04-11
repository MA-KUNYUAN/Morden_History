package com.example.mordenhistory;

import java.util.ArrayList;
import java.util.Vector;

public class YouTubeVideo {
    public String URL;
    public String name;

    public YouTubeVideo(){

    }

    public YouTubeVideo(String URL, String name) {
        this.URL = URL;
        this.name = name;
    }

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

    public static ArrayList<YouTubeVideo> getVideo(String title){
        ArrayList<Topics> topic=Topics.getTopics();
        ArrayList<Topics> topic2=new ArrayList<>();
        ArrayList<YouTubeVideo> vid3=new ArrayList<>();
        for(int i=0; i<topic.size(); i++){
            if((topic.get(i).getName()).equals(title))
                topic2.add(topic.get(i));
        }

        for(int i=0; i<topic2.size() ; i++){

            Topics topic1=topic.get(i);

            ArrayList<YouTubeVideo> vid1=topic1.getYoutube();

            for(int k = 0; k<vid1.size(); k++){

                vid3.add(vid1.get(k));
            }


        }

        return vid3;


    }

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
}
