package com.example.boundservice;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.boundservice.MediaPlayerService.MediaPlayerService;

public class StopServiceActivity extends AppCompatActivity implements View.OnClickListener, ServiceConnection {
    Button stop_service;
    private MediaPlayerService mMediaService;
    private Intent mMediaPlayerIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stop_service);

        stop_service = findViewById(R.id.stop_service);
        stop_service.setOnClickListener(this);

        mMediaPlayerIntent = new Intent(this, MediaPlayerService.class);

        // Connects to MediaPlayerService, if it's null before / has disconnected
        // BIND_AUTO_CREATE : automatically create the service as long as the binding exists.
        /* BIND_ADJUST_WITH_ACTIVITY : If binding from an activity, allow the target service's process importance to be raised
         * based on whether the activity is visible to the user, regardless whether another
         * flag is used to reduce the amount that the client process's overall importance is used to impact it.
         */
        if(mMediaService == null){
            bindService(mMediaPlayerIntent, this, Context.BIND_ADJUST_WITH_ACTIVITY);
        }

    }

    @Override
    public void onClick(View view) {
        if(view.equals(stop_service)){
            mMediaService.stopMediaPlayer();
        }
    }

    @Override
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        mMediaService = ((MediaPlayerService.MediaPlayerBinder)iBinder) .getService();
    }

    @Override
    public void onServiceDisconnected(ComponentName componentName) {
        mMediaService = null;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(this);
    }
}