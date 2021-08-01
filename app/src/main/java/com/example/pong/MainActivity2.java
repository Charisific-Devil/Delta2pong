package com.example.pong;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.pong.views.CustomView;
import com.example.pong.Score_Tracker;
import com.example.pong.views.CustomView2;


public class MainActivity2 extends AppCompatActivity {
    CustomView2 customView;
    public static TextView scoreview;
    public static int scoreval = 0;
    public static SoundPool soundPool;
    public static int endgame, gameaudio, hitsound, wallhitsound;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        scoreview = (TextView) findViewById(R.id.score);
        scoreview.setText("SCORE: " + scoreval);
        customView = new CustomView2(this);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            AudioAttributes audioAttributes = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_ASSISTANCE_SONIFICATION)
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .build();

            soundPool = new SoundPool.Builder()
                    .setMaxStreams(15)
                    .setAudioAttributes(audioAttributes)
                    .build();
        } else {
            soundPool = new SoundPool( 15, AudioManager.STREAM_MUSIC,0);

        }
        endgame = soundPool.load(this, R.raw.endgame,1);
        hitsound = soundPool.load(this, R.raw.hit,1);
        wallhitsound = soundPool.load(this, R.raw.wallhit,1);



    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        soundPool.release();
        soundPool = null;
    }
}