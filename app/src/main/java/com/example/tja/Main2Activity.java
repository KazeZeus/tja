package com.example.tja;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        TextView text1 = (TextView)findViewById(R.id.t1);

        text1.setText(Demo.m1);

        TextView text2 = (TextView)findViewById(R.id.t2);

        text2.setText(Demo.m2);

        TextView text3 = (TextView)findViewById(R.id.t3);

        text3.setText(Demo.m3);

        ImageView v1 = (ImageView) findViewById(R.id.i2);

        v1.setImageBitmap(BitmapFactory.decodeFile(Demo.p1));


    }


}

