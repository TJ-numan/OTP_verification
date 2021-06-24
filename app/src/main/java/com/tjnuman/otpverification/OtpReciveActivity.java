package com.tjnuman.otpverification;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

public class OtpReciveActivity extends AppCompatActivity {
    EditText first,second,third,fourth,fifth,sixth;
    String gotOTP;
    Button varifiedbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_recive);
        first = findViewById(R.id.first);
        second = findViewById(R.id.second);
        third = findViewById(R.id.third);
        fourth = findViewById(R.id.fourth);
        fifth = findViewById(R.id.fifth);
        sixth = findViewById(R.id.sixth);
        gotOTP = getIntent().getStringExtra("mobile");


        varifiedbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String entercodeotp =
                        first.getText().toString()+
                        second.getText().toString()+
                        third.getText().toString()+
                        fourth.getText().toString()+
                        fifth.getText().toString()+
                        sixth.getText().toString();

                if(entercodeotp!=null){
                    PhoneAuthCredential phoneAuthCredential = PhoneAuthProvider.getCredential(gotOTP,entercodeotp);
                    FirebaseAuth.getInstance().signInWithCredential(phoneAuthCredential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(OtpReciveActivity.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                            }
                            else {
                                Toast.makeText(OtpReciveActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }

            }
        });


    }
}