package com.pythoncat.appb.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by pythonCat on 2016/9/22 0022.
 * @apiNote bean
 */

public class PhoneNumber implements Parcelable {


    /**
     * errNum : 0
     * retMsg : success
     * retData : {"phone":"18956071429","prefix":"1895607","supplier":"电信","province":"安徽","city":"合肥","suit":"189卡"}
     */

    public int errNum;
    public String retMsg;
    /**
     * phone : 18956071429
     * prefix : 1895607
     * supplier : 电信
     * province : 安徽
     * city : 合肥
     * suit : 189卡
     */

    public PNResp retData;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.errNum);
        dest.writeString(this.retMsg);
        dest.writeParcelable(this.retData, flags);
    }

    public PhoneNumber() {
    }

    protected PhoneNumber(Parcel in) {
        this.errNum = in.readInt();
        this.retMsg = in.readString();
        this.retData = in.readParcelable(PNResp.class.getClassLoader());
    }

    public static final Parcelable.Creator<PhoneNumber> CREATOR = new Parcelable.Creator<PhoneNumber>() {
        @Override
        public PhoneNumber createFromParcel(Parcel source) {
            return new PhoneNumber(source);
        }

        @Override
        public PhoneNumber[] newArray(int size) {
            return new PhoneNumber[size];
        }
    };
}
