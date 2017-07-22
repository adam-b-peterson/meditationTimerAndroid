package com.example.android.replicatecountdowntimer.SquaredBreathing;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.android.replicatecountdowntimer.R;

public class SquaredBreathingTimer extends AppCompatActivity {
    public Handler handler;
    private TextView tvShowProgress;
    private TextView tvShowState;
    private EditText etTotalDuration;
    int totalDuration;
    private TextView btnStart;
    int progress;
    int state;
    String stateText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_squared_breathing_timer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tvShowProgress = (TextView) findViewById(R.id.tvShowProgress);
        etTotalDuration = (EditText) findViewById(R.id.etTotalDuration);
        btnStart = (TextView) findViewById(R.id.btnStart);





    }


    public void startTimer(View view) {
        handler = new Handler();
        progress = 1;
        state = 0;
        etTotalDuration.setVisibility(View.INVISIBLE);
        btnStart.setVisibility(View.INVISIBLE);


        totalDuration = Integer.parseInt(etTotalDuration.getText().toString());
        tvShowState = (TextView) findViewById(R.id.tvShowState);

        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                Log.v("Timer",""+progress);
                tvShowProgress.setText(""+progress);
                if (progress % 5 == 1){
                    state++;
                    Log.v("Timer","State = "+state);
                    if (state == 1) {
                        stateText = "Inhale Gently";
                    } else if (state == 3) {
                        stateText = "Exhale Gently";
                    } else {
                        stateText = "Hold The Breath";
                    }
                    tvShowState.setText(stateText);
                }
                if (state == 4) {
                    state = 0;
                }
                progress++;

                if (progress <= totalDuration) {
                    handler.postDelayed(this, 1000);
                } else {
                    tvShowState.setText("Congratulations!\nYou've accomplished your current practice!");
                    tvShowProgress.setText("");
                    btnMenu.
                }
            }
        };
        handler.postDelayed(runnable, 1000);
    }
}
