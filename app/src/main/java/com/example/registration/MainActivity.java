package com.example.registration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText emailEditText, passwordEditText;
    private Button loginButton, singUpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailEditText = findViewById(R.id.loginEmailId);
        passwordEditText = findViewById(R.id.loginPasswordId);

        loginButton = findViewById(R.id.loginButtonId);

        singUpButton = findViewById(R.id.singUpButtonId);


        loginButton.setOnClickListener(this);


        singUpButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.loginButtonId){

        }
        if (v.getId()==R.id.singUpButtonId){
            Intent intent = new Intent(MainActivity.this, Registration_Activity.class);
            startActivity(intent);
        }
    }
}