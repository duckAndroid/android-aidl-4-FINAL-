package com.pythoncat.appb.bean;


import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author pythonCat
 * @apiNote phone number POJO
 */
public class PNResp implements Parcelable {
    public String phone;
    public String prefix;
    public String supplier;
    public String province;
    public String city;
    public String suit;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.phone);
        dest.writeString(this.prefix);
        dest.writeString(this.supplier);
        dest.writeString(this.province);
        dest.writeString(this.city);
        dest.writeString(this.suit);
    }

    public PNResp() {
    }

    protected PNResp(Parcel in) {
        this.phone = in.readString();
        this.prefix = in.readString();
        this.supplier = in.readString();
        this.province = in.readString();
        this.city = in.readString();
        this.suit = in.readString();
    }

    public static final Creator<PNResp> CREATOR = new Creator<PNResp>() {
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