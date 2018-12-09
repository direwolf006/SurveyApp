package com.example.ritteshpv.surveyapp;

import android.content.Intent;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;

public class Question1 extends AppCompatActivity {

    private RatingBar rateBar;
    private TextView ratingValue;
    private String ratingCheck="0.0";
    private FloatingActionButton floatingActionButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question1);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        ratingValue = (TextView) findViewById(R.id.rateValue);
        floatingActionButton = (FloatingActionButton) findViewById(R.id.nextQues1);
        rateBar = (RatingBar) findViewById(R.id.ratingBar);
        rateBar.setOnRatingBarChangeListener(new OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                ratingValue.setText(String.valueOf(rating));
                ratingCheck=ratingValue.getText().toString();
                SurveyResults surveyResults=new SurveyResults();
                surveyResults.setAns1(ratingValue.getText().toString());

            }
        });
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ratingCheck=="0.0")
                {
                    Toast.makeText(Question1.this, "Please rate our App UI", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent question2 = new Intent(Question1.this, Question2.class);
                    startActivity(question2);
                }
            }
        });
    }
}
