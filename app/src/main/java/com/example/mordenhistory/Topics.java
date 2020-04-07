package com.example.mordenhistory;

import java.util.ArrayList;
import java.util.Vector;

public class Topics {

    Topics topic(){

        return null;
    }

    private String name;
    private String peroid;
    private ArrayList<Pdf> pdf;
    private Vector<YouTubeVideo> youtube;
    private ArrayList<Quiz> quiz;

    public Topics(String name, String peroid, ArrayList<Pdf> pdf, Vector<YouTubeVideo> youtube, ArrayList<Quiz> quiz) {
        this.name = name;
        this.peroid = peroid;
        this.pdf = pdf;
        this.youtube = youtube;
        this.quiz = quiz;
    }

    public String getPeroid() {
        return peroid;
    }

    public void setPeroid(String peroid) {
        this.peroid = peroid;
    }

    public ArrayList<Pdf> getPdf() {
        return pdf;
    }

    public void setPdf(ArrayList<Pdf> pdf) {
        this.pdf = pdf;
    }

    public Vector<YouTubeVideo> getYoutube() {
        return youtube;
    }

    public void setYoutube(Vector<YouTubeVideo> youtube) {
        this.youtube = youtube;
    }

    public ArrayList<Quiz> getQuiz() {
        return quiz;
    }

    public void setQuiz(ArrayList<Quiz> quiz) {
        this.quiz = quiz;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public static ArrayList<Topics> getTopics(){
     ArrayList<Topics> topics=new ArrayList<>();
     Vector<YouTubeVideo> youTubeEnlighment=new Vector<>();
     Vector<YouTubeVideo> youTubeAmericanR=new Vector<>();
     Vector<YouTubeVideo> youTubeFrenchR=new Vector<>();
     Vector<YouTubeVideo> youTubeIndustrialR=new Vector<>();
     Vector<YouTubeVideo> youTubeImperialism=new Vector<>();

     youTubeEnlighment.add(new YouTubeVideo("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/NnoFj2cMRLY\" frameborder=\"0\" allowfullscreen></iframe>"));

     youTubeEnlighment.add(new YouTubeVideo("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/S9AL0TUHuuM\" frameborder=\"0\" allowfullscreen></iframe>"));

     youTubeAmericanR.add(new YouTubeVideo("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/gzALIXcY4pg\" frameborder=\"0\" allowfullscreen></iframe>"));

     youTubeAmericanR.add(new YouTubeVideo("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/HlUiSBXQHCw\" frameborder=\"0\" allowfullscreen></iframe>"));

     youTubeFrenchR.add(new YouTubeVideo("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/5fJl_ZX91l0\" frameborder=\"0\" allowfullscreen></iframe>"));

     youTubeFrenchR.add(new YouTubeVideo("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/XmWc5BIhZHY\" frameborder=\"0\" allowfullscreen></iframe>"));

     youTubeIndustrialR.add(new YouTubeVideo("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/zjK7PWmRRyg\" frameborder=\"0\" allowfullscreen></iframe>"));

     youTubeIndustrialR.add(new YouTubeVideo("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/xLhNP0qp38Q\" frameborder=\"0\" allowfullscreen></iframe>"));

     youTubeImperialism.add(new YouTubeVideo("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/alJaltUmrGo\" frameborder=\"0\" allowfullscreen></iframe>"));

     youTubeImperialism.add(new YouTubeVideo("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/t_rHrGaoh4w\" frameborder=\"0\" allowfullscreen></iframe>"));



        return topics;
    }


}
