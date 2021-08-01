package com.example.pong.views;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.example.pong.End_dialog;
import com.example.pong.MainActivity;
import com.example.pong.R;
import com.example.pong.Score_Tracker;
import com.example.pong.Scoreboard;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.TimerTask;

import static java.lang.Thread.sleep;

public class CustomView extends View {
    private Rect pong;
    private Rect hit;
    private Rect top;
    private Paint topclr;
    private Paint hitclr;
    private Paint pongcolor;
    private Paint clearclr;
    private float hitx;
    public int posx ;
    public int posy ;
    public int scorecount;
    public int velx ;
    public int vely ;
    public int changecon;
    public int resetcon;
    public int con = 0;
    public final Handler handler = new Handler(Looper.getMainLooper());
    private Paint resetclr;
    private MainActivity mActivity;
    public Score_Tracker trackpad;
    public static Context C;
    public List<Integer> speeds = new ArrayList<>();
    public int ranspeed;


    public void setActivity(MainActivity activity) {
         mActivity = activity;


    }

    public CustomView(Context context) {
        super(context);
        C = context;
        this.scorecount = 0;
        this.resetcon = 0;

        init(null);
    }
    public CustomView(Context context, Score_Tracker trackpad) {
        super(context);
        scorecount = 0;
        this.trackpad = trackpad;


        init(null);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        init(attrs);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init(attrs);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);

        init(attrs);
    }

    private void init(@Nullable AttributeSet set) {
        pong = new Rect();
        pongcolor = new Paint();
        hit = new Rect();
        hitclr = new Paint();
        top = new Rect();
        topclr = new Paint();
        clearclr = new Paint();
        resetclr = new Paint();


    }


    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(0xFF000000);
        resetclr.setColor(0xFF000000);
        if (resetcon == 1) {
            postInvalidate();
        }
        if (con == 0) {
            posx = getWidth()/2;
            posy = getHeight()/2;
            velx = 40;
            vely = 40;
            con = 1;
            scorecount = 0;
        }
        if (posx >= (getWidth() - 60)) {
            velx = -velx;
        }
        if (posx <= 40) {
            velx = -velx;
        }
        if (pong.intersect(hit)) {
            vely = -vely;
            scorecount = scorecount + 1;
            mActivity.scoreval = scorecount;
            changecon = 1;


        }
        if (posy >= getHeight()) {
            vely = - vely;
            Intent intent = new Intent(C, Scoreboard.class);
            intent.putExtra("score",String.valueOf(scorecount));
            C.startActivity(intent);


        }
        if (posy <= 230) {
            vely = -vely;

        }
        if (changecon == 1) {
            mActivity.scoreview.setText("Score: " + mActivity.scoreval);
            changecon = 0;
        }

        posx = posx + velx;
        posy = posy + vely;



        top.left = 0;
        top.top = 170;
        top.right = top.left + getWidth();
        top.bottom = top.top + 40;
        topclr.setColor(0xFFFFFFFF);
        canvas.drawRect(top, topclr);

        if (hitx == 0f) {
            hitx = 460;
        }
        hit.left = (int) hitx;
        hit.top = getHeight() - 150;
        hit.right = hit.left + 240;
        hit.bottom = hit.top + 40;
        hitclr.setColor(0xFFFFFFFF);
        canvas.drawRect(hit, hitclr);

        pong.left = posx;
        pong.top = posy;
        pong.right = pong.left + 40;
        pong.bottom = pong.top + 40;
        pongcolor.setColor(0xFF00FF00);
        canvas.drawRect(pong, pongcolor);

        try {
            sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        postInvalidate();


    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        boolean value = super.onTouchEvent(event);
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: {
                return true;
            }

            case MotionEvent.ACTION_MOVE: {
                float x = event.getX();
                double dx = x - hitx;
                if (dx != 0) {
                    if (x >= 850) {
                        x = 850;
                    }
                    if (x <= -20) {
                        x = -20;
                    }
                    hitx = x;
                    postInvalidate();

                    return true;
                }
                return true;
            }


        }

        return value;
    }








}






