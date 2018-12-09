package com.example.ritteshpv.surveyapp;


import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity{
    EditText emailLogin;
    TextInputEditText passwordLogin;
    TextInputLayout textInputLayout;
    Button login,signUp;
    String emailIdLValue,passwordLValue;
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        emailLogin=findViewById(R.id.emailLogin);
        passwordLogin=findViewById(R.id.passwordLogin);
        TextInputLayout textInputLayout=findViewById(R.id.passtext);
        textInputLayout.setPasswordVisibilityToggleEnabled(true);
        textInputLayout.setPasswordVisibilityToggleDrawable(R.drawable.password_icon_selector);
        signUp=findViewById(R.id.signUpButton);
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent register= new Intent(LoginActivity.this,Register.class);
                startActivity(register);

            }
        });
        firebaseAuth=FirebaseAuth.getInstance();
        login =findViewById(R.id.loginButton);
        login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                        emailIdLValue=emailLogin.getText().toString();
                        passwordLValue=passwordLogin.getEditableText().toString();
                        if(emailIdLValue.isEmpty()||passwordLValue.isEmpty())
                        {
                            Toast.makeText(LoginActivity.this, "Please enter your login credentials", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            firebaseAuth.signInWithEmailAndPassword(emailIdLValue, passwordLValue).addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(LoginActivity.this, "Login Success", Toast.LENGTH_SHORT).show();
                                        Intent question1 = new Intent(LoginActivity.this, Question1.class);
                                        startActivity(question1);
                                    } else {
                                        Toast.makeText(LoginActivity.this, "Error Signing In \n Try Again later", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                        }
            }
        });
    }
}

