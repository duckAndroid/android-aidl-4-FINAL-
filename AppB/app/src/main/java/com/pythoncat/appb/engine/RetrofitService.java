package com.pythoncat.appb.engine;

import com.pythoncat.appb.bean.PhoneNumber;

import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by pythonCat on 2016/9/22 0022.
 * @apiNote retrofit service
 */
public interface RetrofitService {
    String baseURL = "http://apis.baidu.com";

    @GET("/apistore/mobilenumber/mobilenumber")
    Observable<PhoneNumber> attribution(@Header("apikey") String apikey, @Query("phone") String phone);
}
