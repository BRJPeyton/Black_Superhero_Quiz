package cominbrandonrjpeyton.linkedin.www.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;

public class Question3 extends AppCompatActivity {
    int currentScore = 0;
    int usersWrongCBoxes = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question3);
        int q2Score = getIntent().getExtras().getInt("Score_After_Two", 0);
        int q2Errors = getIntent().getExtras().getInt("Errors_After_Two", 0);
        currentScore = q2Score;
        usersWrongCBoxes = q2Errors;
    }

    public void submitAnswer(View view) {
        //See if user has first correct answer
        CheckBox rightAnswerOne = (CheckBox)findViewById(R.id.q3_optionB);
        boolean hasFirstAnswer = rightAnswerOne.isChecked();

        //See if user has second correct answer
        CheckBox rightAnswerTwo = (CheckBox)findViewById(R.id.q3_optionC);
        boolean hasSecondAnswer = rightAnswerTwo.isChecked();

        //See if user checked the wrong answer
        CheckBox wrongAnswerOne = (CheckBox)findViewById(R.id.q3_optionA);
        boolean hasFirstWrongAnswer = wrongAnswerOne.isChecked();

        //See if user checked the wrong answer
        CheckBox wrongAnswerTwo = (CheckBox)findViewById(R.id.q3_optionD);
        boolean hasSecondWrongAnswer = wrongAnswerTwo.isChecked();

        //Calculate score
        int score = calculateScore(hasFirstAnswer, hasSecondAnswer);

        //Add users incorrect checkbox or checkboxes
        int mistakes = calculateNegativeScore(hasFirstWrongAnswer, hasSecondWrongAnswer);

        Intent intent = new Intent(this, Question4.class);
        intent.putExtra("Score_After_Three", score);
        intent.putExtra("Errors_After_Three", mistakes);
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

    private int calculateNegativeScore(boolean addFirstWrongAnswer, boolean addSecondWrongAnswer) {
        int negativeScore = 0;

        //Add 1 instance to the number of times the user selected the wrong checkbox.
        if (addFirstWrongAnswer) {
            negativeScore += + 1;
        }

        //Add 1 instance to the number of times the user selected the wrong checkbox.
        if (addSecondWrongAnswer) {
            negativeScore += + 1;
        }

        //Add this instance to the users total wrong checkboxes.
        return negativeScore + usersWrongCBoxes;
    }
}
