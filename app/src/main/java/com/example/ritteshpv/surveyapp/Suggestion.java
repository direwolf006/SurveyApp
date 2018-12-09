package com.example.ritteshpv.surveyapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class Suggestion extends AppCompatActivity {
    EditText suggestionText;
    FirebaseDatabase firebaseDatabase;
    FirebaseAuth firebaseAuth;
    Button submitButton;
    String suggestionTextValue;
    SurveyResults surveyResults=new SurveyResults();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggestion);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        suggestionText=findViewById(R.id.suggestion);

        submitButton=findViewById(R.id.submitButton);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                suggestionTextValue=suggestionText.getText().toString();
                if(!suggestionTextValue.isEmpty()) {
                    surveyResults.setSuggestion(suggestionTextValue);
                    firebaseAuth = FirebaseAuth.getInstance();
                    String userId = firebaseAuth.getCurrentUser().getUid();
                    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("Survey Details").child(userId);
                    SurveyResults surveyResults = new SurveyResults();
                    firebaseDatabase = FirebaseDatabase.getInstance();
                    Map mydetails = new HashMap();
                    mydetails.put("RatingForUI", surveyResults.getAns1());
                    mydetails.put("Resources", surveyResults.getAns2());
                    mydetails.put("Domain", surveyResults.getAns3());
                    mydetails.put("ProblemsSolved", surveyResults.getAns4());
                    mydetails.put("UserFriendly", surveyResults.getAns5());
                    mydetails.put("Suggestion", surveyResults.getSuggestion());
                    databaseReference.setValue(mydetails);
                    Toast.makeText(Suggestion.this, "Successfully Submitted", Toast.LENGTH_SHORT).show();

                }
                else{
                    Toast.makeText(Suggestion.this, "Please post your suggestion to serve you better", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
