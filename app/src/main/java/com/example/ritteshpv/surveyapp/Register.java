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
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {
    private FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener firebaseAuthListener;
    Button register;
    EditText emailIdRegister,passwordRegister;
    String emailIdRValue,passwordRValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        emailIdRegister=findViewById(R.id.emailRegister);
        passwordRegister=findViewById(R.id.passwordRegister);
        register=findViewById(R.id.registerButton);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                emailIdRValue = emailIdRegister.getText().toString();
                passwordRValue = passwordRegister.getText().toString();
                if(emailIdRValue.isEmpty()||passwordRValue.isEmpty())
                {
                    Toast.makeText(Register.this, "Enter enter your email id and password to register ", Toast.LENGTH_SHORT).show();
                }
                else {
                    firebaseAuth = FirebaseAuth.getInstance();
                    firebaseAuth.createUserWithEmailAndPassword(emailIdRValue, passwordRValue).addOnCompleteListener(Register.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(Register.this, "Registered Succcessfully\n Now , try to Login", Toast.LENGTH_SHORT).show();
                                Intent backToLogin = new Intent(Register.this, LoginActivity.class);
                                startActivity(backToLogin);
                            } else {
                                Toast.makeText(Register.this, "Error in Registration\n Try Again Later", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });
    }

}
