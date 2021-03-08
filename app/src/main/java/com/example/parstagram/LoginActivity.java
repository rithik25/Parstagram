package com.example.parstagram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

public class LoginActivity extends AppCompatActivity {

    private EditText etUsername;
    private EditText etPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        if(ParseUser.getCurrentUser()!=null) {
            goMainActivity();
        }

        etUsername=findViewById(R.id.uname);
        etPassword=findViewById(R.id.pass);
        btnLogin=findViewById(R.id.bttn1);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("LoginActivity", "onClick login button");
                String username=etUsername.getText().toString();
                String password=etPassword.getText().toString();
                loginUser(username, password);
            }
        });
    }

    private void loginUser(String username, String password) {
        Log.i("LoginActivity", "Attempting to login as user "+username);
        ParseUser.logInInBackground(username, password, new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException e) {
                if(e!=null)
                {
                    Log.e("LoginActivity", "Issue with login", e);
                    Toast.makeText(LoginActivity.this, "Issue with login", Toast.LENGTH_SHORT).show();
                    return;
                }
                goMainActivity();
                Toast.makeText(LoginActivity.this, "Success!", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void goMainActivity() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();
    }
}