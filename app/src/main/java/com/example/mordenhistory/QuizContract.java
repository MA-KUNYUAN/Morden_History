package com.example.mordenhistory;

import android.provider.BaseColumns;

public final class QuizContract {
    //make sure we only use this class for the container for the constants
    private QuizContract(){

    }

    //constants for database table
    //implementing the base_collum will snure the table will have id's
    public static class QuestionsTable implements BaseColumns {
        public static final String TABLE_NAME="quiz_questions";
        public static final String COLUMN_QUESTION="question";
        public static final String COLUMN_TOPIC="topic";
        public static final String COLUMN_OPTION1="option1";
        public static final String COLUMN_OPTION2="option2";
        public static final String COLUMN_OPTION3="option3";
        public static final String COLUMN_ANSWER_NR="answer_nr";
    }
}
