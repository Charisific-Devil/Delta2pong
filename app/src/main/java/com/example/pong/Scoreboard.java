package com.example.pong;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static java.lang.Integer.parseInt;

public class Scoreboard extends AppCompatActivity {
    public Button again;
    public Button quit;
    public TextView finalscore;
    public String scoretext;
    public SharedPreferences scores;
    public SharedPreferences.Editor scoreeditor;
    public TextView highscore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scoreboard);
        getSupportActionBar().hide();
        again = findViewById(R.id.playagain);
        quit = findViewById(R.id.quit);
        finalscore = findViewById(R.id.scorebox);
        highscore = findViewById(R.id.highscore);
        Intent scoreintent = getIntent();
        scoretext = scoreintent.getStringExtra("score");
        finalscore.setText("SCORE: " + scoretext);

        scores = PreferenceManager.getDefaultSharedPreferences(this);
        scoreeditor = scores.edit();
        if (scores.contains("High Score")) {
            if (parseInt(scoretext) > scores.getInt("High Score",0)) {
                scoreeditor.putInt("High Score",parseInt(scoretext));
                scoreeditor.commit();
            }
        } else {
            scoreeditor.putInt("High Score",parseInt(scoretext));
            scoreeditor.commit();
        }
        highscore.setText("HIGH SCORE: " + (String.valueOf(scores.getInt("High Score",0))));
        again.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent main1 = new Intent(Scoreboard.this,MainActivity.class);
                startActivity(main1);
                finish();
            }
        });
        quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent main2 = new Intent(Scoreboard.this,Start_page.class);
                startActivity(main2);
                finish();
            }
        });

    }
}