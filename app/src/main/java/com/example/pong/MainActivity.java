package com.example.pong;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.pong.views.CustomView;
import com.example.pong.Score_Tracker;



public class MainActivity extends AppCompatActivity {
    CustomView customView;
    public static TextView scoreview;
    public static int scoreval = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        scoreview = (TextView) findViewById(R.id.score);
        scoreview.setText("SCORE: " + scoreval);
        customView = new CustomView(this);
        MediaPlayer gamesound = MediaPlayer.create(this, R.raw.gameaudio);
        gamesound.setLooping(true);
        gamesound.start();



    }





}