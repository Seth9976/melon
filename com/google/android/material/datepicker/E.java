package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.ArrayList;

public final class e implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        ArrayList arrayList0 = parcel0.readArrayList(DateValidator.class.getClassLoader());
        int v = parcel0.readInt();
        d d0 = CompositeDateValidator.d;
        if(v != 2 && v == 1) {
            d0 = CompositeDateValidator.c;
        }
        arrayList0.getClass();
        return new CompositeDateValidator(arrayList0, d0);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new CompositeDateValidator[v];
    }
}

