package com.example.mordenhistory;

public class UserInfo {
    private int ID;
    private String UserAcc;
    private String Password;
    private String UserName;
    private int TotalScore;

    public UserInfo(){

    }

    public UserInfo(int ID,String UserAcc,String Password,String UserName,int TotalScore){
        this.ID = ID;
        this.UserAcc = UserAcc;
        this.Password = Password;
        this.UserName = UserName;
        this.TotalScore = TotalScore;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getUserAcc() {
        return UserAcc;
    }

    public void setUserAcc(String userAcc) {
        UserAcc = userAcc;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public int getTotalScore() {
        return TotalScore;
    }

    public void setTotalScore(int totalScore) {
        TotalScore = totalScore;
    }
}
