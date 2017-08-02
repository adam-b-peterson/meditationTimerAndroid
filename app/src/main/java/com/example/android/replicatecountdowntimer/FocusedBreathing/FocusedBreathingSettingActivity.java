package com.example.android.replicatecountdowntimer.FocusedBreathing;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.NumberPicker;

import com.example.android.replicatecountdowntimer.R;


public class FocusedBreathingSettingActivity extends AppCompatActivity {
    private NumberPicker npTotalDuration;
    private NumberPicker npPartLength;
    private CheckBox cbShowTimePassed;
    private CheckBox cbShowTimeLeft;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_focused_breathing_setting);
        npTotalDuration = (NumberPicker)findViewById(R.id.npTotalDuration);
        npPartLength = (NumberPicker)findViewById(R.id.npLength);
        cbShowTimePassed = (CheckBox)findViewById(R.id.cbShowTimePassed);
        cbShowTimeLeft = (CheckBox)findViewById(R.id.cbShowTimeLeft);

        //n: set range
        npTotalDuration.setMaxValue(999);
        npTotalDuration.setMinValue(1);

        //n: set range
        npPartLength.setMaxValue(10);
        npPartLength.setMinValue(4);

        cbShowTimePassed.setChecked(false);
        cbShowTimeLeft.setChecked(false);
    }


    public void startSquaredBreathingTimer(View view) {
        Intent intent = new Intent(FocusedBreathingSettingActivity.this, FocusedBreathingTimerActivity.class);
        int totalDuration = npTotalDuration.getValue();
        intent.putExtra("totalDuration",totalDuration);
        int partLength = npPartLength.getValue();
        intent.putExtra("partLength", partLength);
        boolean ShowTimePassed = cbShowTimePassed.isChecked();
        intent.putExtra("ShowTimePassed", ShowTimePassed);
        boolean ShowTimeLeft = cbShowTimeLeft.isChecked();
        intent.putExtra("ShowTimeLeft", ShowTimeLeft);
        startActivity(intent);
    }
}
