package com.google.android.material.internal;

import R3.e;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import android.util.SparseBooleanArray;

public class ParcelableSparseBooleanArray extends SparseBooleanArray implements Parcelable {
    public static final Parcelable.Creator CREATOR;

    static {
        ParcelableSparseBooleanArray.CREATOR = new e(6);
    }

    @Override  // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int[] arr_v = new int[this.size()];
        boolean[] arr_z = new boolean[this.size()];
        for(int v1 = 0; v1 < this.size(); ++v1) {
            arr_v[v1] = this.keyAt(v1);
            arr_z[v1] = this.valueAt(v1);
        }
        parcel0.writeInt(this.size());
        parcel0.writeIntArray(arr_v);
        parcel0.writeBooleanArray(arr_z);
    }
}

