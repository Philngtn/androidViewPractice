package com.example.gradeviewer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.CornerPathEffect;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;


import java.io.Serializable;
import java.sql.Driver;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    //Global scope
    private Button btnMain;

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonMainPage:
                Intent intent = new Intent(MainActivity.this,gradeActivity.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMain = findViewById(R.id.buttonMainPage);
        btnMain.setOnClickListener(this);
    }


}