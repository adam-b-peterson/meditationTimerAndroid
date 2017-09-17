package com.example.android.replicatecountdowntimer;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Philip on 17/08/19.
 */

public class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    public static boolean isVisible = true;

    @Override
    public void onResume() {
        super.onResume();
        setVisible(true);
        isVisible = true;
    }

    @Override
    public void onPause() {
        super.onPause();
        setVisible(false);
        isVisible = false;
    }
}
