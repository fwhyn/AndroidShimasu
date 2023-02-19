package com.fwhyn.android.ServicesPractice;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.Settings;

import androidx.annotation.Nullable;

public class ServicesActivity extends Service {

    private MediaPlayer mediaPlayer;

    // execution of service will start on calling this method
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // create media player which will play notification sound
        mediaPlayer = MediaPlayer.create(this, Settings.System.DEFAULT_NOTIFICATION_URI);
        // the audio on loop
        mediaPlayer.setLooping(true);
        // start running ringtone as service
        mediaPlayer.start();
        // returns the status of the program
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        // stop the media player service
        mediaPlayer.stop();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


}
