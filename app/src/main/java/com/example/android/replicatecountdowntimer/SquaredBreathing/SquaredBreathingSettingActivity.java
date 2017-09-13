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
import android.widget.NumberPicker;
import android.widget.TextView;

import com.example.android.replicatecountdowntimer.BaseActivity;
import com.example.android.replicatecountdowntimer.R;

public class SquaredBreathingSettingActivity extends BaseActivity {
    private NumberPicker npTotalDuration;
    private NumberPicker npPartLength;
    private CheckBox cbShowTimePassed;
    private CheckBox cbShowTimeLeft;
    private TextView btnDuration3mins;
    private TextView btnDuration5mins;
    private TextView btnDuration10mins;
    private TextView btnDuration20mins;
    private TextView btnDuration30mins;
    private TextView btnDurationCustom;
    private TextView btnLength4secs;
    private TextView btnLength5secs;
    private TextView btnLength6secs;
    private TextView btnLength7secs;
    private TextView btnLength8secs;
    private TextView tvHintOfDuration;
    private TextView tvHintOfLength;
    private  TextView btnStartSquaredBreathing;
    private EditText etDurationCurrent;
    private EditText etLengthCurrent;
    private String condition;
    private TextView tvDescriptionOfLength;
    int maxTotalLength;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqaured_breathing_setting);

        tvDescriptionOfLength = (TextView)findViewById(R.id.tvDescriptionOfLength);

        npTotalDuration = (NumberPicker)findViewById(R.id.npTotalDuration);
        npPartLength = (NumberPicker)findViewById(R.id.npLength);
        cbShowTimePassed = (CheckBox)findViewById(R.id.cbShowTimePassed);
        cbShowTimeLeft = (CheckBox)findViewById(R.id.cbShowTimeLeft);

        btnDuration3mins = (TextView)findViewById(R.id.btnDuration3mins);
        btnDuration5mins = (TextView)findViewById(R.id.btnDuration5mins);
        btnDuration10mins = (TextView)findViewById(R.id.btnDuration10mins);
        btnDuration20mins = (TextView)findViewById(R.id.btnDuration20mins);
        btnDuration30mins = (TextView)findViewById(R.id.btnDuration30mins);
//        btnDurationCustom = (TextView)findViewById(R.id.btnDurationCustom);
//        etDurationCurrent = (TextView)findViewById(R.id.etDurationCurrent);
        btnLength4secs = (TextView)findViewById(R.id.btnLength4secs);
        btnLength5secs = (TextView)findViewById(R.id.btnLength5secs);
        btnLength6secs = (TextView)findViewById(R.id.btnLength6secs);
        btnLength7secs = (TextView)findViewById(R.id.btnLength7secs);
        btnLength8secs = (TextView)findViewById(R.id.btnLength8secs);
//        btnLengthCustom = (TextView)findViewById(R.id.btnLengthCustom);
//        etLengthCurrent = (TextView)findViewById(R.id.etLengthCurrent);
        tvHintOfDuration = (TextView)findViewById(R.id.tvHintOfDuration);
        tvHintOfLength = (TextView)findViewById(R.id.tvHintOfLength);
        btnStartSquaredBreathing = (TextView) findViewById(R.id.btnStartSquaredBreathing);
        etDurationCurrent = (EditText) findViewById(R.id.etDurationCurrent);
        etLengthCurrent = (EditText)findViewById(R.id.etLengthCurrent);

        btnStartSquaredBreathing.setVisibility(View.INVISIBLE);


        btnDuration3mins.setOnClickListener(onClickListenerChangeSettings);
        btnDuration5mins.setOnClickListener(onClickListenerChangeSettings);
        btnDuration10mins.setOnClickListener(onClickListenerChangeSettings);
        btnDuration20mins.setOnClickListener(onClickListenerChangeSettings);
        btnDuration30mins.setOnClickListener(onClickListenerChangeSettings);
//        btnDurationCustom.setOnClickListener(onClickListenerChangeSettings);
//        etDurationCurrent.setOnClickListener(onClickListenerChangeSettings);
        btnLength4secs.setOnClickListener(onClickListenerChangeSettings);
        btnLength5secs.setOnClickListener(onClickListenerChangeSettings);
        btnLength6secs.setOnClickListener(onClickListenerChangeSettings);
        btnLength7secs.setOnClickListener(onClickListenerChangeSettings);
        btnLength8secs.setOnClickListener(onClickListenerChangeSettings);
//        btnLengthCustom.setOnClickListener(onClickListenerChangeSettings);
//        etLengthCurrent.setOnClickListener(onClickListenerChangeSettings);

        etDurationCurrent.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(TextUtils.isEmpty(s)) {
                    tvHintOfDuration.setBackgroundColor(Color.RED);
                    tvHintOfDuration.setTextColor(Color.WHITE);
                    btnStartSquaredBreathing.setVisibility(View.INVISIBLE);
                    return;
                } else {
                    int intTotalDuration = Integer.parseInt(s.toString());
                    if ((intTotalDuration >= 1) && (intTotalDuration <= 600)) {
                        tvHintOfDuration.setBackgroundColor(Color.TRANSPARENT);
                        tvHintOfDuration.setTextColor(Color.TRANSPARENT);
                        btnStartSquaredBreathing.setVisibility(View.VISIBLE);
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
                if(TextUtils.isEmpty(s)) {
                    tvHintOfLength.setBackgroundColor(Color.RED);
                    tvHintOfLength.setTextColor(Color.WHITE);
                    btnStartSquaredBreathing.setVisibility(View.INVISIBLE);
                    return;
                } else {
                    int intTotalLength = Integer.parseInt(s.toString());
                    if ((intTotalLength >= 4) && (intTotalLength <= maxTotalLength)) {
                        tvHintOfLength.setBackgroundColor(Color.TRANSPARENT);
                        tvHintOfLength.setTextColor(Color.TRANSPARENT);
                        btnStartSquaredBreathing.setVisibility(View.VISIBLE);
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


//        Bundle bundle = getIntent().getExtras();
//        condition = bundle.getChar("condition");
        condition= getIntent().getStringExtra("condition");
//        Log.d("condition", "condition = " + condition);

        if (condition.equals("square")) {
            tvDescriptionOfLength.setText("Length of Square: (4-15 seconds)");
            tvHintOfLength.setText("Please choose between 4-15 seconds");
            maxTotalLength = 15;
        } else if (condition.equals("deep")) {
            tvDescriptionOfLength.setText("Length of Exhale: (4-30 seconds)");
            tvHintOfLength.setText("Please choose between 4-30 seconds");
            maxTotalLength = 30;
        }

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
//                case R.id.btnDurationCustom:
//                    break;
//                case R.id.etDurationCurrent:
//                    break;
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
//                case R.id.btnLengthCustom:
//                    break;
//                case R.id.etLengthCurrent:
//                    break;
            }
        }
    };

    public void startSquaredBreathingTimer(View view) {
        Intent intent = new Intent(SquaredBreathingSettingActivity.this, SquaredBreathingTimer.class);
        intent.putExtra("totalDuration", Integer.parseInt(etDurationCurrent.getText().toString()));
        intent.putExtra("partLength", Integer.parseInt(etLengthCurrent.getText().toString()));
        boolean ShowTimePassed = cbShowTimePassed.isChecked();
        intent.putExtra("ShowTimePassed", ShowTimePassed);
        boolean ShowTimeLeft = cbShowTimeLeft.isChecked();
        intent.putExtra("ShowTimeLeft", ShowTimeLeft);
        intent.putExtra("condition", condition);
        startActivity(intent);
    }
}
