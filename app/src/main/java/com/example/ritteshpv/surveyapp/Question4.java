package com.example.ritteshpv.surveyapp;

import android.content.Intent;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.Toast;

public class Question4 extends AppCompatActivity {

    SeekBar seekBar;
    int seekValue;
    String userResp;
    boolean slideBarCheck=false;
    FloatingActionButton floatingActionButton;
    SurveyResults surveyResults=new SurveyResults();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question4);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        seekBar=(SeekBar)findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                slideBarCheck=true;
                seekValue=(progress/20);
                switch(seekValue)
                {
                    case 1:userResp="Not at all Solved";
                        break;
                    case 2:userResp="A few Questions Solved";
                        break;
                    case 3:userResp="Partially Solved";
                        break;
                    case 4:userResp="Solved";
                        break;
                    case 5:userResp="Fully Solved";
                        break;
                }
                surveyResults.setAns4(userResp);
            }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {

                }
        });

                floatingActionButton = (FloatingActionButton) findViewById(R.id.nextQues4);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!slideBarCheck) {
                    Toast.makeText(Question4.this, "Please Slide to let us know", Toast.LENGTH_SHORT).show();
                } else {
                    Intent question5 = new Intent(Question4.this, Question5.class);
                    startActivity(question5);

                }
            }
        });
    }

}
