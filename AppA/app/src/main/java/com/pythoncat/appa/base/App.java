package com.pythoncat.appa.base;

import android.app.Application;

/**
 * Created by pythonCat on 2016/9/22 0022.
 *
 * @apiNote App
 */

public class App {
    private static Application mApp;

    public static Application get() {
        return mApp;
    }

    public static void set(Application a) {
        mApp = a;
    }
}
