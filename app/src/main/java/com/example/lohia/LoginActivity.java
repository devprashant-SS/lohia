package com.example.lohia;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.FirebaseException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class LoginActivity extends AppCompatActivity {

    EditText mobile, otp;
    Button getotp, login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mobile = (EditText) findViewById(R.id.mobile);
        getotp = findViewById(R.id.getotp);
        final ProgressBar progressBar = findViewById(R.id.progressbar_sending_otp);
//        otp    = (EditText) findViewById(R.id.otpfill);
//        login  = (Button) findViewById(R.id.getotp);

//        login.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(LoginActivity.this, otpfill.class));
//
//            }
//        });

        getotp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!mobile.getText().toString().trim().isEmpty()) {
                    if ((mobile.getText().toString().trim()).length() == 10) {

                        progressBar.setVisibility(View.VISIBLE);
                        getotp.setVisibility(View.INVISIBLE);

                        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                                "+91" + mobile.getText().toString(),
                                60,
                                TimeUnit.SECONDS,
                                LoginActivity.this,
                                new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                                    @Override
                                    public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                                        progressBar.setVisibility(View.GONE);
                                        getotp.setVisibility(View.VISIBLE);
                                    }

                                    @Override
                                    public void onVerificationFailed(@NonNull FirebaseException e) {
                                        progressBar.setVisibility(View.GONE);
                                        getotp.setVisibility(View.VISIBLE);
                                        Toast.makeText(LoginActivity.this, e.getMessage(),Toast.LENGTH_SHORT).show();
                                    }

                                    @Override
                                    public void onCodeSent(@NonNull String backendotp, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
//                                        super.onCodeSent(s, forceResendingToken);
                                        progressBar.setVisibility(View.GONE);
                                        getotp.setVisibility(View.VISIBLE);
                                        Intent intent = new Intent(getApplicationContext(), otpfill.class);
                                        intent.putExtra("mobile", mobile.getText().toString());
                                        intent.putExtra("backendotp",backendotp);
                                        startActivity(intent);
                                    }
                                }
                        );
//                        Intent intent = new Intent(getApplicationContext(), otpfill.class);
//                        intent.putExtra("mobile", mobile.getText().toString());
//                        startActivity(intent);
                    } else {
                        Toast.makeText(LoginActivity.this, "Please enter correct number", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(LoginActivity.this,"Enter Mobile Number",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}
