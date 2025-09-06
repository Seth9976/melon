package com.melon.ui.playermusic;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import kotlin.jvm.internal.q;

public final class c implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        q.g(parcel0, "parcel");
        return new SpecialVideo(parcel0.readString(), parcel0.readString(), parcel0.readString(), parcel0.readString());
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new SpecialVideo[v];
    }
}

