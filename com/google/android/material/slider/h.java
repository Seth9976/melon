package com.google.android.material.slider;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class h implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        return new RangeSliderState(parcel0);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new RangeSliderState[v];
    }
}

