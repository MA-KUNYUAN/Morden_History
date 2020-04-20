package com.example.mordenhistory.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class DatabaseHelp2 extends SQLiteOpenHelper {
    //database name
    public static final String DATABASE2_NAME = "UserInformation.db";

    //table name and column names
    public static final String USER_TABLE_NAME = "user_table";
    public static final String COL_1 = "UID";
    public static final String COL_2 = "userFullName";
    public static final String COL_3 = "UserName";
    public static final String COL_4 = "TotalScore";
    public static final String COL_5 = "email";
    public static final String COL_6 = "Password";
    public static final String Col_7="enlightenmentScore";
    public static final String Col_8="EnlightenmentAttempt";
    public static final String Col_9="americanRevolutionScore";
    public static final String Col_10="americanRevolutionAttempt";
    public static final String Col_11="frenchRevolutionScore";
    public static final String Col_12="frenchRevolutionAttempt";
    public static final String Col_13="industrialRevolutionScore";
    public static final String Col_14="industrialRevolutionAttempt";
    public static final String Col_15="imperialismScore";
    public static final String Col_16="imperialismAttempt";

    private static final int DATABASE2_VERSION = 1;

    public DatabaseHelp2(Context context) {
        super(context, DATABASE2_NAME, null, DATABASE2_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //create database table
        final String SQL_CREATE_USERS_TABLE ="CREATE TABLE IF NOT EXISTS "+USER_TABLE_NAME+"("+COL_1+" INTEGER PRIMARY KEY AUTOINCREMENT, "
                +COL_2+" TEXT UNIQUE, "
                +COL_3+" TEXT NOT NULL, "
                +COL_4+" INTEGER DEFAULT 0,"
                +COL_5+" TEXT NOT NULL,"
                +COL_6+" TEXT NOT NULL,"
                +Col_7+" INTEGER DEFAULT 0,"
                +Col_8+" INTEGER DEFAULT 0,"
                +Col_9+" INTEGER DEFAULT 0,"
                +Col_10+" INTEGER DEFAULT 0,"
                +Col_11+" INTEGER DEFAULT 0,"
                +Col_12+" INTEGER DEFAULT 0,"
                +Col_13+" INTEGER DEFAULT 0,"
                +Col_14+" INTEGER DEFAULT 0,"
                +Col_15+" INTEGER DEFAULT 0,"
                +Col_16+" INTEGER DEFAULT 0"+");";
        db.execSQL(SQL_CREATE_USERS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+USER_TABLE_NAME+";");
    }


//method for inserting data into the table
    public boolean insertData(String userFullName,String UserName,Integer TotalScore,String email, String Password, Integer enlightenmentScore,
                              Integer EnlightenmentAttempt, Integer americanRevolutionScore, Integer americanRevolutionAttempt,
                              Integer frenchRevolutionScore, Integer frenchRevolutionAttempt, Integer industrialRevolutionScore,
                              Integer industrialRevolutionAttempt, Integer imperialismScore, Integer imperialismAttempt){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,userFullName);
        contentValues.put(COL_3,UserName);
        contentValues.put(COL_4,TotalScore);
        contentValues.put(COL_5,email);
        contentValues.put(COL_6,Password);
        contentValues.put(Col_7,enlightenmentScore);
        contentValues.put(Col_8,EnlightenmentAttempt);
        contentValues.put(Col_9,americanRevolutionScore);
        contentValues.put(Col_10,americanRevolutionAttempt);
        contentValues.put(Col_11,frenchRevolutionScore);
        contentValues.put(Col_12,frenchRevolutionAttempt);
        contentValues.put(Col_13,industrialRevolutionScore);
        contentValues.put(Col_14,industrialRevolutionAttempt);
        contentValues.put(Col_15,imperialismScore);
        contentValues.put(Col_16, imperialismAttempt);

        long Result = db.insert(USER_TABLE_NAME,null,contentValues);
        if(Result==-1){
            return false;
        }else{
            return true;
        }
    }

    //method used to get all the users info
    //It will be displayed in descending order as the user info will be displayed onto the leaderboard
    public Cursor getUserInfo(){
        SQLiteDatabase db =this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM "+USER_TABLE_NAME+" ORDER BY "+COL_4+" DESC",null);
        return res;
    }

    //method used to get current user of the System which is Peter White
    public Cursor getCurrentUserInfor(){

        SQLiteDatabase db =this.getWritableDatabase();
        Cursor cursor=db.rawQuery("SELECT * FROM "+USER_TABLE_NAME+" WHERE "+COL_3+"='Peter'", null);
       return cursor;
    }


}
