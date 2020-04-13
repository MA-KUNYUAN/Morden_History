package com.example.mordenhistory;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

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

    public static ArrayList<Pdf> getPdf(String title){
        ArrayList<Topics> topic=Topics.getTopics();
        ArrayList<Topics> topic2=new ArrayList<>();
        ArrayList<Pdf> pdf3=new ArrayList<>();
        for(int i=0; i<topic.size(); i++){
            if((topic.get(i).getName()).equals(title)) {
                topic2.add(topic.get(i));
            }
        }

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
