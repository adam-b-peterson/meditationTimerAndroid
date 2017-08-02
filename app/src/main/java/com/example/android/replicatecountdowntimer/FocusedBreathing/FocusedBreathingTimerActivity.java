package com.example.android.replicatecountdowntimer.FocusedBreathing;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.android.replicatecountdowntimer.MainActivity;
import com.example.android.replicatecountdowntimer.R;

public class FocusedBreathingTimerActivity extends AppCompatActivity {
    public Handler handler;
    private TextView tvShowProgress;
    private TextView tvShowState;
    private TextView tvShowTimeLeft;
    int progress;
    int secLeft;
    int state;
    String stateText;
    private int totalDuration;
    private int partLength;
    String timePassed;
    String timeLeft;
    boolean ShowTimePassed;
    boolean ShowTimeLeft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_focused_breathing_timer);

        Bundle bundle = getIntent().getExtras();
        totalDuration = bundle.getInt("totalDuration");
        partLength = bundle.getInt("partLength");
        ShowTimePassed = bundle.getBoolean("ShowTimePassed");
        ShowTimeLeft = bundle.getBoolean("ShowTimeLeft");

        tvShowProgress = (TextView) findViewById(R.id.tvShowProgress);

        startTimer();

    }


    public void startTimer() {
        handler = new Handler();
        progress = 1;
        state = 0;

        tvShowState = (TextView) findViewById(R.id.tvShowState);
        tvShowTimeLeft = (TextView) findViewById(R.id.tvShowTimeLeft);
        if (!ShowTimePassed){
            TextView tvTimePassedText = (TextView)findViewById(R.id.tvTimePassedText);
            tvTimePassedText.setVisibility(View.GONE);
            tvShowProgress.setVisibility(View.GONE);
        }
        if (!ShowTimeLeft){
            TextView tvTimeLeftText = (TextView)findViewById(R.id.tvTimeLeftText);
            tvTimeLeftText.setVisibility(View.GONE);
            tvShowTimeLeft.setVisibility(View.GONE);
        }


        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if (progress<60) {
                    timePassed = String.format("%02d", progress % 60);
                } else if (progress<3600){
                    timePassed = String.format("%02d:%02d", progress / 60, progress % 60);
                } else {
                    timePassed = String.format("%02d:%02d:%02d", progress/3600, progress / 60, progress % 60);
                }
                tvShowProgress.setText(timePassed);
                secLeft = totalDuration*60 - progress;
                if (secLeft<60) {
                    timeLeft = String.format("%02d", secLeft % 60);
                } else if (secLeft<3600){
                    timeLeft = String.format("%02d:%02d", secLeft / 60, secLeft % 60);
                } else {
                    timeLeft = String.format("%02d:%02d:%02d", secLeft /3600, secLeft / 60, secLeft % 60);
                }
                tvShowTimeLeft.setText(timeLeft);

                if (progress % partLength == 1){
                    state++;
                    Log.v("Timer","State = "+state);
                    if (state == 1) {
                        stateText = "Inhale Gently";
                    } else if (state == 2) {
                        stateText = "Exhale Gently";
                    }
                    tvShowState.setText(stateText);
                }
                if (state == 2) {
                    state = 0;
                }
                progress++;

                if (progress <= totalDuration*60) {
                    handler.postDelayed(this, 1000);
                } else {
                    tvShowState.setText("Congratulations!\nYou've accomplished your current practice!");
                    tvShowProgress.setText("");
                }
            }
        };
        handler.postDelayed(runnable, 1000);
    }

    public void backToMenu(View view) {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }
}
