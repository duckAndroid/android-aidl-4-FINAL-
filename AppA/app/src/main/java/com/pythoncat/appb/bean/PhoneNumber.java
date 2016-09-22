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
     * errMsg : success
     * retData : {"telString":"15846530170","province":"黑龙江","carrier":"黑龙江移动"}
     */

    public int errNum;
    public String errMsg;
    /**
     * telString : 15846530170
     * province : 黑龙江
     * carrier : 黑龙江移动
     */

    public PNResp retData;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.errNum);
        dest.writeString(this.errMsg);
        dest.writeParcelable(this.retData, flags);
    }

    public PhoneNumber() {
    }

    protected PhoneNumber(Parcel in) {
        this.errNum = in.readInt();
        this.errMsg = in.readString();
        this.retData = in.readParcelable(PNResp.class.getClassLoader());
    }

    public static final Creator<PhoneNumber> CREATOR = new Creator<PhoneNumber>() {
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
