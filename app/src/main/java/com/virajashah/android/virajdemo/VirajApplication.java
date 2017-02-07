package com.virajashah.android.virajdemo;

import android.app.Application;

import com.virajashah.android.virajdemo.util.UtilLog;

/**
 * Created by youngvz on 2/6/17.
 */

public class VirajApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        UtilLog.setDebug(true);
    }
}
