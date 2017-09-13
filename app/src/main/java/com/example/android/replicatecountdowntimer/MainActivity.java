package com.example.android.replicatecountdowntimer;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.android.replicatecountdowntimer.Scoreboard.ScoreboardActivity;
import com.example.android.replicatecountdowntimer.Setting.SettingActivity;
import com.example.android.replicatecountdowntimer.SquaredBreathing.SquaredBreathingSettingActivity;

import static com.example.android.replicatecountdowntimer.R.id.btnDeepBreathing;
import static com.example.android.replicatecountdowntimer.R.id.btnInstruction;
import static com.example.android.replicatecountdowntimer.R.id.btnScoreboard;
import static com.example.android.replicatecountdowntimer.R.id.btnSetting;
import static com.example.android.replicatecountdowntimer.R.id.btnSquaredBreathing;

public class MainActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        setupWindowAnimations();

        LinearLayout btnSquaredBreathing = (LinearLayout) findViewById(R.id.btnSquaredBreathing);
        LinearLayout btnDeepBreathing = (LinearLayout) findViewById(R.id.btnDeepBreathing);
        LinearLayout btnSetting = (LinearLayout) findViewById(R.id.btnSetting);
        LinearLayout btnScoreboard = (LinearLayout) findViewById(R.id.btnScoreboard);
        LinearLayout btnInstruction = (LinearLayout) findViewById(R.id.btnInstruction);

        btnSquaredBreathing.setOnClickListener(menuOnClickListener);
        btnDeepBreathing.setOnClickListener(menuOnClickListener);
        btnSetting.setOnClickListener(menuOnClickListener);
        btnScoreboard.setOnClickListener(menuOnClickListener);
        btnInstruction.setOnClickListener(menuOnClickListener);

    }

    private View.OnClickListener menuOnClickListener = new View.OnClickListener() {
        private Intent intent;

        public void onClick(View v) {
            // do something when the button is clicked
            // Yes we will handle click here but which button clicked??? We don't know

            // So we will make
            switch (v.getId() /*to get clicked view id**/) {
                case btnSquaredBreathing:

                    intent = new Intent(MainActivity.this, SquaredBreathingSettingActivity.class);
                    intent.putExtra("condition", "square");
                    startActivity(intent);

                    //                    setAlphaAnimation(R.layout.activity_main);
                    //                      overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
                    break;
                case btnDeepBreathing:

                    intent = new Intent(MainActivity.this, SquaredBreathingSettingActivity.class);
                    intent.putExtra("condition", "deep");
                    startActivity(intent);
                    break;

                case btnSetting:

                    intent = new Intent(MainActivity.this, SettingActivity.class);
                    startActivity(intent);

                    break;
                case btnScoreboard:

                    intent = new Intent(MainActivity.this, ScoreboardActivity.class);
                    startActivity(intent);

                    break;
                case btnInstruction:
                    intent = new Intent(MainActivity.this, InstructionActivity.class);
                    startActivity(intent);

                    break;
                default:
                    break;
            }
        }
    };

//    private void setupWindowAnimations() {
//        Fade fade = new Fade();
//        fade.setDuration(3000);
//        getWindow().setEnterTransition(fade);
//
//        Explode explode = new Explode();
//        explode.setDuration(3000);
//        getWindow().setExitTransition(explode);
//    }

    public static void setAlphaAnimation(View v) {
        ObjectAnimator fadeOut = ObjectAnimator.ofFloat(v, "alpha",  1f, .3f);
        fadeOut.setDuration(2000);
        ObjectAnimator fadeIn = ObjectAnimator.ofFloat(v, "alpha", .3f, 1f);
        fadeIn.setDuration(2000);

        final AnimatorSet mAnimationSet = new AnimatorSet();

        mAnimationSet.play(fadeIn).after(fadeOut);

        mAnimationSet.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                mAnimationSet.start();
            }
        });
        mAnimationSet.start();
    }

}

