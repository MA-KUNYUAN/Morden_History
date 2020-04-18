package com.example.mordenhistory;

//setting up current user class which represents the user currently in the system
public class User {

    private final String Name="Peter White";
    private final String Username="Peter";
    private int score;
    private final String email="peter.white@gmail.com";
    private final String password="darkgrey";
    private int enlightenmentScore;
    private int EnlightenmentAttempt;
    private int americanRevolutionScore;
    private int americanRevolutionAttempt;
    private int frenchRevolutionScore;
    private int frenchRevolutionAttempt;
    private int industrialRevolutionScore;
    private int industrialRevolutionAttempt;
    private int imperialismScore;
    private int imperialismAttempt;

    public User(int score, int enlightenmentScore, int enlightenmentAttempt, int americanRevolutionScore, int americanRevolutionAttempt, int frenchRevolutionScore, int frenchRevolutionAttempt, int industrialRevolutionScore, int industrialRevolutionAttempt, int imperialismScore, int imperialismAttempt) {
        this.score = score;
        this.enlightenmentScore = enlightenmentScore;
        EnlightenmentAttempt = enlightenmentAttempt;
        this.americanRevolutionScore = americanRevolutionScore;
        this.americanRevolutionAttempt = americanRevolutionAttempt;
        this.frenchRevolutionScore = frenchRevolutionScore;
        this.frenchRevolutionAttempt = frenchRevolutionAttempt;
        this.industrialRevolutionScore = industrialRevolutionScore;
        this.industrialRevolutionAttempt = industrialRevolutionAttempt;
        this.imperialismScore = imperialismScore;
        this.imperialismAttempt = imperialismAttempt;
    }

    public String getName() {
        return Name;
    }

    public String getUsername() {
        return Username;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public int getEnlightenmentScore() {
        return enlightenmentScore;
    }

    public void setEnlightenmentScore(int enlightenmentScore) {
        this.enlightenmentScore = enlightenmentScore;
    }

    public int getEnlightenmentAttempt() {
        return EnlightenmentAttempt;
    }

    public void setEnlightenmentAttempt(int enlightenmentAttempt) {
        EnlightenmentAttempt = enlightenmentAttempt;
    }

    public int getAmericanRevolutionScore() {
        return americanRevolutionScore;
    }

    public void setAmericanRevolutionScore(int americanRevolutionScore) {
        this.americanRevolutionScore = americanRevolutionScore;
    }

    public int getAmericanRevolutionAttempt() {
        return americanRevolutionAttempt;
    }

    public void setAmericanRevolutionAttempt(int americanRevolutionAttempt) {
        this.americanRevolutionAttempt = americanRevolutionAttempt;
    }

    public int getFrenchRevolutionScore() {
        return frenchRevolutionScore;
    }

    public void setFrenchRevolutionScore(int frenchRevolutionScore) {
        this.frenchRevolutionScore = frenchRevolutionScore;
    }

    public int getFrenchRevolutionAttempt() {
        return frenchRevolutionAttempt;
    }

    public void setFrenchRevolutionAttempt(int frenchRevolutionAttempt) {
        this.frenchRevolutionAttempt = frenchRevolutionAttempt;
    }

    public int getIndustrialRevolutionScore() {
        return industrialRevolutionScore;
    }

    public void setIndustrialRevolutionScore(int industrialRevolutionScore) {
        this.industrialRevolutionScore = industrialRevolutionScore;
    }

    public int getIndustrialRevolutionAttempt() {
        return industrialRevolutionAttempt;
    }

    public void setIndustrialRevolutionAttempt(int industrialRevolutionAttempt) {
        this.industrialRevolutionAttempt = industrialRevolutionAttempt;
    }

    public int getImperialismScore() {
        return imperialismScore;
    }

    public void setImperialismScore(int imperialismScore) {
        this.imperialismScore = imperialismScore;
    }

    public int getImperialismAttempt() {
        return imperialismAttempt;
    }

    public void setImperialismAttempt(int imperialismAttempt) {
        this.imperialismAttempt = imperialismAttempt;
    }
}
