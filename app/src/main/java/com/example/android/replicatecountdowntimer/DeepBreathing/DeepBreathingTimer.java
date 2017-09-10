package com.example.android.replicatecountdowntimer.SquaredBreathing;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.replicatecountdowntimer.BaseActivity;
import com.example.android.replicatecountdowntimer.MainActivity;
import com.example.android.replicatecountdowntimer.R;

public class SquaredBreathingTimer extends BaseActivity {
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
    ImageView bg_circle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_squared_breathing_timer);
// a       setupWindowAnimations();

        Bundle bundle = getIntent().getExtras();
        totalDuration = bundle.getInt("totalDuration");
        partLength = bundle.getInt("partLength");
        ShowTimePassed = bundle.getBoolean("ShowTimePassed");
        ShowTimeLeft = bundle.getBoolean("ShowTimeLeft");

        tvShowProgress = (TextView) findViewById(R.id.tvShowProgress);
        bg_circle = (ImageView) findViewById(R.id.bg_circle);

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


            bg_circle.setScaleX(0);
            bg_circle.setScaleY(0);
//
//            ObjectAnimator AnimateCircleX = ObjectAnimator.ofFloat(bg_circle, "ScaleX", 0, 1);
//            ObjectAnimator AnimateCircleY = ObjectAnimator.ofFloat(bg_circle, "ScaleY", 0, 1);
//            AnimatorSet AnimateCircle = new AnimatorSet();
//            AnimateCircle.playTogether(AnimateCircleX, AnimateCircleY);
//            AnimateCircle.start();
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
                        bg_circle.setScaleX(0.3f);
                        bg_circle.setScaleY(0.3f);

                        ObjectAnimator animateCircleX = ObjectAnimator.ofFloat(bg_circle, "ScaleX", 0.3f, 1);
                        ObjectAnimator animateCircleY = ObjectAnimator.ofFloat(bg_circle, "ScaleY", 0.3f, 1);
                        AnimatorSet animateCircle = new AnimatorSet();
                        animateCircle.playTogether(animateCircleX, animateCircleY);
                        animateCircle.setDuration(partLength * 1000);
//                        animateCircle.setInterpolator(new DecelerateInterpolator());
                        animateCircle.start();


                    } else if (state == 3) {
                        stateText = "Exhale Gently";

                        bg_circle.setScaleX(1);
                        bg_circle.setScaleY(1);

                        ObjectAnimator animateCircleX = ObjectAnimator.ofFloat(bg_circle, "ScaleX", 1, 0.3f);
                        ObjectAnimator animateCircleY = ObjectAnimator.ofFloat(bg_circle, "ScaleY", 1, 0.3f);
                        AnimatorSet animateCircle = new AnimatorSet();
                        animateCircle.playTogether(animateCircleX, animateCircleY);
                        animateCircle.setDuration(partLength * 1000);
//                        animateCircle.setInterpolator(new DecelerateInterpolator());
                        animateCircle.start();

                    } else {
                        stateText = "Hold The Breath";
                    }
                    tvShowState.setText(stateText);
                }
                if (state == 4) {
                    state = 0;
                }
                progress++;




//                !!! changed  to 1 when fast feedback while testing
                if (progress <= totalDuration*60) {
//                if (progress <= totalDuration*1) {
                    handler.postDelayed(this, 1000);
                } else {
                    bg_circle.setVisibility(View.GONE);

                    SharedPreferences sharedPreferences = getSharedPreferences("record", MODE_PRIVATE);
                    String recordTotalPracticeDuration = sharedPreferences.getString("recordTotalPracticeDuration", "");
                    int temTimeAdd = Integer.parseInt(recordTotalPracticeDuration) + totalDuration;
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("recordTotalPracticeDuration", Integer.toString(temTimeAdd));
                    editor.apply();
                    String temText = "Congratulations!\nYou've accomplished your current practice!\nTotal Practical Duration: " + Integer.toString(temTimeAdd);
                    tvShowState.setText(temText);
                }
            }
        };
        handler.postDelayed(runnable, 1000);
    }

    public void backToMenu(View view) {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }

// a   Ask Wingy about this
//    private void setupWindowAnimations() {
//        Fade fade = new Fade();
//        fade.setDuration(1000);
//        getWindow().setEnterTransition(fade);
//
//        Explode explode = new Explode();
//        explode.setDuration(1000);
//        getWindow().setExitTransition(explode);
// a\   }
}
