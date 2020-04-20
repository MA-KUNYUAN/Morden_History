package com.example.mordenhistory.Models;

//This is the UerInfo class it represents all the users of the system
public class UserInfo {

    private int id;
    private String name;
    private String userName;
    private int score;
    private String email;
    private String password;
    private int enlightenmentScore;
    private int enlightenmentAttempt;
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

    public UserInfo(int id, String name, String userName, int score, String email, String password, int enlightenmentScore, int enlightenmentAttempt, int americanRevolutionScore, int americanRevolutionAttempt, int frenchRevolutionScore, int frenchRevolutionAttempt, int industrialRevolutionScore, int industrialRevolutionAttempt, int imperialismScore, int imperialismAttempt) {
        this.id = id;
        this.name = name;
        this.userName = userName;
        this.score = score;
        this.email = email;
        this.password = password;
        this.enlightenmentScore = enlightenmentScore;
        this.enlightenmentAttempt = enlightenmentAttempt;
        this.americanRevolutionScore = americanRevolutionScore;
        this.americanRevolutionAttempt = americanRevolutionAttempt;
        this.frenchRevolutionScore = frenchRevolutionScore;
        this.frenchRevolutionAttempt = frenchRevolutionAttempt;
        this.industrialRevolutionScore = industrialRevolutionScore;
        this.industrialRevolutionAttempt = industrialRevolutionAttempt;
        this.imperialismScore = imperialismScore;
        this.imperialismAttempt = imperialismAttempt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
        return enlightenmentAttempt;
    }

    public void setEnlightenmentAttempt(int enlightenmentAttempt) {
        this.enlightenmentAttempt = enlightenmentAttempt;
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
