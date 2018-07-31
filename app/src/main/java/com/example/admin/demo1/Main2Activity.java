package com.example.admin.demo1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.renderscript.Sampler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    String s1,s2,s3,s5,s6,s7,s8,s9;
    SharedPreferences.Editor editor;
    ListView lv;
    ArrayList<String> arrayList;
    ArrayAdapter<String> arrayAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        sharedPreferences=getSharedPreferences("sfname",MODE_PRIVATE);
        editor=sharedPreferences.edit();
        s1=sharedPreferences.getString("key1","def val");
        s2=sharedPreferences.getString("key2","def val");
        s3=sharedPreferences.getString("key3","def val");
        s5=sharedPreferences.getString("key5","def val");
        s6=sharedPreferences.getString("key6","def val");
        s7=sharedPreferences.getString("key7","def val");
        s8=sharedPreferences.getString("key8","def val");
        s9=sharedPreferences.getString("key9","def val");
        lv=findViewById(R.id.listview);
        arrayList=new ArrayList<>();
        arrayList.add(s1);
        arrayList.add(s2);
        arrayList.add(s3);
        arrayList.add(s5);
        arrayList.add(s6);
        arrayList.add(s7);
        arrayList.add(s8);
        arrayList.add(s9);
        arrayAdapter=new ArrayAdapter<String>(Main2Activity.this, android.R.layout.simple_list_item_1,arrayList);
        lv.setAdapter(arrayAdapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                if (position==3) {
                    Intent intent = new Intent(Main2Activity.this, Main3Activity.class);
                    startActivity(intent);
                }

            }
        });


    }}

