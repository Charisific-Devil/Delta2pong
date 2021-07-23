package com.example.pong;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.pong.views.CustomView;

import java.util.Timer;

public class MainActivity extends AppCompatActivity {
    CustomView customView;
    private TextView score;
    public String scoreval;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        customView = new CustomView(this);
        score = (TextView) findViewById(R.id.score);


    }

    public void SetScore() {
        scoreval = "SCORE:" + customView.scorecount;
        score.setText(scoreval);
    }


}