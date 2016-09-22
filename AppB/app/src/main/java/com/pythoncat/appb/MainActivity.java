package com.pythoncat.appb;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.apkfuns.logutils.LogUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        findViewById(R.id.btn_open_a).setOnClickListener(v -> {
            LogUtils.w("open app a main activity .........");
            // 打开另一个app
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_LAUNCHER);
            ComponentName cn = new ComponentName("com.pythoncat.appa", "com.pythoncat.appa.MainActivity");
            intent.setComponent(cn);
            startActivity(intent);
            // todo: ok -> 打开 app A 成功 ！
        });
    }
}
