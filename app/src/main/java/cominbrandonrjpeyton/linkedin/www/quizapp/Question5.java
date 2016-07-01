package cominbrandonrjpeyton.linkedin.www.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

public class Question5 extends AppCompatActivity {
    int currentScore;
    int usersWrongCBoxes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question5);
        int q4Score = getIntent().getExtras().getInt("Score_After_Four", 0);
        int q4Errors = getIntent().getExtras().getInt("Errors_After_Four", 0);
        currentScore = q4Score;
        usersWrongCBoxes = q4Errors;
    }

    public void submitAnswer(View view) {
        //See if user selected the correct answer.
        RadioButton radioButton = (RadioButton)findViewById(R.id.q5_optionB);
        boolean answer = radioButton.isChecked();

        //Calculate score
        int score = calculateScore(answer);

        //Show the user their score.
        Toast.makeText(this, "You scored a " + score + " out of 10!\nWith " + usersWrongCBoxes + " out of 4 incorrect checkboxes", Toast.LENGTH_LONG).show();

    }

    public void answerSheet(View view) {
        Intent intent = new Intent(this, FinaleScore.class);
        startActivity(intent);
    }

    private int calculateScore(boolean answer) {
        int questionScore = 0;

        //Add 1 point to the users score for correct answer.
        if (answer){
            questionScore += +1;
        }
        //Add points earn from this question to total score.
        return questionScore + currentScore;
    }
}
