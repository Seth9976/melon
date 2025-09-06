package com.google.android.material.timepicker;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class f implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        return new TimeModel(parcel0);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new TimeModel[v];
    }
}

