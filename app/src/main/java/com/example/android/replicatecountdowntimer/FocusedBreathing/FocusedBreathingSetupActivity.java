package com.example.android.replicatecountdowntimer.FocusedBreathing;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.TextView;

import com.example.android.replicatecountdowntimer.R;

public class FocusedBreathingSetupActivity extends AppCompatActivity {
    public Handler handler;
    int progress = 1;
    int state = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_focused_breathing_setup);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        handler = new Handler();


        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                Log.v("Timer",""+progress);
                TextView tvShowProgress = (TextView) findViewById(R.id.tvShowProgress);
                tvShowProgress.setText(""+progress);
                if (progress <= 30) {
                    handler.postDelayed(this, 1000);
                }
                if (progress % 5 == 0){
                    state++;
                    Log.v("Timer","State = "+state);
                    TextView tvShowState = (TextView) findViewById(R.id.tvShowState);
                    tvShowState.setText(""+state);
                }
                if (state == 2) {
                    state = 0;
                }
                progress++;
            }
        };

        handler.postDelayed(runnable, 1000);

    }

}
