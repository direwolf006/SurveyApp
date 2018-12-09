package com.example.ritteshpv.surveyapp;

import android.content.Intent;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Question3 extends AppCompatActivity {
    String domain;
    boolean btnCheck=false;
    RadioGroup radioGroup;
    RadioButton radioButton;
    FloatingActionButton floatingActionButton;
    SurveyResults surveyResults=new SurveyResults();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question3);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        radioGroup = findViewById(R.id.radioGroup1);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                btnCheck=true;
                radioButton = findViewById(checkedId);
                domain = radioButton.getText().toString();
                SurveyResults surveyResults = new SurveyResults();
                surveyResults.setAns3(domain);
            }
        });
        floatingActionButton = (FloatingActionButton) findViewById(R.id.nextQues3);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!btnCheck) {
                    RadioButton defaultChoiceQues3 = findViewById(R.id.Domain1);
                    domain = defaultChoiceQues3.getText().toString();
                    SurveyResults surveyResults = new SurveyResults();
                    surveyResults.setAns3(domain);
                    Intent question3 = new Intent(Question3.this, Question4.class);
                    startActivity(question3);

                } else {
                    Intent question4 = new Intent(Question3.this, Question4.class);
                    startActivity(question4);
                }
            }
        });
    }
}
