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
    public static final String DATABASE2_NAME = "UserInformation.db";

    public static final String USER_TABLE_NAME = "user_table";
    public static final String COL_1 = "UID";
    public static final String COL_2 = "AccName";
    public static final String COL_3 = "Password";
    public static final String COL_4 = "UserName";
    public static final String COL_5 = "TotalScore";

    private static final int DATABASE2_VERSION = 1;

    public DatabaseHelp2(Context context) {
        super(context, DATABASE2_NAME, null, DATABASE2_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        //create database table
        final String SQL_CREATE_USERS_TABLE ="CREATE TABLE IF NOT EXISTS "+USER_TABLE_NAME+"("+COL_1+" INTEGER PRIMARY KEY AUTOINCREMENT, "+COL_2+" TEXT UNIQUE, "+COL_3+" TEXT NOT NULL, "+COL_4+" TEXT NOT NULL, "+COL_5+" INTEGER DEFAULT 0"+");";
        db.execSQL(SQL_CREATE_USERS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+USER_TABLE_NAME+";");
    }

    public boolean insertData(String AccName,String Password,String UserName,Integer TotalScore){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,AccName);
        contentValues.put(COL_3,Password);
        contentValues.put(COL_4,UserName);
        contentValues.put(COL_5,TotalScore);
        long Result = db.insert(USER_TABLE_NAME,null,contentValues);
        if(Result==-1){
            return false;
        }else{
            return true;
        }
    }

    public Cursor getUserInfo(){
        SQLiteDatabase db =this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM "+USER_TABLE_NAME+" ORDER BY "+COL_5+" DESC",null);
        return res;
    }
}
