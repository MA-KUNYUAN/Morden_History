package com.example.mordenhistory;

public class UserInfo {

    private int ID;
    private String Name;
    private String Username;
    private int score;
    private String email;
    private String password;
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

    public UserInfo(){

    }

    public UserInfo(int ID, String name, String username, int score, String email, String password, int enlightenmentScore, int enlightenmentAttempt, int americanRevolutionScore, int americanRevolutionAttempt, int frenchRevolutionScore, int frenchRevolutionAttempt, int industrialRevolutionScore, int industrialRevolutionAttempt, int imperialismScore, int imperialismAttempt) {
        this.ID = ID;
        this.Name = name;
       this.Username = username;
        this.score = score;
        this.email = email;
        this.password = password;
        this.enlightenmentScore = enlightenmentScore;
        this.EnlightenmentAttempt = enlightenmentAttempt;
        this.americanRevolutionScore = americanRevolutionScore;
        this.americanRevolutionAttempt = americanRevolutionAttempt;
        this.frenchRevolutionScore = frenchRevolutionScore;
        this.frenchRevolutionAttempt = frenchRevolutionAttempt;
        this.industrialRevolutionScore = industrialRevolutionScore;
        this.industrialRevolutionAttempt = industrialRevolutionAttempt;
        this.imperialismScore = imperialismScore;
        this.imperialismAttempt = imperialismAttempt;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
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

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
