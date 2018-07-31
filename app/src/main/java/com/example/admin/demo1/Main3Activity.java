package com.example.admin.demo1;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    String s1,s2,s3,s5,s6,s7,s8,s9;
    TextView t1,t2,t3,t4,t5,t6,t7,t8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        t1=findViewById(R.id.textView4);
        t2=findViewById(R.id.textView5);
        t3=findViewById(R.id.textView6);
        t4=findViewById(R.id.textView14);
        t5=findViewById(R.id.textView16);
        t6=findViewById(R.id.textView17);
        t7=findViewById(R.id.textView18);
        t8=findViewById(R.id.textView19);
        sharedPreferences=getSharedPreferences("sfname",MODE_PRIVATE);
        editor=sharedPreferences.edit();
    }

    public void Show(View view) {
        s1=sharedPreferences.getString("key1","def val");
        s2=sharedPreferences.getString("key2","def val");
        s3=sharedPreferences.getString("key3","def val");
        s5=sharedPreferences.getString("key5","def val");
        s6=sharedPreferences.getString("key6","def val");
        s7=sharedPreferences.getString("key7","def val");
        s8=sharedPreferences.getString("key8","def val");
        s9=sharedPreferences.getString("key9","def val");
        t1.setText(s1);
        t2.setText(s2);
        t3.setText(s3);
        t4.setText(s5);
        t5.setText(s6);
        t6.setText(s7);
        t7.setText(s8);
        t8.setText(s9);
    }
}
