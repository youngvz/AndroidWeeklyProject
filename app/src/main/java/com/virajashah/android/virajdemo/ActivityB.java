package com.virajashah.android.virajdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class ActivityB extends AppCompatActivity {

    @OnClick(R.id.btn2A)
    public void buttonAClick(){
        Intent intent = new Intent(this, ActivityA.class);
        startActivity(intent);
    }
    @OnClick(R.id.btn2B)
    public void buttonBClick(){
        Intent intent = new Intent(this, ActivityB.class);
        startActivity(intent);
    }
    @OnClick(R.id.btn2C)
    public void buttonCClick(){
        Intent intent = new Intent(this, ActivityC.class);
        startActivity(intent);
    }
    @OnClick(R.id.btn2D)
    public void buttonDClick(){
        Intent intent = new Intent(this, ActivityD.class);
        startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        ButterKnife.bind(this);
    }
}
