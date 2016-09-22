package com.pythoncat.appa.utils;

import android.widget.Toast;

import com.pythoncat.appa.base.App;

/**
 * Created by pythonCat on 2016/8/14 0014.
 *
 * @author pythonCat
 */
public class ToastHelper {

    private static Toast mToast;

    public static void showShort(CharSequence ch) {
        if (mToast == null) {
            mToast = Toast.makeText(App.get(), ch, Toast.LENGTH_SHORT);
        } else {
            cancel();
            mToast = Toast.makeText(App.get(), ch, Toast.LENGTH_SHORT);
        }
        mToast.show();
    }

    public static void cancel() {
        if (mToast != null) {
            mToast.cancel();
        }
    }
}