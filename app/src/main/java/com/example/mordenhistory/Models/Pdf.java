package com.example.mordenhistory.Models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

//pdf class which contains the name of the pdf
public class Pdf implements Parcelable {

    String namePDF;

    public Pdf(){

    }

    public Pdf(String namePDF) {
        this.namePDF = namePDF;
    }

    protected Pdf(Parcel in) {
        namePDF = in.readString();
    }

    public static final Creator<Pdf> CREATOR = new Creator<Pdf>() {
        @Override
        public Pdf createFromParcel(Parcel in) {
            return new Pdf(in);
        }

        @Override
        public Pdf[] newArray(int size) {
            return new Pdf[size];
        }
    };

    public String getNamePDF() {
        return namePDF;
    }

    public void setNamePDF(String namePDF) {
        this.namePDF = namePDF;
    }

    //method created to find relevant pdf associated to the title
    public static ArrayList<Pdf> getPdf(String title){
        //gets all the Topics object from the topics class
        ArrayList<Topics> topic=Topics.getTopics();
        ArrayList<Topics> topic2=new ArrayList<>();
        ArrayList<Pdf> pdf3=new ArrayList<>();

        //if String title is equal to the name of the Topic then Topic will be added to topic2 ArrayList
        for(int i=0; i<topic.size(); i++){
            if((topic.get(i).getName()).equals(title)) {
                topic2.add(topic.get(i));
            }
        }

        //Getting the the pdf of the relevant topic then adding it to the pdf ArrayList
        for(int i=0; i<topic2.size() ; i++){

            Topics topic1=topic2.get(i);

            ArrayList<Pdf> pdf1=topic1.getPdf();

            for(int k = 0; k<pdf1.size(); k++){

                pdf3.add(pdf1.get(k));
            }


        }

        return pdf3;


    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(namePDF);
    }
}
