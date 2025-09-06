package com.iloen.melon.sns.model;

import S7.b;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import java.io.Serializable;

public class ShareLinkData implements Parcelable, Serializable {
    public static final Parcelable.Creator CREATOR;
    @b("NORMAL")
    public String a;
    @b("FACEBOOK")
    public String b;
    @b("TWITTER")
    public String c;
    @b("KAKAOTALK")
    public String d;

    static {
        ShareLinkData.CREATOR = new e(12);
    }

    @Override  // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeString(this.a);
        parcel0.writeString(this.b);
        parcel0.writeString(this.c);
        parcel0.writeString(this.d);
    }
}

