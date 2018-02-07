package com.example.android.astroquiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /*
    This method checks if the answers are correct and calculates the final score
     */
    private int calculateScore() {

        score = 0;

        CheckBox question1Answer1 = (CheckBox) findViewById(R.id.q1_a1);
        boolean question1Answer1Status = question1Answer1.isChecked();

        CheckBox question1Answer2 = (CheckBox) findViewById(R.id.q1_a2);
        boolean question1Answer2Status = question1Answer2.isChecked();

        CheckBox question1Answer3 = (CheckBox) findViewById(R.id.q1_a3);
        boolean question1Answer3Status = question1Answer3.isChecked();

        RadioButton question2Answer1 = (RadioButton) findViewById(R.id.q2_a1);
        boolean question2Answer1Status = question2Answer1.isChecked();

        RadioButton question2Answer2 = (RadioButton) findViewById(R.id.q2_a2);
        boolean question2Answer2Status = question2Answer2.isChecked();

        EditText question3Answer = (EditText) findViewById(R.id.q3_a);
        String question3AnswerSubmit = question3Answer.getText().toString();

        CheckBox question4Answer1 = (CheckBox) findViewById(R.id.q4_a1);
        boolean question4Answer1Status = question4Answer1.isChecked();

        CheckBox question4Answer2 = (CheckBox) findViewById(R.id.q4_a2);
        boolean question4Answer2Status = question4Answer2.isChecked();

        CheckBox question4Answer3 = (CheckBox) findViewById(R.id.q4_a3);
        boolean question4Answer3Status = question4Answer3.isChecked();

        EditText question5Answer = (EditText) findViewById(R.id.q5_a);
        String question5AnswerSubmit = question5Answer.getText().toString();

        if (question1Answer1Status && question1Answer3Status && !question1Answer2Status) {
            score++;
        }

        if (question2Answer1Status) {
            score++;
        }

        if (question3AnswerSubmit.equals("Saturn")) {
            score++;
        }

        if (question4Answer2Status && question4Answer3Status && !question4Answer1Status) {
            score++;
        }

        if (question5AnswerSubmit.equals("North Star")) {
            score++;
        }

        return score;

    }

    /*
    This method decides based on your score which toast to display
     */
    public void submitQuiz(View view) {

        EditText playerName = (EditText) findViewById(R.id.player_name);
        String playerNameSubmit = playerName.getText().toString();

        calculateScore();

        if (score == 0) {
            Toast.makeText(getBaseContext(), "Sorry you have 0 points. Try again " + playerNameSubmit,
                    Toast.LENGTH_LONG).show();
        } else if (score < 5) {
            Toast.makeText(getBaseContext(), "Well done " + playerNameSubmit + "! You have " + score + " points.",
                    Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getBaseContext(), "Excelent " + playerNameSubmit + "! You have answered all the questions correctly!",
                    Toast.LENGTH_LONG).show();
        }

    }

}
