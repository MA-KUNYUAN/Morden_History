package com.example.mordenhistory.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.mordenhistory.Question;
import com.example.mordenhistory.QuizContract;

import java.util.ArrayList;
import java.util.List;


public class DatabaseHelp extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "ModernHistory.db";

    private static final int DATABASE_VERSION = 1;

    private SQLiteDatabase db;

    //when creating instance of DatabaseHelp we only have to use context

    public DatabaseHelp(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //this Oncreate method will be called the first time we try and access this database

    @Override
    public void onCreate(SQLiteDatabase db) {
        //save the database reference , will use this value after the creation of the database to add some values

        this.db = db;

        //create database table
        final String SQL_CREATE_QUESTIONS_TABLE = "CREATE TABLE " +
                QuizContract.QuestionsTable.TABLE_NAME + " ( " +
                QuizContract.QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuizContract.QuestionsTable.COLUMN_QUESTION + " TEXT, " +
                QuizContract.QuestionsTable.COLUMN_TOPIC + " TEXT, " +
                QuizContract.QuestionsTable.COLUMN_OPTION1 + " TEXT, " +
                QuizContract.QuestionsTable.COLUMN_OPTION2 + " TEXT, " +
                QuizContract.QuestionsTable.COLUMN_OPTION3 + " TEXT, " +
                QuizContract.QuestionsTable.COLUMN_ANSWER_NR + " INTEGER" +
                ")";

        db.execSQL(SQL_CREATE_QUESTIONS_TABLE);
        fillQuestionsTable();
    }

    //oncreate will only be called the first time we try and access the database
    //otherwise it would not be called again unless we delete the app from our phone
    //if we want to add additional column to our table the onUpgrade method will be called
    //it will drop the existing table and create a new one
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + QuizContract.QuestionsTable.TABLE_NAME);
        onCreate(db);
    }

    //provide the data for our table
    private void fillQuestionsTable() {
        Question q1 = new Question("A is correct","Enlightenment", "A", "B", "C", 1);
        addQuestion(q1);
        Question q2 = new Question("B is correct","Enlightenmentt", "A", "B", "C", 2);
        addQuestion(q2);
        Question q3 = new Question("C is correct", "Enlightenment", "A", "B", "C", 3);
        addQuestion(q3);
        Question q4 = new Question("A is correct again","Enlightenment", "A", "B", "C", 1);
        addQuestion(q4);
        Question q5 = new Question("B is correct again","Enlightenment", "A", "B", "C", 2);
        addQuestion(q5);
    }

    //insert the data in our database
    private void addQuestion(Question question) {
        ContentValues cv = new ContentValues();
        cv.put(QuizContract.QuestionsTable.COLUMN_QUESTION, question.getQuestion());
        cv.put(QuizContract.QuestionsTable.COLUMN_TOPIC, question.getTopic());
        cv.put(QuizContract.QuestionsTable.COLUMN_OPTION1, question.getOption1());
        cv.put(QuizContract.QuestionsTable.COLUMN_OPTION2, question.getOption2());
        cv.put(QuizContract.QuestionsTable.COLUMN_OPTION3, question.getOption3());
        cv.put(QuizContract.QuestionsTable.COLUMN_ANSWER_NR, question.getAnswerNr());
        db.insert(QuizContract.QuestionsTable.TABLE_NAME, null, cv);
    }

    //get Questions from database
    public List<Question> getAllQuestions() {
        List<Question> questionList = new ArrayList<>();
        db = getReadableDatabase();

        //cursor to query our database
        Cursor c = db.rawQuery("SELECT * FROM " + QuizContract.QuestionsTable.TABLE_NAME, null);

        if (c.moveToFirst()) {
            do {
                Question question = new Question();
                question.setQuestion(c.getString(c.getColumnIndex(QuizContract.QuestionsTable.COLUMN_QUESTION)));
                question.setTopic(c.getString(c.getColumnIndex(QuizContract.QuestionsTable.COLUMN_TOPIC)));
                question.setOption1(c.getString(c.getColumnIndex(QuizContract.QuestionsTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(QuizContract.QuestionsTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(QuizContract.QuestionsTable.COLUMN_OPTION3)));
                question.setAnswerNr(c.getInt(c.getColumnIndex(QuizContract.QuestionsTable.COLUMN_ANSWER_NR)));
                questionList.add(question);
            } while (c.moveToNext());
        }

        c.close();
        return questionList;
    }
}
