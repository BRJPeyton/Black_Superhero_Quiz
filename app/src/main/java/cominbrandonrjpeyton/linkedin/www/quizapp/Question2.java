package cominbrandonrjpeyton.linkedin.www.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

public class Question2 extends Question1 {
    private int currentScore = 0;
    private int usersWrongCBoxes = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question2);

        //Get the score and mistakes from question 1
        int qOneScore = getIntent().getExtras().getInt("Score_After_One", 0);
        int qOneErrors = getIntent().getExtras().getInt("Errors_After_One", 0);
        currentScore = qOneScore;
        usersWrongCBoxes = qOneErrors;
    }

    public void submitAnswer(View view) {
        //See if user has first correct answer
        CheckBox rightAnswerOne = (CheckBox)findViewById(R.id.q2_optionA);
        boolean hasFirstAnswer = rightAnswerOne.isChecked();

        //See if user has second correct answer
        CheckBox rightAnswerTwo = (CheckBox)findViewById(R.id.q2_optionC);
        boolean hasSecondAnswer = rightAnswerTwo.isChecked();

        //See if user has third correct answer
        CheckBox rightAnswerThree = (CheckBox)findViewById(R.id.q2_optionD);
        boolean hasThirdAnswer = rightAnswerThree.isChecked();

        //See if user checked the wrong answer
        CheckBox wrongAnswer = (CheckBox)findViewById(R.id.q2_optionB);
        boolean hasWrongAnswer = wrongAnswer.isChecked();

        //Calculate score
        int score = calculateScore(hasFirstAnswer, hasSecondAnswer, hasThirdAnswer);

        //Add users incorrect checkbox
        int mistakes = calculateNegativeScore(hasWrongAnswer);

        Intent intent = new Intent(this, Question3.class);
        intent.putExtra("Score_After_Two", score);
        intent.putExtra("Errors_After_Two", mistakes);
        startActivity(intent);
    }

    private int calculateScore(boolean addFirstAnswer, boolean addSecondAnswer, boolean addThirdAnswer) {
        int questionScore = 0;

        //Add 1 point to the users score for correct answer.
        if (addFirstAnswer) {
            questionScore += + 1;
        }

        //Add 1 point to the users score for correct answer.
        if (addSecondAnswer) {
            questionScore += + 1;
        }

        //Add 1 point to the users score for correct answer.
        if (addThirdAnswer) {
            questionScore += + 1;
        }

        //Add points earn from this question to total score.
        return questionScore + currentScore;
    }

    private int calculateNegativeScore(boolean addWrongAnswer) {
        int negativeScore = 0;

        //Add 1 instance to the number of times the user selected the wrong checkbox.
        if (addWrongAnswer) {
            negativeScore += + 1;
        }

        //Add this instance to the users total wrong checkboxes.
        return negativeScore + usersWrongCBoxes;
    }
}
