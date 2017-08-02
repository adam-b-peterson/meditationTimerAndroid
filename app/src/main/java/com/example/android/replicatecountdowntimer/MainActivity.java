package com.example.android.replicatecountdowntimer;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.example.android.replicatecountdowntimer.Fragment.MainPageFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainPageFragment fragment = new MainPageFragment();
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.activity_main, fragment, fragment.getTag());
        transaction.commit();

//        // Capture our button from layout
//        TextView btnSquaredBreathing = (TextView) findViewById(R.id.btnSquaredBreathing);
//        TextView btnFocusedBreathing = (TextView) findViewById(R.id.btnFocusedBreathing);
//        TextView btnSetting = (TextView) findViewById(R.id.btnSetting);
//        TextView btnScoreboard = (TextView) findViewById(R.id.btnScoreboard);

        // Register the onClick listener with the implementation above
//        btnSquaredBreathing.setOnClickListener(menuOnClickListener);
//        btnFocusedBreathing.setOnClickListener(menuOnClickListener);
//        btnSetting.setOnClickListener(menuOnClickListener);
//        btnScoreboard.setOnClickListener(menuOnClickListener);
//        setMenuOnClickListener(btnFocusedBreathing);
    }

//    private void setMenuOnClickListener(View view) {
//        view.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                switch (view.getId()) {
//                    case R.id.btnSquaredBreathing:
//                        setIntent(SquaredBreathingSettingActivity.class);
//                        break;
////                    case R.id.btnFocusedBreathing:
////                        setIntent
////                        intent = new Intent(MainActivity.this, FocusedBreathingSettingActivity.class);
////                        startActivity(intent);
////
////                        break;
////                    case R.id.btnSetting:
////                        setIntent
////                        intent = new Intent(MainActivity.this, SettingActivity.class);
////                        startActivity(intent);
////
////                        break;
////                    case R.id.btnScoreboard:
////                        setIntent
////                        intent = new Intent(MainActivity.this, ScoreboardActivity.class);
////                        startActivity(intent);
////
////                        break;
////                    default:
////                        break;
//                }
//            }
//        });
//    }
//
//    private void setIntent(Class activityClass) {
//        Intent intent = new Intent(MainActivity.this, activityClass);
//        startActivity(intent);
//    }
//
//    private View.OnClickListener menuOnClickListener = new View.OnClickListener() {
//        private Intent intent;
//
//        public void onClick(View v) {
//            // do something when the button is clicked
//            // Yes we will handle click here but which button clicked??? We don't know
//
//            // So we will make
//            switch (v.getId() /*to get clicked view id**/) {
//                case R.id.btnSquaredBreathing:
//
//                    intent = new Intent(MainActivity.this, SquaredBreathingSettingActivity.class);
//                    startActivity(intent);
//
//                    break;
//                case R.id.btnFocusedBreathing:
//
//                    intent = new Intent(MainActivity.this, FocusedBreathingSettingActivity.class);
//                    startActivity(intent);
//
//                    break;
//                case R.id.btnSetting:
//
//                    intent = new Intent(MainActivity.this, SettingActivity.class);
//                    startActivity(intent);
//
//                    break;
//                case R.id.btnScoreboard:
//
//                    intent = new Intent(MainActivity.this, ScoreboardActivity.class);
//                    startActivity(intent);
//
//                    break;
//                default:
//                    break;
//            }
//        }
//    };

}
