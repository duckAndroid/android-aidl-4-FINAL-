package com.pythoncat.appa;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;

import com.apkfuns.logutils.LogUtils;
import com.pythoncat.appb.RoAIDL;
import com.pythoncat.appb.callback.Act;

public class MainActivity extends AppCompatActivity {

    private ServiceConnection conn;

    private boolean bindB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        findViewById(R.id.btn_call_b_engine).setOnClickListener(v -> {
            LogUtils.e(" bind B service ....");
            // todo  -> 调用 App B 中的方法
            // com.pythoncat.appb.service.RoService
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_LAUNCHER);
            ComponentName cn = new ComponentName("com.pythoncat.appb", "com.pythoncat.appb.service.RoService");
            intent.setComponent(cn);
            conn = new ServiceConnection() {
                @Override
                public void onServiceConnected(ComponentName name, IBinder service) {
                    bindB = true;
                    LogUtils.e(" b service connected !!");
                    RoAIDL roB = RoAIDL.Stub.asInterface(service);
                    try {
                        int i = roB.applyTribe();
                        LogUtils.e(" i i i i ii ==== " + i);
                        // #############################################
                        LogUtils.e("#############");
                        roB.applyTribeAsync(new Act.Stub() {
                            @Override
                            public void call(int result) throws RemoteException {
                                LogUtils.e("result =  " + result);
                            }
                        });
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void onServiceDisconnected(ComponentName name) {
                    bindB = false;
                    LogUtils.e(" b service disconnected !!");
                }
            };
            boolean ok = bindService(intent, conn, BIND_AUTO_CREATE);
            LogUtils.e(" ok  = " + ok);
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (bindB) {
            unbindService(conn);
        }
    }
}
