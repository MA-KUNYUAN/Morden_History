package com.example.mordenhistory;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.Vector;
import java.util.function.Predicate;

//creating the topic class
  // the class will hold each topics name, the time peroid of the topic as well as the youtube videos and
  //Parcelable defines a way to package objects
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

      Topics topic(){

        return null;
    }

    private String name;
    private String peroid;
    private ArrayList<Pdf> pdf;
    private ArrayList<YouTubeVideo> youtube;
    private ArrayList<Quiz> quiz;


    public Topics(String name, String peroid, ArrayList<Pdf> pdf, ArrayList<YouTubeVideo> youtube, ArrayList<Quiz> quiz) {
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

      public ArrayList<YouTubeVideo> getYoutube() {
          return youtube;
      }

      public void setYoutube(ArrayList<YouTubeVideo> youtube) {
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


      //creating the data associated with each topic
    //putting each new topics data in a Topic ArrayList

    public static ArrayList<Topics> getTopics(){
     ArrayList<Topics> topics=new ArrayList<>();
     ArrayList<YouTubeVideo> youTubeEnlighment=new ArrayList<>();
    ArrayList<YouTubeVideo> youTubeAmericanR=new ArrayList<>();
     ArrayList<YouTubeVideo> youTubeFrenchR=new ArrayList<>();
     ArrayList<YouTubeVideo> youTubeIndustrialR=new ArrayList<>();
      ArrayList<YouTubeVideo> youTubeImperialism=new ArrayList<>();

     youTubeEnlighment.add(new YouTubeVideo("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/NnoFj2cMRLY\" frameborder=\"0\" allowfullscreen></iframe>", "The Enlightenment:Crash Course European History #18"));

     youTubeEnlighment.add(new YouTubeVideo("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/S9AL0TUHuuM\" frameborder=\"0\" allowfullscreen></iframe>", "What wa the Enlightenment?"));

     youTubeAmericanR.add(new YouTubeVideo("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/gzALIXcY4pg\" frameborder=\"0\" allowfullscreen></iframe>", "The American Revolution-OverSimplified"));

     youTubeAmericanR.add(new YouTubeVideo("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/HlUiSBXQHCw\" frameborder=\"0\" allowfullscreen></iframe>", "Tea Taxes, and The American Revolution: Crash Course World History #28" ));

     youTubeFrenchR.add(new YouTubeVideo("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/5fJl_ZX91l0\" frameborder=\"0\" allowfullscreen></iframe>", "The French Revolution: Crash Course European History #21 "));

     youTubeFrenchR.add(new YouTubeVideo("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/XmWc5BIhZHY\" frameborder=\"0\" allowfullscreen></iframe>", "The French Revolution In a Nutshell"));

     youTubeIndustrialR.add(new YouTubeVideo("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/zjK7PWmRRyg\" frameborder=\"0\" allowfullscreen></iframe>", "The Industrial Revolution:Crash European History #24"));

     youTubeIndustrialR.add(new YouTubeVideo("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/xLhNP0qp38Q\" frameborder=\"0\" allowfullscreen></iframe>","The Industrial Revolution(18th-19th Century)"));

     youTubeImperialism.add(new YouTubeVideo("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/alJaltUmrGo\" frameborder=\"0\" allowfullscreen></iframe>","Imperialism: Crash Course World History #35 "));

     youTubeImperialism.add(new YouTubeVideo("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/t_rHrGaoh4w\" frameborder=\"0\" allowfullscreen></iframe>", "European Imperialism for Dummies"));

     ArrayList<Pdf> enlightmentPdf=new ArrayList<>();
     ArrayList<Pdf> americanRPdf=new ArrayList<>();
     ArrayList<Pdf> frenchRPdf=new ArrayList<>();
     ArrayList<Pdf> industrialRPdf=new ArrayList<>();
     ArrayList<Pdf> imperialismRPdf=new ArrayList<>();

     enlightmentPdf.add(new Pdf("Enlightment.pdf"));
     americanRPdf.add(new Pdf("American_Revolution.pdf"));
     frenchRPdf.add(new Pdf("French_Revolution.pdf"));
     imperialismRPdf.add(new Pdf("Imperialism.pdf"));
     industrialRPdf.add(new Pdf("Industrial_Revoltion.pdf"));

     ArrayList<Quiz> enlightmentQuiz=new ArrayList<>();
     ArrayList<Quiz> americanQuiz=new ArrayList<>();
     ArrayList<Quiz> frenchQuiz=new ArrayList<>();
     ArrayList<Quiz> industrialQuiz=new ArrayList<>();
     ArrayList<Quiz> imperialismQuiz=new ArrayList<>();

     enlightmentQuiz.add(new Quiz());
     americanQuiz.add(new Quiz());
     frenchQuiz.add(new Quiz());
     industrialQuiz.add(new Quiz());
     imperialismQuiz.add(new Quiz());

     topics.add(new Topics("Enlightenment", "1750-1789", enlightmentPdf, youTubeEnlighment, enlightmentQuiz  ));
     topics.add(new Topics("American Revolution", "1763-1812", americanRPdf, youTubeAmericanR, americanQuiz));
        topics.add(new Topics("French Revolution", "1744-1799", frenchRPdf, youTubeFrenchR, frenchQuiz));
        topics.add(new Topics("Industrial Revolution", "1750-1890", industrialRPdf, youTubeIndustrialR,industrialQuiz));
        topics.add(new Topics("The age of Imperialism", "1848-1940", imperialismRPdf, youTubeImperialism, imperialismQuiz));


        return topics;
    }

    //will help determine which object has been selected by comparing the name that was selected to the names of each object
    public static Topics pick(String nameR){
        for(Topics t: getTopics()){
            if (nameR.equals(t.getName())){

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
