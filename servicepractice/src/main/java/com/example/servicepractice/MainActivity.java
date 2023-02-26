package com.example.servicepractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button startButton, stopButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startButton = findViewById(R.id.btn_start_service);
        stopButton = findViewById(R.id.btn_stop_service);

        startButton.setOnClickListener(this);
        stopButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == startButton){
            Toast.makeText(this,"Service Started", Toast.LENGTH_LONG).show();
            startService(new Intent(this, ServiceActivity.class));
        } else if (view == stopButton){
            Toast.makeText(this,"Service Stopped", Toast.LENGTH_LONG).show();
            stopService(new Intent(this, ServiceActivity.class));
        }
    }
}