package com.virajashah.android.virajdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.virajashah.android.virajdemo.adapter.ListViewAdapter;
import com.virajashah.android.virajdemo.util.UtilLog;

import java.util.ArrayList;

public class ListViewActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView listView;
    private ArrayList listResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        listResult  = new ArrayList<String>();
        createFakeResult();
        initialView();
    }

    private void createFakeResult(){
        listResult.add("AAAAAAAAAAAAA");
        listResult.add("BBBBB");
        listResult.add("CCCCCCCCC");
        listResult.add("DDDDD");
        listResult.add("EEEEEEEEEEEE");
        listResult.add("FFF");
        listResult.add("GGGGGGG");
        listResult.add("HHHHHH");
        listResult.add("IIIII");
        listResult.add("JJJJJJJJ");
        listResult.add("KKKKKKKKKKK");
        listResult.add("LLLLLL");
        listResult.add("MMMMM");
        listResult.add("NNNN");

    }

    private void initialView() {
        listView = (ListView)findViewById(R.id.list_view);
        View view = getLayoutInflater().inflate(R.layout.listviewheader, null);

        LinearLayout listViewHeader = (LinearLayout)view.findViewById(R.id.list_view_header);
        ListViewAdapter listViewAdapter = new ListViewAdapter(this, listResult);
        listView.addHeaderView(listViewHeader);

        TextView tv = new TextView(this);
        tv.setText("We have no more content");
        tv.setTextSize(28);
        tv.setGravity(Gravity.CENTER);
        listView.addFooterView(tv);


        listView.setAdapter(listViewAdapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, "listView was clicked at position:"+position, Toast.LENGTH_SHORT).show();
        UtilLog.logD("ListViewActivity", String.valueOf(position));
    }
}
