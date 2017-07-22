package com.example.android.replicatecountdowntimer.SquaredBreathing;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.NumberPicker;

import com.example.android.replicatecountdowntimer.R;

public class SquaredBreathingSettingActivity extends AppCompatActivity {
    public NumberPicker npTotalDuration;
    public NumberPicker npPartLength;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqaured_breathing_setting);
        npTotalDuration = (NumberPicker)findViewById(R.id.npTotalDuration);
        npPartLength = (NumberPicker)findViewById(R.id.npLength);

        npTotalDuration.setMaxValue(999);
        npTotalDuration.setMinValue(1);

        npPartLength.setMaxValue(10);
        npPartLength.setMinValue(4);

    }


    public void startSquaredBreathingTimer(View view) {
        Intent intent = new Intent(SquaredBreathingSettingActivity.this, SquaredBreathingTimer.class);
        int totalDuration = npTotalDuration.getValue();
        intent.putExtra("totalDuration",totalDuration);
        int partLength = npPartLength.getValue();
        intent.putExtra("partLength", partLength);
        startActivity(intent);
    }
}
