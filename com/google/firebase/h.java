package com.google.firebase;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import kotlin.jvm.internal.q;

public final class h implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        q.g(parcel0, "source");
        return new Timestamp(parcel0.readLong(), parcel0.readInt());
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new Timestamp[v];
    }
}

