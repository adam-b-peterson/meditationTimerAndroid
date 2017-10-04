package com.example.android.replicatecountdowntimer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
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
        LinearLayout btnscoreboard = (LinearLayout) findViewById(R.id.btnScoreboard);
        LinearLayout btnInstruction = (LinearLayout) findViewById(R.id.btnInstruction);

        btnSquaredBreathing.setOnClickListener(menuOnClickListener);
        btnDeepBreathing.setOnClickListener(menuOnClickListener);
        btnSetting.setOnClickListener(menuOnClickListener);
        btnscoreboard.setOnClickListener(menuOnClickListener);
        btnInstruction.setOnClickListener(menuOnClickListener);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);

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

}

