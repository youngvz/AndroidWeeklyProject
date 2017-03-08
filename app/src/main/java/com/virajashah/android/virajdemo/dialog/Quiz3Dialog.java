package com.virajashah.android.virajdemo.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import com.virajashah.android.virajdemo.util.UtilLog;

import android.widget.RadioGroup;
import android.widget.Toast;

import com.virajashah.android.virajdemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by youngvz on 3/8/17.
 */

public class Quiz3Dialog extends Dialog {

    private int checkedID;


    @BindView(R.id.quizRadioGroup) RadioGroup radioGroup;

    @OnClick(R.id.ok_button)
    public void launchOkButton(){
        switch (checkedID){
            case R.id.launchDialogButton:
                listener.onOkayDialogListener();
                dismiss();
                break;
            case R.id.launchListViewButton:
                listener.onOkayListViewListener();
                dismiss();
                break;
            default:
                listener.onCancelClickListener();
                dismiss();
        }
    }

    @OnClick(R.id.cancel_button)
    public void launchCancelButton(){
        listener.onOkayHeaderViewListener();
        dismiss();
    }

    private IQuiz3DialogEventListener listener;


    public interface IQuiz3DialogEventListener{
        public void onCancelClickListener();
        public void onOkayDialogListener();
        public void onOkayListViewListener();
        public void onOkayHeaderViewListener();
    }

    public Quiz3Dialog(Context context, IQuiz3DialogEventListener listener) {
        super(context, R.style.dialog);
        this.listener = listener;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz3_dialog);
        ButterKnife.bind(this);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                checkedID = checkedId;
            }
        });
    }
}
