package com.pythoncat.appb.bean;


import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author pythonCat
 * @apiNote phone number POJO
 */
public class PNResp implements Parcelable {
    public String telString;
    public String province;
    public String carrier;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.telString);
        dest.writeString(this.province);
        dest.writeString(this.carrier);
    }

    public PNResp() {
    }

    protected PNResp(Parcel in) {
        this.telString = in.readString();
        this.province = in.readString();
        this.carrier = in.readString();
    }

    public static final Parcelable.Creator<PNResp> CREATOR = new Parcelable.Creator<PNResp>() {
        @Override
        public PNResp createFromParcel(Parcel source) {
            return new PNResp(source);
        }

        @Override
        public PNResp[] newArray(int size) {
            return new PNResp[size];
        }
    };
}