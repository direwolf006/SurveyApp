package com.example.ritteshpv.surveyapp;

import android.content.Intent;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class Question5 extends AppCompatActivity {

    RatingBar rateBar;
    TextView ratingValue;
    private String ratingCheck="0.0";
    FloatingActionButton floatingActionButton;
    SurveyResults surveyResults=new SurveyResults();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question5);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        ratingValue = (TextView) findViewById(R.id.rateValue);
        rateBar = (RatingBar) findViewById(R.id.ratingBar2);
        rateBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                ratingValue.setText(String.valueOf(rating));
                ratingCheck=ratingValue.getText().toString();
                surveyResults.setAns5(ratingValue.getText().toString());
            }
        });

        floatingActionButton = (FloatingActionButton) findViewById(R.id.nextQues5);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ratingCheck=="0.0")
                {
                    Toast.makeText(Question5.this, "Please rate our App", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent suggestion = new Intent(Question5.this, Suggestion.class);
                    startActivity(suggestion);
                }
            }
        });
    }
};
