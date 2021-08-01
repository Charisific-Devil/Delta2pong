package com.example.pong;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
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
    public static MediaPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        scoreview = (TextView) findViewById(R.id.score);
        scoreview.setText("SCORE: " + scoreval);
        customView = new CustomView2(this);
        MediaPlayer gamesound = MediaPlayer.create(this, R.raw.gameaudio);
        gamesound.setLooping(true);
        gamesound.start();
    }

    private void stop() {
        player.release();
        player = null;

    }
    protected void onStop() {
        super.onStop();
        stop();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        soundPool.release();
        soundPool = null;
    }

}