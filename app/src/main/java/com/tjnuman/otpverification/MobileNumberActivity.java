package com.tjnuman.otpverification;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MobileNumberActivity extends AppCompatActivity {
    Button sendbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobile_number);
        sendbutton = findViewById(R.id.sendbutton);




        sendbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MobileNumberActivity.this,OtpReciveActivity.class);
                startActivity(intent);
            }
        });
    }
}