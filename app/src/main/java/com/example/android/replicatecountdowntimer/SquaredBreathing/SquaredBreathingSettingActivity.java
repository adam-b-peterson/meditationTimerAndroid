package com.example.android.replicatecountdowntimer.SquaredBreathing;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.example.android.replicatecountdowntimer.BaseActivity;
import com.example.android.replicatecountdowntimer.R;

public class SquaredBreathingSettingActivity extends BaseActivity {
    private CheckBox cbShowTimePassed;
    private CheckBox cbShowTimeLeft;
    private CheckBox cbShowInstructions;
    private CheckBox cbCheckVibrate;

    /**
     * duration views
     */
    private TextView btnDuration3mins;
    private TextView btnDuration5mins;
    private TextView btnDuration10mins;
    private TextView btnDuration20mins;
    private TextView btnDuration30mins;

    /**
     * length views
     */
    private TextView btnLength4secs;
    private TextView btnLength5secs;
    private TextView btnLength6secs;
    private TextView btnLength7secs;
    private TextView btnLength8secs;

    private TextView tvHintOfDuration;
    private TextView tvHintOfLength;
    private TextView btnStartSquaredBreathing;
    private EditText etDurationCurrent;
    private EditText etLengthCurrent;
    private String condition;
    private TextView tvDescriptionOfLength;
    private int intTotalDuration;
    private int intTotalLength;
    int maxTotalLength;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqaured_breathing_setting);

        SquaredBreathingSettingBindViewAndOnClick();

        etDurationCurrent.setText("3");
        etLengthCurrent.setText("4");
        intTotalDuration = Integer.parseInt(etDurationCurrent.getText().toString());
        intTotalLength = Integer.parseInt(etLengthCurrent.getText().toString());

        etDurationCurrent.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (TextUtils.isEmpty(s)) {
                    tvHintOfDuration.setBackgroundColor(Color.RED);
                    tvHintOfDuration.setTextColor(Color.WHITE);
                    btnStartSquaredBreathing.setVisibility(View.INVISIBLE);
                    return;
                } else {
                    intTotalDuration = Integer.parseInt(s.toString());
                    if ((intTotalDuration >= 1) && (intTotalDuration <= 600)) {
                        tvHintOfDuration.setBackgroundColor(Color.TRANSPARENT);
                        tvHintOfDuration.setTextColor(Color.TRANSPARENT);
                        if ((intTotalLength >= 4) && (intTotalLength <= maxTotalLength)) {
                            btnStartSquaredBreathing.setVisibility(View.VISIBLE);
                        }
                    } else {
                        tvHintOfDuration.setBackgroundColor(Color.RED);
                        tvHintOfDuration.setTextColor(Color.WHITE);
                        btnStartSquaredBreathing.setVisibility(View.INVISIBLE);
                    }
                }
            }
        });

        etLengthCurrent.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (TextUtils.isEmpty(s)) {
                    tvHintOfLength.setBackgroundColor(Color.RED);
                    tvHintOfLength.setTextColor(Color.WHITE);
                    btnStartSquaredBreathing.setVisibility(View.INVISIBLE);
                    return;
                } else {
                    intTotalLength = Integer.parseInt(s.toString());
                    if ((intTotalLength >= 4) && (intTotalLength <= maxTotalLength)) {
                        tvHintOfLength.setBackgroundColor(Color.TRANSPARENT);
                        tvHintOfLength.setTextColor(Color.TRANSPARENT);
                        if ((intTotalDuration >= 1) && (intTotalDuration <= 600)) {
                            btnStartSquaredBreathing.setVisibility(View.VISIBLE);
                        }
                    } else {
                        tvHintOfLength.setBackgroundColor(Color.RED);
                        tvHintOfLength.setTextColor(Color.WHITE);
                        btnStartSquaredBreathing.setVisibility(View.INVISIBLE);
                    }
                }
            }
        });

        cbShowTimePassed.setChecked(false);
        cbShowTimeLeft.setChecked(false);
        cbShowInstructions.setChecked(false);
        cbCheckVibrate.setChecked(false);


        condition = getIntent().getStringExtra("condition");

        if (condition.equals("square")) {
            tvDescriptionOfLength.setText(R.string.description_of_length_square);
            tvHintOfLength.setText(R.string.hint_of_length_square);
            maxTotalLength = 15;
        } else if (condition.equals("deep")) {
            tvDescriptionOfLength.setText(R.string.description_of_length_deep);
            tvHintOfLength.setText(R.string.hint_of_length_deep);
            maxTotalLength = 30;
        }

    }

    private void SquaredBreathingSettingBindViewAndOnClick() {
        tvDescriptionOfLength = (TextView) findViewById(R.id.tvDescriptionOfLength);

        cbShowTimePassed = (CheckBox) findViewById(R.id.cbShowTimePassed);
        cbShowTimeLeft = (CheckBox) findViewById(R.id.cbShowTimeLeft);
        cbShowInstructions = (CheckBox) findViewById(R.id.cbShowInstructions);
        cbCheckVibrate = (CheckBox) findViewById(R.id.cbCheckVibrate);

        btnDuration3mins = (TextView) findViewById(R.id.btnDuration3mins);
        btnDuration5mins = (TextView) findViewById(R.id.btnDuration5mins);
        btnDuration10mins = (TextView) findViewById(R.id.btnDuration10mins);
        btnDuration20mins = (TextView) findViewById(R.id.btnDuration20mins);
        btnDuration30mins = (TextView) findViewById(R.id.btnDuration30mins);
        btnLength4secs = (TextView) findViewById(R.id.btnLength4secs);
        btnLength5secs = (TextView) findViewById(R.id.btnLength5secs);
        btnLength6secs = (TextView) findViewById(R.id.btnLength6secs);
        btnLength7secs = (TextView) findViewById(R.id.btnLength7secs);
        btnLength8secs = (TextView) findViewById(R.id.btnLength8secs);
        tvHintOfDuration = (TextView) findViewById(R.id.tvHintOfDuration);
        tvHintOfLength = (TextView) findViewById(R.id.tvHintOfLength);
        btnStartSquaredBreathing = (TextView) findViewById(R.id.btnStartSquaredBreathing);
        etDurationCurrent = (EditText) findViewById(R.id.etDurationCurrent);
        etLengthCurrent = (EditText) findViewById(R.id.etLengthCurrent);

        btnDuration3mins.setOnClickListener(onClickListenerChangeSettings);
        btnDuration5mins.setOnClickListener(onClickListenerChangeSettings);
        btnDuration10mins.setOnClickListener(onClickListenerChangeSettings);
        btnDuration20mins.setOnClickListener(onClickListenerChangeSettings);
        btnDuration30mins.setOnClickListener(onClickListenerChangeSettings);
        btnLength4secs.setOnClickListener(onClickListenerChangeSettings);
        btnLength5secs.setOnClickListener(onClickListenerChangeSettings);
        btnLength6secs.setOnClickListener(onClickListenerChangeSettings);
        btnLength7secs.setOnClickListener(onClickListenerChangeSettings);
        btnLength8secs.setOnClickListener(onClickListenerChangeSettings);
    }

    private View.OnClickListener onClickListenerChangeSettings = new View.OnClickListener() {
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btnDuration3mins:
                    etDurationCurrent.setText("3");
                    break;
                case R.id.btnDuration5mins:
                    etDurationCurrent.setText("5");
                    break;
                case R.id.btnDuration10mins:
                    etDurationCurrent.setText("10");
                    break;
                case R.id.btnDuration20mins:
                    etDurationCurrent.setText("20");
                    break;
                case R.id.btnDuration30mins:
                    etDurationCurrent.setText("30");
                    break;
                case R.id.btnLength4secs:
                    etLengthCurrent.setText("4");
                    break;
                case R.id.btnLength5secs:
                    etLengthCurrent.setText("5");
                    break;
                case R.id.btnLength6secs:
                    etLengthCurrent.setText("6");
                    break;
                case R.id.btnLength7secs:
                    etLengthCurrent.setText("7");
                    break;
                case R.id.btnLength8secs:
                    etLengthCurrent.setText("8");
                    break;
            }
        }
    };

    public void startSquaredBreathingTimer(View view) {
        Intent intent = new Intent(SquaredBreathingSettingActivity.this, SquaredBreathingTimerActivity.class);
        intent.putExtra("totalDuration", Integer.parseInt(etDurationCurrent.getText().toString()));
        intent.putExtra("partLength", Integer.parseInt(etLengthCurrent.getText().toString()));
        boolean ShowTimePassed = cbShowTimePassed.isChecked();
        intent.putExtra("ShowTimePassed", ShowTimePassed);
        boolean ShowTimeLeft = cbShowTimeLeft.isChecked();
        intent.putExtra("ShowTimeLeft", ShowTimeLeft);
        boolean ShowInstructions = cbShowInstructions.isChecked();
        intent.putExtra("ShowInstructions", ShowInstructions);
        boolean CheckVibrate = cbCheckVibrate.isChecked();
        intent.putExtra("CheckVibrate", CheckVibrate);
        intent.putExtra("condition", condition);
        startActivity(intent);
    }
}
