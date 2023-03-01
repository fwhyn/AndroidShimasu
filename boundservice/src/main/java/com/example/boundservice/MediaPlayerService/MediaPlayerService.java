package com.example.boundservice.MediaPlayerService;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.provider.Settings;

import androidx.annotation.Nullable;

public class MediaPlayerService extends Service {
   private MediaPlayer mediaPlayer;
   private final IBinder mMediaPlayerBinder = new MediaPlayerBinder();

   @Nullable
   @Override
   public IBinder onBind(Intent intent) {
      return mMediaPlayerBinder;
   }

   // execution of service will start on calling this method
   @Override
   public int onStartCommand(Intent intent, int flags, int startId) {
      // create media player which will play notification sound
      mediaPlayer = MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI);
      // the audio on loop
      mediaPlayer.setLooping(true);
      // start running ringtone as service
      mediaPlayer.start();
      // returns the status of the program
      return START_STICKY;
   }

   public  void playMediaPlayer(){
      // create media player which will play notification sound
      mediaPlayer = MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI);
      // the audio on loop
      mediaPlayer.setLooping(true);
      // start running ringtone as service
      mediaPlayer.start();
   }

   public void pauseMediaPlayer(){
      mediaPlayer.pause();
   }

   public void replayMediaPlayer(){
      mediaPlayer.start();
   }

   public void stopMediaPlayer(){
      mediaPlayer.stop();
   }

   @Override
   public void onDestroy() {
      super.onDestroy();
      if(mediaPlayer != null) {
         mediaPlayer.stop();
      }
   }

   public class MediaPlayerBinder extends Binder {
      public MediaPlayerService getService(){
         return MediaPlayerService.this;
      }
   }

}
