package com.example.android.replicatecountdowntimer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.android.replicatecountdowntimer.FocusedBreathing.FocusedBreathingSetupActivity;
import com.example.android.replicatecountdowntimer.Fragment.MainPageFragment;
import com.example.android.replicatecountdowntimer.SquaredBreathing.SquaredBreathingTimer;

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
    }


    public void startSquaredBreathingFragment(View view) {
        Intent intent = new Intent(MainActivity.this, SquaredBreathingTimer.class);
        startActivity(intent);
    }

    public void startFocusedBreathingFragment(View view) {
        Intent intent = new Intent(MainActivity.this, FocusedBreathingSetupActivity.class);
        startActivity(intent);
    }

    public void startSettingFragment(View view) {
//        Intent intent = new Intent(MainActivity.this, SquaredBreathingTimer.class);
//        startActivity(intent);
    }

    public void startScoreboardFragment(View view) {
//        Intent intent = new Intent(MainActivity.this, SquaredBreathingTimer.class);
//        startActivity(intent);
    }
}
