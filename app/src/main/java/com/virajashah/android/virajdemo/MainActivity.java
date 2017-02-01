package com.virajashah.android.virajdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

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
        Toast.makeText(v.getContext(), "Button 2 was tapped", Toast.LENGTH_SHORT).show();
    }

    private void initialListener(){

        // Android Best Practice for Listeners
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ViewPagerActivity.class);
                startActivity(intent);
                //Toast.makeText(v.getContext(), "Button 1 was tapped", Toast.LENGTH_SHORT).show();
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ListViewActivity.class);
                startActivity(intent);
            }
        });
    }

}
