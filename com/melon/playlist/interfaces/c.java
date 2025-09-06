package com.melon.playlist.interfaces;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import kotlin.jvm.internal.q;
import oc.M;

public final class c implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        q.g(parcel0, "parcel");
        return new Success(M.valueOf(parcel0.readString()));
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new Success[v];
    }
}

