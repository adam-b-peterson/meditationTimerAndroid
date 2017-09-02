package com.example.android.replicatecountdowntimer.Scoreboard;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import com.example.android.replicatecountdowntimer.BaseActivity;
import com.example.android.replicatecountdowntimer.R;

public class ScoreboardActivity extends BaseActivity {
    TextView tvShowTotalPracticeDuration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scoreboard);
        tvShowTotalPracticeDuration = (TextView)findViewById(R.id.tvShowTotalPracticeDuration);
        SharedPreferences sharedPreferences = getSharedPreferences("record", MODE_PRIVATE);
        String recordTotalPracticeDuration = sharedPreferences.getString("recordTotalPracticeDuration", "");
        tvShowTotalPracticeDuration.setText(recordTotalPracticeDuration);
    }

   }
