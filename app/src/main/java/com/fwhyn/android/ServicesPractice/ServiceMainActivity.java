package com.fwhyn.android.ServicesPractice;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.fwhyn.android.R;

public class ServiceMainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button startButton, stopButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

        startButton = findViewById(R.id.btn_start_service);
        stopButton = findViewById(R.id.btn_stop_service);

        startButton.setOnClickListener(this);
        stopButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view == startButton){
            Toast.makeText(this, "Service Started", Toast.LENGTH_LONG).show();
            startService(new Intent(this, ServicesActivity.class));
        } else if (view == stopButton){
            Toast.makeText(this, "Service Stopped", Toast.LENGTH_LONG).show();
            stopService(new Intent(this, ServicesActivity.class));
        }
    }
}
