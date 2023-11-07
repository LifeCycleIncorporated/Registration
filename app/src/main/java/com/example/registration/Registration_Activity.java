package com.example.registration;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Registration_Activity extends AppCompatActivity {

    private EditText regEmailEditText, regPasswordEditText;
    private Button regButton, regLoginButton;

    private FirebaseAuth mAuth;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        mAuth = FirebaseAuth.getInstance();

        regEmailEditText = findViewById(R.id.singUpEmailId);
        regPasswordEditText = findViewById(R.id.singUpPasswordId);

        regButton = findViewById(R.id.registerButtonId);

        regLoginButton = findViewById(R.id.singInButtonId);


        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userRegistration();

            }
        });


        regLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Registration_Activity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void userRegistration() {
        String email = regEmailEditText.getText().toString().trim();
        String password = regPasswordEditText.getText().toString().trim();

        if (email.isEmpty()){
            regPasswordEditText.setError("Enter an email address");
            regEmailEditText.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            regEmailEditText.setError("Enter an valid email address");
            regEmailEditText.requestFocus();
            return;
        }
        if (password.isEmpty()){
            regPasswordEditText.setError("Enter a password");
            regPasswordEditText.requestFocus();
            return;
        }
        if (password.length()<6){
            regPasswordEditText.setError("Minimum 6 debits used");
            regPasswordEditText.requestFocus();
            return;
        }

        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(getApplicationContext(),"Registration successful", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getApplicationContext(),"Registration Unsuccessful", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}