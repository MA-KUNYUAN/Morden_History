package com.example.mordenhistory.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelp3 extends SQLiteOpenHelper {
    //database name
    public static final String DATABASE3_NAME = "NoteBook.db";

    //table name and column names
    public static final String NOTE_TABLE_NAME = "note_table";
    public static final String COL_1 = "NoteID";
    public static final String COL_2 = "NoteValue";

    public static final int DATABASE3_VERSION = 1;

    public DatabaseHelp3(Context context){
        super(context, DATABASE3_NAME, null, DATABASE3_VERSION);
    }

    //create database table
    @Override
    public void onCreate(SQLiteDatabase db) {
        final String SQL_CREATE_NOTE_TABLE = "CREATE TABLE IF NOT EXISTS "+NOTE_TABLE_NAME+"("+COL_1+" TEXT UNIQUE, "+COL_2+" TEXT);";
        db.execSQL(SQL_CREATE_NOTE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+NOTE_TABLE_NAME+";");
    }

    //method for inserting data into the table
    public boolean insertNotes(String ID, String NoteValue){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,ID);
        contentValues.put(COL_2,NoteValue);
        long Result = db.insert(NOTE_TABLE_NAME,null,contentValues);
        if(Result==-1){
            return false;
        }else{
            return true;
        }
    }

    //method used to get all the users info
    //It will be displayed the user's note in repository in the textView
    public Cursor getNoteInfo(){
        SQLiteDatabase db =this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM "+NOTE_TABLE_NAME,null);
        return res;
    }

    //After user save the note they updated it
    public boolean updateNoteBook(String ID, String NoteValue){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,NoteValue);
        db.update(NOTE_TABLE_NAME,contentValues,"NoteID = ?",new String[]{ID});
        return true;
    }
}
