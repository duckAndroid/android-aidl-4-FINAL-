package com.pythoncat.appa;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.apkfuns.logutils.LogUtils;
import com.pythoncat.appa.utils.ToastHelper;
import com.pythoncat.appb.RoAIDL;
import com.pythoncat.appb.bean.PhoneNumber;
import com.pythoncat.appb.callback.Act;
import com.pythoncat.appb.callback.ActPN;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;

public class MainActivity extends AppCompatActivity {

    private ServiceConnection conn;

    private boolean bindBok;
    private RoAIDL roB;
    private View btnBind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        btnBind = findViewById(R.id.btn_call_b_engine);
        btnBind.setOnClickListener(v -> bindB());
        findViewById(R.id.btn_call_1024).setOnClickListener(v -> callInt());
        findViewById(R.id.btn_call_1024_async).setOnClickListener(v -> callIntAsync());
        findViewById(R.id.btn_call_net_pn).setOnClickListener(v -> callNetPOJO());
    }

    private void callNetPOJO() {
        LogUtils.e("############# callNetPOJO ");
        if (roB == null) {
            bindB();
        } else {
            try {
                roB.attribution(new ActPN.Stub() {
                    @Override
                    public void call(PhoneNumber pn) throws RemoteException {
                        Observable.just(0).observeOn(AndroidSchedulers.mainThread())
                                .subscribe(obj -> {
                                    LogUtils.e(pn);
                                    LogUtils.e(" hashCode = " + pn.hashCode()
                                            + " thread = " + Thread.currentThread().getName());
//                         hashCode = 13104567 thread = Binder_1　 todo --> 非UI 线程
                                    if (pn.errNum == 0) {
                                        String province = pn.retData.province;
                                        ToastHelper.showShort("号码：" + pn.retData.phone + "的归属地为：" + province);
                                    }
                                }, Throwable::printStackTrace);
                    }
                });
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    private void callIntAsync() {
        LogUtils.e("############# callIntAsync ");
        if (roB == null) {
            bindB();
        } else {
            try {
                roB.applyTribeAsync(new Act.Stub() {
                    @Override
                    public void call(int result) throws RemoteException {
                        Observable.just(0).observeOn(AndroidSchedulers.mainThread())
                                .subscribe(obj -> {
                                    String object = "result =  " + result
                                            + " thread = " + Thread.currentThread().getName();
                                    LogUtils.e(object);
//                        result =  1024 thread = Binder_1  todo --> 非UI 线程
                                    ToastHelper.showShort(object);
                                }, Throwable::printStackTrace);
                    }
                });
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    private void callInt() {
        if (roB == null) {
            bindB();
        } else {
            try {
                int i = roB.applyTribe();
                String object = " i i i i ii ==== " + i
                        + " thread = " + Thread.currentThread().getName();
                LogUtils.e(object);
//                i i i i ii ==== 1024 thread = main todo --> UI 线程
                ToastHelper.showShort(object);
                // #############################################
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

    }

    private void bindB() {
        LogUtils.e(" bind B service ....");
        // com.pythoncat.appb.service.RoService
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_LAUNCHER);
        ComponentName cn = new ComponentName("com.pythoncat.appb", "com.pythoncat.appb.service.RoService");
        intent.setComponent(cn);
        conn = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                bindBok = true;
                btnBind.setEnabled(false);
                LogUtils.e(" b service connected !!");
                roB = RoAIDL.Stub.asInterface(service);
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
                bindBok = false;
                btnBind.setEnabled(true);
                LogUtils.e(" b service disconnected !!");
            }
        };
        boolean ok = bindService(intent, conn, BIND_AUTO_CREATE);
        LogUtils.e(" ok  = " + ok);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (bindBok) {
            unbindService(conn);
        }
    }
}
