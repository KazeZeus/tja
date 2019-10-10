package com.example.tja;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;




public class MainActivity extends AppCompatActivity {

    private static final int PERMISSION_REQUEST = 0;
    private static final int RESULT_LOAD_IMAGE = 1;

    EditText edit1 = (EditText)findViewById(R.id.e1);
    EditText edit2 = (EditText)findViewById(R.id.e2);
    EditText edit3 = (EditText)findViewById(R.id.e3);

    private Button button1;
    private Button button2 = (Button)findViewById(R.id.b2);
    ImageView img1 = (ImageView)findViewById(R.id.imgq);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        if(Build.VERSION.SDK_INT > Build.VERSION_CODES.M && checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
            != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, PERMISSION_REQUEST);
        }



        button1 = (Button)findViewById(R.id.b1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1 = new Intent (Intent.ACTION_PICK,
                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(i1, RESULT_LOAD_IMAGE );
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                Demo.m1 = edit1.getText().toString();
                Intent i2 = new Intent(getApplicationContext(), Main2Activity.class);
                startActivity(i2);

                Demo.m2 = edit2.getText().toString();
                Intent i3 = new Intent(getApplicationContext(), Main2Activity.class);
                startActivity(i3);

                Demo.m3 = edit3.getText().toString();
                Intent i4 = new Intent(getApplicationContext(), Main2Activity.class);
                startActivity(i4);

                Intent i5 = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(i5);

            }
        }
        );



    }

    public void onRequestPermissionResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case PERMISSION_REQUEST :
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "permission granted", Toast.LENGTH_SHORT).show();
                finish();



            }
        }
    }

    protected void onAnctvityResult(int requestCode, int resultCode, Intent data){
        switch (requestCode){
            case RESULT_LOAD_IMAGE:
            if (resultCode == RESULT_OK){
                Uri selectedImage = data.getData();
                String[] filePathColumn = {MediaStore.Images.Media.DATA};
                Cursor cursor = getContentResolver().query(selectedImage, filePathColumn, null, null, null);
                cursor.moveToFirst();
                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                String picturePath = cursor.getString(columnIndex);
                cursor.close();
                img1.setImageBitmap(BitmapFactory.decodeFile(picturePath));
                Demo.img2.setImageBitmap(BitmapFactory.decodeFile(picturePath));
                Demo.p1 = picturePath;



            }
        }

    }



}
