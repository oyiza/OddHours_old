package com.example.oddhours;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText mLoginUserNameOrEmail, mLoginPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get data
        mLoginUserNameOrEmail = (EditText) findViewById(R.id.editTextUserName);
        mLoginPassword = (EditText) findViewById(R.id.editTextPassword);

        Button btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(v -> {
            if (getLoginUserNameOrEmail().isEmpty() || getLoginPassword().isEmpty()) {
                Toast.makeText(MainActivity.this, "Please enter both username/email and password to login", Toast.LENGTH_LONG).show();
            }else if (getLoginUserNameOrEmail().equalsIgnoreCase("a") && getLoginPassword().equals("a")) {
                Intent HomeIntent = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(HomeIntent);
                Toast.makeText(MainActivity.this, "You are logged in, Welcome!!", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(MainActivity.this, "Sorry, username/email and password incorrect", Toast.LENGTH_LONG).show();
            }
        });

        Button btnGoogleSignIn = (Button) findViewById(R.id.btnGoogleSignIn);
        btnGoogleSignIn.setOnClickListener(v -> {
            Toast.makeText(MainActivity.this, "Sorry, google sign in is not yet implemented.. bear with me", Toast.LENGTH_LONG).show();
        });
    }

    // TODO: getters and setters for username and password, sanitization and protecting the variables

    private String getLoginUserNameOrEmail() {
        return mLoginUserNameOrEmail.getText().toString();
    }

    private String getLoginPassword() {
        return mLoginPassword.getText().toString();
    }
}