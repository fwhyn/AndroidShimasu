package com.mulyanimu.startedservice.service;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.mulyanimu.startedservice.R;

public class AboutServiceActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_service);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
