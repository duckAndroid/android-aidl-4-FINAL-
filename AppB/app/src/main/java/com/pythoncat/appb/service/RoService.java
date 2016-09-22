package com.pythoncat.appb.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

import com.apkfuns.logutils.LogUtils;
import com.pythoncat.appb.RoAIDL;
import com.pythoncat.appb.callback.Act;
import com.pythoncat.appb.engine.NetEngine;
import com.pythoncat.appb.utils.Po;

public class RoService extends Service {
    public RoService() {
    }

    @Override
    public IBinder onBind(Intent intent) {

        return new RoBinder();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        LogUtils.e(" i am ro service in B App ...... I was created just now .");
    }

    public class RoBinder extends RoAIDL.Stub {

        @Override
        public int applyTribe() throws RemoteException {
            return NetEngine.applyTribe(Po.myPid(), 123456, "duck", "www.baidu.com");
        }

        @Override
        public void applyTribeAsync(Act action) throws RemoteException {
            NetEngine.applyTribeAsync(action);
        }
    }
}
