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

public class Question2 extends AppCompatActivity {

    RadioGroup radioGroup;
    RadioButton radioButton;
    String QuesAns2;
    boolean btnChecked=false;
    FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question2);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        radioGroup=findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                btnChecked=true;
               radioButton=findViewById(checkedId);
                QuesAns2=radioButton.getText().toString();
                SurveyResults surveyResults=new SurveyResults();
                surveyResults.setAns2(QuesAns2);
            }
        });

        floatingActionButton=(FloatingActionButton)findViewById(R.id.nextQues2);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!btnChecked) {
                    RadioButton defaultChoice=findViewById(R.id.Option1);
                    QuesAns2=defaultChoice.getText().toString();
                    SurveyResults surveyResults=new SurveyResults();
                    surveyResults.setAns2(QuesAns2);
                    Intent question3 = new Intent(Question2.this, Question3.class);
                    startActivity(question3);

                }
                else
                {
                    Intent question3 = new Intent(Question2.this, Question3.class);
                    startActivity(question3);

                }

            }
        });
    }
}
