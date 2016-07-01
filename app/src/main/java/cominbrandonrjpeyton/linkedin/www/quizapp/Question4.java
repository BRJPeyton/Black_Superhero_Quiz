package cominbrandonrjpeyton.linkedin.www.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class Question4 extends AppCompatActivity {
    int currentScore = 0;
    int usersWrongCBoxes = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question4);
        int q3Score = getIntent().getExtras().getInt("Score_After_Three", 0);
        int q3Errors = getIntent().getExtras().getInt("Errors_After_Three", 0);
        currentScore = q3Score;
        usersWrongCBoxes = q3Errors;
    }

    public void submitAnswer(View view) {
        //See if user entered the correct title
        EditText title = (EditText)findViewById(R.id.q4_answer);
        String answer = title.getText().toString();

        //Calculate score
        int score = calculateScore(answer);

        Intent intent = new Intent(this, Question5.class);
        intent.putExtra("Score_After_Four", score);
        intent.putExtra("Errors_After_Four", usersWrongCBoxes);
        startActivity(intent);
    }

    private int calculateScore(String answer) {
        int questionScore = 0;

        //Add 1 point to the users score for correct answer.
        if (answer.matches("blade|Blade"))
            questionScore += +1;

        //Add points earn from this question to total score.
        return questionScore + currentScore;
    }
}
