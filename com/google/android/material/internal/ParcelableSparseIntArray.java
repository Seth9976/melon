package com.google.android.material.internal;

import R3.e;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import android.util.SparseIntArray;

public class ParcelableSparseIntArray extends SparseIntArray implements Parcelable {
    public static final Parcelable.Creator CREATOR;

    static {
        ParcelableSparseIntArray.CREATOR = new e(7);
    }

    @Override  // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int[] arr_v = new int[this.size()];
        int[] arr_v1 = new int[this.size()];
        for(int v1 = 0; v1 < this.size(); ++v1) {
            arr_v[v1] = this.keyAt(v1);
            arr_v1[v1] = this.valueAt(v1);
        }
        parcel0.writeInt(this.size());
        parcel0.writeIntArray(arr_v);
        parcel0.writeIntArray(arr_v1);
    }
}

