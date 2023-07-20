package com.example.android.citiesquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Initialize Score variable
    public int score=0;

    //initialize variables for questions
    private  EditText q1;
    private EditText q2;
    private EditText q3;
    private EditText q4;
    private EditText q5;
    private CheckBox q6a;
    private CheckBox q6b;
    private CheckBox q6c;
    private CheckBox q6d;
    private RadioButton q7;
    private RadioButton q8;
    private RadioButton q9;
    private RadioButton q10;
    private RadioGroup radio7;
    private RadioGroup radio8;
    private RadioGroup radio9;
    private RadioGroup radio10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Find all views with answers
        q1=(EditText) findViewById(R.id.q_1);
        q2=(EditText) findViewById(R.id.q_2);
        q3=(EditText) findViewById(R.id.q_3);
        q4=(EditText) findViewById(R.id.q_4);
        q5=(EditText) findViewById(R.id.q_5);
        q6a=(CheckBox) findViewById(R.id.q_6a);
        q6b=(CheckBox) findViewById(R.id.q_6b);
        q6c=(CheckBox) findViewById(R.id.q_6c);
        q6d=(CheckBox) findViewById(R.id.q_6d);
        q7=(RadioButton) findViewById(R.id.q_7);
        q8=(RadioButton) findViewById(R.id.q_8);
        q9=(RadioButton) findViewById(R.id.q_9);
        q10=(RadioButton) findViewById(R.id.q_10);
        radio7=(RadioGroup) findViewById(R.id.radio_7);
        radio8=(RadioGroup) findViewById(R.id.radio_8);
        radio9=(RadioGroup) findViewById(R.id.radio_9);
        radio10=(RadioGroup) findViewById(R.id.radio_10);
    }

    public void TotalScore(View v){
        //Initialize score variable
        score=0;

        //convert answers of questions 1-5 to lowercase strings
        //and store answers into variables
        String answ1=q1.getText().toString().toLowerCase();
        String answ2=q2.getText().toString().toLowerCase();
        String answ3=q3.getText().toString().toLowerCase();
        String answ4=q4.getText().toString().toLowerCase();
        String answ5=q5.getText().toString().toLowerCase();

        //Update the score variable using the user answers
        //Questions 1-5 EditText
        if (answ1.equals(getString(R.string.q1_correct_answer)))
            score+=1;

        if (answ2.equals(getString(R.string.q2_correct_answer)))
            score+=1;

        if (answ3.equals(getString(R.string.q3_correct_answer)))
            score+=1;

        if (answ4.equals(getString(R.string.q4_correct_answer)))
            score+=1;

        if (answ5.equals(getString(R.string.q5_correct_answer)))
            score+=1;

        //Question 6 CheckBox
        if (q6a.isChecked()  && q6b.isChecked() && !q6c.isChecked() && !q6d.isChecked())
            score+=1;

        //Question7-10 RadioBox
        if (q7.isChecked())
            score+=1;

        if (q8.isChecked())
            score+=1;

        if (q9.isChecked())
            score+=1;

        if (q10.isChecked())
            score+=1;

        //Open the ScoreActivity using intent
        Intent intentScoreActivity=new Intent(this,ScoreActivity.class);
        intentScoreActivity.putExtra("score",Integer.toString(score));
        startActivity(intentScoreActivity);
    }

    public void clearAnswers(View view){
        //reset all views
        q1.setText(null);
        q2.setText(null);
        q3.setText(null);
        q4.setText(null);
        q5.setText(null);
        q6a.setChecked(false);
        q6b.setChecked(false);
        q6c.setChecked(false);
        q6d.setChecked(false);
        radio7.clearCheck();
        radio8.clearCheck();
        radio9.clearCheck();
        radio10.clearCheck();

        //reset the variable score
        score=0;

        //Show message
        Toast.makeText(this,R.string.all_reset, Toast.LENGTH_SHORT).show();
    }
}
