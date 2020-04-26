package com.example.mordenhistory.Models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

//creating the topic class
// the class will hold each topics name, the time peroid of the topic as well as the youtube videos, pdf attached to the topic
//Parcelable defines a way a object packaged
public class Topics implements Parcelable {

    protected Topics(Parcel in) {
        name = in.readString();
        peroid = in.readString();
    }

    public static final Creator<Topics> CREATOR = new Creator<Topics>() {
        @Override
        public Topics createFromParcel(Parcel in) {
            return new Topics(in);
        }

        @Override
        public Topics[] newArray(int size) {
            return new Topics[size];
        }
    };

    Topics topic() {

        return null;
    }

    private String name;
    private String peroid;
    private ArrayList<Pdf> pdf;
    private ArrayList<YouTubeVideo> youtube;


    public Topics(String name, String peroid, ArrayList<Pdf> pdf, ArrayList<YouTubeVideo> youtube) {
        this.name = name;
        this.peroid = peroid;
        this.pdf = pdf;
        this.youtube = youtube;
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

    public ArrayList<YouTubeVideo> getYoutube() {
        return youtube;
    }

    public void setYoutube(ArrayList<YouTubeVideo> youtube) {
        this.youtube = youtube;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    //creating the data associated with each topic
    //putting each new topic in a Topic ArrayList

    public static ArrayList<Topics> getTopics() {
        ArrayList<Topics> topics = new ArrayList<>();
        ArrayList<YouTubeVideo> youTubeEnlighment = new ArrayList<>();
        ArrayList<YouTubeVideo> youTubeAmericanR = new ArrayList<>();
        ArrayList<YouTubeVideo> youTubeFrenchR = new ArrayList<>();
        ArrayList<YouTubeVideo> youTubeIndustrialR = new ArrayList<>();
        ArrayList<YouTubeVideo> youTubeImperialism = new ArrayList<>();

        youTubeEnlighment.add(new YouTubeVideo("NnoFj2cMRLY", "The Enlightenment:Crash Course European History #18"));

        youTubeEnlighment.add(new YouTubeVideo("S9AL0TUHuuM", "What wa the Enlightenment?"));

        youTubeAmericanR.add(new YouTubeVideo("gzALIXcY4pg", "The American Revolution-OverSimplified"));

        youTubeAmericanR.add(new YouTubeVideo("HlUiSBXQHCw", "Tea Taxes, and The American Revolution: Crash Course World History #28"));

        youTubeFrenchR.add(new YouTubeVideo("5fJl_ZX91l0", "The French Revolution: Crash Course European History #21 "));

        youTubeFrenchR.add(new YouTubeVideo("XmWc5BIhZHY", "The French Revolution In a Nutshell"));

        youTubeIndustrialR.add(new YouTubeVideo("zjK7PWmRRyg", "The Industrial Revolution:Crash European History #24"));

        youTubeIndustrialR.add(new YouTubeVideo("xLhNP0qp38Q", "The Industrial Revolution(18th-19th Century)"));

        youTubeImperialism.add(new YouTubeVideo("alJaltUmrGo", "Imperialism: Crash Course World History #35 "));

        youTubeImperialism.add(new YouTubeVideo("t_rHrGaoh4w", "European Imperialism for Dummies"));

        ArrayList<Pdf> enlightmentPdf = new ArrayList<>();
        ArrayList<Pdf> americanRPdf = new ArrayList<>();
        ArrayList<Pdf> frenchRPdf = new ArrayList<>();
        ArrayList<Pdf> industrialRPdf = new ArrayList<>();
        ArrayList<Pdf> imperialismRPdf = new ArrayList<>();

        enlightmentPdf.add(new Pdf("Enlightment.pdf"));
        americanRPdf.add(new Pdf("American_Revolution.pdf"));
        frenchRPdf.add(new Pdf("French_Revolution.pdf"));
        imperialismRPdf.add(new Pdf("Imperialism.pdf"));
        industrialRPdf.add(new Pdf("Industrial_Revolution.pdf"));


        topics.add(new Topics("Enlightenment", "1750-1789", enlightmentPdf, youTubeEnlighment));
        topics.add(new Topics("American Revolution", "1763-1812", americanRPdf, youTubeAmericanR));
        topics.add(new Topics("French Revolution", "1744-1799", frenchRPdf, youTubeFrenchR));
        topics.add(new Topics("Industrial Revolution", "1750-1890", industrialRPdf, youTubeIndustrialR));
        topics.add(new Topics("The age of Imperialism", "1848-1940", imperialismRPdf, youTubeImperialism));


        return topics;
    }

    //will help determine which object has been selected by comparing the name that was selected to the names of each object
    public static Topics pick(String nameR) {
        for (Topics t : getTopics()) {
            if (nameR.equals(t.getName())) {

                return t;
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
        dest.writeString(name);
        dest.writeString(peroid);
    }
}
