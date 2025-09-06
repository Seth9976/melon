package com.iloen.melon.types;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import v9.n;

public class TagInfo implements Parcelable {
    public static final Parcelable.Creator CREATOR;
    public String a;
    public String b;

    static {
        TagInfo.CREATOR = new n(1);
    }

    @Override  // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeString(this.a);
        parcel0.writeString(this.b);
    }
}

