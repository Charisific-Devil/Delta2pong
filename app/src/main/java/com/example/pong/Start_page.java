package com.example.pong;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Start_page extends AppCompatActivity {
    public Button normal;
    public Button hard;
    public Button Computer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_page);
        getSupportActionBar().hide();
        normal = findViewById(R.id.Normal);
        hard = findViewById(R.id.Hard);
        Computer = findViewById(R.id.Computer);
        normal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent normals = new Intent(Start_page.this,MainActivity.class);
                startActivity(normals);
                finish();
            }
        });
        hard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent hards = new Intent(Start_page.this,MainActivity.class);
                startActivity(hards);
                finish();
            }
        });
    }
}