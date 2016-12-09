package com.example.a403.myapplication;

import android.graphics.Color;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.CompoundButton;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    Chronometer cro1;
    Button btn1, btn2, btn3, btn4;
    Switch sw1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sw1 = (Switch)findViewById(R.id.switch1);
        cro1 = (Chronometer)findViewById(R.id.chronometer2);
        btn1 = (Button)findViewById(R.id.button2);

        sw1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                cro1.setBase(SystemClock.elapsedRealtime());
                cro1.start();
                cro1.setTextColor(Color.parseColor("#FF0000"));
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cro1.stop();
                cro1.setTextColor(Color.parseColor("#0000FF"));
            }
        });
    }
}
