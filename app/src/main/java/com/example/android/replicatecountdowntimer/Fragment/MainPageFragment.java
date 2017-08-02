package com.example.android.replicatecountdowntimer.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.replicatecountdowntimer.FocusedBreathing.FocusedBreathingSettingActivity;
import com.example.android.replicatecountdowntimer.R;
import com.example.android.replicatecountdowntimer.Scoreboard.ScoreboardActivity;
import com.example.android.replicatecountdowntimer.Setting.SettingActivity;
import com.example.android.replicatecountdowntimer.SquaredBreathing.SquaredBreathingSettingActivity;

import static com.example.android.replicatecountdowntimer.R.id.btnFocusedBreathing;
import static com.example.android.replicatecountdowntimer.R.id.btnScoreboard;
import static com.example.android.replicatecountdowntimer.R.id.btnSetting;
import static com.example.android.replicatecountdowntimer.R.id.btnSquaredBreathing;

public class MainPageFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main_page, container, false);
        // Capture our button from layout
        TextView btnSquaredBreathing = (TextView) view.findViewById(R.id.btnSquaredBreathing);
        TextView btnFocusedBreathing = (TextView) view.findViewById(R.id.btnFocusedBreathing);
        TextView btnSetting = (TextView) view.findViewById(R.id.btnSetting);
        TextView btnScoreboard = (TextView) view.findViewById(R.id.btnScoreboard);

        btnSquaredBreathing.setOnClickListener(menuOnClickListener);
        btnFocusedBreathing.setOnClickListener(menuOnClickListener);
        btnSetting.setOnClickListener(menuOnClickListener);
        btnScoreboard.setOnClickListener(menuOnClickListener);

        return view;






    }

    private View.OnClickListener menuOnClickListener = new View.OnClickListener() {
        private Intent intent;

        public void onClick(View v) {
            // do something when the button is clicked
            // Yes we will handle click here but which button clicked??? We don't know

            // So we will make
            switch (v.getId() /*to get clicked view id**/) {
                case btnSquaredBreathing:

                    intent = new Intent(getActivity(), SquaredBreathingSettingActivity.class);
                    startActivity(intent);

                    break;
                case btnFocusedBreathing:

                    intent = new Intent(getActivity(), FocusedBreathingSettingActivity.class);
                    startActivity(intent);

                    break;
                case btnSetting:

                    intent = new Intent(getActivity(), SettingActivity.class);
                    startActivity(intent);

                    break;
                case btnScoreboard:

                    intent = new Intent(getActivity(), ScoreboardActivity.class);
                    startActivity(intent);

                    break;
                default:
                    break;
            }
        }
    };

}
