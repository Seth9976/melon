package com.iloen.melon.custom.tablayout;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import y.a;

public class TabInfo implements Parcelable {
    public static final Parcelable.Creator CREATOR;
    public int a;
    public String b;
    public int c;
    public String d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public float j;
    public float k;
    public float l;
    public float m;
    public float n;
    public int o;

    static {
        TabInfo.CREATOR = new a(1);
    }

    @Override  // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override
    public final String toString() {
        return ToStringUtil.toStringFields(this);
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeInt(this.a);
        parcel0.writeString(this.b);
        parcel0.writeInt(this.c);
        parcel0.writeString(this.d);
        parcel0.writeInt(this.e);
        parcel0.writeInt(this.f);
        parcel0.writeInt(this.g);
        parcel0.writeInt(this.h);
        parcel0.writeInt(this.i);
        parcel0.writeFloat(this.j);
        parcel0.writeFloat(this.k);
        parcel0.writeFloat(this.l);
        parcel0.writeFloat(this.m);
        parcel0.writeFloat(this.n);
        parcel0.writeInt(this.o);
    }
}

