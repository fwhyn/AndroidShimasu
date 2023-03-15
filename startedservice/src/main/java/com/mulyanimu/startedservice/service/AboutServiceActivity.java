package com.mulyanimu.startedservice.service;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.mulyanimu.startedservice.R;

public class AboutServiceActivity extends Activity implements View.OnClickListener {

    private Button stopServiceOtherActivity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_service);

        stopServiceOtherActivity = findViewById(R.id.btn_stop_service_other_activity);

        stopServiceOtherActivity.setOnClickListener(this);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public void onClick(View view) {
        if (view == stopServiceOtherActivity) {
            Toast.makeText(this, getString(R.string.stop_service),Toast.LENGTH_SHORT).show();
            stopService(new Intent(this, StartedServiceActivity.class));
        }
    }
}
