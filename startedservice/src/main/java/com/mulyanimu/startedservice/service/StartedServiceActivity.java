package com.mulyanimu.startedservice.service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.Settings;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.mulyanimu.startedservice.R;

public class StartedServiceActivity extends Service {

    private MediaPlayer mediaPlayer;

    // Service Lifecycle #1 onCreate
    @Override
    public void onCreate() {
        Toast.makeText(this, getString(R.string.my_service_created), Toast.LENGTH_SHORT).show();
    }

    // Service Lifecycle #2 onStartCommand
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, getString(R.string.my_service_on_start_command), Toast.LENGTH_SHORT).show();
        // create media player which will play notification sound
        mediaPlayer = MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI);
        // the audio on loop
        mediaPlayer.setLooping(true);
        // start running ringtone as service
        mediaPlayer.start();
        // returns the status of the program
        return START_STICKY;
    }

    // Service Lifecycle #3 onDestroy
    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null){
            Toast.makeText(this, getString(R.string.my_service_stopped), Toast.LENGTH_SHORT).show();
            // stop the media player service
            mediaPlayer.stop();
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
