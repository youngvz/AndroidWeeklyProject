package com.virajashah.android.virajdemo;

import android.content.Intent;
import android.inputmethodservice.KeyboardView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.virajashah.android.virajdemo.bean.Book;
import com.virajashah.android.virajdemo.dialog.Quiz3Dialog;
import com.virajashah.android.virajdemo.util.UtilLog;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements View.OnTouchListener {

    private ImageButton btn1;
    private ImageButton btn3;
    private GestureDetector mGestureDetector;


    @OnClick(R.id.quiz3)
    public void launchQuiz3(){
//        Quiz3Dialog dialog = new Quiz3Dialog(this);
//        dialog.show();

       final Quiz3Dialog quiz3Dialog = new Quiz3Dialog(this, new Quiz3Dialog.IQuiz3DialogEventListener() {
           @Override
           public void onCancelClickListener() {
               toastShort("User clicked Cancel");
           }

           @Override
           public void onOkayDialogListener() {
               toastShort("User clicked Dialog View");
               launchDialogActivity();

           }

           @Override
           public void onOkayListViewListener() {
               toastShort("User clicked ListView");
               launchListViewActivity();
           }

           @Override
           public void onOkayHeaderViewListener() {
               toastShort("User clicked HeaderView");
               launchHeaderActivity();
           }
       });
        quiz3Dialog.show();
    }


    @OnClick(R.id.btn2)
    public void button2Click(){
        Intent intent = new Intent(this, DialogActivity.class);
        startActivityForResult(intent, 2);
        //toActivity(DialogActivity.class);
    }

    @OnClick(R.id.launchActivities)
    public void launchActivities(){
        Intent intent = new Intent(this, ActivityA.class);
        startActivity(intent);
    }

    @OnClick(R.id.Button1)
    public void launchAnimator(){
        Intent intent = new Intent(this, AnimatorActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialView();
        initialListener();
        ButterKnife.bind(this);

        mGestureDetector = new GestureDetector(this, new simpleGestureListener());
        //fl.setOnTouchListener(this);
    }



    private void initialView(){

        btn1 =(ImageButton)findViewById(R.id.btn1);
        btn3 =(ImageButton)findViewById(R.id.btn3);
    }

    // Uses Reflection to search source code for on click method

    private void initialListener(){

        // Android Best Practice for Listeners
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                toastShort("Button 1 was tapped");
                Intent intent = new Intent(v.getContext(), ViewPagerActivity.class);
                intent.putExtra("key", "value");
                Bundle bundle = new Bundle();
                bundle.putInt("Integer", 12345);
                Book book = new Book();
                book.setName("Android");
                book.setAuthor("Viraj");
                bundle.putSerializable("book",book);

                intent.putExtras(bundle);
                startActivityForResult(intent,1);
                //toActivity(ViewPagerActivity.class);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toastShort("Button 2 was clicked!");
                Intent intent = new Intent(v.getContext(),ListViewActivity.class);
                startActivityForResult(intent,3);
            }
        });
    }

    @Override
    protected void onStart(){
        super.onStart();
        toastShort("onStart");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case 1:
                String message = data.getStringExtra("message");
                toastShort(message);
                break;
            case 2:
                launchDialogActivity();
                break;
            case 3:
                launchListViewActivity();
                break;
            default:
        }

    }

    public  void launchHeaderActivity(){
        Intent intent = new Intent(this, ViewPagerActivity.class);
        intent.putExtra("key", "value");
        Bundle bundle = new Bundle();
        bundle.putInt("Integer", 12345);
        Book book = new Book();
        book.setName("Android");
        book.setAuthor("Viraj");
        bundle.putSerializable("book",book);

        intent.putExtras(bundle);
        startActivityForResult(intent,1);
    }

    public void launchDialogActivity(){
        Intent intent = new Intent(this, DialogActivity.class);
        startActivity(intent);
    }

    public void launchListViewActivity(){
        Intent intent = new Intent(this, ListViewActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return mGestureDetector.onTouchEvent(event);
    }

    private class simpleGestureListener extends GestureDetector.SimpleOnGestureListener{

        public boolean onDown(MotionEvent e){
            UtilLog.logD("MyGesture", "onDown");
            toastShort("onDown");
            return false;
        }

        public void onShowPress(MotionEvent e){
            UtilLog.logD("MyGesture", "onShowPress");
            toastShort("onShowPress");
        }

        public void onLongPress(MotionEvent e){
            UtilLog.logD("MyGesture", "onLongPress");
            toastShort("onLongPress");
        }

        public boolean onSingleTapUp(MotionEvent e){
            toastShort( "onSingleTap" );
            return true;
        }

        public boolean onSingleTapConfirmed(MotionEvent e){
            toastShort("OnSingleTapConfirmed");
            return true;
        }

        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY){
        UtilLog.logD("MyGesture", "onScroll:" + (e2.getX() - e1.getX()) + "     " + distanceX);
            toastShort("onScroll");
            return true;
        }

        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY){
            toastShort("onFling");
            return true;
        }

        public boolean onDoubleTap(MotionEvent e){
            toastShort( "onDoubleTap" );
            return true;
        }

        public boolean onDoubleTapEvent(MotionEvent e){
            toastShort("onDoubleTapEvent");
            return true;
        }


    }

}
