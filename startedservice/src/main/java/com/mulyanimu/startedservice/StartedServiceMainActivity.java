package com.mulyanimu.startedservice;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.mulyanimu.startedservice.service.AboutServiceActivity;
import com.mulyanimu.startedservice.service.StartedServiceActivity;

public class StartedServiceMainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button startServiceButton, stopServiceButton, aboutServiceButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_started_service_main);

        startServiceButton = findViewById(R.id.btn_start_service);
        stopServiceButton = findViewById(R.id.btn_stop_service);
        aboutServiceButton = findViewById(R.id.btn_service_about);

        startServiceButton.setOnClickListener(this);
        stopServiceButton.setOnClickListener(this);
        aboutServiceButton.setOnClickListener(this);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public void onClick(View view) {
        if (view == startServiceButton) {
            Toast.makeText(this, getString(R.string.start_service),Toast.LENGTH_SHORT).show();
            startService(new Intent(this, StartedServiceActivity.class));
        }
        else if (view == stopServiceButton) {
            Toast.makeText(this, getString(R.string.stop_service),Toast.LENGTH_SHORT).show();
            stopService(new Intent(this, StartedServiceActivity.class));
        }
        else if (view == aboutServiceButton) {
            Intent intent = new Intent(this, AboutServiceActivity.class);
            startActivity(intent);
        }
    }
}