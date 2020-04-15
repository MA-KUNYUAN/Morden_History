package com.example.mordenhistory;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mordenhistory.Database.DatabaseHelp;

import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class ActualQuiz extends AppCompatActivity {



    private TextView textViewQuestion;
    private TextView textViewScore;
    private TextView textViewQuestionCount;
    private TextView textViewCountDown;
    private RadioGroup rbGroup;
    private RadioButton rb1;
    private RadioButton rb2;
    private RadioButton rb3;
    private Button buttonConfirmNext;

    //gives the user 30 seconds to answer each question
    private static final long COUNTDOWN_IN_MILLIS = 30000;


    //save default colour for radio button, we going to change the colour to either green or red depending if the answer is correct
    private ColorStateList textColorDefaultRb;
    //saves the default colour for the timer
    private ColorStateList textColorDefaultCd;

    private CountDownTimer countDownTimer;
    private long timeLeftInMillis;


    private List<Question> entireQuestionList;
    private List<Question> questionList;

    //count the amount of questions shown
    private int questionCounter;

    //total questions within our array List
    private int questionCountTotal;
    private Question currentQuestion;

    private int score;

    // it will decide what happens when we submit the question
    //either lock the answer if the question wasn't answered
    //or show the next question if the question has been answered
    private boolean answered;

    private long backPressedTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actual_quiz);


        textViewQuestion = findViewById(R.id.question);
        textViewScore = findViewById(R.id.text_view_score);
        textViewQuestionCount = findViewById(R.id.question_number);
        textViewCountDown = findViewById(R.id.countDown);
        rbGroup = findViewById(R.id.radio_group);
        rb1 = findViewById(R.id.radio_button1);
        rb2 = findViewById(R.id.radio_button2);
        rb3 = findViewById(R.id.radio_button3);
        buttonConfirmNext = findViewById(R.id.submit);

        //will save the default colour of the text
        textColorDefaultRb = rb1.getTextColors();
        textColorDefaultCd=textViewCountDown.getTextColors();


        //initialising helper class
        //and getting the questions

        Intent intent=getIntent();
        Bundle extras=intent.getExtras();
        String topic= (String) extras.get("topic_title");

        DatabaseHelp dbHelper = new DatabaseHelp(this);

        entireQuestionList=dbHelper.getAllQuestions();
        questionList = Question.getQuestions(topic,entireQuestionList);
                questionCountTotal = questionList.size();
        //ensure question are in random order
        Collections.shuffle(questionList);

        //
        showNextQuestion();

        // checks whether the radioButton has been clicked
        buttonConfirmNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!answered) {
                    // checks whether the radioButton has been clicked
                    if (rb1.isChecked() || rb2.isChecked() || rb3.isChecked()) {
                        checkAnswer();
                    } else {
                        //text will display when no radio button has been selected but they are trying to confirm the answer
                        Toast.makeText(ActualQuiz.this, "Please select an answer", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    showNextQuestion();
                }
            }
        });
    }

    //method for next question
    private void showNextQuestion() {

      //setting default text colour for radio buttons
        rb1.setTextColor(textColorDefaultRb);
        rb2.setTextColor(textColorDefaultRb);
        rb3.setTextColor(textColorDefaultRb);

        //the method will unselect all the radio buttons
        rbGroup.clearCheck();

        //the if statement is checking whether there are any questions left
        if (questionCounter < questionCountTotal) {
            //setting the current question to the next question in our arraylist
            currentQuestion = questionList.get(questionCounter);

            //setting text fields
            textViewQuestion.setText(currentQuestion.getQuestion());
            rb1.setText(currentQuestion.getOption1());
            rb2.setText(currentQuestion.getOption2());
            rb3.setText(currentQuestion.getOption3());

            //incrementing question count
            questionCounter++;
            textViewQuestionCount.setText("Question: " + questionCounter + "/" + questionCountTotal);
            //setting answred variable to false so that that when the user presses the submit botton it will move to the next question
            answered = false;
            buttonConfirmNext.setText("Confirm");
            //start the countdown
            timeLeftInMillis = COUNTDOWN_IN_MILLIS;
            startCountDown();
        } else {
            //if now question are left
            finishQuiz();
        }
    }

    //create and start the countdown timer
    private void startCountDown() {
        countDownTimer = new CountDownTimer(timeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMillis = millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                timeLeftInMillis = 0;
                updateCountDownText();
                //will check answer even when there is no time left
                checkAnswer();
            }

            //immediately start teh countdown timer when created
        }.start();
    }


    private void updateCountDownText() {

        //putting time in in a readable format
        int minutes = (int) (timeLeftInMillis / 1000) / 60;
        int seconds = (int) (timeLeftInMillis / 1000) % 60;

        //formatting minutes and seconds
        String timeFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);

        textViewCountDown.setText(timeFormatted);


        //if time is below 10 seconds make the text colour red
        if (timeLeftInMillis < 10000) {
            textViewCountDown.setTextColor(Color.RED);
        } else {
            textViewCountDown.setTextColor(textColorDefaultCd);
        }
    }

    private void checkAnswer() {
        answered = true;

        // we want to stop the timer when a answer is confirmed
        countDownTimer.cancel();

        //will return id of which ever radio button has been checked
        RadioButton rbSelected = findViewById(rbGroup.getCheckedRadioButtonId());
        //wil return the index of the radio button that have been selected in our radio group
        int answerNr = rbGroup.indexOfChild(rbSelected) + 1;

        //determines whether the answer number of the selected is correct for the current question

        if (answerNr == currentQuestion.getAnswerNr()) {
            score++;
            textViewScore.setText("Score: " + score);
        }

        showSolution();
    }

    private void showSolution() {
        //make all radio buttons red
        rb1.setTextColor(Color.RED);
        rb2.setTextColor(Color.RED);
        rb3.setTextColor(Color.RED);


        //make the correct answer green

        switch (currentQuestion.getAnswerNr()) {
            case 1:
                rb1.setTextColor(Color.GREEN);
                textViewQuestion.setText("Answer 1 is correct");
                break;
            case 2:
                rb2.setTextColor(Color.GREEN);
                textViewQuestion.setText("Answer 2 is correct");
                break;
            case 3:
                rb3.setTextColor(Color.GREEN);
                textViewQuestion.setText("Answer 3 is correct");
                break;
        }

        //if we have any question left then make submit button be next
        //if not make the sumbit button be finish

        if (questionCounter < questionCountTotal) {
            buttonConfirmNext.setText("Next");
        } else {
            buttonConfirmNext.setText("Finish");
        }
    }

    //send score back to previous activity
    private void finishQuiz() {

        finish();
    }

    //overide back press button if press twice in two seconds will finish quiz
    @Override
    public void onBackPressed() {
        if (backPressedTime + 2000 > System.currentTimeMillis()) {
            finishQuiz();
        } else {
            Toast.makeText(this, "Press back again to finish", Toast.LENGTH_SHORT).show();
        }

        backPressedTime = System.currentTimeMillis();
    }

    @Override
    protected void onDestroy() {
        //need to destroy countdown timer even if timer is not null
        super.onDestroy();
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }


}
