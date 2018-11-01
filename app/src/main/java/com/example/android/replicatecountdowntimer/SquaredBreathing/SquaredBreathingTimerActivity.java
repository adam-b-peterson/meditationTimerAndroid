package com.example.android.replicatecountdowntimer.SquaredBreathing;

import android.animation.Animator;
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
import android.os.Vibrator;

public class SquaredBreathingTimerActivity extends BaseActivity {
    private Handler handler;
    private TextView tvShowProgress;
    private TextView tvShowInstructions;
    private TextView tvShowTimeLeft;
    private int progress;
    private int secLeft;
    private int state;
    private String stateText;
    private int totalDuration;
    private int partLength;
    private String timePassed;
    private String timeLeft;
    boolean ShowTimePassed;
    boolean ShowTimeLeft;
    boolean ShowInstructions;
    boolean CheckVibrate;

    private ImageView bg_circle;
    private String condition;
    private Vibrator vibrator;
    private AnimatorSet animateCircleDeepIn;
    private AnimatorSet animateCircleDeepOut;
    private AnimatorSet animateCircleSquareIn;
    private AnimatorSet animateCircleSquareOut;
    private Runnable runnable;

    // Back button kills Runnable to stop vibration
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        handler.removeCallbacks(runnable);
    }

    // remove status bar and lower bar
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        View decorView = getWindow().getDecorView();
        if(hasFocus) {
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_squared_breathing_timer);

        Bundle bundle = getIntent().getExtras();
        totalDuration = bundle.getInt("totalDuration");
        partLength = bundle.getInt("partLength");
        ShowTimePassed = bundle.getBoolean("ShowTimePassed");
        ShowTimeLeft = bundle.getBoolean("ShowTimeLeft");
        ShowInstructions = bundle.getBoolean("ShowInstructions");
        CheckVibrate = bundle.getBoolean("CheckVibrate");

        tvShowProgress = (TextView) findViewById(R.id.tvShowProgress);
        bg_circle = (ImageView) findViewById(R.id.bg_circle);

        condition = bundle.getString("condition");
        Log.d("condition", "condition = " + condition);

        vibrator = (Vibrator) getSystemService(getBaseContext().VIBRATOR_SERVICE);

        startTimer();

    }

    private void vibrateReminder() {
        if (CheckVibrate) {
            vibrator.vibrate(500);
        }
    }


    public void startTimer() {
        handler = new Handler();
        progress = 1;
        state = 0;

        tvShowInstructions = (TextView) findViewById(R.id.tvShowInstructions);
        tvShowTimeLeft = (TextView) findViewById(R.id.tvShowTimeLeft);
        if (!ShowTimePassed) {
            TextView tvTimePassedText = (TextView) findViewById(R.id.tvTimePassedText);
            tvTimePassedText.setVisibility(View.GONE);
            tvShowProgress.setVisibility(View.GONE);
        }
        if (!ShowTimeLeft) {
            TextView tvTimeLeftText = (TextView) findViewById(R.id.tvTimeLeftText);
            tvTimeLeftText.setVisibility(View.GONE);
            tvShowTimeLeft.setVisibility(View.GONE);
        }

        if (!ShowInstructions) {
            tvShowInstructions.setVisibility(View.INVISIBLE);
        }

        bg_circle.setScaleX(0);
        bg_circle.setScaleY(0);


        runnable = new Runnable() {
            @Override
            public void run() {
                if (progress < 60) {
                    timePassed = String.format("%02d", progress % 60);
                } else if (progress < 3600) {
                    timePassed = String.format("%02d:%02d", progress / 60, progress % 60);
                } else {
                    timePassed = String.format("%02d:%02d:%02d", progress / 3600, progress / 60, progress % 60);
                }
                tvShowProgress.setText(timePassed);
                secLeft = totalDuration * 60 - progress;
                if (secLeft < 60) {
                    timeLeft = String.format("%02d", secLeft % 60);
                } else if (secLeft < 3600) {
                    timeLeft = String.format("%02d:%02d", secLeft / 60, secLeft % 60);
                } else {
                    timeLeft = String.format("%02d:%02d:%02d", secLeft / 3600, secLeft / 60, secLeft % 60);
                }
                tvShowTimeLeft.setText(timeLeft);

                if (condition.equals("deep")) {
                    if (progress % (4 + partLength) == 1) {

                        ObjectAnimator animateCircleX = ObjectAnimator.ofFloat(bg_circle, "ScaleX", 0.3f, 1);
                        ObjectAnimator animateCircleY = ObjectAnimator.ofFloat(bg_circle, "ScaleY", 0.3f, 1);
                        animateCircleDeepIn = new AnimatorSet();
                        animateCircleDeepIn.playTogether(animateCircleX, animateCircleY);
                        animateCircleDeepIn.setDuration(4 * 1000);

                        ObjectAnimator animateCircle2X = ObjectAnimator.ofFloat(bg_circle, "ScaleX", 1, 0.3f);
                        ObjectAnimator animateCircle2Y = ObjectAnimator.ofFloat(bg_circle, "ScaleY", 1, 0.3f);
                        animateCircleDeepOut = new AnimatorSet();
                        animateCircleDeepOut.playTogether(animateCircle2X, animateCircle2Y);
                        animateCircleDeepOut.setDuration(partLength * 1000);

                        animateCircleDeepIn.addListener(new Animator.AnimatorListener() {
                            @Override
                            public void onAnimationStart(Animator animator) {
                                stateText = getString(R.string.Deep_In);
                                vibrateReminder();
                                tvShowInstructions.setText(stateText);

                                bg_circle.setScaleX(0.3f);
                                bg_circle.setScaleY(0.3f);
                            }

                            @Override
                            public void onAnimationEnd(Animator animator) {
                                stateText = getString(R.string.Deep_Out);
                                vibrateReminder();
                                tvShowInstructions.setText(stateText);

                                bg_circle.setScaleX(1);
                                bg_circle.setScaleY(1);

                                animateCircleDeepOut.start();
                            }

                            @Override
                            public void onAnimationCancel(Animator animator) {

                            }

                            @Override
                            public void onAnimationRepeat(Animator animator) {

                            }
                        });
                        animateCircleDeepIn.start();


                    }
                } else if (condition.equals("square")) {
                    if (progress % partLength == 1) {
                        state++;
                        Log.v("Timer", "State = " + state);
                        if (state == 1) {
                            stateText = getString(R.string.instruction_inhale);
                            vibrateReminder();

                            bg_circle.setScaleX(0.3f);
                            bg_circle.setScaleY(0.3f);

                            ObjectAnimator animateCircleX = ObjectAnimator.ofFloat(bg_circle, "ScaleX", 0.3f, 1);
                            ObjectAnimator animateCircleY = ObjectAnimator.ofFloat(bg_circle, "ScaleY", 0.3f, 1);
                            animateCircleSquareIn = new AnimatorSet();
                            animateCircleSquareIn.playTogether(animateCircleX, animateCircleY);
                            animateCircleSquareIn.setDuration(partLength * 1000);
//                        animateCircleSquareIn.setInterpolator(new DecelerateInterpolator());
                            animateCircleSquareIn.start();


                        } else if (state == 3) {
                            stateText = getString(R.string.instruction_exhale);
                            vibrateReminder();

                            bg_circle.setScaleX(1);
                            bg_circle.setScaleY(1);

                            ObjectAnimator animateCircleX = ObjectAnimator.ofFloat(bg_circle, "ScaleX", 1, 0.3f);
                            ObjectAnimator animateCircleY = ObjectAnimator.ofFloat(bg_circle, "ScaleY", 1, 0.3f);
                            animateCircleSquareOut = new AnimatorSet();
                            animateCircleSquareOut.playTogether(animateCircleX, animateCircleY);
                            animateCircleSquareOut.setDuration(partLength * 1000);
//                        animateCircleSquareOut.setInterpolator(new DecelerateInterpolator());
                            animateCircleSquareOut.start();

                        } else {
                            stateText = getString(R.string.instruction_hold);
                            vibrateReminder();
                        }
                        tvShowInstructions.setText(stateText);
                    }
                    if (state == 4) {
                        state = 0;
                    }
                }
                progress++;


//                !!! changed  to 1 when fast feedback while testing
                if (progress <= totalDuration * 60) {
//                if (progress <= totalDuration*1) {
                    handler.postDelayed(this, 1000);
                } else {
                    handler.removeCallbacks(runnable);
                    bg_circle.setVisibility(View.GONE);

                    SharedPreferences sharedPreferences = getSharedPreferences("record", MODE_PRIVATE);
                    String recordTotalPracticeDuration = sharedPreferences.getString("recordTotalPracticeDuration", "");
                    int temTimeAdd = 0;
                    try{
                        temTimeAdd = Integer.parseInt(recordTotalPracticeDuration) + totalDuration;
                        Log.d("TemTimeAdd", String.valueOf(temTimeAdd));
                    }catch(NumberFormatException ex){ // handle your exception
                    }
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("recordTotalPracticeDuration", Integer.toString(temTimeAdd));
                    editor.apply();
                    String temText = getString(R.string.finish_text) + Integer.toString(temTimeAdd);
                    tvShowInstructions.setVisibility(View.VISIBLE);
                    tvShowInstructions.setText(temText);
                    Intent intent = new Intent(getBaseContext(), MainActivity.class);
                    startActivity(intent);
                }
            }
        };
        handler.postDelayed(runnable, 1000);
    }

}
