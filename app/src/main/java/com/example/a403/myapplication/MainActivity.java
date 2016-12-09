package com.example.a403.myapplication;

import android.graphics.Color;
import android.os.SystemClock;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Chronometer cro1;
    Button btn1, btn2, btn3, btn4;
    Switch sw1;
    RadioButton rd1, rd2, rd3, rd4, rd5;
    LinearLayout lay1, lay2;
    TextView tx1, tx2, tx3;
    EditText etx1, etx2, etx3;
    CalendarView cal1;
    TimePicker tim1;
    int adult=0;
    int semiadult=0;
    int child=0;
    int total=0;
    int disco=0;
    int discount=0;
    int origprice=0;
    int price=0;
    ImageView img;
    int hou, min, yea, mon, day;
    int check1=0, check2=0;

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
        img = (ImageView)findViewById(R.id.imageView);
        btn2 = (Button)findViewById(R.id.button3);
        btn3 = (Button)findViewById(R.id.button5);
        btn4 = (Button)findViewById(R.id.button6);
        cal1 = (CalendarView)findViewById(R.id.calendarView);
        tim1 = (TimePicker)findViewById(R.id.timePicker);
        rd4= (RadioButton)findViewById(R.id.radioButton4);
        rd5= (RadioButton)findViewById(R.id.radioButton5);


        sw1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked=true){
                    lay1.setVisibility(View.VISIBLE);
                    lay2.setVisibility(View.INVISIBLE);
                    cro1.setBase(SystemClock.elapsedRealtime());
                    cro1.start();
                    cro1.setTextColor(Color.parseColor("#FF0000"));

                } else {
                    lay1.setVisibility(View.INVISIBLE);
                    lay2.setVisibility(View.INVISIBLE);
                    etx1.setText("");
                    etx2.setText("");
                    etx3.setText("");
                    rd1.isChecked();
                    tx1.setText("총 명수:" );
                    tx2.setText("할임금액:");
                    tx3.setText("결제금액:");
                    check1=0;
                }
            }
        });

        rd1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                disco = 5;
                img.setImageResource(R.drawable.t1);
            }
        });

        rd2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                disco = 10;
                img.setImageResource(R.drawable.t2);
            }
        });

        rd3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                disco = 20;
                img.setImageResource(R.drawable.t3);
            }
        });

        rd4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                cal1.setVisibility(View.INVISIBLE);
                tim1.setVisibility(View.VISIBLE);
            }
        });

        rd5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                cal1.setVisibility(View.VISIBLE);
                tim1.setVisibility(View.INVISIBLE);
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etx1.getText().toString().equals(""))
                    check2=1;
                else if(etx2.getText().toString().equals(""))
                    check2=1;
                else if(etx3.getText().toString().equals(""))
                    check2=1;
                if(check2==1){
                    Toast.makeText(MainActivity.this,"인원수를 입력해주세요",Toast.LENGTH_SHORT).show();
                }
                else {
                    adult= Integer.parseInt(etx1.getText().toString());
                    semiadult = Integer.parseInt(etx2.getText().toString());
                    child = Integer.parseInt(etx3.getText().toString());
                    cro1.stop();
                    cro1.setTextColor(Color.parseColor("#0000FF"));
                    total = adult + semiadult + child;
                    origprice = (adult * 15000) + (semiadult * 12000) + (child * 6000);
                    discount = (origprice / 100) * disco;
                    price = origprice - discount;
                    tx1.setText("총 명수:" + total);
                    tx2.setText("할임금액:" + discount);
                    tx3.setText("결제금액:" + price);
                    check1=1;
                }
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lay1.setVisibility(View.INVISIBLE);
                lay2.setVisibility(View.VISIBLE);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(check1==1)
                    Toast.makeText(MainActivity.this, yea + "년" + mon + "월" + day + "일" + hou + "시" + min + "분 예약됨", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this, "인원 예약을 먼저하세요", Toast.LENGTH_SHORT).show();
            }
        });

        tim1.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                hou = hourOfDay;
                min = minute;
            }
        });
        cal1.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                yea = year;
                mon = month;
                day = dayOfMonth;
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lay1.setVisibility(View.VISIBLE);
                lay2.setVisibility(View.INVISIBLE);
            }
        });
    }
}
