package com.example.a403.myapplication;

import android.graphics.Color;
import android.os.SystemClock;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Chronometer cro1;
    Button btn1, btn2, btn3, btn4;
    Switch sw1;
    RadioButton rd1, rd2, rd3;
    LinearLayout lay1, lay2;
    TextView tx1, tx2, tx3;
    EditText etx1, etx2, etx3;
    int adult=0;
    int semiadult=0;
    int child=0;
    int total=0;
    int discount=0;
    int price=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sw1 = (Switch)findViewById(R.id.switch1);
        cro1 = (Chronometer)findViewById(R.id.chronometer2);
        btn1 = (Button)findViewById(R.id.button2);
        lay1 = (LinearLayout)findViewById(R.id.layout1);
        lay2 = (LinearLayout)findViewById(R.id.layout2);
        tx1 = (TextView)findViewById(R.id.textView5);
        tx2 = (TextView)findViewById(R.id.textView6);
        tx3 = (TextView)findViewById(R.id.textView7);
        etx1 = (EditText)findViewById(R.id.editText);
        etx2 = (EditText)findViewById(R.id.editText2);
        etx3 = (EditText)findViewById(R.id.editText3);
        rd1 = (RadioButton)findViewById(R.id.radioButton);
        rd2 = (RadioButton)findViewById(R.id.radioButton2);
        rd3 = (RadioButton)findViewById(R.id.radioButton3);

        sw1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked=true){
                    lay1.setVisibility(View.VISIBLE);
                    cro1.setBase(SystemClock.elapsedRealtime());
                    cro1.start();
                    cro1.setTextColor(Color.parseColor("#FF0000"));
                } else {

                }
            }
        });


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cro1.stop();
                cro1.setTextColor(Color.parseColor("#0000FF"));
                adult= Integer.parseInt(etx1.getText().toString());
                semiadult = Integer.parseInt(etx2.getText().toString());
                child = Integer.parseInt(etx3.getText().toString());
                total=adult+semiadult+child;
                tx1.setText("총 명수:" + total);
            }
        });
    }
}
