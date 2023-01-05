package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

public class MainActivity extends AppCompatActivity{
    private boolean isRunning=false;
    private long pausetime=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Chronometer chronometer=findViewById(R.id.timer);
        Button onStart=findViewById(R.id.start);
        Button onPause=findViewById(R.id.pause);
        Button onReset=findViewById(R.id.reset);

        onStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             if(!isRunning){
                 chronometer.setBase(SystemClock.elapsedRealtime()-pausetime);
                 chronometer.start();
                 isRunning=true;
             }

            }
        });

        onPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isRunning){
                    chronometer.stop();
                    pausetime=SystemClock.elapsedRealtime()-chronometer.getBase();
                    isRunning=false;
                }

            }
        });
        onReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chronometer.setBase(SystemClock.elapsedRealtime());
                chronometer.stop();
                pausetime=0;
                isRunning=false;
            }
        });
    }
}