package com.tjnuman.otpverification;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.FirebaseException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

import okio.Timeout;

public class MobileNumberActivity extends AppCompatActivity {
    Button sendbutton;
    TextView phoneNumber;
    String phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobile_number);
        sendbutton = findViewById(R.id.sendbutton);
        phoneNumber = findViewById(R.id.mobileNumber);
        phone = phoneNumber.getText().toString();

        sendbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PhoneAuthProvider.getInstance().verifyPhoneNumber(
                        "880" + phone,
                        60,
                        TimeUnit.SECONDS,
                        MobileNumberActivity.this,
                        new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                            @Override
                            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {

                            }

                            @Override
                            public void onVerificationFailed(@NonNull FirebaseException e) {
                                Toast.makeText(MobileNumberActivity.this, "Verification failed", Toast.LENGTH_SHORT).show();

                            }

                            @Override
                            public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                                super.onCodeSent(s, forceResendingToken);
                                Intent intent = new Intent(MobileNumberActivity.this,OtpReciveActivity.class);
                                intent.putExtra("mobile", phone);
                                startActivity(intent);

                            }
                        }
                );

            }
        });
    }
}