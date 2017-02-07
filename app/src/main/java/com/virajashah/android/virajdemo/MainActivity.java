package com.virajashah.android.virajdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.virajashah.android.virajdemo.util.UtilLog;

public class MainActivity extends BaseActivity {

    private ImageButton btn1;
    private ImageButton btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialView();
        initialListener();
    }



    private void initialView(){

        btn1 =(ImageButton)findViewById(R.id.btn1);
        btn3 =(ImageButton)findViewById(R.id.btn3);
    }

    // Uses Reflection to search source code for on click method
    public void onClick(View v){
        //Toast.makeText(v.getContext(), "Button 2 was tapped", Toast.LENGTH_SHORT).show();
        UtilLog.logD("MainActivity", "Button 2 was tapped");
    }

    private void initialListener(){

        // Android Best Practice for Listeners
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                toActivity(ViewPagerActivity.class);
                toastShort("Button 1 was tapped");
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                toastLong("Button 2 was clicked!");
                toActivity(ListViewActivity.class);
            }
        });
    }

}
