package com.example.admin.demo1;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Paint;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    TextView t1,t2,t3,t4,t5,t6,t7,t15,t8;
    EditText e1,e2,e3,e4;
    Button b1,b2;
    RadioGroup rg1;
    CheckBox cb1;
    String s1,s2,s3,s5,s6,s7,s8,s9,s10;
    int s4;
    MediaPlayer mp;
    AlertDialog.Builder alertdialogue,ad2;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Spinner sp;
    ArrayList<Integer> al;
    ArrayAdapter<Integer> ar;
    Calendar calendar;
    int currenthour;
    int currentminute;
    String ampm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferences=getSharedPreferences("sfname",MODE_PRIVATE);
        editor=sharedPreferences.edit();
        mp=MediaPlayer.create(MainActivity.this,R.raw.dd);
        t1 = findViewById(R.id.textView7);
        t2 = findViewById(R.id.textView8);
        t3 = findViewById(R.id.textView9);
        t4 = findViewById(R.id.textView10);
        t5 = findViewById(R.id.textView11);
        t6 = findViewById(R.id.textView12);
        t7 = findViewById(R.id.textView13);
        t8=findViewById(R.id.textView2);
        t8.setPaintFlags(t8.getPaintFlags()|
        Paint.UNDERLINE_TEXT_FLAG);
        t15=findViewById(R.id.textView15);
        t15.setPaintFlags(t15.getPaintFlags()|
                Paint.UNDERLINE_TEXT_FLAG);
        e1 = findViewById(R.id.editText);
        e2 = findViewById(R.id.editText2);
        e3 = findViewById(R.id.editText3);
        e4 = findViewById(R.id.editText4);
        rg1 = findViewById(R.id.radiogroup);
        cb1 = findViewById(R.id.checkBox);
        b1 = findViewById(R.id.button);
        b2 = findViewById(R.id.button2);
        sp=findViewById(R.id.spinner);
        al=new ArrayList<>();
        al.add(0);
        al.add(1);
        al.add(2);
        al.add(3);
        al.add(4);
        al.add(5);
        ar=new ArrayAdapter<Integer>(MainActivity.this,R.layout.support_simple_spinner_dropdown_item,al);
        sp.setAdapter(ar);
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
         t15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            DatePickerDialog    datePickerDialog=new DatePickerDialog(MainActivity.this,dob,2010,0,06);
                datePickerDialog.show();

            }
        });
        t8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ad2=new AlertDialog.Builder(MainActivity.this);
                ad2.setTitle("Warning");
                ad2.setMessage("Choose from the following");
                ad2.setPositiveButton("Set System Time", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int hourofday) {
                        calendar=Calendar.getInstance();
                        currenthour=calendar.get(Calendar.HOUR_OF_DAY);
                        currentminute=calendar.get(Calendar.MINUTE);
                        if (hourofday==12){
                            ampm="pm";
                        }else {
                            ampm="am";
                        }
                        t8.setText(ampm);
                        TimePickerDialog timePickerDialog=new TimePickerDialog(MainActivity.this,time,currenthour,currentminute,false);
                        timePickerDialog.show();
                    }
                });
                ad2.setNegativeButton("Set Time", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int hourofday) {
                        TimePickerDialog timePickerDialog=new TimePickerDialog(MainActivity.this,time,02,10,false);
                        if (hourofday==12){
                            ampm="pm";
                        }else {
                            ampm="am";
                        }
                        t8.setText(ampm);
                        timePickerDialog.show();
                    }
                });ad2.show();


            }

        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

             if (cb1.isChecked()) {

                 s1 = e1.getText().toString();
                 s2 = e2.getText().toString();
                 s3 = e3.getText().toString();
                 s5 = e4.getText().toString();
                 s6 = t15.getText().toString();
                 s7 = t8.getText().toString();
                 s8=sp.getSelectedItem().toString();
                 s4 = rg1.getCheckedRadioButtonId();
                 if (s4 == R.id.radioButton) {
                     s10="Male";
                 } else if (s4 == R.id.radioButton2) {
                     s10="Female";
                 }
                 Toast.makeText(MainActivity.this, s1 +"\n" +s2 +"\n"+ s3 +"\n"+s10+"\n"+s5+"\n"+s6+"\n"+s7+"\n"+s8, Toast.LENGTH_SHORT).show();
             }
             else {
                 mp.start();
                 alertdialogue=new AlertDialog.Builder(MainActivity.this);
                 alertdialogue.setTitle("Warning");
                 alertdialogue.setMessage("Kindly Agree the condition");
                 alertdialogue.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                     @Override
                     public void onClick(DialogInterface dialogInterface, int i) {

                     }
                 });
                 alertdialogue.show();

             }

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s1=e1.getText().toString();
                s2=e2.getText().toString();
                s3=e3.getText().toString();
                s5=e4.getText().toString();
                s6=t15.getText().toString();
                s8 = t8.getText().toString();
                s9=sp.getSelectedItem().toString();
                s4=rg1.getCheckedRadioButtonId();
                if (s4==R.id.radioButton){
                    s7="Male";
                    }
                else if (s4==R.id.radioButton2){
                    s7="Female";
                    }
                editor.putString("key1",s1);
                editor.putString("key2",s2);
                editor.putString("key3",s3);
                editor.putString("key5",s5);
                editor.putString("key6",s6);
                editor.putString("key7",s7);
                editor.putString("key8",s8);
                editor.putString("key9",s9);
                editor.commit();

                startActivity(new Intent(MainActivity.this,Main2Activity.class));
            }
        });
    }

    DatePickerDialog.OnDateSetListener dob=new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int year, int month, int dayofmonth) {

            t15.setText(year+"/"+(month+1)+"/"+dayofmonth+"");
        }
    };
    TimePickerDialog.OnTimeSetListener time=new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourofday, int minute) {
            t8.setText(hourofday+":"+minute+"");
        }
    };
}
