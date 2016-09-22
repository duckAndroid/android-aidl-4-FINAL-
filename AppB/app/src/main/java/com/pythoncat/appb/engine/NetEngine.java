package com.pythoncat.appb.engine;

import android.os.RemoteException;

import com.apkfuns.logutils.LogUtils;
import com.pythoncat.appb.bean.PhoneNumber;
import com.pythoncat.appb.callback.Act;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by pythonCat on 2016/9/22 0022.
 *
 * @apiNote can only run on main process !!!
 */

public class NetEngine {

    private static final String apiKey = "be23933faecee3c74e149bd3fdbaa6cb";
    private static final String pn = "13838387438";

    public static int applyTribe(int yourPid, long groupId, String nick, String iconUrl) {
        LogUtils.w("your pid = " + yourPid);
        LogUtils.e(" apply tribe: groupID = " + groupId + " , nick = " + nick +
                " , iconUrl = " + iconUrl + "\n is Main Process = ");
        return 1024; // 假装需要一个返回值给别人用
    }

    public static void applyTribeAsync(Act ac) {
        Observable.interval(1, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .take(4)
                .subscribe(
                        t -> LogUtils.e(" t = " + t),
                        Throwable::printStackTrace,
                        () -> {
                            try {
                                ac.call(1024);
                            } catch (RemoteException e) {
                                e.printStackTrace();
                                throw new RuntimeException(e);
                            }
                        }); // 模拟延时回调ok
    }

    public static Observable<PhoneNumber> attributionPhoneNumber() {
        Retrofit retrofit = new Retrofit.Builder()
                .client(client())
                .baseUrl(RetrofitService.baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return retrofit.create(RetrofitService.class).attribution(apiKey, pn);
    }

    private static OkHttpClient client() {
        return new OkHttpClient.Builder()
                .addInterceptor(new LoggerInterceptor("okHttp:", true)) // 输出 完整 url
                .connectTimeout(10000L, TimeUnit.MILLISECONDS)
                .readTimeout(10000L, TimeUnit.MILLISECONDS).build();
    }
}
