package com.example.mypanda.entieny;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by 红超 on 2017/2/22.
 */

public class Name implements Parcelable {
    String cname;
    String ename;

    public Name() {
    }

    protected Name(Parcel in) {
        cname = in.readString();
        ename = in.readString();
    }

    public static final Creator<Name> CREATOR = new Creator<Name>() {
        @Override
        public Name createFromParcel(Parcel in) {
            return new Name(in);
        }

        @Override
        public Name[] newArray(int size) {
            return new Name[size];
        }
    };

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public Name(String cname, String ename) {
        this.cname = cname;
        this.ename = ename;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(cname);
        dest.writeString(ename);
    }
}
