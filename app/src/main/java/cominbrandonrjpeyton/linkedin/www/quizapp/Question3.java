package cominbrandonrjpeyton.linkedin.www.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;

public class Question3 extends AppCompatActivity {
    int currentScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question3);
        int q2Score = getIntent().getExtras().getInt("Score_After_Two", 0);
        currentScore = q2Score;
    }

    public void submitAnswer(View view) {
        //See if user has first correct answer
        CheckBox rightAnswerOne = (CheckBox)findViewById(R.id.q3_optionB);
        boolean hasFirstAnswer = rightAnswerOne.isChecked();

        //See if user has second correct answer
        CheckBox rightAnswerTwo = (CheckBox)findViewById(R.id.q3_optionC);
        boolean hasSecondAnswer = rightAnswerTwo.isChecked();

        //Calculate score
        int score = calculateScore(hasFirstAnswer, hasSecondAnswer);

        Intent intent = new Intent(this, Question4.class);
        intent.putExtra("Score_After_Three", score);
        startActivity(intent);
    }

    private int calculateScore(boolean addFirstAnswer, boolean addSecondAnswer) {
        int questionScore = 0;

        //Add 1 point to the users score for correct answer.
        if (addFirstAnswer) {
            questionScore += + 1;
        }

        //Add 1 point to the users score for correct answer.
        if (addSecondAnswer) {
            questionScore += + 1;
        }

        //Add points earn from this question to total score.
        return questionScore + currentScore;
    }
}
