package com.melon.playlist.interfaces;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import kotlin.jvm.internal.q;

public final class e implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        q.g(parcel0, "parcel");
        parcel0.readInt();
        return SelectRepeatOn.a;
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new SelectRepeatOn[v];
    }
}

