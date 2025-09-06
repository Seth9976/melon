package com.melon.ui.playermusic;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import kotlin.jvm.internal.q;

public final class b implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        q.g(parcel0, "parcel");
        String s = parcel0.readString();
        String s1 = parcel0.readString();
        return new SpecialImage(parcel0.createStringArrayList(), s, s1);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new SpecialImage[v];
    }
}

