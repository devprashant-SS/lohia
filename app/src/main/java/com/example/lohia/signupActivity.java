package com.example.lohia;

import static com.example.lohia.R.id.loginviamobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

public class signupActivity extends AppCompatActivity {

    Button loginmobile, loginemail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        loginmobile = findViewById(R.id.loginviamobile);
        loginemail = findViewById(R.id.loginviaemail);

//        otp    = (EditText) findViewById(R.id.otpfill);
//        login  = (Button) findViewById(R.id.getotp);

        loginemail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(signupActivity.this, usernameActivity.class));

            }

        });
        loginmobile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity(new Intent(signupActivity.this, LoginActivity.class));
                startActivity(new Intent(signupActivity.this,MainActivity.class));
            }
        });
    }
}