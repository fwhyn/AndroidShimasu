package com.example.boundservice;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.boundservice.MediaPlayerService.MediaPlayerService;

public class BoundServiceMainActivity extends AppCompatActivity implements View.OnClickListener, ServiceConnection {
    private Button mPlayBtn, mStopBtn, mPauseBtn;
    private MediaPlayerService mMediaService;
    private Intent mMediaPlayerIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bind);
        mMediaPlayerIntent = new Intent(this, MediaPlayerService.class);

        // TODO Yelsa: tambah comment maksudnya apa
        if(mMediaService == null){
            bindService(mMediaPlayerIntent, this, Context.BIND_AUTO_CREATE);
        }

        mPlayBtn = findViewById(R.id.play_media_btn);
        mPauseBtn = findViewById(R.id.pause_media_btn);
        mStopBtn = findViewById(R.id.stop_media_btn);

        mPlayBtn.setOnClickListener(this);
        mPauseBtn.setOnClickListener(this);
        mStopBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view.equals(mPlayBtn)){
            mMediaService.playMediaPlayer();
            mPauseBtn.setEnabled(true);
            mPlayBtn.setEnabled(false);
            Toast.makeText(this, "Playing Media Player", Toast.LENGTH_LONG).show();
        } else if(view.equals(mPauseBtn)){
            mMediaService.pauseMediaPlayer();
            mPauseBtn.setEnabled(false);
            mPlayBtn.setEnabled(true);
            mPlayBtn.setText("Replay Service");
            Toast.makeText(this, "Pausing Media Player", Toast.LENGTH_LONG).show();
        } else if(view.equals(mStopBtn)){
            mMediaService.stopMediaPlayer();
            mPlayBtn.setEnabled(true);
            mPauseBtn.setEnabled(true);
            Toast.makeText(this, "Stopping Media Player", Toast.LENGTH_LONG).show();
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
        if(mMediaService != null) {
//            unbindService(this);
        }
    }
}