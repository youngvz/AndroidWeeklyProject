package com.virajashah.android.virajdemo.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.virajashah.android.virajdemo.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by youngvz on 2/15/17.
 */

public class CustomDialog extends Dialog {

    @OnClick(R.id.dialog_ok)
    public void okClick(){
        listener.onClickListener();
        dismiss();

    }

    private ICustomDialogEventListener listener;


    public interface ICustomDialogEventListener{

        public void onClickListener();

    }


    public CustomDialog(@NonNull Context context, ICustomDialogEventListener listener){
        super(context, R.style.dialog);
        this.listener= listener;
    }

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_dialog);
        ButterKnife.bind(this);
    }

}