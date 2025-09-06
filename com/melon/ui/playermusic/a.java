package com.melon.ui.playermusic;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import kotlin.jvm.internal.q;

public final class a implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        q.g(parcel0, "parcel");
        return new Album(parcel0.readString(), parcel0.readString(), parcel0.createStringArrayList());
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new Album[v];
    }
}

