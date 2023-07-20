package com.example.android.citiesquiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ScoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        // Acquiring score from MainActivity
        float score = 0;
        String scoreString = "";

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            scoreString = extras.getString("score");
            score = Float.parseFloat(extras.getString("score"));
        }

        // Putting score into final_score TextView
        TextView finalScore = (TextView) findViewById(R.id.final_score);
        finalScore.setText("SCORE\n"+scoreString+" of 10");
    }
}
