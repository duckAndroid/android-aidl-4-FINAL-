package com.pythoncat.appb.base;

import android.app.Application;

/**
 * Created by pythonCat on 2016/9/22 0022.
 *
 * @apiNote application
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        App.set(this);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        App.set(null);
    }
}
