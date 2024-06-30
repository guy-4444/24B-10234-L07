package com.guy.a24b_10234_l07;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;

public class Activity_Panel extends AppCompatActivity {

    private MaterialTextView panel_LBL_info;
    private MaterialButton panel_BTN_start;
    private MaterialButton panel_BTN_stop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panel);

        panel_LBL_info = findViewById(R.id.panel_LBL_info);
        panel_BTN_start = findViewById(R.id.panel_BTN_start);
        panel_BTN_stop = findViewById(R.id.panel_BTN_stop);

        panel_BTN_start.setOnClickListener(v -> startService());
        panel_BTN_stop.setOnClickListener(v -> stopService());

    }

    private void startService() {
        sendActionToService(LocationService.START_FOREGROUND_SERVICE);
    }

    private void stopService() {
        sendActionToService(LocationService.STOP_FOREGROUND_SERVICE);
    }

    private void sendActionToService(String action) {
        Intent intent = new Intent(this, LocationService.class);
        intent.setAction(action);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            startForegroundService(intent);
            // or
            //ContextCompat.startForegroundService(this, startIntent);
        } else {
            startService(intent);
        }
    }

}